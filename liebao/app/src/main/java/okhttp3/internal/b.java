package okhttp3.internal;

/* compiled from: NamedRunnable.java */
/* loaded from: classes2.dex */
public abstract class b implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    protected final String f7437c;

    protected abstract void c();

    public b(String str, Object... objArr) {
        this.f7437c = c.a(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f7437c);
        try {
            c();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
