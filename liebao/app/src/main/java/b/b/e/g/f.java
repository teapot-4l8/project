package b.b.e.g;

import b.b.i;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: NewThreadWorker.java */
/* loaded from: classes.dex */
public class f extends i.c implements b.b.b.b {

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f3444a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f3445b;

    public f(ThreadFactory threadFactory) {
        this.f3445b = k.a(threadFactory);
    }

    @Override // b.b.i.c
    public b.b.b.b a(Runnable runnable) {
        return a(runnable, 0L, null);
    }

    @Override // b.b.i.c
    public b.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f3444a) {
            return b.b.e.a.c.INSTANCE;
        }
        return a(runnable, j, timeUnit, (b.b.e.a.a) null);
    }

    public b.b.b.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        i iVar = new i(b.b.g.a.a(runnable));
        try {
            if (j <= 0) {
                schedule = this.f3445b.submit(iVar);
            } else {
                schedule = this.f3445b.schedule(iVar, j, timeUnit);
            }
            iVar.a(schedule);
            return iVar;
        } catch (RejectedExecutionException e2) {
            b.b.g.a.a(e2);
            return b.b.e.a.c.INSTANCE;
        }
    }

    public b.b.b.b b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        Runnable a2 = b.b.g.a.a(runnable);
        if (j2 <= 0) {
            c cVar = new c(a2, this.f3445b);
            try {
                if (j <= 0) {
                    schedule = this.f3445b.submit(cVar);
                } else {
                    schedule = this.f3445b.schedule(cVar, j, timeUnit);
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
            hVar.a(this.f3445b.scheduleAtFixedRate(hVar, j, j2, timeUnit));
            return hVar;
        } catch (RejectedExecutionException e3) {
            b.b.g.a.a(e3);
            return b.b.e.a.c.INSTANCE;
        }
    }

    public j a(Runnable runnable, long j, TimeUnit timeUnit, b.b.e.a.a aVar) {
        Future<?> schedule;
        j jVar = new j(b.b.g.a.a(runnable), aVar);
        if (aVar == null || aVar.a(jVar)) {
            try {
                if (j <= 0) {
                    schedule = this.f3445b.submit((Callable) jVar);
                } else {
                    schedule = this.f3445b.schedule((Callable) jVar, j, timeUnit);
                }
                jVar.a(schedule);
            } catch (RejectedExecutionException e2) {
                if (aVar != null) {
                    aVar.b(jVar);
                }
                b.b.g.a.a(e2);
            }
            return jVar;
        }
        return jVar;
    }

    @Override // b.b.b.b
    public void a() {
        if (this.f3444a) {
            return;
        }
        this.f3444a = true;
        this.f3445b.shutdownNow();
    }

    public void c() {
        if (this.f3444a) {
            return;
        }
        this.f3444a = true;
        this.f3445b.shutdown();
    }
}
