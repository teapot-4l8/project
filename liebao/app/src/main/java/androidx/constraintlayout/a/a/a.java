package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Analyzer.java */
/* loaded from: classes.dex */
public class a {
    public static void a(g gVar) {
        if ((gVar.J() & 32) != 32) {
            b(gVar);
            return;
        }
        gVar.ax = true;
        gVar.as = false;
        gVar.at = false;
        gVar.au = false;
        ArrayList<f> arrayList = gVar.az;
        List<h> list = gVar.ar;
        boolean z = gVar.F() == f.a.WRAP_CONTENT;
        boolean z2 = gVar.G() == f.a.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (f fVar : arrayList) {
            fVar.r = null;
            fVar.Y = false;
            fVar.b();
        }
        for (f fVar2 : arrayList) {
            if (fVar2.r == null && !a(fVar2, list, z3)) {
                b(gVar);
                gVar.ax = false;
                return;
            }
        }
        int i = 0;
        int i2 = 0;
        for (h hVar : list) {
            i = Math.max(i, a(hVar, 0));
            i2 = Math.max(i2, a(hVar, 1));
        }
        if (z) {
            gVar.a(f.a.FIXED);
            gVar.j(i);
            gVar.as = true;
            gVar.at = true;
            gVar.av = i;
        }
        if (z2) {
            gVar.b(f.a.FIXED);
            gVar.k(i2);
            gVar.as = true;
            gVar.au = true;
            gVar.aw = i2;
        }
        a(list, 0, gVar.p());
        a(list, 1, gVar.r());
    }

    private static boolean a(f fVar, List<h> list, boolean z) {
        h hVar = new h(new ArrayList(), true);
        list.add(hVar);
        return a(fVar, hVar, list, z);
    }

