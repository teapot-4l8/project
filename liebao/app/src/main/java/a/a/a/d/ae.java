package a.a.a.d;

/* compiled from: HINFORecord.java */
/* loaded from: classes.dex */
public class ae extends bx {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f116a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f117b;

    @Override // a.a.a.d.bx
    bx a() {
        return new ae();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f116a = tVar.k();
        this.f117b = tVar.k();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(this.f116a);
        vVar.b(this.f117b);
    }

    @Override // a.a.a.d.bx
    String b() {
        return a(this.f116a, true) + " " + a(this.f117b, true);
    }
}
