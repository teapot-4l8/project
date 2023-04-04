package a.a.a.d;

/* compiled from: ISDNRecord.java */
/* loaded from: classes.dex */
public class ah extends bx {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f127a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f128b;

    @Override // a.a.a.d.bx
    bx a() {
        return new ah();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f127a = tVar.k();
        if (tVar.b() > 0) {
            this.f128b = tVar.k();
        }
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(this.f127a);
        byte[] bArr = this.f128b;
        if (bArr != null) {
            vVar.b(bArr);
        }
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(a(this.f127a, true));
        if (this.f128b != null) {
            sb.append(" ");
            sb.append(a(this.f128b, true));
        }
        return sb.toString();
    }
}
