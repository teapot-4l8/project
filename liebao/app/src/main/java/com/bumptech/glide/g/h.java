package com.bumptech.glide.g;

/* compiled from: ThumbnailRequestCoordinator.java */
/* loaded from: classes.dex */
public class h implements b, c {

    /* renamed from: a  reason: collision with root package name */
    private final c f5214a;

    /* renamed from: b  reason: collision with root package name */
    private b f5215b;

    /* renamed from: c  reason: collision with root package name */
    private b f5216c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5217d;

    h() {
        this(null);
    }

    public h(c cVar) {
        this.f5214a = cVar;
    }

    public void a(b bVar, b bVar2) {
        this.f5215b = bVar;
        this.f5216c = bVar2;
    }

    @Override // com.bumptech.glide.g.c
    public boolean b(b bVar) {
        return j() && (bVar.equals(this.f5215b) || !this.f5215b.e());
    }

    private boolean j() {
        c cVar = this.f5214a;
        return cVar == null || cVar.b(this);
    }

    @Override // com.bumptech.glide.g.c
    public boolean c(b bVar) {
        return l() && bVar.equals(this.f5215b) && !i();
    }

    @Override // com.bumptech.glide.g.c
    public boolean d(b bVar) {
        return k() && bVar.equals(this.f5215b);
    }

    private boolean k() {
        c cVar = this.f5214a;
        return cVar == null || cVar.d(this);
    }

    private boolean l() {
        c cVar = this.f5214a;
        return cVar == null || cVar.c(this);
    }

    @Override // com.bumptech.glide.g.c
    public boolean i() {
        return m() || e();
    }

    @Override // com.bumptech.glide.g.c
    public void e(b bVar) {
        if (bVar.equals(this.f5216c)) {
            return;
        }
        c cVar = this.f5214a;
        if (cVar != null) {
            cVar.e(this);
        }
        if (this.f5216c.d()) {
            return;
        }
        this.f5216c.b();
    }

    @Override // com.bumptech.glide.g.c
    public void f(b bVar) {
        c cVar;
        if (bVar.equals(this.f5215b) && (cVar = this.f5214a) != null) {
            cVar.f(this);
        }
    }

    private boolean m() {
        c cVar = this.f5214a;
        return cVar != null && cVar.i();
    }

    @Override // com.bumptech.glide.g.b
    public void a() {
        this.f5217d = true;
        if (!this.f5215b.d() && !this.f5216c.c()) {
            this.f5216c.a();
        }
        if (!this.f5217d || this.f5215b.c()) {
            return;
        }
        this.f5215b.a();
    }

    @Override // com.bumptech.glide.g.b
    public void b() {
        this.f5217d = false;
        this.f5216c.b();
        this.f5215b.b();
    }

    @Override // com.bumptech.glide.g.b
    public boolean c() {
        return this.f5215b.c();
    }

    @Override // com.bumptech.glide.g.b
    public boolean d() {
        return this.f5215b.d() || this.f5216c.d();
    }

    @Override // com.bumptech.glide.g.b
    public boolean e() {
        return this.f5215b.e() || this.f5216c.e();
    }

    @Override // com.bumptech.glide.g.b
    public boolean f() {
        return this.f5215b.f();
    }

    @Override // com.bumptech.glide.g.b
    public boolean g() {
        return this.f5215b.g();
    }

    @Override // com.bumptech.glide.g.b
    public void h() {
        this.f5215b.h();
        this.f5216c.h();
    }

    @Override // com.bumptech.glide.g.b
    public boolean a(b bVar) {
        if (bVar instanceof h) {
            h hVar = (h) bVar;
            b bVar2 = this.f5215b;
            if (bVar2 == null) {
                if (hVar.f5215b != null) {
                    return false;
                }
            } else if (!bVar2.a(hVar.f5215b)) {
                return false;
            }
            b bVar3 = this.f5216c;
            b bVar4 = hVar.f5216c;
            if (bVar3 == null) {
                if (bVar4 != null) {
                    return false;
                }
            } else if (!bVar3.a(bVar4)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
