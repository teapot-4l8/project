package a.a.a.d;

/* compiled from: GPOSRecord.java */
/* loaded from: classes.dex */
public class ac extends bx {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f112a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f113b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f114c;

    @Override // a.a.a.d.bx
    bx a() {
        return new ac();
    }

    private void a(double d2, double d3) {
        if (d2 < -90.0d || d2 > 90.0d) {
            throw new IllegalArgumentException("illegal longitude " + d2);
        } else if (d3 < -180.0d || d3 > 180.0d) {
            throw new IllegalArgumentException("illegal latitude " + d3);
        }
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f113b = tVar.k();
        this.f112a = tVar.k();
        this.f114c = tVar.k();
        try {
            a(d(), f());
        } catch (IllegalArgumentException e2) {
            throw new dg(e2.getMessage());
        }
    }

    @Override // a.a.a.d.bx
    String b() {
        return a(this.f113b, true) + " " + a(this.f112a, true) + " " + a(this.f114c, true);
    }

    public String k_() {
        return a(this.f113b, false);
    }

    public double d() {
        return Double.parseDouble(k_());
    }

    public String e() {
        return a(this.f112a, false);
    }

    public double f() {
        return Double.parseDouble(e());
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(this.f113b);
        vVar.b(this.f112a);
        vVar.b(this.f114c);
    }
}
