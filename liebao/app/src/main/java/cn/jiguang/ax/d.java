package cn.jiguang.ax;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4011a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar, Looper looper) {
        super(looper);
        this.f4011a = bVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        try {
            concurrentHashMap = this.f4011a.f4008d;
            a aVar = (a) concurrentHashMap.get(Integer.valueOf(message.what));
            if (aVar == null) {
                cn.jiguang.an.d.f("TaskHandlerManager_xxx", "miss task:" + message.what);
                return;
            }
            if (aVar.f4004c == 1) {
                sendEmptyMessageDelayed(message.what, aVar.f4003b);
            } else {
                concurrentHashMap2 = this.f4011a.f4008d;
                concurrentHashMap2.remove(Integer.valueOf(message.what));
            }
            aVar.a(message);
        } catch (Throwable th) {
            cn.jiguang.an.d.f("TaskHandlerManager_xxx", "handleMessage,e:" + th);
        }
    }
}
