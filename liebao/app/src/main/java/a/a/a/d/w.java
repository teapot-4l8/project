package a.a.a.d;

/* compiled from: DSRecord.java */
/* loaded from: classes.dex */
public class w extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f343a;

    /* renamed from: b  reason: collision with root package name */
    private int f344b;

    /* renamed from: c  reason: collision with root package name */
    private int f345c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f346d;

    @Override // a.a.a.d.bx
    bx a() {
        return new w();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f343a = tVar.h();
        this.f344b = tVar.g();
        this.f345c = tVar.g();
        this.f346d = tVar.j();
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f343a);
        sb.append(" ");
        sb.append(this.f344b);
        sb.append(" ");
        sb.append(this.f345c);
        if (this.f346d != null) {
            sb.append(" ");
            sb.append(a.a.a.d.a.a.a(this.f346d));
        }
        return sb.toString();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.c(this.f343a);
        vVar.b(this.f344b);
        vVar.b(this.f345c);
        byte[] bArr = this.f346d;
        if (bArr != null) {
            vVar.a(bArr);
        }
    }
}
