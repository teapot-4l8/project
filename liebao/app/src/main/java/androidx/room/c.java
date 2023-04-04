package androidx.room;

/* compiled from: EntityInsertionAdapter.java */
/* loaded from: classes.dex */
public abstract class c<T> extends n {
    protected abstract void a(androidx.e.a.f fVar, T t);

    public c(j jVar) {
        super(jVar);
    }

    public final void a(T t) {
        androidx.e.a.f c2 = c();
        try {
            a(c2, t);
            c2.b();
        } finally {
            a(c2);
        }
    }

    public final long b(T t) {
        androidx.e.a.f c2 = c();
        try {
            a(c2, t);
            return c2.b();
        } finally {
            a(c2);
        }
    }
}
