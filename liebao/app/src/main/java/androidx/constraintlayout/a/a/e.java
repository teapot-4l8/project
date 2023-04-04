package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.h;

/* compiled from: ConstraintAnchor.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    final f f1269a;

    /* renamed from: b  reason: collision with root package name */
    final c f1270b;

    /* renamed from: c  reason: collision with root package name */
    e f1271c;
    androidx.constraintlayout.a.h f;
    private m g = new m(this);

    /* renamed from: d  reason: collision with root package name */
    public int f1272d = 0;

    /* renamed from: e  reason: collision with root package name */
    int f1273e = -1;
    private b h = b.NONE;
    private a i = a.RELAXED;
    private int j = 0;

    /* compiled from: ConstraintAnchor.java */
    /* loaded from: classes.dex */
    public enum a {
        RELAXED,
        STRICT
    }

    /* compiled from: ConstraintAnchor.java */
    /* loaded from: classes.dex */
    public enum b {
        NONE,
        STRONG,
        WEAK
    }

    /* compiled from: ConstraintAnchor.java */
    /* loaded from: classes.dex */
    public enum c {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public m a() {
        return this.g;
    }

    public e(f fVar, c cVar) {
        this.f1269a = fVar;
        this.f1270b = cVar;
    }

    public androidx.constraintlayout.a.h b() {
        return this.f;
    }

    public void a(androidx.constraintlayout.a.c cVar) {
        androidx.constraintlayout.a.h hVar = this.f;
        if (hVar == null) {
            this.f = new androidx.constraintlayout.a.h(h.a.UNRESTRICTED, null);
        } else {
            hVar.b();
        }
    }

    public f c() {
        return this.f1269a;
    }

    public c d() {
        return this.f1270b;
    }

    public int e() {
        e eVar;
        if (this.f1269a.l() == 8) {
            return 0;
        }
        if (this.f1273e > -1 && (eVar = this.f1271c) != null && eVar.f1269a.l() == 8) {
            return this.f1273e;
        }
        return this.f1272d;
    }

    public b f() {
        return this.h;
    }

    public e g() {
        return this.f1271c;
    }

    public int h() {
        return this.j;
    }

    public void i() {
        this.f1271c = null;
        this.f1272d = 0;
        this.f1273e = -1;
        this.h = b.STRONG;
        this.j = 0;
        this.i = a.RELAXED;
        this.g.b();
    }

    public boolean a(e eVar, int i, b bVar, int i2) {
        return a(eVar, i, -1, bVar, i2, false);
    }

    public boolean a(e eVar, int i, int i2, b bVar, int i3, boolean z) {
        if (eVar == null) {
            this.f1271c = null;
            this.f1272d = 0;
            this.f1273e = -1;
            this.h = b.NONE;
            this.j = 2;
            return true;
        } else if (z || a(eVar)) {
            this.f1271c = eVar;
            if (i > 0) {
                this.f1272d = i;
            } else {
                this.f1272d = 0;
            }
            this.f1273e = i2;
            this.h = bVar;
            this.j = i3;
            return true;
        } else {
            return false;
        }
    }

    public boolean j() {
        return this.f1271c != null;
    }

    public boolean a(e eVar) {
        boolean z = false;
        if (eVar == null) {
            return false;
        }
        c d2 = eVar.d();
        c cVar = this.f1270b;
        if (d2 == cVar) {
            return cVar != c.BASELINE || (eVar.c().z() && c().z());
        }
        switch (AnonymousClass1.f1274a[this.f1270b.ordinal()]) {
            case 1:
                return (d2 == c.BASELINE || d2 == c.CENTER_X || d2 == c.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z2 = d2 == c.LEFT || d2 == c.RIGHT;
                if (eVar.c() instanceof i) {
                    return (z2 || d2 == c.CENTER_X) ? true : true;
                }
                return z2;
            case 4:
            case 5:
                boolean z3 = d2 == c.TOP || d2 == c.BOTTOM;
                if (eVar.c() instanceof i) {
                    return (z3 || d2 == c.CENTER_Y) ? true : true;
                }
                return z3;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f1270b.name());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstraintAnchor.java */
    /* renamed from: androidx.constraintlayout.a.a.e$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1274a;

        static {
            int[] iArr = new int[c.values().length];
            f1274a = iArr;
            try {
                iArr[c.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1274a[c.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1274a[c.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1274a[c.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1274a[c.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1274a[c.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1274a[c.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1274a[c.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1274a[c.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public String toString() {
        return this.f1269a.m() + ":" + this.f1270b.toString();
    }
}
