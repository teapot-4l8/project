package a.a.a.d;

/* compiled from: DLVRecord.java */
/* loaded from: classes.dex */
public class r extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f333a;

    /* renamed from: b  reason: collision with root package name */
    private int f334b;

    /* renamed from: c  reason: collision with root package name */
    private int f335c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f336d;

    @Override // a.a.a.d.bx
    bx a() {
        return new r();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f333a = tVar.h();
        this.f334b = tVar.g();
        this.f335c = tVar.g();
        this.f336d = tVar.j();
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f333a);
        sb.append(" ");
        sb.append(this.f334b);
        sb.append(" ");
        sb.append(this.f335c);
        if (this.f336d != null) {
            sb.append(" ");
            sb.append(a.a.a.d.a.a.a(this.f336d));
        }
        return sb.toString();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.c(this.f333a);
        vVar.b(this.f334b);
        vVar.b(this.f335c);
        byte[] bArr = this.f336d;
        if (bArr != null) {
            vVar.a(bArr);
        }
    }
}
