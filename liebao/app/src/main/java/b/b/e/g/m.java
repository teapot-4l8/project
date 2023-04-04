package b.b.e.g;

import b.b.i;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TrampolineScheduler.java */
/* loaded from: classes.dex */
public final class m extends b.b.i {

    /* renamed from: b  reason: collision with root package name */
    private static final m f3467b = new m();

    public static m c() {
        return f3467b;
    }

    @Override // b.b.i
    public i.c a() {
        return new c();
    }

    m() {
    }

    @Override // b.b.i
    public b.b.b.b a(Runnable runnable) {
        b.b.g.a.a(runnable).run();
        return b.b.e.a.c.INSTANCE;
    }

    @Override // b.b.i
    public b.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            b.b.g.a.a(runnable).run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            b.b.g.a.a(e2);
        }
        return b.b.e.a.c.INSTANCE;
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    static final class c extends i.c implements b.b.b.b {

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f3477c;

        /* renamed from: a  reason: collision with root package name */
        final PriorityBlockingQueue<b> f3475a = new PriorityBlockingQueue<>();

        /* renamed from: d  reason: collision with root package name */
        private final AtomicInteger f3478d = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        final AtomicInteger f3476b = new AtomicInteger();

        c() {
        }

        @Override // b.b.i.c
        public b.b.b.b a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // b.b.i.c
        public b.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return a(new a(runnable, this, a2), a2);
        }

        b.b.b.b a(Runnable runnable, long j) {
            if (this.f3477c) {
                return b.b.e.a.c.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.f3476b.incrementAndGet());
            this.f3475a.add(bVar);
            if (this.f3478d.getAndIncrement() == 0) {
                int i = 1;
                while (!this.f3477c) {
                    b poll = this.f3475a.poll();
                    if (poll != null) {
                        if (!poll.f3474d) {
                            poll.f3471a.run();
                        }
                    } else {
                        i = this.f3478d.addAndGet(-i);
                        if (i == 0) {
                            return b.b.e.a.c.INSTANCE;
                        }
                    }
                }
                this.f3475a.clear();
                return b.b.e.a.c.INSTANCE;
            }
            return b.b.b.c.a(new a(bVar));
        }

        @Override // b.b.b.b
        public void a() {
            this.f3477c = true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* loaded from: classes.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final b f3479a;

            a(b bVar) {
                this.f3479a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f3479a.f3474d = true;
                c.this.f3475a.remove(this.f3479a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f3471a;

        /* renamed from: b  reason: collision with root package name */
        final long f3472b;

        /* renamed from: c  reason: collision with root package name */
        final int f3473c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f3474d;

        b(Runnable runnable, Long l, int i) {
            this.f3471a = runnable;
            this.f3472b = l.longValue();
            this.f3473c = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(b bVar) {
            int a2 = b.b.e.b.b.a(this.f3472b, bVar.f3472b);
            return a2 == 0 ? b.b.e.b.b.a(this.f3473c, bVar.f3473c) : a2;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes.dex */
    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f3468a;

        /* renamed from: b  reason: collision with root package name */
        private final c f3469b;

        /* renamed from: c  reason: collision with root package name */
        private final long f3470c;

        a(Runnable runnable, c cVar, long j) {
            this.f3468a = runnable;
            this.f3469b = cVar;
            this.f3470c = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3469b.f3477c) {
                return;
            }
            long a2 = this.f3469b.a(TimeUnit.MILLISECONDS);
            long j = this.f3470c;
            if (j > a2) {
                try {
                    Thread.sleep(j - a2);
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    b.b.g.a.a(e2);
                    return;
                }
            }
            if (this.f3469b.f3477c) {
                return;
            }
            this.f3468a.run();
        }
    }
}
