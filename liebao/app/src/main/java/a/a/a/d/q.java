package a.a.a.d;

/* compiled from: DHCIDRecord.java */
/* loaded from: classes.dex */
public class q extends bx {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f332a;

    @Override // a.a.a.d.bx
    bx a() {
        return new q();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f332a = tVar.j();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.a(this.f332a);
    }

    @Override // a.a.a.d.bx
    String b() {
        return a.a.a.d.a.c.a(this.f332a);
    }
}
