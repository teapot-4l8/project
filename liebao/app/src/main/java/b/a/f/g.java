package b.a.f;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
class g implements RejectedExecutionHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3165a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.f3165a = aVar;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
    }
}
