package a.a.a.d;

/* compiled from: OPENPGPKEYRecord.java */
/* loaded from: classes.dex */
public class bl extends bx {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f183a;

    @Override // a.a.a.d.bx
    bx a() {
        return new bl();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f183a = tVar.j();
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        if (this.f183a != null) {
            if (bo.b("multiline")) {
                sb.append("(\n");
                sb.append(a.a.a.d.a.c.a(this.f183a, 64, "\t", true));
            } else {
                sb.append(a.a.a.d.a.c.a(this.f183a));
            }
        }
        return sb.toString();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.a(this.f183a);
    }
}
