package b.b.e.g;

import java.util.concurrent.Callable;

/* compiled from: ScheduledDirectTask.java */
/* loaded from: classes.dex */
public final class i extends a implements Callable<Void> {
    public i(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b */
    public Void call() {
        this.f3410b = Thread.currentThread();
        try {
            this.f3409a.run();
            return null;
        } finally {
            lazySet(f3407c);
            this.f3410b = null;
        }
    }
}
