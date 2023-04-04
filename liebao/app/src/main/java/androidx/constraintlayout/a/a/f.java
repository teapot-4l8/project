package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import java.util.ArrayList;

/* compiled from: ConstraintWidget.java */
/* loaded from: classes.dex */
public class f {
    public static float R = 0.5f;
    protected e[] A;
    protected ArrayList<e> B;
    protected a[] C;
    f D;
    int E;
    int F;
    protected float G;
    protected int H;
    protected int I;
    protected int J;
    int K;
    int L;
    protected int M;
    protected int N;
    int O;
    protected int P;
    protected int Q;
    float S;
    float T;
    boolean U;
    boolean V;
    boolean W;
    boolean X;
    boolean Y;
    int Z;
    int aa;
    boolean ab;
    boolean ac;
    float[] ad;
    protected f[] ae;
    protected f[] af;
    f ag;
    f ah;
    private int ak;
    private int al;
    private int am;
    private int an;
    private int ao;
    private int ap;
    private Object aq;
    private int ar;
    private int as;
    private String at;
    private String au;

    /* renamed from: c  reason: collision with root package name */
    n f1289c;

    /* renamed from: d  reason: collision with root package name */
    n f1290d;
    boolean n;
    boolean o;
    e z;

    /* renamed from: a  reason: collision with root package name */
    public int f1287a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f1288b = -1;

    /* renamed from: e  reason: collision with root package name */
    int f1291e = 0;
    int f = 0;
    int[] g = new int[2];
    int h = 0;
    int i = 0;
    float j = 1.0f;
    int k = 0;
    int l = 0;
    float m = 1.0f;
    int p = -1;

    /* renamed from: q  reason: collision with root package name */
    float f1292q = 1.0f;
    h r = null;
    private int[] ai = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    private float aj = 0.0f;
    e s = new e(this, e.c.LEFT);
    e t = new e(this, e.c.TOP);
    e u = new e(this, e.c.RIGHT);
    e v = new e(this, e.c.BOTTOM);
    e w = new e(this, e.c.BASELINE);
    e x = new e(this, e.c.CENTER_X);
    e y = new e(this, e.c.CENTER_Y);

    /* compiled from: ConstraintWidget.java */
    /* loaded from: classes.dex */
    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public void c() {
    }

    public void c(int i) {
        this.ai[0] = i;
    }

    public void d(int i) {
        this.ai[1] = i;
    }

    public boolean d() {
        return this.f1291e == 0 && this.G == 0.0f && this.h == 0 && this.i == 0 && this.C[0] == a.MATCH_CONSTRAINT;
    }

    public boolean e() {
        return this.f == 0 && this.G == 0.0f && this.k == 0 && this.l == 0 && this.C[1] == a.MATCH_CONSTRAINT;
    }

    public void f() {
        this.s.i();
        this.t.i();
        this.u.i();
        this.v.i();
        this.w.i();
        this.x.i();
        this.y.i();
        this.z.i();
        this.D = null;
        this.aj = 0.0f;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.ak = 0;
        this.al = 0;
        this.am = 0;
        this.an = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.ao = 0;
        this.ap = 0;
        float f = R;
        this.S = f;
        this.T = f;
        this.C[0] = a.FIXED;
        this.C[1] = a.FIXED;
        this.aq = null;
        this.ar = 0;
        this.as = 0;
        this.au = null;
        this.U = false;
        this.V = false;
        this.Z = 0;
        this.aa = 0;
        this.ab = false;
        this.ac = false;
        float[] fArr = this.ad;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f1287a = -1;
        this.f1288b = -1;
        int[] iArr = this.ai;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f1291e = 0;
        this.f = 0;
        this.j = 1.0f;
        this.m = 1.0f;
        this.i = Integer.MAX_VALUE;
        this.l = Integer.MAX_VALUE;
        this.h = 0;
        this.k = 0;
        this.p = -1;
        this.f1292q = 1.0f;
        n nVar = this.f1289c;
        if (nVar != null) {
            nVar.b();
        }
        n nVar2 = this.f1290d;
        if (nVar2 != null) {
            nVar2.b();
        }
        this.r = null;
        this.W = false;
        this.X = false;
        this.Y = false;
    }

    public void b() {
        for (int i = 0; i < 6; i++) {
            this.A[i].a().b();
        }
    }

    public void g() {
        for (int i = 0; i < 6; i++) {
            this.A[i].a().c();
        }
    }

    public void b(int i) {
        k.a(i, this);
    }

    public boolean h() {
        return this.s.a().i == 1 && this.u.a().i == 1 && this.t.a().i == 1 && this.v.a().i == 1;
    }

    public n i() {
        if (this.f1289c == null) {
            this.f1289c = new n();
        }
        return this.f1289c;
    }

