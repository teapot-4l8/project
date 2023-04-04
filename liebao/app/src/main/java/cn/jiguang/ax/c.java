package cn.jiguang.ax;

import android.os.HandlerThread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends HandlerThread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4010a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, String str) {
        super(str);
        this.f4010a = bVar;
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            super.run();
        } catch (RuntimeException e2) {
            cn.jiguang.an.d.h("TaskHandlerManager_xxx", "handler thread run e:" + e2 + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
        }
    }
}
