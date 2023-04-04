package a.a.a.d;

import java.util.Date;

/* compiled from: TSIGRecord.java */
/* loaded from: classes.dex */
public class cu extends bx {

    /* renamed from: a  reason: collision with root package name */
    private bj f261a;

    /* renamed from: b  reason: collision with root package name */
    private Date f262b;

    /* renamed from: c  reason: collision with root package name */
    private int f263c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f264d;

    /* renamed from: e  reason: collision with root package name */
    private int f265e;
    private int f;
    private byte[] k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu() {
    }

    @Override // a.a.a.d.bx
    bx a() {
        return new cu();
    }

    public cu(bj bjVar, int i, long j, bj bjVar2, Date date, int i2, byte[] bArr, int i3, int i4, byte[] bArr2) {
        super(bjVar, 250, i, j);
        this.f261a = a("alg", bjVar2);
        this.f262b = date;
        this.f263c = a("fudge", i2);
        this.f264d = bArr;
        this.f265e = a("originalID", i3);
        this.f = a(com.umeng.analytics.pro.d.O, i4);
        this.k = bArr2;
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f261a = new bj(tVar);
        this.f262b = new Date(((tVar.h() << 32) + tVar.i()) * 1000);
        this.f263c = tVar.h();
        this.f264d = tVar.d(tVar.h());
        this.f265e = tVar.h();
        this.f = tVar.h();
        int h = tVar.h();
        if (h > 0) {
            this.k = tVar.d(h);
        } else {
            this.k = null;
        }
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f261a);
        sb.append(" ");
        if (bo.b("multiline")) {
            sb.append("(\n\t");
        }
        sb.append(this.f262b.getTime() / 1000);
        sb.append(" ");
        sb.append(this.f263c);
        sb.append(" ");
        sb.append(this.f264d.length);
        if (bo.b("multiline")) {
            sb.append("\n");
            sb.append(a.a.a.d.a.c.a(this.f264d, 64, "\t", false));
        } else {
            sb.append(" ");
            sb.append(a.a.a.d.a.c.a(this.f264d));
        }
        sb.append(" ");
        sb.append(bw.b(this.f));
        sb.append(" ");
        byte[] bArr = this.k;
        if (bArr == null) {
            sb.append(0);
        } else {
            sb.append(bArr.length);
            if (bo.b("multiline")) {
                sb.append("\n\n\n\t");
            } else {
                sb.append(" ");
            }
            if (this.f == 18) {
                byte[] bArr2 = this.k;
                if (bArr2.length != 6) {
                    sb.append("<invalid BADTIME other data>");
                } else {
                    sb.append("<server time: ");
                    sb.append(new Date((((bArr2[0] & 255) << 40) + ((bArr2[1] & 255) << 32) + ((bArr2[2] & 255) << 24) + ((bArr2[3] & 255) << 16) + ((bArr2[4] & 255) << 8) + (bArr2[5] & 255)) * 1000));
                    sb.append(">");
                }
            } else {
                sb.append("<");
                sb.append(a.a.a.d.a.c.a(this.k));
                sb.append(">");
            }
        }
        if (bo.b("multiline")) {
            sb.append(" )");
        }
        return sb.toString();
    }

    public bj e() {
        return this.f261a;
    }

    public Date f() {
        return this.f262b;
    }

    public int g() {
        return this.f263c;
    }

    public byte[] o() {
        return this.f264d;
    }

    public int p() {
        return this.f;
    }

    public byte[] q() {
        return this.k;
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        this.f261a.a(vVar, (o) null, z);
        long time = this.f262b.getTime() / 1000;
        vVar.c((int) (time >> 32));
        vVar.a(time & 4294967295L);
        vVar.c(this.f263c);
        vVar.c(this.f264d.length);
        vVar.a(this.f264d);
        vVar.c(this.f265e);
        vVar.c(this.f);
        byte[] bArr = this.k;
        if (bArr != null) {
            vVar.c(bArr.length);
            vVar.a(this.k);
            return;
        }
        vVar.c(0);
    }
}
