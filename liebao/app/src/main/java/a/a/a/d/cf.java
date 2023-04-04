package a.a.a.d;

/* compiled from: SMIMEARecord.java */
/* loaded from: classes.dex */
public class cf extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f212a;

    /* renamed from: b  reason: collision with root package name */
    private int f213b;

    /* renamed from: c  reason: collision with root package name */
    private int f214c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f215d;

    @Override // a.a.a.d.bx
    bx a() {
        return new cf();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f212a = tVar.g();
        this.f213b = tVar.g();
        this.f214c = tVar.g();
        this.f215d = tVar.j();
    }

    @Override // a.a.a.d.bx
    String b() {
        return this.f212a + " " + this.f213b + " " + this.f214c + " " + a.a.a.d.a.a.a(this.f215d);
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(this.f212a);
        vVar.b(this.f213b);
        vVar.b(this.f214c);
        vVar.a(this.f215d);
    }
}
