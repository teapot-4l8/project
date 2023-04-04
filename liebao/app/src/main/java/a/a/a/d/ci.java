package a.a.a.d;

/* compiled from: SRVRecord.java */
/* loaded from: classes.dex */
public class ci extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f221a;

    /* renamed from: b  reason: collision with root package name */
    private int f222b;

    /* renamed from: c  reason: collision with root package name */
    private int f223c;

    /* renamed from: d  reason: collision with root package name */
    private bj f224d;

    @Override // a.a.a.d.bx
    bx a() {
        return new ci();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f221a = tVar.h();
        this.f222b = tVar.h();
        this.f223c = tVar.h();
        this.f224d = new bj(tVar);
    }

    @Override // a.a.a.d.bx
    String b() {
        return this.f221a + " " + this.f222b + " " + this.f223c + " " + this.f224d;
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.c(this.f221a);
        vVar.c(this.f222b);
        vVar.c(this.f223c);
        this.f224d.a(vVar, (o) null, z);
    }

    @Override // a.a.a.d.bx
    public bj c() {
        return this.f224d;
    }
}
