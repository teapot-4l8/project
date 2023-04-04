package b.b.e.g;

/* compiled from: ScheduledDirectPeriodicTask.java */
/* loaded from: classes.dex */
public final class h extends a implements Runnable {
    public h(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3410b = Thread.currentThread();
        try {
            this.f3409a.run();
            this.f3410b = null;
        } catch (Throwable th) {
            this.f3410b = null;
            lazySet(f3407c);
            b.b.g.a.a(th);
        }
    }
}
