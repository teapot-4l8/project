package a.a.a.d;

/* compiled from: X25Record.java */
/* loaded from: classes.dex */
public class dh extends bx {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f287a;

    @Override // a.a.a.d.bx
    bx a() {
        return new dh();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f287a = tVar.k();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(this.f287a);
    }

    @Override // a.a.a.d.bx
    String b() {
        return a(this.f287a, true);
    }
}
