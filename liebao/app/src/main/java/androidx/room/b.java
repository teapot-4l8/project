package androidx.room;

/* compiled from: EntityDeletionOrUpdateAdapter.java */
/* loaded from: classes.dex */
public abstract class b<T> extends n {
    @Override // androidx.room.n
    protected abstract String a();

    protected abstract void a(androidx.e.a.f fVar, T t);

    public b(j jVar) {
        super(jVar);
    }

    public final int a(T t) {
        androidx.e.a.f c2 = c();
        try {
            a(c2, t);
            return c2.a();
        } finally {
            a(c2);
        }
    }
}
