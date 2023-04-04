package a.a.a.d;

import java.security.PublicKey;

/* compiled from: KEYBase.java */
/* loaded from: classes.dex */
abstract class al extends bx {

    /* renamed from: a  reason: collision with root package name */
    protected int f129a;

    /* renamed from: b  reason: collision with root package name */
    protected int f130b;

    /* renamed from: c  reason: collision with root package name */
    protected int f131c;

    /* renamed from: d  reason: collision with root package name */
    protected byte[] f132d;

    /* renamed from: e  reason: collision with root package name */
    protected int f133e = -1;
    protected PublicKey f = null;

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f129a = tVar.h();
        this.f130b = tVar.g();
        this.f131c = tVar.g();
        if (tVar.b() > 0) {
            this.f132d = tVar.j();
        }
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f129a);
        sb.append(" ");
        sb.append(this.f130b);
        sb.append(" ");
        sb.append(this.f131c);
        if (this.f132d != null) {
            if (bo.b("multiline")) {
                sb.append(" (\n");
                sb.append(a.a.a.d.a.c.a(this.f132d, 64, "\t", true));
                sb.append(" ; key_tag = ");
                sb.append(f_());
            } else {
                sb.append(" ");
                sb.append(a.a.a.d.a.c.a(this.f132d));
            }
        }
        return sb.toString();
    }

    public int f_() {
        int i;
        int i2;
        int i3 = this.f133e;
        if (i3 >= 0) {
            return i3;
        }
        v vVar = new v();
        int i4 = 0;
        a(vVar, (o) null, false);
        byte[] b2 = vVar.b();
        if (this.f131c == 1) {
            i2 = b2[b2.length - 2] & 255;
            i = (b2[b2.length - 3] & 255) << 8;
        } else {
            i = 0;
            while (i4 < b2.length - 1) {
                i += ((b2[i4] & 255) << 8) + (b2[i4 + 1] & 255);
                i4 += 2;
            }
            if (i4 < b2.length) {
                i += (b2[i4] & 255) << 8;
            }
            i2 = (i >> 16) & 65535;
        }
        int i5 = (i + i2) & 65535;
        this.f133e = i5;
        return i5;
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.c(this.f129a);
        vVar.b(this.f130b);
        vVar.b(this.f131c);
        byte[] bArr = this.f132d;
        if (bArr != null) {
            vVar.a(bArr);
        }
    }
}
