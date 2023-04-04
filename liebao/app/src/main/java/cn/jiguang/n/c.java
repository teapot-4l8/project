package cn.jiguang.n;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes.dex */
final class c implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4144a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f4144a = bVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Thread thread;
        if (message == null || message.what != 1 || (thread = (Thread) message.obj) == null) {
            return false;
        }
        thread.interrupt();
        return false;
    }
}
