package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SharedSQLiteStatement.java */
/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f2479a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final j f2480b;

    /* renamed from: c  reason: collision with root package name */
    private volatile androidx.e.a.f f2481c;

    protected abstract String a();

    public n(j jVar) {
        this.f2480b = jVar;
    }

    protected void b() {
        this.f2480b.e();
    }

    private androidx.e.a.f d() {
        return this.f2480b.a(a());
    }

    private androidx.e.a.f a(boolean z) {
        if (z) {
            if (this.f2481c == null) {
                this.f2481c = d();
            }
            return this.f2481c;
        }
        return d();
    }

    public androidx.e.a.f c() {
        b();
        return a(this.f2479a.compareAndSet(false, true));
    }

    public void a(androidx.e.a.f fVar) {
        if (fVar == this.f2481c) {
            this.f2479a.set(false);
        }
    }
}
