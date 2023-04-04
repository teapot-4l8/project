package b.b.e.g;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InstantPeriodicTask.java */
/* loaded from: classes.dex */
public final class c implements b.b.b.b, Callable<Void> {
    static final FutureTask<Void> f = new FutureTask<>(b.b.e.b.a.f3298b, null);

    /* renamed from: a  reason: collision with root package name */
    final Runnable f3423a;

    /* renamed from: d  reason: collision with root package name */
    final ExecutorService f3426d;

    /* renamed from: e  reason: collision with root package name */
    Thread f3427e;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Future<?>> f3425c = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<Future<?>> f3424b = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Runnable runnable, ExecutorService executorService) {
        this.f3423a = runnable;
        this.f3426d = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b */
    public Void call() {
        this.f3427e = Thread.currentThread();
        try {
            this.f3423a.run();
            b(this.f3426d.submit(this));
            this.f3427e = null;
        } catch (Throwable th) {
            this.f3427e = null;
            b.b.g.a.a(th);
        }
        return null;
    }

    @Override // b.b.b.b
    public void a() {
        Future<?> andSet = this.f3425c.getAndSet(f);
        if (andSet != null && andSet != f) {
            andSet.cancel(this.f3427e != Thread.currentThread());
        }
        Future<?> andSet2 = this.f3424b.getAndSet(f);
        if (andSet2 == null || andSet2 == f) {
            return;
        }
        andSet2.cancel(this.f3427e != Thread.currentThread());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f3425c.get();
            if (future2 == f) {
                future.cancel(this.f3427e != Thread.currentThread());
                return;
            }
        } while (!this.f3425c.compareAndSet(future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.f3424b.get();
            if (future2 == f) {
                future.cancel(this.f3427e != Thread.currentThread());
                return;
            }
        } while (!this.f3424b.compareAndSet(future2, future));
    }
}
