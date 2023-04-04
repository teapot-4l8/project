package a.a.a.d;

import java.util.ArrayList;
import java.util.List;

/* compiled from: OPTRecord.java */
/* loaded from: classes.dex */
public class bm extends bx {

    /* renamed from: a  reason: collision with root package name */
    private List<x> f184a;

    @Override // a.a.a.d.bx
    bx a() {
        return new bm();
    }

    @Override // a.a.a.d.bx
    void a(t tVar) {
        if (tVar.b() > 0) {
            this.f184a = new ArrayList();
        }
        while (tVar.b() > 0) {
            this.f184a.add(x.b(tVar));
        }
    }

    @Override // a.a.a.d.bx
    String b() {
        StringBuilder sb = new StringBuilder();
        List<x> list = this.f184a;
        if (list != null) {
            sb.append(list);
            sb.append(" ");
        }
        sb.append(" ; payload ");
        sb.append(d());
        sb.append(", xrcode ");
        sb.append(e());
        sb.append(", version ");
        sb.append(f());
        sb.append(", flags ");
        sb.append(g());
        return sb.toString();
    }

    public int d() {
        return this.i;
    }

    public int e() {
        return (int) (this.j >>> 24);
    }

    public int f() {
        return (int) ((this.j >>> 16) & 255);
    }

    public int g() {
        return (int) (this.j & 65535);
    }

    @Override // a.a.a.d.bx
    void a(v vVar, o oVar, boolean z) {
        List<x> list = this.f184a;
        if (list == null) {
            return;
        }
        for (x xVar : list) {
            xVar.b(vVar);
        }
    }

    @Override // a.a.a.d.bx
    public boolean equals(Object obj) {
        return super.equals(obj) && this.j == ((bm) obj).j;
    }
}
