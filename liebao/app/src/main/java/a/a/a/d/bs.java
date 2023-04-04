package a.a.a.d;

/* compiled from: RPRecord.java */
/* loaded from: classes.dex */
public class bs extends bx {

    /* renamed from: a  reason: collision with root package name */
    private bj f190a;

    /* renamed from: b  reason: collision with root package name */
    private bj f191b;

    @Override // a.a.a.d.bx
    bx a() {
        return new bs();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f190a = new bj(tVar);
        this.f191b = new bj(tVar);
    }

    @Override // a.a.a.d.bx
    String b() {
        return this.f190a + " " + this.f191b;
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        this.f190a.a(vVar, (o) null, z);
        this.f191b.a(vVar, (o) null, z);
    }
}
