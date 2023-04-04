package a.a.a.d;

/* compiled from: MINFORecord.java */
/* loaded from: classes.dex */
public class au extends bx {

    /* renamed from: a  reason: collision with root package name */
    private bj f145a;

    /* renamed from: b  reason: collision with root package name */
    private bj f146b;

    @Override // a.a.a.d.bx
    bx a() {
        return new au();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f145a = new bj(tVar);
        this.f146b = new bj(tVar);
    }

    @Override // a.a.a.d.bx
    String b() {
        return this.f145a + " " + this.f146b;
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        this.f145a.a(vVar, (o) null, z);
        this.f146b.a(vVar, (o) null, z);
    }
}
