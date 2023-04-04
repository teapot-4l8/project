package a.a.a.d;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Message.java */
/* loaded from: classes.dex */
public class ax implements Cloneable {
    private static bx[] j = new bx[0];
    private static bu[] k = new bu[0];

    /* renamed from: a  reason: collision with root package name */
    int f147a;

    /* renamed from: b  reason: collision with root package name */
    int f148b;

    /* renamed from: c  reason: collision with root package name */
    int f149c;

    /* renamed from: d  reason: collision with root package name */
    private af f150d;

    /* renamed from: e  reason: collision with root package name */
    private List<bx>[] f151e;
    private int f;
    private ct g;
    private cu h;
    private int i;

    private ax(af afVar) {
        this.f151e = new List[4];
        this.f150d = afVar;
    }

    public ax(int i) {
        this(new af(i));
    }

    public ax() {
        this(new af());
    }

    public static ax a(bx bxVar) {
        ax axVar = new ax();
        axVar.f150d.d(0);
        axVar.f150d.a(7);
        axVar.a(bxVar, 0);
        return axVar;
    }

    ax(t tVar) {
        this(new af(tVar));
        boolean z = this.f150d.d() == 5;
        boolean b2 = this.f150d.b(6);
        for (int i = 0; i < 4; i++) {
            try {
                int g = this.f150d.g(i);
                if (g > 0) {
                    this.f151e[i] = new ArrayList(g);
                }
                for (int i2 = 0; i2 < g; i2++) {
                    int a2 = tVar.a();
                    bx a3 = bx.a(tVar, i, z);
                    this.f151e[i].add(a3);
                    if (i == 3) {
                        if (a3.k() == 250) {
                            this.f147a = a2;
                        }
                        if (a3.k() == 24 && ((ce) a3).e() == 0) {
                            this.f149c = a2;
                        }
                    }
                }
            } catch (dg e2) {
                if (!b2) {
                    throw e2;
                }
            }
        }
        this.f = tVar.a();
    }

    public ax(byte[] bArr) {
        this(new t(bArr));
    }

    public af a() {
        return this.f150d;
    }

    public void a(bx bxVar, int i) {
        List<bx>[] listArr = this.f151e;
        if (listArr[i] == null) {
            listArr[i] = new LinkedList();
        }
        this.f150d.e(i);
        this.f151e[i].add(bxVar);
    }

    public bx b() {
        List<bx> list = this.f151e[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public cu c() {
        int g = this.f150d.g(3);
        if (g == 0) {
            return null;
        }
        bx bxVar = this.f151e[3].get(g - 1);
        if (bxVar.h != 250) {
            return null;
        }
        return (cu) bxVar;
    }

    public boolean d() {
        int i = this.f148b;
        return i == 3 || i == 1 || i == 4;
    }

    public boolean e() {
        return this.f148b == 1;
    }

    public bm f() {
        bx[] a2;
        for (bx bxVar : a(3)) {
            if (bxVar instanceof bm) {
                return (bm) bxVar;
            }
        }
        return null;
    }

    public int g() {
        int c2 = this.f150d.c();
        bm f = f();
        return f != null ? c2 + (f.e() << 4) : c2;
    }

    public bx[] a(int i) {
        List<bx>[] listArr = this.f151e;
        if (listArr[i] == null) {
            return j;
        }
        return (bx[]) listArr[i].toArray(new bx[0]);
    }

    private static boolean a(bx bxVar, bx bxVar2) {
        return bxVar.l_() == bxVar2.l_() && bxVar.l() == bxVar2.l() && bxVar.j().equals(bxVar2.j());
    }

    public bu[] b(int i) {
        if (this.f151e[i] == null) {
            return k;
        }
        LinkedList linkedList = new LinkedList();
        bx[] a2 = a(i);
        HashSet hashSet = new HashSet();
        for (bx bxVar : a2) {
            bj j2 = bxVar.j();
            boolean z = true;
            if (hashSet.contains(j2)) {
                int size = linkedList.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    bu buVar = (bu) linkedList.get(size);
                    if (buVar.b() == bxVar.l_() && buVar.e() == bxVar.l() && buVar.d().equals(j2)) {
                        buVar.a((bu) bxVar);
                        z = false;
                        break;
                    }
                    size--;
                }
            }
            if (z) {
                linkedList.add(new bu(bxVar));
                hashSet.add(j2);
            }
        }
        return (bu[]) linkedList.toArray(new bu[0]);
    }

    void a(v vVar) {
        this.f150d.a(vVar);
        o oVar = new o();
        int i = 0;
        while (true) {
            List<bx>[] listArr = this.f151e;
            if (i >= listArr.length) {
                return;
            }
            if (listArr[i] != null) {
                for (bx bxVar : listArr[i]) {
                    bxVar.a(vVar, i, oVar);
                }
            }
            i++;
        }
    }

    private int a(v vVar, int i, o oVar, int i2) {
        int size = this.f151e[i].size();
        int a2 = vVar.a();
        bx bxVar = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            bx bxVar2 = this.f151e[i].get(i5);
            if (i != 3 || !(bxVar2 instanceof bm)) {
                if (bxVar != null && !a(bxVar2, bxVar)) {
                    a2 = vVar.a();
                    i4 = i3;
                }
                bxVar2.a(vVar, i, oVar);
                if (vVar.a() > i2) {
                    vVar.a(a2);
                    return size - i4;
                }
                i3++;
                bxVar = bxVar2;
            }
        }
        return size - i3;
    }

