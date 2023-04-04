package a.a.a.d;

/* compiled from: URIRecord.java */
/* loaded from: classes.dex */
public class de extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f281a;

    /* renamed from: b  reason: collision with root package name */
    private int f282b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f283c = new byte[0];

    @Override // a.a.a.d.bx
    bx a() {
        return new de();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f281a = tVar.h();
        this.f282b = tVar.h();
        this.f283c = tVar.j();
    }

    @Override // a.a.a.d.bx
    String b() {
        return this.f281a + " " + this.f282b + " " + a(this.f283c, true);
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.c(this.f281a);
        vVar.c(this.f282b);
        vVar.a(this.f283c);
    }
}
