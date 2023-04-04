package a.a.a.d;

/* compiled from: NAPTRRecord.java */
/* loaded from: classes.dex */
public class az extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f157a;

    /* renamed from: b  reason: collision with root package name */
    private int f158b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f159c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f160d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f161e;
    private bj f;

    @Override // a.a.a.d.bx
    bx a() {
        return new az();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f157a = tVar.h();
        this.f158b = tVar.h();
        this.f159c = tVar.k();
        this.f160d = tVar.k();
        this.f161e = tVar.k();
        this.f = new bj(tVar);
    }

    @Override // a.a.a.d.bx
    String b() {
        return this.f157a + " " + this.f158b + " " + a(this.f159c, true) + " " + a(this.f160d, true) + " " + a(this.f161e, true) + " " + this.f;
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.c(this.f157a);
        vVar.c(this.f158b);
        vVar.b(this.f159c);
        vVar.b(this.f160d);
        vVar.b(this.f161e);
        this.f.a(vVar, (o) null, z);
    }

    @Override // a.a.a.d.bx
    public bj c() {
        return this.f;
    }
}
