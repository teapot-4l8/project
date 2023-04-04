package b.b.e.d;

import b.b.h;

/* compiled from: BasicFuseableObserver.java */
/* loaded from: classes.dex */
public abstract class a<T, R> implements b.b.e.c.a<R>, h<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final h<? super R> f3304a;

    /* renamed from: b  reason: collision with root package name */
    protected b.b.b.b f3305b;

    /* renamed from: c  reason: collision with root package name */
    protected b.b.e.c.a<T> f3306c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f3307d;

    /* renamed from: e  reason: collision with root package name */
    protected int f3308e;

    protected boolean e() {
        return true;
    }

    protected void f() {
    }

    public a(h<? super R> hVar) {
        this.f3304a = hVar;
    }

    @Override // b.b.h
    public final void a(b.b.b.b bVar) {
        if (b.b.e.a.b.a(this.f3305b, bVar)) {
            this.f3305b = bVar;
            if (bVar instanceof b.b.e.c.a) {
                this.f3306c = (b.b.e.c.a) bVar;
            }
            if (e()) {
                this.f3304a.a(this);
                f();
            }
        }
    }

    @Override // b.b.h
    public void a(Throwable th) {
        if (this.f3307d) {
            b.b.g.a.a(th);
            return;
        }
        this.f3307d = true;
        this.f3304a.a(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(Throwable th) {
        b.b.c.b.b(th);
        this.f3305b.a();
        a(th);
    }

    @Override // b.b.h
    public void b() {
        if (this.f3307d) {
            return;
        }
        this.f3307d = true;
        this.f3304a.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int b(int i) {
        b.b.e.c.a<T> aVar = this.f3306c;
        if (aVar == null || (i & 4) != 0) {
            return 0;
        }
        int a2 = aVar.a(i);
        if (a2 != 0) {
            this.f3308e = a2;
        }
        return a2;
    }

    @Override // b.b.b.b
    public void a() {
        this.f3305b.a();
    }

    @Override // b.b.e.c.e
    public boolean c() {
        return this.f3306c.c();
    }

    @Override // b.b.e.c.e
    public void d() {
        this.f3306c.d();
    }

    @Override // b.b.e.c.e
    public final boolean a(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
