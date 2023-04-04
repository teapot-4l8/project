package androidx.constraintlayout.a;

import androidx.constraintlayout.a.e;
import androidx.constraintlayout.a.h;

/* compiled from: ArrayRow.java */
/* loaded from: classes.dex */
public class b implements e.a {

    /* renamed from: d  reason: collision with root package name */
    public final a f1326d;

    /* renamed from: a  reason: collision with root package name */
    h f1323a = null;

    /* renamed from: b  reason: collision with root package name */
    float f1324b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    boolean f1325c = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f1327e = false;

    public b(c cVar) {
        this.f1326d = new a(this, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        h hVar = this.f1323a;
        return hVar != null && (hVar.f == h.a.UNRESTRICTED || this.f1324b >= 0.0f);
    }

    public String toString() {
        return b();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String b() {
        boolean z;
        String str = (this.f1323a == null ? "0" : "" + this.f1323a) + " = ";
        if (this.f1324b != 0.0f) {
            str = str + this.f1324b;
            z = true;
        } else {
            z = false;
        }
        int i = this.f1326d.f1258a;
        for (int i2 = 0; i2 < i; i2++) {
            h a2 = this.f1326d.a(i2);
            if (a2 != null) {
                float b2 = this.f1326d.b(i2);
                if (b2 != 0.0f) {
                    String hVar = a2.toString();
                    if (!z) {
                        if (b2 < 0.0f) {
                            str = str + "- ";
                            b2 *= -1.0f;
                        }
                        str = b2 == 1.0f ? str + hVar : str + b2 + " " + hVar;
                        z = true;
                    } else if (b2 > 0.0f) {
                        str = str + " + ";
                        if (b2 == 1.0f) {
                        }
                        z = true;
                    } else {
                        str = str + " - ";
                        b2 *= -1.0f;
                        if (b2 == 1.0f) {
                        }
                        z = true;
                    }
                }
            }
        }
        if (z) {
            return str;
        }
        return str + "0.0";
    }

    public void c() {
        this.f1323a = null;
        this.f1326d.a();
        this.f1324b = 0.0f;
        this.f1327e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(h hVar) {
        return this.f1326d.a(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(h hVar, int i) {
        this.f1323a = hVar;
        float f = i;
        hVar.f1348d = f;
        this.f1324b = f;
        this.f1327e = true;
        return this;
    }

    public b b(h hVar, int i) {
        if (i < 0) {
            this.f1324b = i * (-1);
            this.f1326d.a(hVar, 1.0f);
        } else {
            this.f1324b = i;
            this.f1326d.a(hVar, -1.0f);
        }
        return this;
    }

    public b a(h hVar, h hVar2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1324b = i;
        }
        if (!z) {
            this.f1326d.a(hVar, -1.0f);
            this.f1326d.a(hVar2, 1.0f);
        } else {
            this.f1326d.a(hVar, 1.0f);
            this.f1326d.a(hVar2, -1.0f);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b c(h hVar, int i) {
        this.f1326d.a(hVar, i);
        return this;
    }

    public b a(h hVar, h hVar2, h hVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1324b = i;
        }
        if (!z) {
            this.f1326d.a(hVar, -1.0f);
            this.f1326d.a(hVar2, 1.0f);
            this.f1326d.a(hVar3, 1.0f);
        } else {
            this.f1326d.a(hVar, 1.0f);
            this.f1326d.a(hVar2, -1.0f);
            this.f1326d.a(hVar3, -1.0f);
        }
        return this;
    }

    public b b(h hVar, h hVar2, h hVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1324b = i;
        }
        if (!z) {
            this.f1326d.a(hVar, -1.0f);
            this.f1326d.a(hVar2, 1.0f);
            this.f1326d.a(hVar3, -1.0f);
        } else {
            this.f1326d.a(hVar, 1.0f);
            this.f1326d.a(hVar2, -1.0f);
            this.f1326d.a(hVar3, 1.0f);
        }
        return this;
    }

    public b a(float f, float f2, float f3, h hVar, h hVar2, h hVar3, h hVar4) {
        this.f1324b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.f1326d.a(hVar, 1.0f);
            this.f1326d.a(hVar2, -1.0f);
            this.f1326d.a(hVar4, 1.0f);
            this.f1326d.a(hVar3, -1.0f);
        } else if (f == 0.0f) {
            this.f1326d.a(hVar, 1.0f);
            this.f1326d.a(hVar2, -1.0f);
        } else if (f3 == 0.0f) {
            this.f1326d.a(hVar3, 1.0f);
            this.f1326d.a(hVar4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.f1326d.a(hVar, 1.0f);
            this.f1326d.a(hVar2, -1.0f);
            this.f1326d.a(hVar4, f4);
            this.f1326d.a(hVar3, -f4);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(h hVar, h hVar2, int i, float f, h hVar3, h hVar4, int i2) {
        if (hVar2 == hVar3) {
            this.f1326d.a(hVar, 1.0f);
            this.f1326d.a(hVar4, 1.0f);
            this.f1326d.a(hVar2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.f1326d.a(hVar, 1.0f);
            this.f1326d.a(hVar2, -1.0f);
            this.f1326d.a(hVar3, -1.0f);
            this.f1326d.a(hVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.f1324b = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            this.f1326d.a(hVar, -1.0f);
            this.f1326d.a(hVar2, 1.0f);
            this.f1324b = i;
        } else if (f >= 1.0f) {
            this.f1326d.a(hVar3, -1.0f);
            this.f1326d.a(hVar4, 1.0f);
            this.f1324b = i2;
        } else {
            float f2 = 1.0f - f;
            this.f1326d.a(hVar, f2 * 1.0f);
            this.f1326d.a(hVar2, f2 * (-1.0f));
            this.f1326d.a(hVar3, (-1.0f) * f);
            this.f1326d.a(hVar4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.f1324b = ((-i) * f2) + (i2 * f);
            }
        }
        return this;
    }

    public b a(e eVar, int i) {
        this.f1326d.a(eVar.a(i, "ep"), 1.0f);
        this.f1326d.a(eVar.a(i, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b a(h hVar, h hVar2, h hVar3, float f) {
        this.f1326d.a(hVar, -1.0f);
        this.f1326d.a(hVar2, 1.0f - f);
        this.f1326d.a(hVar3, f);
        return this;
    }

    public b a(h hVar, h hVar2, h hVar3, h hVar4, float f) {
        this.f1326d.a(hVar, -1.0f);
        this.f1326d.a(hVar2, 1.0f);
        this.f1326d.a(hVar3, f);
        this.f1326d.a(hVar4, -f);
        return this;
    }

    public b b(h hVar, h hVar2, h hVar3, h hVar4, float f) {
        this.f1326d.a(hVar3, 0.5f);
        this.f1326d.a(hVar4, 0.5f);
        this.f1326d.a(hVar, -0.5f);
        this.f1326d.a(hVar2, -0.5f);
        this.f1324b = -f;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        float f = this.f1324b;
        if (f < 0.0f) {
            this.f1324b = f * (-1.0f);
            this.f1326d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(e eVar) {
        boolean z;
        h a2 = this.f1326d.a(eVar);
        if (a2 == null) {
            z = true;
        } else {
            c(a2);
            z = false;
        }
        if (this.f1326d.f1258a == 0) {
            this.f1327e = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h b(h hVar) {
        return this.f1326d.a((boolean[]) null, hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(h hVar) {
        h hVar2 = this.f1323a;
        if (hVar2 != null) {
            this.f1326d.a(hVar2, -1.0f);
            this.f1323a = null;
        }
        float a2 = this.f1326d.a(hVar, true) * (-1.0f);
        this.f1323a = hVar;
        if (a2 == 1.0f) {
            return;
        }
        this.f1324b /= a2;
        this.f1326d.a(a2);
    }

    public boolean e() {
        return this.f1323a == null && this.f1324b == 0.0f && this.f1326d.f1258a == 0;
    }

    @Override // androidx.constraintlayout.a.e.a
    public h a(e eVar, boolean[] zArr) {
        return this.f1326d.a(zArr, (h) null);
    }

    @Override // androidx.constraintlayout.a.e.a
    public void f() {
        this.f1326d.a();
        this.f1323a = null;
        this.f1324b = 0.0f;
    }

    @Override // androidx.constraintlayout.a.e.a
    public void a(e.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f1323a = null;
            this.f1326d.a();
            for (int i = 0; i < bVar.f1326d.f1258a; i++) {
                this.f1326d.a(bVar.f1326d.a(i), bVar.f1326d.b(i), true);
            }
        }
    }

    @Override // androidx.constraintlayout.a.e.a
    public void d(h hVar) {
        float f = 1.0f;
        if (hVar.f1347c != 1) {
            if (hVar.f1347c == 2) {
                f = 1000.0f;
            } else if (hVar.f1347c == 3) {
                f = 1000000.0f;
            } else if (hVar.f1347c == 4) {
                f = 1.0E9f;
            } else if (hVar.f1347c == 5) {
                f = 1.0E12f;
            }
        }
        this.f1326d.a(hVar, f);
    }

    @Override // androidx.constraintlayout.a.e.a
    public h g() {
        return this.f1323a;
    }
}
