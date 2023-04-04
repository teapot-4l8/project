package c;

/* compiled from: ForwardingSink.java */
/* loaded from: classes.dex */
public abstract class g implements r {

    /* renamed from: a  reason: collision with root package name */
    private final r f3550a;

    public g(r rVar) {
        if (rVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f3550a = rVar;
    }

    @Override // c.r
    public void a_(c cVar, long j) {
        this.f3550a.a_(cVar, j);
    }

    @Override // c.r, java.io.Flushable
    public void flush() {
        this.f3550a.flush();
    }

    @Override // c.r
    public t a() {
        return this.f3550a.a();
    }

    @Override // c.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3550a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f3550a.toString() + ")";
    }
}
