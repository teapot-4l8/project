package b.b.e.g;

import b.b.i;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SingleScheduler.java */
/* loaded from: classes.dex */
public final class l extends b.b.i {

    /* renamed from: d  reason: collision with root package name */
    static final g f3460d;

    /* renamed from: e  reason: collision with root package name */
    static final ScheduledExecutorService f3461e;

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f3462b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f3463c;

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f3461e = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f3460d = new g("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public l() {
        this(f3460d);
    }

    public l(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.f3463c = atomicReference;
        this.f3462b = threadFactory;
        atomicReference.lazySet(a(threadFactory));
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return k.a(threadFactory);
    }

    @Override // b.b.i
    public void b() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.f3463c.get();
            if (scheduledExecutorService != f3461e) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = a(this.f3462b);
            }
        } while (!this.f3463c.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    @Override // b.b.i
    public i.c a() {
        return new a(this.f3463c.get());
    }

    @Override // b.b.i
    public b.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        i iVar = new i(b.b.g.a.a(runnable));
        try {
            if (j <= 0) {
                schedule = this.f3463c.get().submit(iVar);
            } else {
                schedule = this.f3463c.get().schedule(iVar, j, timeUnit);
            }
            iVar.a(schedule);
            return iVar;
        } catch (RejectedExecutionException e2) {
            b.b.g.a.a(e2);
            return b.b.e.a.c.INSTANCE;
        }
    }

    @Override // b.b.i
    public b.b.b.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable a2 = b.b.g.a.a(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f3463c.get();
            c cVar = new c(a2, scheduledExecutorService);
            try {
                if (j <= 0) {
                    schedule = scheduledExecutorService.submit(cVar);
                } else {
                    schedule = scheduledExecutorService.schedule(cVar, j, timeUnit);
                }
                cVar.a(schedule);
                return cVar;
            } catch (RejectedExecutionException e2) {
                b.b.g.a.a(e2);
                return b.b.e.a.c.INSTANCE;
            }
        }
        h hVar = new h(a2);
        try {
            hVar.a(this.f3463c.get().scheduleAtFixedRate(hVar, j, j2, timeUnit));
            return hVar;
        } catch (RejectedExecutionException e3) {
            b.b.g.a.a(e3);
            return b.b.e.a.c.INSTANCE;
        }
    }

    /* compiled from: SingleScheduler.java */
    /* loaded from: classes.dex */
    static final class a extends i.c {

        /* renamed from: a  reason: collision with root package name */
        final ScheduledExecutorService f3464a;

        /* renamed from: b  reason: collision with root package name */
        final b.b.b.a f3465b = new b.b.b.a();

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f3466c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f3464a = scheduledExecutorService;
        }

        @Override // b.b.i.c
        public b.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.f3466c) {
                return b.b.e.a.c.INSTANCE;
            }
            j jVar = new j(b.b.g.a.a(runnable), this.f3465b);
            this.f3465b.a(jVar);
            try {
                if (j <= 0) {
                    schedule = this.f3464a.submit((Callable) jVar);
                } else {
                    schedule = this.f3464a.schedule((Callable) jVar, j, timeUnit);
                }
                jVar.a(schedule);
                return jVar;
            } catch (RejectedExecutionException e2) {
                a();
                b.b.g.a.a(e2);
                return b.b.e.a.c.INSTANCE;
            }
        }

        @Override // b.b.b.b
        public void a() {
            if (this.f3466c) {
                return;
            }
            this.f3466c = true;
            this.f3465b.a();
        }
    }
}