    public n j() {
        if (this.f1290d == null) {
            this.f1290d = new n();
        }
        return this.f1290d;
    }

    public f() {
        e eVar = new e(this, e.c.CENTER);
        this.z = eVar;
        this.A = new e[]{this.s, this.u, this.t, this.v, this.w, eVar};
        this.B = new ArrayList<>();
        this.C = new a[]{a.FIXED, a.FIXED};
        this.D = null;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = -1;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = 0;
        this.ak = 0;
        this.al = 0;
        this.am = 0;
        this.an = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        float f = R;
        this.S = f;
        this.T = f;
        this.ar = 0;
        this.as = 0;
        this.at = null;
        this.au = null;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = 0;
        this.aa = 0;
        this.ad = new float[]{-1.0f, -1.0f};
        this.ae = new f[]{null, null};
        this.af = new f[]{null, null};
        this.ag = null;
        this.ah = null;
        J();
    }

    public void a(androidx.constraintlayout.a.c cVar) {
        this.s.a(cVar);
        this.t.a(cVar);
        this.u.a(cVar);
        this.v.a(cVar);
        this.w.a(cVar);
        this.z.a(cVar);
        this.x.a(cVar);
        this.y.a(cVar);
    }

    private void J() {
        this.B.add(this.s);
        this.B.add(this.t);
        this.B.add(this.u);
        this.B.add(this.v);
        this.B.add(this.x);
        this.B.add(this.y);
        this.B.add(this.z);
        this.B.add(this.w);
    }

    public f k() {
        return this.D;
    }

    public void a(f fVar) {
        this.D = fVar;
    }

    public void b(boolean z) {
        this.n = z;
    }

    public void c(boolean z) {
        this.o = z;
    }

    public void a(f fVar, float f, int i) {
        a(e.c.CENTER, fVar, e.c.CENTER, i, 0);
        this.aj = f;
    }

    public void e(int i) {
        this.as = i;
    }

    public int l() {
        return this.as;
    }

    public String m() {
        return this.at;
    }

    public void a(String str) {
        this.at = str;
    }

    public void b(androidx.constraintlayout.a.e eVar) {
        eVar.a(this.s);
        eVar.a(this.t);
        eVar.a(this.u);
        eVar.a(this.v);
        if (this.O > 0) {
            eVar.a(this.w);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.au != null) {
            str = "type: " + this.au + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.at != null) {
            str2 = "id: " + this.at + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.I);
        sb.append(", ");
        sb.append(this.J);
        sb.append(") - (");
        sb.append(this.E);
        sb.append(" x ");
        sb.append(this.F);
        sb.append(") wrap: (");
        sb.append(this.ao);
        sb.append(" x ");
        sb.append(this.ap);
        sb.append(")");
        return sb.toString();
    }

    public int n() {
        return this.I;
    }

    public int o() {
        return this.J;
    }

    public int p() {
        if (this.as == 8) {
            return 0;
        }
        return this.E;
    }

    public int q() {
        return this.ao;
    }

    public int r() {
        if (this.as == 8) {
            return 0;
        }
        return this.F;
    }

    public int s() {
        return this.ap;
    }

    public int f(int i) {
        if (i == 0) {
            return p();
        }
        if (i == 1) {
            return r();
        }
        return 0;
    }

    public int t() {
        return this.ak + this.M;
    }

