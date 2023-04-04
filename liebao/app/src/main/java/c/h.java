package c;

/* compiled from: ForwardingSource.java */
/* loaded from: classes.dex */
public abstract class h implements s {

    /* renamed from: a  reason: collision with root package name */
    private final s f3551a;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f3551a = sVar;
    }

    public final s b() {
        return this.f3551a;
    }

    @Override // c.s
    public long a(c cVar, long j) {
        return this.f3551a.a(cVar, j);
    }

    @Override // c.s
    public t a() {
        return this.f3551a.a();
    }

    @Override // c.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3551a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f3551a.toString() + ")";
    }
}