    private static boolean a(f fVar, h hVar, List<h> list, boolean z) {
        if (fVar == null) {
            return true;
        }
        fVar.X = false;
        g gVar = (g) fVar.k();
        if (fVar.r == null) {
            fVar.W = true;
            hVar.f1300a.add(fVar);
            fVar.r = hVar;
            if (fVar.s.f1271c == null && fVar.u.f1271c == null && fVar.t.f1271c == null && fVar.v.f1271c == null && fVar.w.f1271c == null && fVar.z.f1271c == null) {
                a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
            }
            if (fVar.t.f1271c != null && fVar.v.f1271c != null) {
                gVar.G();
                f.a aVar = f.a.WRAP_CONTENT;
                if (z) {
                    a(gVar, fVar, hVar);
                    return false;
                } else if (fVar.t.f1271c.f1269a != fVar.k() || fVar.v.f1271c.f1269a != fVar.k()) {
                    a(gVar, fVar, hVar);
                }
            }
            if (fVar.s.f1271c != null && fVar.u.f1271c != null) {
                gVar.F();
                f.a aVar2 = f.a.WRAP_CONTENT;
                if (z) {
                    a(gVar, fVar, hVar);
                    return false;
                } else if (fVar.s.f1271c.f1269a != fVar.k() || fVar.u.f1271c.f1269a != fVar.k()) {
                    a(gVar, fVar, hVar);
                }
            }
            if (((fVar.F() == f.a.MATCH_CONSTRAINT) ^ (fVar.G() == f.a.MATCH_CONSTRAINT)) && fVar.G != 0.0f) {
                a(fVar);
            } else if (fVar.F() == f.a.MATCH_CONSTRAINT || fVar.G() == f.a.MATCH_CONSTRAINT) {
                a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
            }
            if (((fVar.s.f1271c == null && fVar.u.f1271c == null) || ((fVar.s.f1271c != null && fVar.s.f1271c.f1269a == fVar.D && fVar.u.f1271c == null) || ((fVar.u.f1271c != null && fVar.u.f1271c.f1269a == fVar.D && fVar.s.f1271c == null) || (fVar.s.f1271c != null && fVar.s.f1271c.f1269a == fVar.D && fVar.u.f1271c != null && fVar.u.f1271c.f1269a == fVar.D)))) && fVar.z.f1271c == null && !(fVar instanceof i) && !(fVar instanceof j)) {
                hVar.f.add(fVar);
            }
            if (((fVar.t.f1271c == null && fVar.v.f1271c == null) || ((fVar.t.f1271c != null && fVar.t.f1271c.f1269a == fVar.D && fVar.v.f1271c == null) || ((fVar.v.f1271c != null && fVar.v.f1271c.f1269a == fVar.D && fVar.t.f1271c == null) || (fVar.t.f1271c != null && fVar.t.f1271c.f1269a == fVar.D && fVar.v.f1271c != null && fVar.v.f1271c.f1269a == fVar.D)))) && fVar.z.f1271c == null && fVar.w.f1271c == null && !(fVar instanceof i) && !(fVar instanceof j)) {
                hVar.g.add(fVar);
            }
            if (fVar instanceof j) {
                a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
                j jVar = (j) fVar;
                for (int i = 0; i < jVar.aj; i++) {
                    if (!a(jVar.ai[i], hVar, list, z)) {
                        return false;
                    }
                }
            }
            int length = fVar.A.length;
            for (int i2 = 0; i2 < length; i2++) {
                e eVar = fVar.A[i2];
                if (eVar.f1271c != null && eVar.f1271c.f1269a != fVar.k()) {
                    if (eVar.f1270b == e.c.CENTER) {
                        a(gVar, fVar, hVar);
                        if (z) {
                            return false;
                        }
                    } else {
                        a(eVar);
                    }
                    if (!a(eVar.f1271c.f1269a, hVar, list, z)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (fVar.r != hVar) {
            hVar.f1300a.addAll(fVar.r.f1300a);
            hVar.f.addAll(fVar.r.f);
            hVar.g.addAll(fVar.r.g);
            if (!fVar.r.f1303d) {
                hVar.f1303d = false;
            }
            list.remove(fVar.r);
            for (f fVar2 : fVar.r.f1300a) {
                fVar2.r = hVar;
            }
        }
        return true;
    }

    private static void a(g gVar, f fVar, h hVar) {
        hVar.f1303d = false;
        gVar.ax = false;
        fVar.W = false;
    }

    private static int a(h hVar, int i) {
        int i2 = i * 2;
        List<f> a2 = hVar.a(i);
        int size = a2.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            f fVar = a2.get(i4);
            int i5 = i2 + 1;
            i3 = Math.max(i3, a(fVar, i, fVar.A[i5].f1271c == null || !(fVar.A[i2].f1271c == null || fVar.A[i5].f1271c == null), 0));
        }
        hVar.f1304e[i] = i3;
        return i3;
    }

    private static int a(f fVar, int i, boolean z, int i2) {
        int r;
        int A;
        int i3;
        int i4;
        int i5;
        int p;
        int i6;
        int i7;
        f k;
        int i8;
        int i9 = 0;
        if (fVar.W) {
            boolean z2 = fVar.w.f1271c != null && i == 1;
            if (z) {
                r = fVar.A();
                A = fVar.r() - fVar.A();
                i4 = i * 2;
                i3 = i4 + 1;
            } else {
                r = fVar.r() - fVar.A();
                A = fVar.A();
                i3 = i * 2;
                i4 = i3 + 1;
            }
            if (fVar.A[i3].f1271c == null || fVar.A[i4].f1271c != null) {
                i5 = 1;
            } else {
                i5 = -1;
                int i10 = i3;
                i3 = i4;
                i4 = i10;
            }
            int i11 = z2 ? i2 - r : i2;
            int e2 = (fVar.A[i4].e() * i5) + a(fVar, i);
            int i12 = i11 + e2;
            int p2 = (i == 0 ? fVar.p() : fVar.r()) * i5;
            Iterator<o> it = fVar.A[i4].a().h.iterator();
            while (it.hasNext()) {
                i9 = Math.max(i9, a(((m) it.next()).f1307a.f1269a, i, z, i12));
            }
            int i13 = 0;
            for (Iterator<o> it2 = fVar.A[i3].a().h.iterator(); it2.hasNext(); it2 = it2) {
                i13 = Math.max(i13, a(((m) it2.next()).f1307a.f1269a, i, z, p2 + i12));
            }
            if (z2) {
                i9 -= r;
                p = i13 + A;
            } else {
                p = i13 + ((i == 0 ? fVar.p() : fVar.r()) * i5);
            }
            int i14 = 1;
            if (i == 1) {
                Iterator<o> it3 = fVar.w.a().h.iterator();
                int i15 = 0;
                while (it3.hasNext()) {
                    Iterator<o> it4 = it3;
                    m mVar = (m) it3.next();
                    if (i5 == i14) {
                        i15 = Math.max(i15, a(mVar.f1307a.f1269a, i, z, r + i12));
                        i8 = i3;
                    } else {
                        i8 = i3;
                        i15 = Math.max(i15, a(mVar.f1307a.f1269a, i, z, (A * i5) + i12));
                    }
                    it3 = it4;
                    i3 = i8;
                    i14 = 1;
                }
                i6 = i3;
                int i16 = i15;
                i7 = (fVar.w.a().h.size() <= 0 || z2) ? i16 : i5 == 1 ? i16 + r : i16 - A;
            } else {
                i6 = i3;
                i7 = 0;
            }
            int max = e2 + Math.max(i9, Math.max(p, i7));
            int i17 = p2 + i12;
            if (i5 == -1) {
                i17 = i12;
                i12 = i17;
            }
            if (z) {
                k.a(fVar, i, i12);
                fVar.a(i12, i17, i);
            } else {
                fVar.r.a(fVar, i);
                fVar.e(i12, i);
            }
            if (fVar.t(i) == f.a.MATCH_CONSTRAINT && fVar.G != 0.0f) {
                fVar.r.a(fVar, i);
            }
            if (fVar.A[i4].f1271c != null && fVar.A[i6].f1271c != null && fVar.A[i4].f1271c.f1269a == (k = fVar.k()) && fVar.A[i6].f1271c.f1269a == k) {
                fVar.r.a(fVar, i);
            }
            return max;
        }
        return 0;
    }

    private static void a(e eVar) {
        m a2 = eVar.a();
        if (eVar.f1271c == null || eVar.f1271c.f1271c == eVar) {
            return;
        }
        eVar.f1271c.a().a(a2);
    }

    private static void b(g gVar) {
        gVar.ar.clear();
        gVar.ar.add(0, new h(gVar.az));
    }

    public static void a(List<h> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (f fVar : list.get(i3).b(i)) {
                if (fVar.W) {
                    a(fVar, i, i2);
                }
            }
        }
    }

    private static void a(f fVar, int i, int i2) {
        int i3 = i * 2;
        e eVar = fVar.A[i3];
        e eVar2 = fVar.A[i3 + 1];
        if ((eVar.f1271c == null || eVar2.f1271c == null) ? false : true) {
            k.a(fVar, i, a(fVar, i) + eVar.e());
        } else if (fVar.G != 0.0f && fVar.t(i) == f.a.MATCH_CONSTRAINT) {
            int a2 = a(fVar);
            int i4 = (int) fVar.A[i3].a().f;
            eVar2.a().f1311e = eVar.a();
            eVar2.a().f = a2;
            eVar2.a().i = 1;
            fVar.a(i4, i4 + a2, i);
        } else {
            int p = i2 - fVar.p(i);
            int f = p - fVar.f(i);
            fVar.a(f, p, i);
            k.a(fVar, i, f);
        }
    }

    private static int a(f fVar, int i) {
        int i2 = i * 2;
        e eVar = fVar.A[i2];
        e eVar2 = fVar.A[i2 + 1];
        if (eVar.f1271c == null || eVar.f1271c.f1269a != fVar.D || eVar2.f1271c == null || eVar2.f1271c.f1269a != fVar.D) {
            return 0;
        }
        return (int) ((((fVar.D.f(i) - eVar.e()) - eVar2.e()) - fVar.f(i)) * (i == 0 ? fVar.S : fVar.T));
    }

    private static int a(f fVar) {
        float p;
        float r;
        if (fVar.F() == f.a.MATCH_CONSTRAINT) {
            if (fVar.H == 0) {
                r = fVar.r() * fVar.G;
            } else {
                r = fVar.r() / fVar.G;
            }
            int i = (int) r;
            fVar.j(i);
            return i;
        } else if (fVar.G() == f.a.MATCH_CONSTRAINT) {
            if (fVar.H == 1) {
                p = fVar.p() * fVar.G;
            } else {
                p = fVar.p() / fVar.G;
            }
            int i2 = (int) p;
            fVar.k(i2);
            return i2;
        } else {
            return -1;
        }
    }
}
