package androidx.constraintlayout.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.h;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: LinearSystem.java */
/* loaded from: classes.dex */
public class e {
    public static f g = null;
    private static int h = 1000;

    /* renamed from: b  reason: collision with root package name */
    b[] f1332b;
    final c f;
    private a j;
    private final a r;

    /* renamed from: a  reason: collision with root package name */
    int f1331a = 0;
    private HashMap<String, h> i = null;
    private int k = 32;
    private int l = 32;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1333c = false;
    private boolean[] m = new boolean[32];

    /* renamed from: d  reason: collision with root package name */
    int f1334d = 1;

    /* renamed from: e  reason: collision with root package name */
    int f1335e = 0;
    private int n = 32;
    private h[] o = new h[h];
    private int p = 0;

    /* renamed from: q  reason: collision with root package name */
    private b[] f1336q = new b[32];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinearSystem.java */
    /* loaded from: classes.dex */
    public interface a {
        h a(e eVar, boolean[] zArr);

        void a(a aVar);

        void d(h hVar);

        void f();

        h g();
    }

    public e() {
        this.f1332b = null;
        this.f1332b = new b[32];
        i();
        c cVar = new c();
        this.f = cVar;
        this.j = new d(cVar);
        this.r = new b(this.f);
    }

    public static f a() {
        return g;
    }

    private void h() {
        int i = this.k * 2;
        this.k = i;
        this.f1332b = (b[]) Arrays.copyOf(this.f1332b, i);
        c cVar = this.f;
        cVar.f1330c = (h[]) Arrays.copyOf(cVar.f1330c, this.k);
        int i2 = this.k;
        this.m = new boolean[i2];
        this.l = i2;
        this.n = i2;
        f fVar = g;
        if (fVar != null) {
            fVar.f1340d++;
            f fVar2 = g;
            fVar2.p = Math.max(fVar2.p, this.k);
            f fVar3 = g;
            fVar3.D = fVar3.p;
        }
    }

    private void i() {
        int i = 0;
        while (true) {
            b[] bVarArr = this.f1332b;
            if (i >= bVarArr.length) {
                return;
            }
            b bVar = bVarArr[i];
            if (bVar != null) {
                this.f.f1328a.a(bVar);
            }
            this.f1332b[i] = null;
            i++;
        }
    }

    public void b() {
        for (int i = 0; i < this.f.f1330c.length; i++) {
            h hVar = this.f.f1330c[i];
            if (hVar != null) {
                hVar.b();
            }
        }
        this.f.f1329b.a(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.f.f1330c, (Object) null);
        HashMap<String, h> hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f1331a = 0;
        this.j.f();
        this.f1334d = 1;
        for (int i2 = 0; i2 < this.f1335e; i2++) {
            this.f1332b[i2].f1325c = false;
        }
        i();
        this.f1335e = 0;
    }

