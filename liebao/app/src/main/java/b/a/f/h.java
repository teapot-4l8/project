package b.a.f;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
class h implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    AtomicInteger f3166a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f3167b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.f3167b = aVar;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("pool-core-f-" + this.f3166a.getAndIncrement());
        return thread;
    }
}
