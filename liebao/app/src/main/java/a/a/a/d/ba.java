package a.a.a.d;

/* compiled from: NSAPRecord.java */
/* loaded from: classes.dex */
public class ba extends bx {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f163a;

    @Override // a.a.a.d.bx
    bx a() {
        return new ba();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f163a = tVar.j();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.a(this.f163a);
    }

    @Override // a.a.a.d.bx
    String b() {
        return "0x" + a.a.a.d.a.a.a(this.f163a);
    }
}
