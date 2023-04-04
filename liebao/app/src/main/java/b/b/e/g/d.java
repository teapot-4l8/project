package b.b.e.g;

import b.b.i;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IoScheduler.java */
/* loaded from: classes.dex */
public final class d extends b.b.i {

    /* renamed from: b  reason: collision with root package name */
    static final g f3428b;

    /* renamed from: c  reason: collision with root package name */
    static final g f3429c;

    /* renamed from: d  reason: collision with root package name */
    static final c f3430d;
    static final a g;

    /* renamed from: e  reason: collision with root package name */
    final ThreadFactory f3431e;
    final AtomicReference<a> f;
    private static final TimeUnit i = TimeUnit.SECONDS;
    private static final long h = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    static {
        c cVar = new c(new g("RxCachedThreadSchedulerShutdown"));
        f3430d = cVar;
        cVar.a();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        f3428b = new g("RxCachedThreadScheduler", max);
        f3429c = new g("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0L, null, f3428b);
        g = aVar;
        aVar.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes.dex */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final b.b.b.a f3432a;

        /* renamed from: b  reason: collision with root package name */
        private final long f3433b;

        /* renamed from: c  reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f3434c;

        /* renamed from: d  reason: collision with root package name */
        private final ScheduledExecutorService f3435d;

        /* renamed from: e  reason: collision with root package name */
        private final Future<?> f3436e;
        private final ThreadFactory f;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.f3433b = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f3434c = new ConcurrentLinkedQueue<>();
            this.f3432a = new b.b.b.a();
            this.f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, d.f3429c);
                long j2 = this.f3433b;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f3435d = scheduledExecutorService;
            this.f3436e = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
        }

        c a() {
            if (this.f3432a.b()) {
                return d.f3430d;
            }
            while (!this.f3434c.isEmpty()) {
                c poll = this.f3434c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f);
            this.f3432a.a(cVar);
            return cVar;
        }

        void a(c cVar) {
            cVar.a(c() + this.f3433b);
            this.f3434c.offer(cVar);
        }

        void b() {
            if (this.f3434c.isEmpty()) {
                return;
            }
            long c2 = c();
            Iterator<c> it = this.f3434c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.b() > c2) {
                    return;
                }
                if (this.f3434c.remove(next)) {
                    this.f3432a.b(next);
                }
            }
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            this.f3432a.a();
            Future<?> future = this.f3436e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f3435d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public d() {
        this(f3428b);
    }

    public d(ThreadFactory threadFactory) {
        this.f3431e = threadFactory;
        this.f = new AtomicReference<>(g);
        b();
    }

    @Override // b.b.i
    public void b() {
        a aVar = new a(h, i, this.f3431e);
        if (this.f.compareAndSet(g, aVar)) {
            return;
        }
        aVar.d();
    }

    @Override // b.b.i
    public i.c a() {
        return new b(this.f.get());
    }

    /* compiled from: IoScheduler.java */
    /* loaded from: classes.dex */
    static final class b extends i.c {

        /* renamed from: a  reason: collision with root package name */
        final AtomicBoolean f3437a = new AtomicBoolean();

        /* renamed from: b  reason: collision with root package name */
        private final b.b.b.a f3438b = new b.b.b.a();

        /* renamed from: c  reason: collision with root package name */
        private final a f3439c;

        /* renamed from: d  reason: collision with root package name */
        private final c f3440d;

        b(a aVar) {
            this.f3439c = aVar;
            this.f3440d = aVar.a();
        }

        @Override // b.b.b.b
        public void a() {
            if (this.f3437a.compareAndSet(false, true)) {
                this.f3438b.a();
                this.f3439c.a(this.f3440d);
            }
        }

        @Override // b.b.i.c
        public b.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f3438b.b()) {
                return b.b.e.a.c.INSTANCE;
            }
            return this.f3440d.a(runnable, j, timeUnit, this.f3438b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes.dex */
    public static final class c extends f {

        /* renamed from: b  reason: collision with root package name */
        private long f3441b;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f3441b = 0L;
        }

        public long b() {
            return this.f3441b;
        }

        public void a(long j) {
            this.f3441b = j;
        }
    }
}
