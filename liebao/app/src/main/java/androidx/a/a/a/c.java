package androidx.a.a.a;

/* compiled from: TaskExecutor.java */
/* loaded from: classes.dex */
public abstract class c {
    public abstract void a(Runnable runnable);

    public abstract void b(Runnable runnable);

    public abstract boolean c();

    public void c(Runnable runnable) {
        if (c()) {
            runnable.run();
        } else {
            b(runnable);
        }
    }
}
