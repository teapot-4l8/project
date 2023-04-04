package a.a.a.d;

/* compiled from: NSECRecord.java */
/* loaded from: classes.dex */
public class be extends bx {

    /* renamed from: a  reason: collision with root package name */
    private bj f173a;

    /* renamed from: b  reason: collision with root package name */
    private da f174b;

    @Override // a.a.a.d.bx
    bx a() {
        return new be();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f173a = new bj(tVar);
        this.f174b = new da(tVar);
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        this.f173a.a(vVar, (o) null, false);
        this.f174b.a(vVar);
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f173a);
        if (!this.f174b.a()) {
            sb.append(' ');
            sb.append(this.f174b.toString());
        }
        return sb.toString();
    }
}