    public int u() {
        return this.al + this.N;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int v() {
        return this.I + this.M;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int w() {
        return this.J + this.N;
    }

    public int x() {
        return n() + this.E;
    }

    public int y() {
        return o() + this.F;
    }

    public float g(int i) {
        if (i == 0) {
            return this.S;
        }
        if (i == 1) {
            return this.T;
        }
        return -1.0f;
    }

    public boolean z() {
        return this.O > 0;
    }

    public int A() {
        return this.O;
    }

    public Object B() {
        return this.aq;
    }

    public ArrayList<e> C() {
        return this.B;
    }

    public void h(int i) {
        this.I = i;
    }

    public void i(int i) {
        this.J = i;
    }

    public void a(int i, int i2) {
        this.I = i;
        this.J = i2;
    }

    public void b(int i, int i2) {
        this.M = i;
        this.N = i2;
    }

    public void D() {
        int i = this.I;
        int i2 = this.J;
        this.ak = i;
        this.al = i2;
        this.am = (this.E + i) - i;
        this.an = (this.F + i2) - i2;
    }

    public void j(int i) {
        this.E = i;
        int i2 = this.P;
        if (i < i2) {
            this.E = i2;
        }
    }

    public void k(int i) {
        this.F = i;
        int i2 = this.Q;
        if (i < i2) {
            this.F = i2;
        }
    }

    public void a(int i, int i2, int i3, float f) {
        this.f1291e = i;
        this.h = i2;
        this.i = i3;
        this.j = f;
        if (f >= 1.0f || i != 0) {
            return;
        }
        this.f1291e = 2;
    }

    public void b(int i, int i2, int i3, float f) {
        this.f = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        if (f >= 1.0f || i != 0) {
            return;
        }
        this.f = 2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:39:0x0085). Please submit an issue!!! */
    public void b(String str) {
        float f;
        int i = 0;
        if (str == null || str.length() == 0) {
            this.G = 0.0f;
            return;
        }
        int i2 = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i3 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase("W")) {
                i2 = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i2 = 1;
            }
            i3 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 >= 0 && indexOf2 < length - 1) {
            String substring2 = str.substring(i3, indexOf2);
            String substring3 = str.substring(indexOf2 + 1);
            if (substring2.length() > 0 && substring3.length() > 0) {
                float parseFloat = Float.parseFloat(substring2);
                float parseFloat2 = Float.parseFloat(substring3);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    if (i2 == 1) {
                        f = Math.abs(parseFloat2 / parseFloat);
                    } else {
                        f = Math.abs(parseFloat / parseFloat2);
                    }
                }
            }
            f = 0.0f;
        } else {
            String substring4 = str.substring(i3);
            if (substring4.length() > 0) {
                f = Float.parseFloat(substring4);
            }
            f = 0.0f;
        }
        i = (f > i ? 1 : (f == i ? 0 : -1));
        if (i > 0) {
            this.G = f;
            this.H = i2;
        }
    }

    public void a(float f) {
        this.S = f;
    }

    public void b(float f) {
        this.T = f;
    }

    public void l(int i) {
        if (i < 0) {
            this.P = 0;
        } else {
            this.P = i;
        }
    }

    public void m(int i) {
        if (i < 0) {
            this.Q = 0;
        } else {
            this.Q = i;
        }
    }

    public void n(int i) {
        this.ao = i;
    }

    public void o(int i) {
        this.ap = i;
    }

    public void a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.I = i;
        this.J = i2;
        if (this.as == 8) {
            this.E = 0;
            this.F = 0;
            return;
        }
        if (this.C[0] == a.FIXED && i7 < (i6 = this.E)) {
            i7 = i6;
        }
        if (this.C[1] == a.FIXED && i8 < (i5 = this.F)) {
            i8 = i5;
        }
        this.E = i7;
        this.F = i8;
        int i9 = this.Q;
        if (i8 < i9) {
            this.F = i9;
        }
        int i10 = this.E;
        int i11 = this.P;
        if (i10 < i11) {
            this.E = i11;
        }
        this.X = true;
    }

    public void a(int i, int i2, int i3) {
        if (i3 == 0) {
            c(i, i2);
        } else if (i3 == 1) {
            d(i, i2);
        }
        this.X = true;
    }

    public void c(int i, int i2) {
        this.I = i;
        int i3 = i2 - i;
        this.E = i3;
        int i4 = this.P;
        if (i3 < i4) {
            this.E = i4;
        }
    }

    public void d(int i, int i2) {
        this.J = i;
        int i3 = i2 - i;
        this.F = i3;
        int i4 = this.Q;
        if (i3 < i4) {
            this.F = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p(int i) {
        if (i == 0) {
            return this.K;
        }
        if (i == 1) {
            return this.L;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i, int i2) {
        if (i2 == 0) {
            this.K = i;
        } else if (i2 == 1) {
            this.L = i;
        }
    }

    public void q(int i) {
        this.O = i;
    }

    public void a(Object obj) {
        this.aq = obj;
    }

    public void c(float f) {
        this.ad[0] = f;
    }

    public void d(float f) {
        this.ad[1] = f;
    }

    public void r(int i) {
        this.Z = i;
    }

    public void s(int i) {
        this.aa = i;
    }

    public boolean a() {
        return this.as != 8;
    }

    public void a(e.c cVar, f fVar, e.c cVar2, int i, int i2) {
        a(cVar).a(fVar.a(cVar2), i, i2, e.b.STRONG, 0, true);
    }

    public void E() {
        f k = k();
        if (k != null && (k instanceof g) && ((g) k()).S()) {
            return;
        }
        int size = this.B.size();
        for (int i = 0; i < size; i++) {
            this.B.get(i).i();
        }
    }

    public e a(e.c cVar) {
        switch (AnonymousClass1.f1293a[cVar.ordinal()]) {
            case 1:
                return this.s;
            case 2:
                return this.t;
            case 3:
                return this.u;
            case 4:
                return this.v;
            case 5:
                return this.w;
            case 6:
                return this.z;
            case 7:
                return this.x;
            case 8:
                return this.y;
            case 9:
                return null;
            default:
                throw new AssertionError(cVar.name());
        }
    }

    public a F() {
        return this.C[0];
    }

    public a G() {
        return this.C[1];
    }

    public a t(int i) {
        if (i == 0) {
            return F();
        }
        if (i == 1) {
            return G();
        }
        return null;
    }

    public void a(a aVar) {
        this.C[0] = aVar;
        if (aVar == a.WRAP_CONTENT) {
            j(this.ao);
        }
    }

    public void b(a aVar) {
        this.C[1] = aVar;
        if (aVar == a.WRAP_CONTENT) {
            k(this.ap);
        }
    }

    public boolean H() {
        if (this.s.f1271c == null || this.s.f1271c.f1271c != this.s) {
            return this.u.f1271c != null && this.u.f1271c.f1271c == this.u;
        }
        return true;
    }

    public boolean I() {
        if (this.t.f1271c == null || this.t.f1271c.f1271c != this.t) {
            return this.v.f1271c != null && this.v.f1271c.f1271c == this.v;
        }
        return true;
    }

    private boolean a(int i) {
        int i2 = i * 2;
        if (this.A[i2].f1271c != null) {
            e eVar = this.A[i2].f1271c.f1271c;
            e[] eVarArr = this.A;
            if (eVar != eVarArr[i2]) {
                int i3 = i2 + 1;
                if (eVarArr[i3].f1271c != null && this.A[i3].f1271c.f1271c == this.A[i3]) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0252 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(androidx.constraintlayout.a.e eVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        androidx.constraintlayout.a.h hVar;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z5;
        boolean z6;
        androidx.constraintlayout.a.h hVar2;
        androidx.constraintlayout.a.h hVar3;
        boolean z7;
        androidx.constraintlayout.a.h hVar4;
        androidx.constraintlayout.a.h hVar5;
        androidx.constraintlayout.a.e eVar2;
        boolean z8;
        androidx.constraintlayout.a.h hVar6;
        f fVar;
        int i5;
        int i6;
        boolean H;
        boolean I;
        androidx.constraintlayout.a.h a2 = eVar.a(this.s);
        androidx.constraintlayout.a.h a3 = eVar.a(this.u);
        androidx.constraintlayout.a.h a4 = eVar.a(this.t);
        androidx.constraintlayout.a.h a5 = eVar.a(this.v);
        androidx.constraintlayout.a.h a6 = eVar.a(this.w);
        f fVar2 = this.D;
        if (fVar2 != null) {
            z = fVar2 != null && fVar2.C[0] == a.WRAP_CONTENT;
            f fVar3 = this.D;
            boolean z9 = fVar3 != null && fVar3.C[1] == a.WRAP_CONTENT;
            if (a(0)) {
                ((g) this.D).a(this, 0);
                H = true;
            } else {
                H = H();
            }
            if (a(1)) {
                ((g) this.D).a(this, 1);
                I = true;
            } else {
                I = I();
            }
            if (z && this.as != 8 && this.s.f1271c == null && this.u.f1271c == null) {
                eVar.a(eVar.a(this.D.u), a3, 0, 1);
            }
            if (z9 && this.as != 8 && this.t.f1271c == null && this.v.f1271c == null && this.w == null) {
                eVar.a(eVar.a(this.D.v), a5, 0, 1);
            }
            z2 = z9;
            z3 = H;
            z4 = I;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
        }
        int i7 = this.E;
        int i8 = this.P;
        if (i7 < i8) {
            i7 = i8;
        }
        int i9 = this.F;
        int i10 = this.Q;
        if (i9 < i10) {
            i9 = i10;
        }
        boolean z10 = this.C[0] != a.MATCH_CONSTRAINT;
        boolean z11 = this.C[1] != a.MATCH_CONSTRAINT;
        this.p = this.H;
        float f = this.G;
        this.f1292q = f;
        int i11 = this.f1291e;
        int i12 = this.f;
        if (f <= 0.0f || this.as == 8) {
            hVar = a6;
            i = i11;
            i2 = i7;
            i3 = i9;
            i4 = i12;
            z5 = false;
        } else {
            hVar = a6;
            if (this.C[0] == a.MATCH_CONSTRAINT && i11 == 0) {
                i11 = 3;
            }
            if (this.C[1] == a.MATCH_CONSTRAINT && i12 == 0) {
                i12 = 3;
            }
            if (this.C[0] == a.MATCH_CONSTRAINT && this.C[1] == a.MATCH_CONSTRAINT && i11 == 3 && i12 == 3) {
                a(z, z2, z10, z11);
            } else if (this.C[0] == a.MATCH_CONSTRAINT && i11 == 3) {
                this.p = 0;
                a aVar = this.C[1];
                a aVar2 = a.MATCH_CONSTRAINT;
                i2 = (int) (this.f1292q * this.F);
                if (aVar != aVar2) {
                    i3 = i9;
                    i4 = i12;
                    z5 = false;
                    i = 4;
                } else {
                    i = i11;
                    i3 = i9;
                    i4 = i12;
                    z5 = true;
                }
            } else if (this.C[1] == a.MATCH_CONSTRAINT && i12 == 3) {
                this.p = 1;
                if (this.H == -1) {
                    this.f1292q = 1.0f / this.f1292q;
                }
                a aVar3 = this.C[0];
                a aVar4 = a.MATCH_CONSTRAINT;
                i3 = (int) (this.f1292q * this.E);
                i = i11;
                i2 = i7;
                if (aVar3 != aVar4) {
                    z5 = false;
                    i4 = 4;
                }
                i4 = i12;
                z5 = true;
            }
            i = i11;
            i2 = i7;
            i3 = i9;
            i4 = i12;
            z5 = true;
        }
        int[] iArr = this.g;
        iArr[0] = i;
        iArr[1] = i4;
        if (z5 && ((i6 = this.p) == 0 || i6 == -1)) {
            z6 = true;
            boolean z12 = this.C[0] != a.WRAP_CONTENT && (this instanceof g);
            boolean z13 = !this.z.j();
            if (this.f1287a == 2) {
                f fVar4 = this.D;
                androidx.constraintlayout.a.h a7 = fVar4 != null ? eVar.a(fVar4.u) : null;
                f fVar5 = this.D;
                z7 = z2;
                hVar4 = hVar;
                hVar5 = a5;
                hVar2 = a4;
                boolean z14 = z12;
                hVar3 = a3;
                a(eVar, z, fVar5 != null ? eVar.a(fVar5.s) : null, a7, this.C[0], z14, this.s, this.u, this.I, i2, this.P, this.ai[0], this.S, z6, z3, i, this.h, this.i, this.j, z13);
            } else {
                hVar2 = a4;
                hVar3 = a3;
                z7 = z2;
                hVar4 = hVar;
                hVar5 = a5;
            }
            if (this.f1288b != 2) {
                return;
            }
            boolean z15 = this.C[1] == a.WRAP_CONTENT && (this instanceof g);
            boolean z16 = z5 && ((i5 = this.p) == 1 || i5 == -1);
            if (this.O <= 0) {
                eVar2 = eVar;
            } else if (this.w.a().i == 1) {
                eVar2 = eVar;
                this.w.a().a(eVar2);
            } else {
                eVar2 = eVar;
                androidx.constraintlayout.a.h hVar7 = hVar4;
                hVar6 = hVar2;
                eVar2.c(hVar7, hVar6, A(), 6);
                if (this.w.f1271c != null) {
                    eVar2.c(hVar7, eVar2.a(this.w.f1271c), 0, 6);
                    z8 = false;
                    f fVar6 = this.D;
                    androidx.constraintlayout.a.h a8 = fVar6 != null ? eVar2.a(fVar6.v) : null;
                    f fVar7 = this.D;
                    androidx.constraintlayout.a.h hVar8 = hVar6;
                    a(eVar, z7, fVar7 != null ? eVar2.a(fVar7.t) : null, a8, this.C[1], z15, this.t, this.v, this.J, i3, this.Q, this.ai[1], this.T, z16, z4, i4, this.k, this.l, this.m, z8);
                    if (z5) {
                        fVar = this;
                        if (fVar.p == 1) {
                            eVar.a(hVar5, hVar8, hVar3, a2, fVar.f1292q, 6);
                        } else {
                            eVar.a(hVar3, a2, hVar5, hVar8, fVar.f1292q, 6);
                        }
                    } else {
                        fVar = this;
                    }
                    if (fVar.z.j()) {
                        eVar.a(fVar, fVar.z.g().c(), (float) Math.toRadians(fVar.aj + 90.0f), fVar.z.e());
                        return;
                    }
                    return;
                }
                z8 = z13;
                f fVar62 = this.D;
                if (fVar62 != null) {
                }
                f fVar72 = this.D;
                androidx.constraintlayout.a.h hVar82 = hVar6;
                a(eVar, z7, fVar72 != null ? eVar2.a(fVar72.t) : null, a8, this.C[1], z15, this.t, this.v, this.J, i3, this.Q, this.ai[1], this.T, z16, z4, i4, this.k, this.l, this.m, z8);
                if (z5) {
                }
                if (fVar.z.j()) {
                }
            }
            hVar6 = hVar2;
            z8 = z13;
            f fVar622 = this.D;
            if (fVar622 != null) {
            }
            f fVar722 = this.D;
            androidx.constraintlayout.a.h hVar822 = hVar6;
            a(eVar, z7, fVar722 != null ? eVar2.a(fVar722.t) : null, a8, this.C[1], z15, this.t, this.v, this.J, i3, this.Q, this.ai[1], this.T, z16, z4, i4, this.k, this.l, this.m, z8);
            if (z5) {
            }
            if (fVar.z.j()) {
            }
        }
        z6 = false;
        if (this.C[0] != a.WRAP_CONTENT) {
        }
        boolean z132 = !this.z.j();
        if (this.f1287a == 2) {
        }
        if (this.f1288b != 2) {
        }
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.p == -1) {
            if (z3 && !z4) {
                this.p = 0;
            } else if (!z3 && z4) {
                this.p = 1;
                if (this.H == -1) {
                    this.f1292q = 1.0f / this.f1292q;
                }
            }
        }
        if (this.p == 0 && (!this.t.j() || !this.v.j())) {
            this.p = 1;
        } else if (this.p == 1 && (!this.s.j() || !this.u.j())) {
            this.p = 0;
        }
        if (this.p == -1 && (!this.t.j() || !this.v.j() || !this.s.j() || !this.u.j())) {
            if (this.t.j() && this.v.j()) {
                this.p = 0;
            } else if (this.s.j() && this.u.j()) {
                this.f1292q = 1.0f / this.f1292q;
                this.p = 1;
            }
        }
        if (this.p == -1) {
            if (z && !z2) {
                this.p = 0;
            } else if (!z && z2) {
                this.f1292q = 1.0f / this.f1292q;
                this.p = 1;
            }
        }
        if (this.p == -1) {
            if (this.h > 0 && this.k == 0) {
                this.p = 0;
            } else if (this.h == 0 && this.k > 0) {
                this.f1292q = 1.0f / this.f1292q;
                this.p = 1;
            }
        }
        if (this.p == -1 && z && z2) {
            this.f1292q = 1.0f / this.f1292q;
            this.p = 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02e9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:194:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01cc A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(androidx.constraintlayout.a.e eVar, boolean z, androidx.constraintlayout.a.h hVar, androidx.constraintlayout.a.h hVar2, a aVar, boolean z2, e eVar2, e eVar3, int i, int i2, int i3, int i4, float f, boolean z3, boolean z4, int i5, int i6, int i7, float f2, boolean z5) {
        boolean z6;
        int i8;
        int i9;
        int i10;
        boolean z7;
        androidx.constraintlayout.a.h a2;
        androidx.constraintlayout.a.h a3;
        androidx.constraintlayout.a.h hVar3;
        int i11;
        int i12;
        int i13;
        int i14;
        androidx.constraintlayout.a.h hVar4;
        boolean z8;
        boolean z9;
        androidx.constraintlayout.a.h hVar5;
        androidx.constraintlayout.a.h hVar6;
        boolean z10;
        boolean z11;
        int i15;
        androidx.constraintlayout.a.h hVar7;
        androidx.constraintlayout.a.h hVar8;
        androidx.constraintlayout.a.h hVar9;
        boolean z12;
        boolean z13;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z14;
        androidx.constraintlayout.a.h a4 = eVar.a(eVar2);
        androidx.constraintlayout.a.h a5 = eVar.a(eVar3);
        androidx.constraintlayout.a.h a6 = eVar.a(eVar2.g());
        androidx.constraintlayout.a.h a7 = eVar.a(eVar3.g());
        if (eVar.f1333c && eVar2.a().i == 1 && eVar3.a().i == 1) {
            if (androidx.constraintlayout.a.e.a() != null) {
                androidx.constraintlayout.a.e.a().s++;
            }
            eVar2.a().a(eVar);
            eVar3.a().a(eVar);
            if (z4 || !z) {
                return;
            }
            eVar.a(hVar2, a5, 0, 6);
            return;
        }
        if (androidx.constraintlayout.a.e.a() != null) {
            androidx.constraintlayout.a.e.a().B++;
        }
        boolean j = eVar2.j();
        boolean j2 = eVar3.j();
        boolean j3 = this.z.j();
        int i20 = j ? 1 : 0;
        if (j2) {
            i20++;
        }
        if (j3) {
            i20++;
        }
        int i21 = i20;
        int i22 = z3 ? 3 : i5;
        int i23 = AnonymousClass1.f1294b[aVar.ordinal()];
        boolean z15 = (i23 == 1 || i23 == 2 || i23 == 3 || i23 != 4 || i22 == 4) ? false : true;
        if (this.as == 8) {
            i8 = 0;
            z6 = false;
        } else {
            z6 = z15;
            i8 = i2;
        }
        if (z5) {
            if (!j && !j2 && !j3) {
                eVar.a(a4, i);
            } else if (j && !j2) {
                i9 = 6;
                eVar.c(a4, a6, eVar2.e(), 6);
                if (z6) {
                    if (z2) {
                        eVar.c(a5, a4, 0, 3);
                        if (i3 > 0) {
                            eVar.a(a5, a4, i3, 6);
                        }
                        if (i4 < Integer.MAX_VALUE) {
                            eVar.b(a5, a4, i4, 6);
                        }
                    } else {
                        eVar.c(a5, a4, i8, i9);
                    }
                    i10 = i6;
                    i12 = i22;
                    i13 = i21;
                    hVar4 = a7;
                    hVar3 = a6;
                    z9 = z6;
                    i14 = i7;
                } else {
                    i10 = i6;
                    int i24 = i7;
                    if (i10 == -2) {
                        i10 = i8;
                    }
                    if (i24 == -2) {
                        i24 = i8;
                    }
                    if (i10 > 0) {
                        eVar.a(a5, a4, i10, 6);
                        i8 = Math.max(i8, i10);
                    }
                    if (i24 > 0) {
                        eVar.b(a5, a4, i24, 6);
                        i8 = Math.min(i8, i24);
                    }
                    if (i22 != 1) {
                        z7 = z6;
                        if (i22 == 2) {
                            if (eVar2.d() == e.c.TOP || eVar2.d() == e.c.BOTTOM) {
                                a2 = eVar.a(this.D.a(e.c.TOP));
                                a3 = eVar.a(this.D.a(e.c.BOTTOM));
                            } else {
                                a2 = eVar.a(this.D.a(e.c.LEFT));
                                a3 = eVar.a(this.D.a(e.c.RIGHT));
                            }
                            androidx.constraintlayout.a.h hVar10 = a2;
                            hVar3 = a6;
                            i11 = i8;
                            i12 = i22;
                            i13 = i21;
                            i14 = i24;
                            hVar4 = a7;
                            eVar.a(eVar.c().a(a5, a4, a3, hVar10, f2));
                            z8 = false;
                            if (z8) {
                            }
                            z9 = z8;
                        }
                    } else if (z) {
                        eVar.c(a5, a4, i8, 6);
                        i12 = i22;
                        i13 = i21;
                        hVar4 = a7;
                        hVar3 = a6;
                        z7 = z6;
                        i11 = i8;
                        i14 = i24;
                        z8 = z7;
                        if (z8 || i13 == 2 || z3) {
                            z9 = z8;
                        } else {
                            int max = Math.max(i10, i11);
                            if (i14 > 0) {
                                max = Math.min(i14, max);
                            }
                            eVar.c(a5, a4, max, 6);
                            z9 = false;
                        }
                    } else if (z4) {
                        z7 = z6;
                        eVar.c(a5, a4, i8, 4);
                    } else {
                        z7 = z6;
                        eVar.c(a5, a4, i8, 1);
                    }
                    i12 = i22;
                    i13 = i21;
                    i14 = i24;
                    hVar4 = a7;
                    hVar3 = a6;
                    i11 = i8;
                    z8 = z7;
                    if (z8) {
                    }
                    z9 = z8;
                }
                if (z5 || z4) {
                    if (i13 < 2 || !z) {
                    }
                    eVar.a(a4, hVar, 0, 6);
                    eVar.a(hVar2, a5, 0, 6);
                    return;
                }
                if (j || j2 || j3) {
                    if (!j || j2) {
                        if (!j && j2) {
                            eVar.c(a5, hVar4, -eVar3.e(), 6);
                            if (z) {
                                eVar.a(a4, hVar, 0, 5);
                            }
                        } else if (j && j2) {
                            if (z9) {
                                hVar5 = hVar4;
                                if (z && i3 == 0) {
                                    eVar.a(a5, a4, 0, 6);
                                }
                                if (i12 == 0) {
                                    if (i14 > 0 || i10 > 0) {
                                        i19 = 4;
                                        z14 = true;
                                    } else {
                                        i19 = 6;
                                        z14 = false;
                                    }
                                    hVar6 = hVar3;
                                    eVar.c(a4, hVar6, eVar2.e(), i19);
                                    eVar.c(a5, hVar5, -eVar3.e(), i19);
                                    z10 = i14 > 0 || i10 > 0;
                                    z11 = z14;
                                    i15 = 5;
                                } else {
                                    int i25 = i12;
                                    hVar6 = hVar3;
                                    if (i25 == 1) {
                                        z10 = true;
                                        z11 = true;
                                        i15 = 6;
                                    } else if (i25 == 3) {
                                        int i26 = (z3 || this.p == -1 || i14 > 0) ? 4 : 6;
                                        eVar.c(a4, hVar6, eVar2.e(), i26);
                                        eVar.c(a5, hVar5, -eVar3.e(), i26);
                                        z10 = true;
                                        z11 = true;
                                        i15 = 5;
                                        if (z10) {
                                            hVar8 = hVar5;
                                            hVar7 = hVar6;
                                            hVar9 = a5;
                                            eVar.a(a4, hVar6, eVar2.e(), f, hVar5, a5, eVar3.e(), i15);
                                            boolean z16 = eVar2.f1271c.f1269a instanceof b;
                                            boolean z17 = eVar3.f1271c.f1269a instanceof b;
                                            if (z16 && !z17) {
                                                z12 = z;
                                                i16 = 6;
                                                i17 = 5;
                                                z13 = true;
                                            } else if (!z16 && z17) {
                                                z13 = z;
                                                i16 = 5;
                                                i17 = 6;
                                                z12 = true;
                                            }
                                            if (z11) {
                                                i16 = 6;
                                                i17 = 6;
                                            }
                                            if ((!z9 && z12) || z11) {
                                                eVar.a(a4, hVar7, eVar2.e(), i17);
                                            }
                                            if ((!z9 && z13) || z11) {
                                                eVar.b(hVar9, hVar8, -eVar3.e(), i16);
                                            }
                                            i18 = 0;
                                            if (z) {
                                                eVar.a(a4, hVar, 0, 6);
                                            }
                                            if (z) {
                                                eVar.a(hVar2, hVar9, i18, 6);
                                                return;
                                            }
                                            return;
                                        }
                                        hVar7 = hVar6;
                                        hVar8 = hVar5;
                                        hVar9 = a5;
                                        z12 = z;
                                        z13 = z12;
                                        i16 = 5;
                                        i17 = 5;
                                        if (z11) {
                                        }
                                        if (!z9) {
                                            eVar.a(a4, hVar7, eVar2.e(), i17);
                                            if (!z9) {
                                                eVar.b(hVar9, hVar8, -eVar3.e(), i16);
                                                i18 = 0;
                                                if (z) {
                                                }
                                                if (z) {
                                                }
                                            }
                                            eVar.b(hVar9, hVar8, -eVar3.e(), i16);
                                            i18 = 0;
                                            if (z) {
                                            }
                                            if (z) {
                                            }
                                        }
                                        eVar.a(a4, hVar7, eVar2.e(), i17);
                                        if (!z9) {
                                        }
                                        eVar.b(hVar9, hVar8, -eVar3.e(), i16);
                                        i18 = 0;
                                        if (z) {
                                        }
                                        if (z) {
                                        }
                                    } else {
                                        z10 = false;
                                    }
                                }
                                if (z10) {
                                }
                                z12 = z;
                                z13 = z12;
                                i16 = 5;
                                i17 = 5;
                                if (z11) {
                                }
                                if (!z9) {
                                }
                                eVar.a(a4, hVar7, eVar2.e(), i17);
                                if (!z9) {
                                }
                                eVar.b(hVar9, hVar8, -eVar3.e(), i16);
                                i18 = 0;
                                if (z) {
                                }
                                if (z) {
                                }
                            } else {
                                hVar5 = hVar4;
                                hVar6 = hVar3;
                                z10 = true;
                            }
                            z11 = false;
                            i15 = 5;
                            if (z10) {
                            }
                            z12 = z;
                            z13 = z12;
                            i16 = 5;
                            i17 = 5;
                            if (z11) {
                            }
                            if (!z9) {
                            }
                            eVar.a(a4, hVar7, eVar2.e(), i17);
                            if (!z9) {
                            }
                            eVar.b(hVar9, hVar8, -eVar3.e(), i16);
                            i18 = 0;
                            if (z) {
                            }
                            if (z) {
                            }
                        }
                    } else if (z) {
                        eVar.a(hVar2, a5, 0, 5);
                    }
                } else if (z) {
                    eVar.a(hVar2, a5, 0, 5);
                }
                hVar9 = a5;
                i18 = 0;
                if (z) {
                }
            }
        }
        i9 = 6;
        if (z6) {
        }
        if (z5) {
        }
        if (i13 < 2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstraintWidget.java */
    /* renamed from: androidx.constraintlayout.a.a.f$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1293a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1294b;

        static {
            int[] iArr = new int[a.values().length];
            f1294b = iArr;
            try {
                iArr[a.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1294b[a.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1294b[a.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1294b[a.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f1293a = iArr2;
            try {
                iArr2[e.c.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1293a[e.c.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1293a[e.c.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1293a[e.c.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1293a[e.c.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1293a[e.c.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1293a[e.c.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1293a[e.c.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1293a[e.c.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public void c(androidx.constraintlayout.a.e eVar) {
        int b2 = eVar.b(this.s);
        int b3 = eVar.b(this.t);
        int b4 = eVar.b(this.u);
        int b5 = eVar.b(this.v);
        int i = b5 - b3;
        if (b4 - b2 < 0 || i < 0 || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE || b5 == Integer.MIN_VALUE || b5 == Integer.MAX_VALUE) {
            b5 = 0;
            b2 = 0;
            b3 = 0;
            b4 = 0;
        }
        a(b2, b3, b4, b5);
    }
}
