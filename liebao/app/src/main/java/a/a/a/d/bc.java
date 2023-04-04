package a.a.a.d;

/* compiled from: NSEC3PARAMRecord.java */
/* loaded from: classes.dex */
public class bc extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f164a;

    /* renamed from: b  reason: collision with root package name */
    private int f165b;

    /* renamed from: c  reason: collision with root package name */
    private int f166c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f167d;

    @Override // a.a.a.d.bx
    bx a() {
        return new bc();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f164a = tVar.g();
        this.f165b = tVar.g();
        this.f166c = tVar.h();
        int g = tVar.g();
        if (g > 0) {
            this.f167d = tVar.d(g);
        } else {
            this.f167d = null;
        }
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(this.f164a);
        vVar.b(this.f165b);
        vVar.c(this.f166c);
        byte[] bArr = this.f167d;
        if (bArr != null) {
            vVar.b(bArr.length);
            vVar.a(this.f167d);
            return;
        }
        vVar.b(0);
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f164a);
        sb.append(' ');
        sb.append(this.f165b);
        sb.append(' ');
        sb.append(this.f166c);
        sb.append(' ');
        byte[] bArr = this.f167d;
        if (bArr == null) {
            sb.append('-');
        } else {
            sb.append(a.a.a.d.a.a.a(bArr));
        }
        return sb.toString();
    }
}
