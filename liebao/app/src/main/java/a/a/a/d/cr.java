package a.a.a.d;

import java.util.Date;

/* compiled from: TKEYRecord.java */
/* loaded from: classes.dex */
public class cr extends bx {

    /* renamed from: a  reason: collision with root package name */
    private bj f242a;

    /* renamed from: b  reason: collision with root package name */
    private Date f243b;

    /* renamed from: c  reason: collision with root package name */
    private Date f244c;

    /* renamed from: d  reason: collision with root package name */
    private int f245d;

    /* renamed from: e  reason: collision with root package name */
    private int f246e;
    private byte[] f;
    private byte[] k;

    @Override // a.a.a.d.bx
    bx a() {
        return new cr();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f242a = new bj(tVar);
        this.f243b = new Date(tVar.i() * 1000);
        this.f244c = new Date(tVar.i() * 1000);
        this.f245d = tVar.h();
        this.f246e = tVar.h();
        int h = tVar.h();
        if (h > 0) {
            this.f = tVar.d(h);
        } else {
            this.f = null;
        }
        int h2 = tVar.h();
        if (h2 > 0) {
            this.k = tVar.d(h2);
        } else {
            this.k = null;
        }
    }

    protected String e() {
        int i = this.f245d;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? Integer.toString(i) : "DELETE" : "RESOLVERASSIGNED" : "GSSAPI" : "DIFFIEHELLMAN" : "SERVERASSIGNED";
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f242a);
        sb.append(" ");
        if (bo.b("multiline")) {
            sb.append("(\n\t");
        }
        sb.append(ab.a(this.f243b));
        sb.append(" ");
        sb.append(ab.a(this.f244c));
        sb.append(" ");
        sb.append(e());
        sb.append(" ");
        sb.append(bw.b(this.f246e));
        if (bo.b("multiline")) {
            sb.append("\n");
            byte[] bArr = this.f;
            if (bArr != null) {
                sb.append(a.a.a.d.a.c.a(bArr, 64, "\t", false));
                sb.append("\n");
            }
            byte[] bArr2 = this.k;
            if (bArr2 != null) {
                sb.append(a.a.a.d.a.c.a(bArr2, 64, "\t", false));
            }
            sb.append(" )");
        } else {
            sb.append(" ");
            byte[] bArr3 = this.f;
            if (bArr3 != null) {
                sb.append(a.a.a.d.a.c.a(bArr3));
                sb.append(" ");
            }
            byte[] bArr4 = this.k;
            if (bArr4 != null) {
                sb.append(a.a.a.d.a.c.a(bArr4));
            }
        }
        return sb.toString();
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        this.f242a.a(vVar, (o) null, z);
        vVar.a(this.f243b.getTime() / 1000);
        vVar.a(this.f244c.getTime() / 1000);
        vVar.c(this.f245d);
        vVar.c(this.f246e);
        byte[] bArr = this.f;
        if (bArr != null) {
            vVar.c(bArr.length);
            vVar.a(this.f);
        } else {
            vVar.c(0);
        }
        byte[] bArr2 = this.k;
        if (bArr2 != null) {
            vVar.c(bArr2.length);
            vVar.a(this.k);
            return;
        }
        vVar.c(0);
    }
}
