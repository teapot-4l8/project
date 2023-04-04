package a.a.a.d;

/* compiled from: NSEC3Record.java */
/* loaded from: classes.dex */
public class bd extends bx {
    private static final a.a.a.d.a.b k = new a.a.a.d.a.b("0123456789ABCDEFGHIJKLMNOPQRSTUV=", false, false);

    /* renamed from: a  reason: collision with root package name */
    private int f168a;

    /* renamed from: b  reason: collision with root package name */
    private int f169b;

    /* renamed from: c  reason: collision with root package name */
    private int f170c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f171d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f172e;
    private da f;

    @Override // a.a.a.d.bx
    bx a() {
        return new bd();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f168a = tVar.g();
        this.f169b = tVar.g();
        this.f170c = tVar.h();
        int g = tVar.g();
        if (g > 0) {
            this.f171d = tVar.d(g);
        } else {
            this.f171d = null;
        }
        this.f172e = tVar.d(tVar.g());
        this.f = new da(tVar);
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(this.f168a);
        vVar.b(this.f169b);
        vVar.c(this.f170c);
        byte[] bArr = this.f171d;
        if (bArr != null) {
            vVar.b(bArr.length);
            vVar.a(this.f171d);
        } else {
            vVar.b(0);
        }
        vVar.b(this.f172e.length);
        vVar.a(this.f172e);
        this.f.a(vVar);
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f168a);
        sb.append(' ');
        sb.append(this.f169b);
        sb.append(' ');
        sb.append(this.f170c);
        sb.append(' ');
        byte[] bArr = this.f171d;
        if (bArr == null) {
            sb.append('-');
        } else {
            sb.append(a.a.a.d.a.a.a(bArr));
        }
        sb.append(' ');
        sb.append(k.a(this.f172e));
        if (!this.f.a()) {
            sb.append(' ');
            sb.append(this.f.toString());
        }
        return sb.toString();
    }
}
