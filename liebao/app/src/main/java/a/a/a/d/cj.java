package a.a.a.d;

/* compiled from: SSHFPRecord.java */
/* loaded from: classes.dex */
public class cj extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f225a;

    /* renamed from: b  reason: collision with root package name */
    private int f226b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f227c;

    @Override // a.a.a.d.bx
    bx a() {
        return new cj();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f225a = tVar.g();
        this.f226b = tVar.g();
        this.f227c = tVar.j();
    }

    @Override // a.a.a.d.bx
    String b() {
        return this.f225a + " " + this.f226b + " " + a.a.a.d.a.a.a(this.f227c);
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(this.f225a);
        vVar.b(this.f226b);
        vVar.a(this.f227c);
    }
}
