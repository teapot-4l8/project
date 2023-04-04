package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;

/* compiled from: ResolutionAnchor.java */
/* loaded from: classes.dex */
public class m extends o {

    /* renamed from: a  reason: collision with root package name */
    e f1307a;

    /* renamed from: b  reason: collision with root package name */
    float f1308b;

    /* renamed from: c  reason: collision with root package name */
    m f1309c;

    /* renamed from: d  reason: collision with root package name */
    float f1310d;

    /* renamed from: e  reason: collision with root package name */
    m f1311e;
    float f;
    private m j;
    private float k;
    int g = 0;
    private n l = null;
    private int m = 1;
    private n n = null;
    private int o = 1;

    String a(int i) {
        return i == 1 ? "DIRECT" : i == 2 ? "CENTER" : i == 3 ? "MATCH" : i == 4 ? "CHAIN" : i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public m(e eVar) {
        this.f1307a = eVar;
    }

    public String toString() {
        if (this.i == 1) {
            if (this.f1311e == this) {
                return "[" + this.f1307a + ", RESOLVED: " + this.f + "]  type: " + a(this.g);
            }
            return "[" + this.f1307a + ", RESOLVED: " + this.f1311e + ":" + this.f + "] type: " + a(this.g);
        }
        return "{ " + this.f1307a + " UNRESOLVED} type: " + a(this.g);
    }

    public void a(m mVar, float f) {
        if (this.i == 0 || !(this.f1311e == mVar || this.f == f)) {
            this.f1311e = mVar;
            this.f = f;
            if (this.i == 1) {
                e();
            }
            f();
        }
    }

    @Override // androidx.constraintlayout.a.a.o
    public void a() {
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        float f;
        float f2;
        float p;
        float f3;
        m mVar7;
        boolean z = true;
        if (this.i == 1 || this.g == 4) {
            return;
        }
        n nVar = this.l;
        if (nVar != null) {
            if (nVar.i != 1) {
                return;
            }
            this.f1310d = this.m * this.l.f1312a;
        }
        n nVar2 = this.n;
        if (nVar2 != null) {
            if (nVar2.i != 1) {
                return;
            }
            this.k = this.o * this.n.f1312a;
        }
        if (this.g == 1 && ((mVar7 = this.f1309c) == null || mVar7.i == 1)) {
            m mVar8 = this.f1309c;
            if (mVar8 == null) {
                this.f1311e = this;
                this.f = this.f1310d;
            } else {
                this.f1311e = mVar8.f1311e;
                this.f = mVar8.f + this.f1310d;
            }
            f();
        } else if (this.g == 2 && (mVar4 = this.f1309c) != null && mVar4.i == 1 && (mVar5 = this.j) != null && (mVar6 = mVar5.f1309c) != null && mVar6.i == 1) {
            if (androidx.constraintlayout.a.e.a() != null) {
                androidx.constraintlayout.a.e.a().w++;
            }
            this.f1311e = this.f1309c.f1311e;
            m mVar9 = this.j;
            mVar9.f1311e = mVar9.f1309c.f1311e;
            int i = 0;
            if (this.f1307a.f1270b != e.c.RIGHT && this.f1307a.f1270b != e.c.BOTTOM) {
                z = false;
            }
            if (z) {
                f = this.f1309c.f;
                f2 = this.j.f1309c.f;
            } else {
                f = this.j.f1309c.f;
                f2 = this.f1309c.f;
            }
            float f4 = f - f2;
            if (this.f1307a.f1270b == e.c.LEFT || this.f1307a.f1270b == e.c.RIGHT) {
                p = f4 - this.f1307a.f1269a.p();
                f3 = this.f1307a.f1269a.S;
            } else {
                p = f4 - this.f1307a.f1269a.r();
                f3 = this.f1307a.f1269a.T;
            }
            int e2 = this.f1307a.e();
            int e3 = this.j.f1307a.e();
            if (this.f1307a.g() == this.j.f1307a.g()) {
                f3 = 0.5f;
                e3 = 0;
            } else {
                i = e2;
            }
            float f5 = i;
            float f6 = e3;
            float f7 = (p - f5) - f6;
            if (z) {
                m mVar10 = this.j;
                mVar10.f = mVar10.f1309c.f + f6 + (f7 * f3);
                this.f = (this.f1309c.f - f5) - (f7 * (1.0f - f3));
            } else {
                this.f = this.f1309c.f + f5 + (f7 * f3);
                m mVar11 = this.j;
                mVar11.f = (mVar11.f1309c.f - f6) - (f7 * (1.0f - f3));
            }
            f();
            this.j.f();
        } else if (this.g == 3 && (mVar = this.f1309c) != null && mVar.i == 1 && (mVar2 = this.j) != null && (mVar3 = mVar2.f1309c) != null && mVar3.i == 1) {
            if (androidx.constraintlayout.a.e.a() != null) {
                androidx.constraintlayout.a.e.a().x++;
            }
            m mVar12 = this.f1309c;
            this.f1311e = mVar12.f1311e;
            m mVar13 = this.j;
            m mVar14 = mVar13.f1309c;
            mVar13.f1311e = mVar14.f1311e;
            this.f = mVar12.f + this.f1310d;
            mVar13.f = mVar14.f + mVar13.f1310d;
            f();
            this.j.f();
        } else if (this.g == 5) {
            this.f1307a.f1269a.c();
        }
    }

    public void b(int i) {
        this.g = i;
    }

    @Override // androidx.constraintlayout.a.a.o
    public void b() {
        super.b();
        this.f1309c = null;
        this.f1310d = 0.0f;
        this.l = null;
        this.m = 1;
        this.n = null;
        this.o = 1;
        this.f1311e = null;
        this.f = 0.0f;
        this.f1308b = 0.0f;
        this.j = null;
        this.k = 0.0f;
        this.g = 0;
    }

    public void c() {
        e g = this.f1307a.g();
        if (g == null) {
            return;
        }
        if (g.g() == this.f1307a) {
            this.g = 4;
            g.a().g = 4;
        }
        int e2 = this.f1307a.e();
        if (this.f1307a.f1270b == e.c.RIGHT || this.f1307a.f1270b == e.c.BOTTOM) {
            e2 = -e2;
        }
        a(g.a(), e2);
    }

    public void a(int i, m mVar, int i2) {
        this.g = i;
        this.f1309c = mVar;
        this.f1310d = i2;
        mVar.a(this);
    }

    public void a(m mVar, int i) {
        this.f1309c = mVar;
        this.f1310d = i;
        mVar.a(this);
    }

    public void a(m mVar, int i, n nVar) {
        this.f1309c = mVar;
        mVar.a(this);
        this.l = nVar;
        this.m = i;
        nVar.a(this);
    }

    public void b(m mVar, float f) {
        this.j = mVar;
        this.k = f;
    }

    public void b(m mVar, int i, n nVar) {
        this.j = mVar;
        this.n = nVar;
        this.o = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(androidx.constraintlayout.a.e eVar) {
        androidx.constraintlayout.a.h b2 = this.f1307a.b();
        m mVar = this.f1311e;
        if (mVar == null) {
            eVar.a(b2, (int) (this.f + 0.5f));
        } else {
            eVar.c(b2, eVar.a(mVar.f1307a), (int) (this.f + 0.5f), 6);
        }
    }

    public float d() {
        return this.f;
    }
}
