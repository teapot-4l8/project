package b.b.e.g;

import b.b.i;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ComputationScheduler.java */
/* loaded from: classes.dex */
public final class b extends b.b.i {

    /* renamed from: b  reason: collision with root package name */
    static final C0073b f3411b;

    /* renamed from: c  reason: collision with root package name */
    static final g f3412c;

    /* renamed from: d  reason: collision with root package name */
    static final int f3413d = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: e  reason: collision with root package name */
    static final c f3414e;
    final ThreadFactory f;
    final AtomicReference<C0073b> g;

    static int a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    static {
        c cVar = new c(new g("RxComputationShutdown"));
        f3414e = cVar;
        cVar.a();
        g gVar = new g("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f3412c = gVar;
        C0073b c0073b = new C0073b(0, gVar);
        f3411b = c0073b;
        c0073b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: b.b.e.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0073b {

        /* renamed from: a  reason: collision with root package name */
        final int f3420a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f3421b;

        /* renamed from: c  reason: collision with root package name */
        long f3422c;

        C0073b(int i, ThreadFactory threadFactory) {
            this.f3420a = i;
            this.f3421b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f3421b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f3420a;
            if (i == 0) {
                return b.f3414e;
            }
            c[] cVarArr = this.f3421b;
            long j = this.f3422c;
            this.f3422c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.f3421b) {
                cVar.a();
            }
        }
    }

    public b() {
        this(f3412c);
    }

    public b(ThreadFactory threadFactory) {
        this.f = threadFactory;
        this.g = new AtomicReference<>(f3411b);
        b();
    }

    @Override // b.b.i
    public i.c a() {
        return new a(this.g.get().a());
    }

    @Override // b.b.i
    public b.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.g.get().a().b(runnable, j, timeUnit);
    }

    @Override // b.b.i
    public b.b.b.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.g.get().a().b(runnable, j, j2, timeUnit);
    }

    @Override // b.b.i
    public void b() {
        C0073b c0073b = new C0073b(f3413d, this.f);
        if (this.g.compareAndSet(f3411b, c0073b)) {
            return;
        }
        c0073b.b();
    }

    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes.dex */
    static final class a extends i.c {

        /* renamed from: a  reason: collision with root package name */
        volatile boolean f3415a;

        /* renamed from: b  reason: collision with root package name */
        private final b.b.e.a.d f3416b = new b.b.e.a.d();

        /* renamed from: c  reason: collision with root package name */
        private final b.b.b.a f3417c = new b.b.b.a();

        /* renamed from: d  reason: collision with root package name */
        private final b.b.e.a.d f3418d;

        /* renamed from: e  reason: collision with root package name */
        private final c f3419e;

        a(c cVar) {
            this.f3419e = cVar;
            b.b.e.a.d dVar = new b.b.e.a.d();
            this.f3418d = dVar;
            dVar.a(this.f3416b);
            this.f3418d.a(this.f3417c);
        }

        @Override // b.b.b.b
        public void a() {
            if (this.f3415a) {
                return;
            }
            this.f3415a = true;
            this.f3418d.a();
        }

        @Override // b.b.i.c
        public b.b.b.b a(Runnable runnable) {
            if (this.f3415a) {
                return b.b.e.a.c.INSTANCE;
            }
            return this.f3419e.a(runnable, 0L, TimeUnit.MILLISECONDS, this.f3416b);
        }

        @Override // b.b.i.c
        public b.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f3415a) {
                return b.b.e.a.c.INSTANCE;
            }
            return this.f3419e.a(runnable, j, timeUnit, this.f3417c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes.dex */
    public static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
