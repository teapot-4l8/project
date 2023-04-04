package b.b.a.b;

import android.os.Handler;
import android.os.Message;
import b.b.b.c;
import b.b.i;
import java.util.concurrent.TimeUnit;

/* compiled from: HandlerScheduler.java */
/* loaded from: classes.dex */
final class b extends i {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3273b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f3274c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Handler handler, boolean z) {
        this.f3273b = handler;
        this.f3274c = z;
    }

    @Override // b.b.i
    public b.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            RunnableC0068b runnableC0068b = new RunnableC0068b(this.f3273b, b.b.g.a.a(runnable));
            this.f3273b.postDelayed(runnableC0068b, timeUnit.toMillis(j));
            return runnableC0068b;
        }
        throw new NullPointerException("run == null");
    }

    @Override // b.b.i
    public i.c a() {
        return new a(this.f3273b, this.f3274c);
    }

    /* compiled from: HandlerScheduler.java */
    /* loaded from: classes.dex */
    private static final class a extends i.c {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f3275a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f3276b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f3277c;

        a(Handler handler, boolean z) {
            this.f3275a = handler;
            this.f3276b = z;
        }

        @Override // b.b.i.c
        public b.b.b.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable != null) {
                if (timeUnit == null) {
                    throw new NullPointerException("unit == null");
                }
                if (this.f3277c) {
                    return c.a();
                }
                RunnableC0068b runnableC0068b = new RunnableC0068b(this.f3275a, b.b.g.a.a(runnable));
                Message obtain = Message.obtain(this.f3275a, runnableC0068b);
                obtain.obj = this;
                if (this.f3276b) {
                    obtain.setAsynchronous(true);
                }
                this.f3275a.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (this.f3277c) {
                    this.f3275a.removeCallbacks(runnableC0068b);
                    return c.a();
                }
                return runnableC0068b;
            }
            throw new NullPointerException("run == null");
        }

        @Override // b.b.b.b
        public void a() {
            this.f3277c = true;
            this.f3275a.removeCallbacksAndMessages(this);
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: b.b.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class RunnableC0068b implements b.b.b.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f3278a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f3279b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f3280c;

        RunnableC0068b(Handler handler, Runnable runnable) {
            this.f3278a = handler;
            this.f3279b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f3279b.run();
            } catch (Throwable th) {
                b.b.g.a.a(th);
            }
        }

        @Override // b.b.b.b
        public void a() {
            this.f3278a.removeCallbacks(this);
            this.f3280c = true;
        }
    }
}
