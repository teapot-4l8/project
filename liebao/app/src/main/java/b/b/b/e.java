package b.b.b;

/* compiled from: RunnableDisposable.java */
/* loaded from: classes.dex */
final class e extends d<Runnable> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Runnable runnable) {
        super(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.b.b.d
    public void a(Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + b() + ", " + get() + ")";
    }
}
