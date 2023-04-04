package a.a.a.d;

import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SIGBase.java */
/* loaded from: classes.dex */
public abstract class cd extends bx {

    /* renamed from: a  reason: collision with root package name */
    protected int f207a;

    /* renamed from: b  reason: collision with root package name */
    protected int f208b;

    /* renamed from: c  reason: collision with root package name */
    protected int f209c;

    /* renamed from: d  reason: collision with root package name */
    protected long f210d;

    /* renamed from: e  reason: collision with root package name */
    protected Date f211e;
    protected Date f;
    protected int k;
    protected bj l;
    protected byte[] m;

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f207a = tVar.h();
        this.f208b = tVar.g();
        this.f209c = tVar.g();
        this.f210d = tVar.i();
        this.f211e = new Date(tVar.i() * 1000);
        this.f = new Date(tVar.i() * 1000);
        this.k = tVar.h();
        this.l = new bj(tVar);
        this.m = tVar.j();
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(cz.b(this.f207a));
        sb.append(" ");
        sb.append(this.f208b);
        sb.append(" ");
        sb.append(this.f209c);
        sb.append(" ");
        sb.append(this.f210d);
        sb.append(" ");
        if (bo.b("multiline")) {
            sb.append("(\n\t");
        }
        sb.append(ab.a(this.f211e));
        sb.append(" ");
        sb.append(ab.a(this.f));
        sb.append(" ");
        sb.append(this.k);
        sb.append(" ");
        sb.append(this.l);
        if (bo.b("multiline")) {
            sb.append("\n");
            sb.append(a.a.a.d.a.c.a(this.m, 64, "\t", true));
        } else {
            sb.append(" ");
            sb.append(a.a.a.d.a.c.a(this.m));
        }
        return sb.toString();
    }

    public int e() {
        return this.f207a;
    }

    @Override // a.a.a.d.bx
    public int l_() {
        return this.f207a;
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        vVar.c(this.f207a);
        vVar.b(this.f208b);
        vVar.b(this.f209c);
        vVar.a(this.f210d);
        vVar.a(this.f211e.getTime() / 1000);
        vVar.a(this.f.getTime() / 1000);
        vVar.c(this.k);
        this.l.a(vVar, (o) null, z);
        vVar.a(this.m);
    }
}
