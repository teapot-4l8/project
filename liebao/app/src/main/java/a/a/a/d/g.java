package a.a.a.d;

/* compiled from: CAARecord.java */
/* loaded from: classes.dex */
public class g extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f301a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f302b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f303c;

    @Override // a.a.a.d.bx
    bx a() {
        return new g();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f301a = tVar.g();
        this.f302b = tVar.k();
        this.f303c = tVar.j();
    }

    @Override // a.a.a.d.bx
    String b() {
        return this.f301a + " " + a(this.f302b, false) + " " + a(this.f303c, true);
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(this.f301a);
        vVar.b(this.f302b);
        vVar.a(this.f303c);
    }
}
