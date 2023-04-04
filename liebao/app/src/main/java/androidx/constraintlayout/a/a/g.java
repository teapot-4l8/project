package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ConstraintWidgetContainer.java */
/* loaded from: classes.dex */
public class g extends q {
    private p aB;
    int aj;
    int ak;
    int al;
    int am;
    private boolean aA = false;
    protected androidx.constraintlayout.a.e ai = new androidx.constraintlayout.a.e();
    int an = 0;
    int ao = 0;
    d[] ap = new d[4];
    d[] aq = new d[4];
    public List<h> ar = new ArrayList();
    public boolean as = false;
    public boolean at = false;
    public boolean au = false;
    public int av = 0;
    public int aw = 0;
    private int aC = 7;
    public boolean ax = false;
    private boolean aD = false;
    private boolean aE = false;
    int ay = 0;

    public boolean S() {
        return false;
    }

    public void a(int i) {
        this.aC = i;
    }

    public int J() {
        return this.aC;
    }

    public boolean u(int i) {
        return (this.aC & i) == i;
    }

    @Override // androidx.constraintlayout.a.a.q, androidx.constraintlayout.a.a.f
    public void f() {
        this.ai.b();
        this.aj = 0;
        this.al = 0;
        this.ak = 0;
        this.am = 0;
        this.ar.clear();
        this.ax = false;
        super.f();
    }

    public boolean K() {
        return this.aD;
    }

    public boolean L() {
        return this.aE;
    }

