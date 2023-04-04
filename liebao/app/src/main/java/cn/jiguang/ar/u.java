package cn.jiguang.ar;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f3867a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(ExecutorService executorService) {
        super(r.c());
        this.f3867a = executorService;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            if (this.f3867a.isShutdown()) {
                cn.jiguang.an.d.f("Step", "executor is shutdown");
            } else {
                this.f3867a.submit((Callable) message.obj);
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.h("Step", "handleMessage e:" + th);
        }
    }
}
