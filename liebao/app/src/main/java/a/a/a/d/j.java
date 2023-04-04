package a.a.a.d;

/* compiled from: CERTRecord.java */
/* loaded from: classes.dex */
public class j extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f304a;

    /* renamed from: b  reason: collision with root package name */
    private int f305b;

    /* renamed from: c  reason: collision with root package name */
    private int f306c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f307d;

    @Override // a.a.a.d.bx
    bx a() {
        return new j();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f304a = tVar.h();
        this.f305b = tVar.h();
        this.f306c = tVar.g();
        this.f307d = tVar.j();
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f304a);
        sb.append(" ");
        sb.append(this.f305b);
        sb.append(" ");
        sb.append(this.f306c);
        if (this.f307d != null) {
            if (bo.b("multiline")) {
                sb.append(" (\n");
                sb.append(a.a.a.d.a.c.a(this.f307d, 64, "\t", true));
            } else {
                sb.append(" ");
                sb.append(a.a.a.d.a.c.a(this.f307d));
            }
        }
        return sb.toString();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.c(this.f304a);
        vVar.c(this.f305b);
        vVar.b(this.f306c);
        vVar.a(this.f307d);
    }
}
