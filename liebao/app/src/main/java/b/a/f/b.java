package b.a.f;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    AtomicInteger f3154a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3155b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f3155b = aVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("pool-core-t-" + this.f3154a.getAndIncrement());
        return thread;
    }
}
