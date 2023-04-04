package b.b;

import java.util.concurrent.TimeUnit;

/* compiled from: Scheduler.java */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    static final long f3508a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    public abstract c a();

    public void b() {
    }

    public b.b.b.b a(Runnable runnable) {
        return a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public b.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        c a2 = a();
        a aVar = new a(b.b.g.a.a(runnable), a2);
        a2.a(aVar, j, timeUnit);
        return aVar;
    }

    public b.b.b.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c a2 = a();
        b bVar = new b(b.b.g.a.a(runnable), a2);
        b.b.b.b a3 = a2.a(bVar, j, j2, timeUnit);
        return a3 == b.b.e.a.c.INSTANCE ? a3 : bVar;
    }

    /* compiled from: Scheduler.java */
    /* loaded from: classes.dex */
    public static abstract class c implements b.b.b.b {
        public abstract b.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit);

        public b.b.b.b a(Runnable runnable) {
            return a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public b.b.b.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            b.b.e.a.f fVar = new b.b.e.a.f();
            b.b.e.a.f fVar2 = new b.b.e.a.f(fVar);
            Runnable a2 = b.b.g.a.a(runnable);
            long nanos = timeUnit.toNanos(j2);
            long a3 = a(TimeUnit.NANOSECONDS);
            b.b.b.b a4 = a(new a(a3 + timeUnit.toNanos(j), a2, a3, fVar2, nanos), j, timeUnit);
            if (a4 == b.b.e.a.c.INSTANCE) {
                return a4;
            }
            fVar.a(a4);
            return fVar2;
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Scheduler.java */
        /* loaded from: classes.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final Runnable f3525a;

            /* renamed from: b  reason: collision with root package name */
            final b.b.e.a.f f3526b;

            /* renamed from: c  reason: collision with root package name */
            final long f3527c;

            /* renamed from: d  reason: collision with root package name */
            long f3528d;

            /* renamed from: e  reason: collision with root package name */
            long f3529e;
            long f;

            a(long j, Runnable runnable, long j2, b.b.e.a.f fVar, long j3) {
                this.f3525a = runnable;
                this.f3526b = fVar;
                this.f3527c = j3;
                this.f3529e = j2;
                this.f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.f3525a.run();
                if (this.f3526b.b()) {
                    return;
                }
                long a2 = c.this.a(TimeUnit.NANOSECONDS);
                long j2 = this.f3529e;
                if (i.f3508a + a2 < j2 || a2 >= j2 + this.f3527c + i.f3508a) {
                    long j3 = this.f3527c;
                    long j4 = a2 + j3;
                    long j5 = this.f3528d + 1;
                    this.f3528d = j5;
                    this.f = j4 - (j3 * j5);
                    j = j4;
                } else {
                    long j6 = this.f;
                    long j7 = this.f3528d + 1;
                    this.f3528d = j7;
                    j = j6 + (j7 * this.f3527c);
                }
                this.f3529e = a2;
                this.f3526b.a(c.this.a(this, j - a2, TimeUnit.NANOSECONDS));
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* loaded from: classes.dex */
    static final class b implements b.b.b.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f3522a;

        /* renamed from: b  reason: collision with root package name */
        final c f3523b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f3524c;

        b(Runnable runnable, c cVar) {
            this.f3522a = runnable;
            this.f3523b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3524c) {
                return;
            }
            try {
                this.f3522a.run();
            } catch (Throwable th) {
                b.b.c.b.b(th);
                this.f3523b.a();
                throw b.b.e.h.c.a(th);
            }
        }

        @Override // b.b.b.b
        public void a() {
            this.f3524c = true;
            this.f3523b.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Scheduler.java */
    /* loaded from: classes.dex */
    public static final class a implements b.b.b.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f3514a;

        /* renamed from: b  reason: collision with root package name */
        final c f3515b;

        /* renamed from: c  reason: collision with root package name */
        Thread f3516c;

        a(Runnable runnable, c cVar) {
            this.f3514a = runnable;
            this.f3515b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3516c = Thread.currentThread();
            try {
                this.f3514a.run();
            } finally {
                a();
                this.f3516c = null;
            }
        }

        @Override // b.b.b.b
        public void a() {
            if (this.f3516c == Thread.currentThread()) {
                c cVar = this.f3515b;
                if (cVar instanceof b.b.e.g.f) {
                    ((b.b.e.g.f) cVar).c();
                    return;
                }
            }
            this.f3515b.a();
        }
    }
}
