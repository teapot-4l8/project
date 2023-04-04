package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import androidx.constraintlayout.a.a.f;
import java.util.ArrayList;

/* compiled from: Guideline.java */
/* loaded from: classes.dex */
public class i extends f {
    protected float ai = -1.0f;
    protected int aj = -1;
    protected int ak = -1;
    private e al = this.t;
    private int am = 0;
    private boolean an = false;
    private int ao = 0;
    private l ap = new l();
    private int aq = 8;

    @Override // androidx.constraintlayout.a.a.f
    public boolean a() {
        return true;
    }

    public i() {
        this.B.clear();
        this.B.add(this.al);
        int length = this.A.length;
        for (int i = 0; i < length; i++) {
            this.A[i] = this.al;
        }
    }

    public void a(int i) {
        if (this.am == i) {
            return;
        }
        this.am = i;
        this.B.clear();
        if (this.am == 1) {
            this.al = this.s;
        } else {
            this.al = this.t;
        }
        this.B.add(this.al);
        int length = this.A.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.A[i2] = this.al;
        }
    }

    public int J() {
        return this.am;
    }

    /* compiled from: Guideline.java */
    /* renamed from: androidx.constraintlayout.a.a.i$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1305a;

        static {
            int[] iArr = new int[e.c.values().length];
            f1305a = iArr;
            try {
                iArr[e.c.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1305a[e.c.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1305a[e.c.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1305a[e.c.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1305a[e.c.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1305a[e.c.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1305a[e.c.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1305a[e.c.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1305a[e.c.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // androidx.constraintlayout.a.a.f
    public e a(e.c cVar) {
        switch (AnonymousClass1.f1305a[cVar.ordinal()]) {
            case 1:
            case 2:
                if (this.am == 1) {
                    return this.al;
                }
                break;
            case 3:
            case 4:
                if (this.am == 0) {
                    return this.al;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(cVar.name());
    }

    @Override // androidx.constraintlayout.a.a.f
    public ArrayList<e> C() {
        return this.B;
    }

    public void e(float f) {
        if (f > -1.0f) {
            this.ai = f;
            this.aj = -1;
            this.ak = -1;
        }
    }

    public void u(int i) {
        if (i > -1) {
            this.ai = -1.0f;
            this.aj = i;
            this.ak = -1;
        }
    }

    public void v(int i) {
        if (i > -1) {
            this.ai = -1.0f;
            this.aj = -1;
            this.ak = i;
        }
    }

    @Override // androidx.constraintlayout.a.a.f
    public void b(int i) {
        f k = k();
        if (k == null) {
            return;
        }
        if (J() == 1) {
            this.t.a().a(1, k.t.a(), 0);
            this.v.a().a(1, k.t.a(), 0);
            if (this.aj != -1) {
                this.s.a().a(1, k.s.a(), this.aj);
                this.u.a().a(1, k.s.a(), this.aj);
                return;
            } else if (this.ak != -1) {
                this.s.a().a(1, k.u.a(), -this.ak);
                this.u.a().a(1, k.u.a(), -this.ak);
                return;
            } else if (this.ai == -1.0f || k.F() != f.a.FIXED) {
                return;
            } else {
                int i2 = (int) (k.E * this.ai);
                this.s.a().a(1, k.s.a(), i2);
                this.u.a().a(1, k.s.a(), i2);
                return;
            }
        }
        this.s.a().a(1, k.s.a(), 0);
        this.u.a().a(1, k.s.a(), 0);
        if (this.aj != -1) {
            this.t.a().a(1, k.t.a(), this.aj);
            this.v.a().a(1, k.t.a(), this.aj);
        } else if (this.ak != -1) {
            this.t.a().a(1, k.v.a(), -this.ak);
            this.v.a().a(1, k.v.a(), -this.ak);
        } else if (this.ai == -1.0f || k.G() != f.a.FIXED) {
        } else {
            int i3 = (int) (k.F * this.ai);
            this.t.a().a(1, k.t.a(), i3);
            this.v.a().a(1, k.t.a(), i3);
        }
    }

    @Override // androidx.constraintlayout.a.a.f
    public void a(androidx.constraintlayout.a.e eVar) {
        g gVar = (g) k();
        if (gVar == null) {
            return;
        }
        e a2 = gVar.a(e.c.LEFT);
        e a3 = gVar.a(e.c.RIGHT);
        boolean z = true;
        boolean z2 = this.D != null && this.D.C[0] == f.a.WRAP_CONTENT;
        if (this.am == 0) {
            a2 = gVar.a(e.c.TOP);
            a3 = gVar.a(e.c.BOTTOM);
            z2 = (this.D == null || this.D.C[1] != f.a.WRAP_CONTENT) ? false : false;
        }
        if (this.aj != -1) {
            androidx.constraintlayout.a.h a4 = eVar.a(this.al);
            eVar.c(a4, eVar.a(a2), this.aj, 6);
            if (z2) {
                eVar.a(eVar.a(a3), a4, 0, 5);
            }
        } else if (this.ak != -1) {
            androidx.constraintlayout.a.h a5 = eVar.a(this.al);
            androidx.constraintlayout.a.h a6 = eVar.a(a3);
            eVar.c(a5, a6, -this.ak, 6);
            if (z2) {
                eVar.a(a5, eVar.a(a2), 0, 5);
                eVar.a(a6, a5, 0, 5);
            }
        } else if (this.ai != -1.0f) {
            eVar.a(androidx.constraintlayout.a.e.a(eVar, eVar.a(this.al), eVar.a(a2), eVar.a(a3), this.ai, this.an));
        }
    }

    @Override // androidx.constraintlayout.a.a.f
    public void c(androidx.constraintlayout.a.e eVar) {
        if (k() == null) {
            return;
        }
        int b2 = eVar.b(this.al);
        if (this.am == 1) {
            h(b2);
            i(0);
            k(k().r());
            j(0);
            return;
        }
        h(0);
        i(b2);
        j(k().p());
        k(0);
    }
}