    public boolean d(androidx.constraintlayout.a.e eVar) {
        a(eVar);
        int size = this.az.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.az.get(i);
            if (fVar instanceof g) {
                f.a aVar = fVar.C[0];
                f.a aVar2 = fVar.C[1];
                if (aVar == f.a.WRAP_CONTENT) {
                    fVar.a(f.a.FIXED);
                }
                if (aVar2 == f.a.WRAP_CONTENT) {
                    fVar.b(f.a.FIXED);
                }
                fVar.a(eVar);
                if (aVar == f.a.WRAP_CONTENT) {
                    fVar.a(aVar);
                }
                if (aVar2 == f.a.WRAP_CONTENT) {
                    fVar.b(aVar2);
                }
            } else {
                k.a(this, eVar, fVar);
                fVar.a(eVar);
            }
        }
        if (this.an > 0) {
            c.a(this, eVar, 0);
        }
        if (this.ao > 0) {
            c.a(this, eVar, 1);
        }
        return true;
    }

    public void a(androidx.constraintlayout.a.e eVar, boolean[] zArr) {
        zArr[2] = false;
        c(eVar);
        int size = this.az.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.az.get(i);
            fVar.c(eVar);
            if (fVar.C[0] == f.a.MATCH_CONSTRAINT && fVar.p() < fVar.q()) {
                zArr[2] = true;
            }
            if (fVar.C[1] == f.a.MATCH_CONSTRAINT && fVar.r() < fVar.s()) {
                zArr[2] = true;
            }
        }
    }

    public void a(boolean z) {
        this.aA = z;
    }

    public boolean M() {
        return this.aA;
    }

    @Override // androidx.constraintlayout.a.a.f
    public void b(int i) {
        super.b(i);
        int size = this.az.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.az.get(i2).b(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01dc  */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v27 */
    @Override // androidx.constraintlayout.a.a.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void N() {
        int i;
        int i2;
        char c2;
        int i3;
        boolean z;
        int max;
        int max2;
        ?? r8;
        boolean z2;
        int i4 = this.I;
        int i5 = this.J;
        int max3 = Math.max(0, p());
        int max4 = Math.max(0, r());
        this.aD = false;
        this.aE = false;
        if (this.D != null) {
            if (this.aB == null) {
                this.aB = new p(this);
            }
            this.aB.a(this);
            h(this.aj);
            i(this.ak);
            E();
            a(this.ai.g());
        } else {
            this.I = 0;
            this.J = 0;
        }
        int i6 = 32;
        if (this.aC != 0) {
            if (!u(8)) {
                Q();
            }
            if (!u(32)) {
                R();
            }
            this.ai.f1333c = true;
        } else {
            this.ai.f1333c = false;
        }
        f.a aVar = this.C[1];
        f.a aVar2 = this.C[0];
        V();
        if (this.ar.size() == 0) {
            this.ar.clear();
            this.ar.add(0, new h(this.az));
        }
        int size = this.ar.size();
        ArrayList<f> arrayList = this.az;
        boolean z3 = F() == f.a.WRAP_CONTENT || G() == f.a.WRAP_CONTENT;
        boolean z4 = false;
        int i7 = 0;
        while (i7 < size && !this.ax) {
            if (this.ar.get(i7).f1303d) {
                i = size;
            } else {
                if (u(i6)) {
                    if (F() == f.a.FIXED && G() == f.a.FIXED) {
                        this.az = (ArrayList) this.ar.get(i7).a();
                    } else {
                        this.az = (ArrayList) this.ar.get(i7).f1300a;
                    }
                }
                V();
                int size2 = this.az.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    f fVar = this.az.get(i8);
                    if (fVar instanceof q) {
                        ((q) fVar).N();
                    }
                }
                boolean z5 = z4;
                int i9 = 0;
                boolean z6 = true;
                while (z6) {
                    boolean z7 = z5;
                    int i10 = i9 + 1;
                    try {
                        this.ai.b();
                        V();
                        b(this.ai);
                        int i11 = 0;
                        while (i11 < size2) {
                            boolean z8 = z6;
                            try {
                                this.az.get(i11).b(this.ai);
                                i11++;
                                z6 = z8;
                            } catch (Exception e2) {
                                e = e2;
                                z6 = z8;
                                e.printStackTrace();
                                PrintStream printStream = System.out;
                                boolean z9 = z6;
                                StringBuilder sb = new StringBuilder();
                                i2 = size;
                                sb.append("EXCEPTION : ");
                                sb.append(e);
                                printStream.println(sb.toString());
                                z6 = z9;
                                if (z6) {
                                }
                                c2 = 2;
                                if (z3) {
                                }
                                i3 = i10;
                                z = false;
                                max = Math.max(this.P, p());
                                if (max > p()) {
                                }
                                max2 = Math.max(this.Q, r());
                                if (max2 <= r()) {
                                }
                                if (!z2) {
                                }
                                z6 = z;
                                z5 = z2;
                                i9 = i3;
                                size = i2;
                            }
                        }
                        z6 = d(this.ai);
                        if (z6) {
                            try {
                                this.ai.f();
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                PrintStream printStream2 = System.out;
                                boolean z92 = z6;
                                StringBuilder sb2 = new StringBuilder();
                                i2 = size;
                                sb2.append("EXCEPTION : ");
                                sb2.append(e);
                                printStream2.println(sb2.toString());
                                z6 = z92;
                                if (z6) {
                                }
                                c2 = 2;
                                if (z3) {
                                }
                                i3 = i10;
                                z = false;
                                max = Math.max(this.P, p());
                                if (max > p()) {
                                }
                                max2 = Math.max(this.Q, r());
                                if (max2 <= r()) {
                                }
                                if (!z2) {
                                }
                                z6 = z;
                                z5 = z2;
                                i9 = i3;
                                size = i2;
                            }
                        }
                        i2 = size;
                    } catch (Exception e4) {
                        e = e4;
                    }
                    if (z6) {
                        a(this.ai, k.f1306a);
                    } else {
                        c(this.ai);
                        int i12 = 0;
                        while (true) {
                            if (i12 >= size2) {
                                break;
                            }
                            f fVar2 = this.az.get(i12);
                            if (fVar2.C[0] == f.a.MATCH_CONSTRAINT && fVar2.p() < fVar2.q()) {
                                k.f1306a[2] = true;
                                break;
                            } else if (fVar2.C[1] == f.a.MATCH_CONSTRAINT && fVar2.r() < fVar2.s()) {
                                c2 = 2;
                                k.f1306a[2] = true;
                                break;
                            } else {
                                i12++;
                            }
                        }
                        if (z3 || i10 >= 8 || !k.f1306a[c2]) {
                            i3 = i10;
                            z = false;
                        } else {
                            int i13 = 0;
                            int i14 = 0;
                            int i15 = 0;
                            while (i13 < size2) {
                                f fVar3 = this.az.get(i13);
                                i14 = Math.max(i14, fVar3.I + fVar3.p());
                                i15 = Math.max(i15, fVar3.J + fVar3.r());
                                i13++;
                                i10 = i10;
                            }
                            i3 = i10;
                            int max5 = Math.max(this.P, i14);
                            int max6 = Math.max(this.Q, i15);
                            if (aVar2 != f.a.WRAP_CONTENT || p() >= max5) {
                                z = false;
                            } else {
                                j(max5);
                                this.C[0] = f.a.WRAP_CONTENT;
                                z = true;
                                z7 = true;
                            }
                            if (aVar == f.a.WRAP_CONTENT && r() < max6) {
                                k(max6);
                                this.C[1] = f.a.WRAP_CONTENT;
                                z = true;
                                z7 = true;
                            }
                        }
                        max = Math.max(this.P, p());
                        if (max > p()) {
                            j(max);
                            this.C[0] = f.a.FIXED;
                            z = true;
                            z7 = true;
                        }
                        max2 = Math.max(this.Q, r());
                        if (max2 <= r()) {
                            k(max2);
                            r8 = 1;
                            this.C[1] = f.a.FIXED;
                            z = true;
                            z2 = true;
                        } else {
                            r8 = 1;
                            z2 = z7;
                        }
                        if (!z2) {
                            if (this.C[0] == f.a.WRAP_CONTENT && max3 > 0 && p() > max3) {
                                this.aD = r8;
                                this.C[0] = f.a.FIXED;
                                j(max3);
                                z = true;
                                z2 = true;
                            }
                            if (this.C[r8] == f.a.WRAP_CONTENT && max4 > 0 && r() > max4) {
                                this.aE = r8;
                                this.C[r8] = f.a.FIXED;
                                k(max4);
                                z5 = true;
                                z6 = true;
                                i9 = i3;
                                size = i2;
                            }
                        }
                        z6 = z;
                        z5 = z2;
                        i9 = i3;
                        size = i2;
                    }
                    c2 = 2;
                    if (z3) {
                    }
                    i3 = i10;
                    z = false;
                    max = Math.max(this.P, p());
                    if (max > p()) {
                    }
                    max2 = Math.max(this.Q, r());
                    if (max2 <= r()) {
                    }
                    if (!z2) {
                    }
                    z6 = z;
                    z5 = z2;
                    i9 = i3;
                    size = i2;
                }
                i = size;
                this.ar.get(i7).b();
                z4 = z5;
            }
            i7++;
            size = i;
            i6 = 32;
        }
        this.az = arrayList;
        if (this.D != null) {
            int max7 = Math.max(this.P, p());
            int max8 = Math.max(this.Q, r());
            this.aB.b(this);
            j(max7 + this.aj + this.al);
            k(max8 + this.ak + this.am);
        } else {
            this.I = i4;
            this.J = i5;
        }
        if (z4) {
            this.C[0] = aVar2;
            this.C[1] = aVar;
        }
        a(this.ai.g());
        if (this == T()) {
            D();
        }
    }

    public void O() {
        Q();
        b(this.aC);
    }

    public void P() {
        m a2 = a(e.c.LEFT).a();
        m a3 = a(e.c.TOP).a();
        a2.a((m) null, 0.0f);
        a3.a((m) null, 0.0f);
    }

    public void f(int i, int i2) {
        if (this.C[0] != f.a.WRAP_CONTENT && this.f1289c != null) {
            this.f1289c.a(i);
        }
        if (this.C[1] == f.a.WRAP_CONTENT || this.f1290d == null) {
            return;
        }
        this.f1290d.a(i2);
    }

    public void Q() {
        int size = this.az.size();
        b();
        for (int i = 0; i < size; i++) {
            this.az.get(i).b();
        }
    }

    public void R() {
        if (!u(8)) {
            b(this.aC);
        }
        P();
    }

    private void V() {
        this.an = 0;
        this.ao = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar, int i) {
        if (i == 0) {
            d(fVar);
        } else if (i == 1) {
            e(fVar);
        }
    }

    private void d(f fVar) {
        int i = this.an + 1;
        d[] dVarArr = this.aq;
        if (i >= dVarArr.length) {
            this.aq = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.aq[this.an] = new d(fVar, 0, M());
        this.an++;
    }

    private void e(f fVar) {
        int i = this.ao + 1;
        d[] dVarArr = this.ap;
        if (i >= dVarArr.length) {
            this.ap = (d[]) Arrays.copyOf(dVarArr, dVarArr.length * 2);
        }
        this.ap[this.ao] = new d(fVar, 1, M());
        this.ao++;
    }
}
