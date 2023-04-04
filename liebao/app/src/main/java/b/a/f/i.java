package b.a.f;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
class i implements RejectedExecutionHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.f3168a = aVar;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
    }
}
