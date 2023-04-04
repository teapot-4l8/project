package a.a.a.d;

/* compiled from: U16NameBase.java */
/* loaded from: classes.dex */
abstract class db extends bx {

    /* renamed from: a  reason: collision with root package name */
    protected int f275a;

    /* renamed from: b  reason: collision with root package name */
    protected bj f276b;

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f275a = tVar.h();
        this.f276b = new bj(tVar);
    }

    @Override // a.a.a.d.bx
    String b() {
        return this.f275a + " " + this.f276b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bj e() {
        return this.f276b;
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.c(this.f275a);
        this.f276b.a(vVar, (o) null, z);
    }
}
