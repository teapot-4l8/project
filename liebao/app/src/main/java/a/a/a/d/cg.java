package a.a.a.d;

/* compiled from: SOARecord.java */
/* loaded from: classes.dex */
public class cg extends bx {

    /* renamed from: a  reason: collision with root package name */
    private bj f216a;

    /* renamed from: b  reason: collision with root package name */
    private bj f217b;

    /* renamed from: c  reason: collision with root package name */
    private long f218c;

    /* renamed from: d  reason: collision with root package name */
    private long f219d;

    /* renamed from: e  reason: collision with root package name */
    private long f220e;
    private long f;
    private long k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg() {
    }

    @Override // a.a.a.d.bx
    bx a() {
        return new cg();
    }

    public cg(bj bjVar, int i, long j, bj bjVar2, bj bjVar3, long j2, long j3, long j4, long j5, long j6) {
        super(bjVar, 6, i, j);
        this.f216a = a("host", bjVar2);
        this.f217b = a("admin", bjVar3);
        this.f218c = a("serial", j2);
        this.f219d = a("refresh", j3);
        this.f220e = a("retry", j4);
        this.f = a("expire", j5);
        this.k = a("minimum", j6);
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        this.f216a = new bj(tVar);
        this.f217b = new bj(tVar);
        this.f218c = tVar.i();
        this.f219d = tVar.i();
        this.f220e = tVar.i();
        this.f = tVar.i();
        this.k = tVar.i();
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f216a);
        sb.append(" ");
        sb.append(this.f217b);
        if (bo.b("multiline")) {
            sb.append(" (\n\t\t\t\t\t");
            sb.append(this.f218c);
            sb.append("\t; serial\n\t\t\t\t\t");
            sb.append(this.f219d);
            sb.append("\t; refresh\n\t\t\t\t\t");
            sb.append(this.f220e);
            sb.append("\t; retry\n\t\t\t\t\t");
            sb.append(this.f);
            sb.append("\t; expire\n\t\t\t\t\t");
            sb.append(this.k);
            sb.append(" )\t; minimum");
        } else {
            sb.append(" ");
            sb.append(this.f218c);
            sb.append(" ");
            sb.append(this.f219d);
            sb.append(" ");
            sb.append(this.f220e);
            sb.append(" ");
            sb.append(this.f);
            sb.append(" ");
            sb.append(this.k);
        }
        return sb.toString();
    }

    public long e() {
        return this.f218c;
    }

    public long f() {
        return this.k;
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        this.f216a.a(vVar, oVar, z);
        this.f217b.a(vVar, oVar, z);
        vVar.a(this.f218c);
        vVar.a(this.f219d);
        vVar.a(this.f220e);
        vVar.a(this.f);
        vVar.a(this.k);
    }
}
