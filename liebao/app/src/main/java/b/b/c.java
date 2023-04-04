package b.b;

/* compiled from: Flowable.java */
/* loaded from: classes.dex */
public abstract class c<T> {

    /* renamed from: a  reason: collision with root package name */
    static final int f3283a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int a() {
        return f3283a;
    }

    public final c<T> b() {
        return a(a(), false, true);
    }

    public final c<T> a(int i, boolean z, boolean z2) {
        b.b.e.b.b.a(i, "bufferSize");
        return b.b.g.a.a(new b.b.e.e.b.c(this, i, z2, z, b.b.e.b.a.f3299c));
    }

    public final c<T> c() {
        return b.b.g.a.a(new b.b.e.e.b.d(this));
    }

    public final c<T> d() {
        return b.b.g.a.a(new b.b.e.e.b.f(this));
    }
}
