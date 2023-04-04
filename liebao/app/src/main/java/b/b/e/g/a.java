package b.b.e.g;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: AbstractDirectTask.java */
/* loaded from: classes.dex */
abstract class a extends AtomicReference<Future<?>> implements b.b.b.b {

    /* renamed from: c  reason: collision with root package name */
    protected static final FutureTask<Void> f3407c = new FutureTask<>(b.b.e.b.a.f3298b, null);

    /* renamed from: d  reason: collision with root package name */
    protected static final FutureTask<Void> f3408d = new FutureTask<>(b.b.e.b.a.f3298b, null);

    /* renamed from: a  reason: collision with root package name */
    protected final Runnable f3409a;

    /* renamed from: b  reason: collision with root package name */
    protected Thread f3410b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Runnable runnable) {
        this.f3409a = runnable;
    }

    @Override // b.b.b.b
    public final void a() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == f3407c || future == (futureTask = f3408d) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.f3410b != Thread.currentThread());
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == f3407c) {
                return;
            }
            if (future2 == f3408d) {
                future.cancel(this.f3410b != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
