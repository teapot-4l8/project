package a.a.a.d;

import java.net.InetAddress;

/* compiled from: IPSECKEYRecord.java */
/* loaded from: classes.dex */
public class ag extends bx {

    /* renamed from: a  reason: collision with root package name */
    private int f122a;

    /* renamed from: b  reason: collision with root package name */
    private int f123b;

    /* renamed from: c  reason: collision with root package name */
    private int f124c;

    /* renamed from: d  reason: collision with root package name */
    private Object f125d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f126e;

    @Override // a.a.a.d.bx
    bx a() {
        return new ag();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f122a = tVar.g();
        this.f123b = tVar.g();
        this.f124c = tVar.g();
        int i = this.f123b;
        if (i == 0) {
            this.f125d = null;
        } else if (i == 1) {
            this.f125d = InetAddress.getByAddress(tVar.d(4));
        } else if (i == 2) {
            this.f125d = InetAddress.getByAddress(tVar.d(16));
        } else if (i == 3) {
            this.f125d = new bj(tVar);
        } else {
            throw new dg("invalid gateway type");
        }
        if (tVar.b() > 0) {
            this.f126e = tVar.j();
        }
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f122a);
        sb.append(" ");
        sb.append(this.f123b);
        sb.append(" ");
        sb.append(this.f124c);
        sb.append(" ");
        int i = this.f123b;
        if (i == 0) {
            sb.append(".");
        } else if (i == 1 || i == 2) {
            sb.append(((InetAddress) this.f125d).getHostAddress());
        } else if (i == 3) {
            sb.append(this.f125d);
        }
        if (this.f126e != null) {
            sb.append(" ");
            sb.append(a.a.a.d.a.c.a(this.f126e));
        }
        return sb.toString();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.b(this.f122a);
        vVar.b(this.f123b);
        vVar.b(this.f124c);
        int i = this.f123b;
        if (i == 1 || i == 2) {
            vVar.a(((InetAddress) this.f125d).getAddress());
        } else if (i == 3) {
            ((bj) this.f125d).a(vVar, (o) null, z);
        }
        byte[] bArr = this.f126e;
        if (bArr != null) {
            vVar.a(bArr);
        }
    }
}
