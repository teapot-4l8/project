package a.a.a.d;

/* compiled from: PXRecord.java */
/* loaded from: classes.dex */
public class bq extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f187a;

    /* renamed from: b  reason: collision with root package name */
    private bj f188b;

    /* renamed from: c  reason: collision with root package name */
    private bj f189c;

    @Override // a.a.a.d.bx
    bx a() {
        return new bq();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f187a = tVar.h();
        this.f188b = new bj(tVar);
        this.f189c = new bj(tVar);
    }

    @Override // a.a.a.d.bx
    String b() {
        return this.f187a + " " + this.f188b + " " + this.f189c;
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.c(this.f187a);
        this.f188b.a(vVar, (o) null, z);
        this.f189c.a(vVar, (o) null, z);
    }
}