    private boolean a(v vVar, int i) {
        if (i < 12) {
            return false;
        }
        ct ctVar = this.g;
        if (ctVar != null) {
            i -= ctVar.a();
        }
        bm f = f();
        byte[] bArr = null;
        if (f != null) {
            bArr = f.a(3);
            i -= bArr.length;
        }
        int a2 = vVar.a();
        this.f150d.a(vVar);
        o oVar = new o();
        int e2 = this.f150d.e();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= 4) {
                break;
            }
            if (this.f151e[i2] != null) {
                int a3 = a(vVar, i2, oVar, i);
                if (a3 != 0 && i2 != 3) {
                    e2 = af.a(e2, 6, true);
                    int g = this.f150d.g(i2) - a3;
                    int i4 = a2 + 4;
                    vVar.a(g, (i2 * 2) + i4);
                    for (int i5 = i2 + 1; i5 < 3; i5++) {
                        vVar.a(0, (i5 * 2) + i4);
                    }
                } else if (i2 == 3) {
                    i3 = this.f150d.g(i2) - a3;
                }
            }
            i2++;
        }
        if (bArr != null) {
            vVar.a(bArr);
            i3++;
        }
        if (e2 != this.f150d.e()) {
            vVar.a(e2, a2 + 2);
        }
        if (i3 != this.f150d.g(3)) {
            vVar.a(i3, a2 + 10);
        }
        ct ctVar2 = this.g;
        if (ctVar2 != null) {
            ctVar2.a(this, vVar.b(), this.i, this.h).a(vVar, 3, oVar);
            vVar.a(i3 + 1, a2 + 10);
        }
        return true;
    }

    public byte[] h() {
        v vVar = new v();
        a(vVar);
        this.f = vVar.a();
        return vVar.b();
    }

    public byte[] c(int i) {
        v vVar = new v();
        a(vVar, i);
        this.f = vVar.a();
        return vVar.b();
    }

    public int i() {
        return this.f;
    }

    public String d(int i) {
        bx[] a2;
        if (i > 3) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (bx bxVar : a(i)) {
            if (i == 0) {
                sb.append(";;\t");
                sb.append(bxVar.g);
                sb.append(", type = ");
                sb.append(cz.b(bxVar.h));
                sb.append(", class = ");
                sb.append(p.b(bxVar.i));
            } else {
                sb.append(bxVar);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (f() != null) {
            sb.append(this.f150d.h(g()));
            sb.append("\n");
        } else {
            sb.append(this.f150d);
            sb.append("\n");
        }
        if (d()) {
            sb.append(";; TSIG ");
            if (e()) {
                sb.append("ok");
            } else {
                sb.append("invalid");
            }
            sb.append('\n');
        }
        for (int i = 0; i < 4; i++) {
            if (this.f150d.d() != 5) {
                sb.append(";; ");
                sb.append(ck.b(i));
                sb.append(":\n");
            } else {
                sb.append(";; ");
                sb.append(ck.c(i));
                sb.append(":\n");
            }
            sb.append(d(i));
            sb.append("\n");
        }
        sb.append(";; Message size: ");
        sb.append(i());
        sb.append(" bytes");
        return sb.toString();
    }

    public Object clone() {
        ax axVar = new ax();
        int i = 0;
        while (true) {
            List<bx>[] listArr = this.f151e;
            if (i < listArr.length) {
                if (listArr[i] != null) {
                    axVar.f151e[i] = new LinkedList(this.f151e[i]);
                }
                i++;
            } else {
                axVar.f150d = (af) this.f150d.clone();
                axVar.f = this.f;
                return axVar;
            }
        }
    }
}
