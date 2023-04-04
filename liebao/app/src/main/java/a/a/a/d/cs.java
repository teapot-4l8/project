package a.a.a.d;

/* compiled from: TLSARecord.java */
/* loaded from: classes.dex */
public class cs extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f247a;

    /* renamed from: b  reason: collision with root package name */
    private int f248b;

    /* renamed from: c  reason: collision with root package name */
    private int f249c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f250d;

    @Override // a.a.a.d.bx
    bx a() {
        return new cs();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f247a = tVar.g();
        this.f248b = tVar.g();
        this.f249c = tVar.g();
        this.f250d = tVar.j();
    }

    @Override // a.a.a.d.bx
    String b() {
        return this.f247a + " " + this.f248b + " " + this.f249c + " " + a.a.a.d.a.a.a(this.f250d);
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(this.f247a);
        vVar.b(this.f248b);
        vVar.b(this.f249c);
        vVar.a(this.f250d);
    }
}
