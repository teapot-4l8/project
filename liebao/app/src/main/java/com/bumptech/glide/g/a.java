package com.bumptech.glide.g;

/* compiled from: ErrorRequestCoordinator.java */
/* loaded from: classes.dex */
public final class a implements b, c {

    /* renamed from: a  reason: collision with root package name */
    private final c f5177a;

    /* renamed from: b  reason: collision with root package name */
    private b f5178b;

    /* renamed from: c  reason: collision with root package name */
    private b f5179c;

    public a(c cVar) {
        this.f5177a = cVar;
    }

    public void a(b bVar, b bVar2) {
        this.f5178b = bVar;
        this.f5179c = bVar2;
    }

    @Override // com.bumptech.glide.g.b
    public void a() {
        if (this.f5178b.c()) {
            return;
        }
        this.f5178b.a();
    }

    @Override // com.bumptech.glide.g.b
    public void b() {
        this.f5178b.b();
        if (this.f5179c.c()) {
            this.f5179c.b();
        }
    }

    @Override // com.bumptech.glide.g.b
    public boolean c() {
        return (this.f5178b.g() ? this.f5179c : this.f5178b).c();
    }

    @Override // com.bumptech.glide.g.b
    public boolean d() {
        return (this.f5178b.g() ? this.f5179c : this.f5178b).d();
    }

    @Override // com.bumptech.glide.g.b
    public boolean e() {
        return (this.f5178b.g() ? this.f5179c : this.f5178b).e();
    }

    @Override // com.bumptech.glide.g.b
    public boolean f() {
        return (this.f5178b.g() ? this.f5179c : this.f5178b).f();
    }

    @Override // com.bumptech.glide.g.b
    public boolean g() {
        return this.f5178b.g() && this.f5179c.g();
    }

    @Override // com.bumptech.glide.g.b
    public void h() {
        this.f5178b.h();
        this.f5179c.h();
    }

    @Override // com.bumptech.glide.g.b
    public boolean a(b bVar) {
        if (bVar instanceof a) {
            a aVar = (a) bVar;
            return this.f5178b.a(aVar.f5178b) && this.f5179c.a(aVar.f5179c);
        }
        return false;
    }

    @Override // com.bumptech.glide.g.c
    public boolean b(b bVar) {
        return j() && g(bVar);
    }

    private boolean j() {
        c cVar = this.f5177a;
        return cVar == null || cVar.b(this);
    }

    @Override // com.bumptech.glide.g.c
    public boolean c(b bVar) {
        return l() && g(bVar);
    }

    @Override // com.bumptech.glide.g.c
    public boolean d(b bVar) {
        return k() && g(bVar);
    }

    private boolean k() {
        c cVar = this.f5177a;
        return cVar == null || cVar.d(this);
    }

    private boolean l() {
        c cVar = this.f5177a;
        return cVar == null || cVar.c(this);
    }

    private boolean g(b bVar) {
        return bVar.equals(this.f5178b) || (this.f5178b.g() && bVar.equals(this.f5179c));
    }

    @Override // com.bumptech.glide.g.c
    public boolean i() {
        return m() || e();
    }

    private boolean m() {
        c cVar = this.f5177a;
        return cVar != null && cVar.i();
    }

    @Override // com.bumptech.glide.g.c
    public void e(b bVar) {
        c cVar = this.f5177a;
        if (cVar != null) {
            cVar.e(this);
        }
    }

    @Override // com.bumptech.glide.g.c
    public void f(b bVar) {
        if (!bVar.equals(this.f5179c)) {
            if (this.f5179c.c()) {
                return;
            }
            this.f5179c.a();
            return;
        }
        c cVar = this.f5177a;
        if (cVar != null) {
            cVar.f(this);
        }
    }
}