    public h a(Object obj) {
        h hVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f1334d + 1 >= this.l) {
            h();
        }
        if (obj instanceof androidx.constraintlayout.a.a.e) {
            androidx.constraintlayout.a.a.e eVar = (androidx.constraintlayout.a.a.e) obj;
            hVar = eVar.b();
            if (hVar == null) {
                eVar.a(this.f);
                hVar = eVar.b();
            }
            if (hVar.f1345a == -1 || hVar.f1345a > this.f1331a || this.f.f1330c[hVar.f1345a] == null) {
                if (hVar.f1345a != -1) {
                    hVar.b();
                }
                int i = this.f1331a + 1;
                this.f1331a = i;
                this.f1334d++;
                hVar.f1345a = i;
                hVar.f = h.a.UNRESTRICTED;
                this.f.f1330c[this.f1331a] = hVar;
            }
        }
        return hVar;
    }

    public b c() {
        b a2 = this.f.f1328a.a();
        if (a2 == null) {
            a2 = new b(this.f);
        } else {
            a2.c();
        }
        h.a();
        return a2;
    }

    public h d() {
        f fVar = g;
        if (fVar != null) {
            fVar.n++;
        }
        if (this.f1334d + 1 >= this.l) {
            h();
        }
        h a2 = a(h.a.SLACK, (String) null);
        int i = this.f1331a + 1;
        this.f1331a = i;
        this.f1334d++;
        a2.f1345a = i;
        this.f.f1330c[this.f1331a] = a2;
        return a2;
    }

    public h e() {
        f fVar = g;
        if (fVar != null) {
            fVar.o++;
        }
        if (this.f1334d + 1 >= this.l) {
            h();
        }
        h a2 = a(h.a.SLACK, (String) null);
        int i = this.f1331a + 1;
        this.f1331a = i;
        this.f1334d++;
        a2.f1345a = i;
        this.f.f1330c[this.f1331a] = a2;
        return a2;
    }

    private void b(b bVar) {
        bVar.a(this, 0);
    }

    void a(b bVar, int i, int i2) {
        bVar.c(a(i2, (String) null), i);
    }

    public h a(int i, String str) {
        f fVar = g;
        if (fVar != null) {
            fVar.m++;
        }
        if (this.f1334d + 1 >= this.l) {
            h();
        }
        h a2 = a(h.a.ERROR, str);
        int i2 = this.f1331a + 1;
        this.f1331a = i2;
        this.f1334d++;
        a2.f1345a = i2;
        a2.f1347c = i;
        this.f.f1330c[this.f1331a] = a2;
        this.j.d(a2);
        return a2;
    }

    private h a(h.a aVar, String str) {
        h a2 = this.f.f1329b.a();
        if (a2 == null) {
            a2 = new h(aVar, str);
            a2.a(aVar, str);
        } else {
            a2.b();
            a2.a(aVar, str);
        }
        int i = this.p;
        int i2 = h;
        if (i >= i2) {
            int i3 = i2 * 2;
            h = i3;
            this.o = (h[]) Arrays.copyOf(this.o, i3);
        }
        h[] hVarArr = this.o;
        int i4 = this.p;
        this.p = i4 + 1;
        hVarArr[i4] = a2;
        return a2;
    }

    public int b(Object obj) {
        h b2 = ((androidx.constraintlayout.a.a.e) obj).b();
        if (b2 != null) {
            return (int) (b2.f1348d + 0.5f);
        }
        return 0;
    }

    public void f() {
        f fVar = g;
        if (fVar != null) {
            fVar.f1341e++;
        }
        if (this.f1333c) {
            f fVar2 = g;
            if (fVar2 != null) {
                fVar2.r++;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.f1335e) {
                    z = true;
                    break;
                } else if (!this.f1332b[i].f1327e) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                a(this.j);
                return;
            }
            f fVar3 = g;
            if (fVar3 != null) {
                fVar3.f1342q++;
            }
            j();
            return;
        }
        a(this.j);
    }

    void a(a aVar) {
        f fVar = g;
        if (fVar != null) {
            fVar.t++;
            f fVar2 = g;
            fVar2.u = Math.max(fVar2.u, this.f1334d);
            f fVar3 = g;
            fVar3.v = Math.max(fVar3.v, this.f1335e);
        }
        c((b) aVar);
        b(aVar);
        a(aVar, false);
        j();
    }

    private final void c(b bVar) {
        if (this.f1335e > 0) {
            bVar.f1326d.a(bVar, this.f1332b);
            if (bVar.f1326d.f1258a == 0) {
                bVar.f1327e = true;
            }
        }
    }

    public void a(b bVar) {
        h b2;
        if (bVar == null) {
            return;
        }
        f fVar = g;
        if (fVar != null) {
            fVar.f++;
            if (bVar.f1327e) {
                g.g++;
            }
        }
        boolean z = true;
        if (this.f1335e + 1 >= this.n || this.f1334d + 1 >= this.l) {
            h();
        }
        boolean z2 = false;
        if (!bVar.f1327e) {
            c(bVar);
            if (bVar.e()) {
                return;
            }
            bVar.d();
            if (bVar.a(this)) {
                h e2 = e();
                bVar.f1323a = e2;
                d(bVar);
                this.r.a(bVar);
                a(this.r, true);
                if (e2.f1346b == -1) {
                    if (bVar.f1323a == e2 && (b2 = bVar.b(e2)) != null) {
                        f fVar2 = g;
                        if (fVar2 != null) {
                            fVar2.j++;
                        }
                        bVar.c(b2);
                    }
                    if (!bVar.f1327e) {
                        bVar.f1323a.c(bVar);
                    }
                    this.f1335e--;
                }
            } else {
                z = false;
            }
            if (!bVar.a()) {
                return;
            }
            z2 = z;
        }
        if (z2) {
            return;
        }
        d(bVar);
    }

    private final void d(b bVar) {
        if (this.f1332b[this.f1335e] != null) {
            this.f.f1328a.a(this.f1332b[this.f1335e]);
        }
        this.f1332b[this.f1335e] = bVar;
        bVar.f1323a.f1346b = this.f1335e;
        this.f1335e++;
        bVar.f1323a.c(bVar);
    }

    private final int a(a aVar, boolean z) {
        f fVar = g;
        if (fVar != null) {
            fVar.h++;
        }
        for (int i = 0; i < this.f1334d; i++) {
            this.m[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            f fVar2 = g;
            if (fVar2 != null) {
                fVar2.i++;
            }
            i2++;
            if (i2 >= this.f1334d * 2) {
                return i2;
            }
            if (aVar.g() != null) {
                this.m[aVar.g().f1345a] = true;
            }
            h a2 = aVar.a(this, this.m);
            if (a2 != null) {
                if (this.m[a2.f1345a]) {
                    return i2;
                }
                this.m[a2.f1345a] = true;
            }
            if (a2 != null) {
                float f = Float.MAX_VALUE;
                int i3 = -1;
                for (int i4 = 0; i4 < this.f1335e; i4++) {
                    b bVar = this.f1332b[i4];
                    if (bVar.f1323a.f != h.a.UNRESTRICTED && !bVar.f1327e && bVar.a(a2)) {
                        float b2 = bVar.f1326d.b(a2);
                        if (b2 < 0.0f) {
                            float f2 = (-bVar.f1324b) / b2;
                            if (f2 < f) {
                                i3 = i4;
                                f = f2;
                            }
                        }
                    }
                }
                if (i3 > -1) {
                    b bVar2 = this.f1332b[i3];
                    bVar2.f1323a.f1346b = -1;
                    f fVar3 = g;
                    if (fVar3 != null) {
                        fVar3.j++;
                    }
                    bVar2.c(a2);
                    bVar2.f1323a.f1346b = i3;
                    bVar2.f1323a.c(bVar2);
                }
            }
            z2 = true;
        }
        return i2;
    }

    private int b(a aVar) {
        float f;
        boolean z;
        int i = 0;
        while (true) {
            f = 0.0f;
            if (i >= this.f1335e) {
                z = false;
                break;
            } else if (this.f1332b[i].f1323a.f != h.a.UNRESTRICTED && this.f1332b[i].f1324b < 0.0f) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            boolean z2 = false;
            int i2 = 0;
            while (!z2) {
                f fVar = g;
                if (fVar != null) {
                    fVar.k++;
                }
                i2++;
                float f2 = Float.MAX_VALUE;
                int i3 = 0;
                int i4 = -1;
                int i5 = -1;
                int i6 = 0;
                while (i3 < this.f1335e) {
                    b bVar = this.f1332b[i3];
                    if (bVar.f1323a.f != h.a.UNRESTRICTED && !bVar.f1327e && bVar.f1324b < f) {
                        int i7 = 1;
                        while (i7 < this.f1334d) {
                            h hVar = this.f.f1330c[i7];
                            float b2 = bVar.f1326d.b(hVar);
                            if (b2 > f) {
                                for (int i8 = 0; i8 < 7; i8++) {
                                    float f3 = hVar.f1349e[i8] / b2;
                                    if ((f3 < f2 && i8 == i6) || i8 > i6) {
                                        i5 = i7;
                                        i6 = i8;
                                        f2 = f3;
                                        i4 = i3;
                                    }
                                }
                            }
                            i7++;
                            f = 0.0f;
                        }
                    }
                    i3++;
                    f = 0.0f;
                }
                if (i4 != -1) {
                    b bVar2 = this.f1332b[i4];
                    bVar2.f1323a.f1346b = -1;
                    f fVar2 = g;
                    if (fVar2 != null) {
                        fVar2.j++;
                    }
                    bVar2.c(this.f.f1330c[i5]);
                    bVar2.f1323a.f1346b = i4;
                    bVar2.f1323a.c(bVar2);
                } else {
                    z2 = true;
                }
                if (i2 > this.f1334d / 2) {
                    z2 = true;
                }
                f = 0.0f;
            }
            return i2;
        }
        return 0;
    }

    private void j() {
        for (int i = 0; i < this.f1335e; i++) {
            b bVar = this.f1332b[i];
            bVar.f1323a.f1348d = bVar.f1324b;
        }
    }

    public c g() {
        return this.f;
    }

    public void a(h hVar, h hVar2, int i, int i2) {
        b c2 = c();
        h d2 = d();
        d2.f1347c = 0;
        c2.a(hVar, hVar2, d2, i);
        if (i2 != 6) {
            a(c2, (int) (c2.f1326d.b(d2) * (-1.0f)), i2);
        }
        a(c2);
    }

    public void a(h hVar, h hVar2, boolean z) {
        b c2 = c();
        h d2 = d();
        d2.f1347c = 0;
        c2.a(hVar, hVar2, d2, 0);
        if (z) {
            a(c2, (int) (c2.f1326d.b(d2) * (-1.0f)), 1);
        }
        a(c2);
    }

    public void b(h hVar, h hVar2, int i, int i2) {
        b c2 = c();
        h d2 = d();
        d2.f1347c = 0;
        c2.b(hVar, hVar2, d2, i);
        if (i2 != 6) {
            a(c2, (int) (c2.f1326d.b(d2) * (-1.0f)), i2);
        }
        a(c2);
    }

    public void b(h hVar, h hVar2, boolean z) {
        b c2 = c();
        h d2 = d();
        d2.f1347c = 0;
        c2.b(hVar, hVar2, d2, 0);
        if (z) {
            a(c2, (int) (c2.f1326d.b(d2) * (-1.0f)), 1);
        }
        a(c2);
    }

    public void a(h hVar, h hVar2, int i, float f, h hVar3, h hVar4, int i2, int i3) {
        b c2 = c();
        c2.a(hVar, hVar2, i, f, hVar3, hVar4, i2);
        if (i3 != 6) {
            c2.a(this, i3);
        }
        a(c2);
    }

    public void a(h hVar, h hVar2, h hVar3, h hVar4, float f, int i) {
        b c2 = c();
        c2.a(hVar, hVar2, hVar3, hVar4, f);
        if (i != 6) {
            c2.a(this, i);
        }
        a(c2);
    }

    public b c(h hVar, h hVar2, int i, int i2) {
        b c2 = c();
        c2.a(hVar, hVar2, i);
        if (i2 != 6) {
            c2.a(this, i2);
        }
        a(c2);
        return c2;
    }

    public void a(h hVar, int i) {
        int i2 = hVar.f1346b;
        if (hVar.f1346b != -1) {
            b bVar = this.f1332b[i2];
            if (bVar.f1327e) {
                bVar.f1324b = i;
                return;
            } else if (bVar.f1326d.f1258a == 0) {
                bVar.f1327e = true;
                bVar.f1324b = i;
                return;
            } else {
                b c2 = c();
                c2.b(hVar, i);
                a(c2);
                return;
            }
        }
        b c3 = c();
        c3.a(hVar, i);
        a(c3);
    }

    public static b a(e eVar, h hVar, h hVar2, h hVar3, float f, boolean z) {
        b c2 = eVar.c();
        if (z) {
            eVar.b(c2);
        }
        return c2.a(hVar, hVar2, hVar3, f);
    }

    public void a(androidx.constraintlayout.a.a.f fVar, androidx.constraintlayout.a.a.f fVar2, float f, int i) {
        h a2 = a(fVar.a(e.c.LEFT));
        h a3 = a(fVar.a(e.c.TOP));
        h a4 = a(fVar.a(e.c.RIGHT));
        h a5 = a(fVar.a(e.c.BOTTOM));
        h a6 = a(fVar2.a(e.c.LEFT));
        h a7 = a(fVar2.a(e.c.TOP));
        h a8 = a(fVar2.a(e.c.RIGHT));
        h a9 = a(fVar2.a(e.c.BOTTOM));
        b c2 = c();
        double d2 = f;
        double sin = Math.sin(d2);
        double d3 = i;
        Double.isNaN(d3);
        c2.b(a3, a5, a7, a9, (float) (sin * d3));
        a(c2);
        b c3 = c();
        double cos = Math.cos(d2);
        Double.isNaN(d3);
        c3.b(a2, a4, a6, a8, (float) (cos * d3));
        a(c3);
    }
}
