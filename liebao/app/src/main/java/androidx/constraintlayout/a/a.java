package androidx.constraintlayout.a;

import androidx.constraintlayout.a.h;
import java.util.Arrays;

/* compiled from: ArrayLinkedVariables.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private final b f1259b;

    /* renamed from: c  reason: collision with root package name */
    private final c f1260c;

    /* renamed from: a  reason: collision with root package name */
    int f1258a = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1261d = 8;

    /* renamed from: e  reason: collision with root package name */
    private h f1262e = null;
    private int[] f = new int[8];
    private int[] g = new int[8];
    private float[] h = new float[8];
    private int i = -1;
    private int j = -1;
    private boolean k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, c cVar) {
        this.f1259b = bVar;
        this.f1260c = cVar;
    }

    public final void a(h hVar, float f) {
        if (f == 0.0f) {
            a(hVar, true);
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            this.h[0] = f;
            this.f[0] = hVar.f1345a;
            this.g[this.i] = -1;
            hVar.i++;
            hVar.a(this.f1259b);
            this.f1258a++;
            if (this.k) {
                return;
            }
            int i2 = this.j + 1;
            this.j = i2;
            int[] iArr = this.f;
            if (i2 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.f1258a; i4++) {
            if (this.f[i] == hVar.f1345a) {
                this.h[i] = f;
                return;
            }
            if (this.f[i] < hVar.f1345a) {
                i3 = i;
            }
            i = this.g[i];
        }
        int i5 = this.j;
        int i6 = i5 + 1;
        if (this.k) {
            int[] iArr2 = this.f;
            if (iArr2[i5] != -1) {
                i5 = iArr2.length;
            }
        } else {
            i5 = i6;
        }
        int[] iArr3 = this.f;
        if (i5 >= iArr3.length && this.f1258a < iArr3.length) {
            int i7 = 0;
            while (true) {
                int[] iArr4 = this.f;
                if (i7 >= iArr4.length) {
                    break;
                } else if (iArr4[i7] == -1) {
                    i5 = i7;
                    break;
                } else {
                    i7++;
                }
            }
        }
        int[] iArr5 = this.f;
        if (i5 >= iArr5.length) {
            i5 = iArr5.length;
            int i8 = this.f1261d * 2;
            this.f1261d = i8;
            this.k = false;
            this.j = i5 - 1;
            this.h = Arrays.copyOf(this.h, i8);
            this.f = Arrays.copyOf(this.f, this.f1261d);
            this.g = Arrays.copyOf(this.g, this.f1261d);
        }
        this.f[i5] = hVar.f1345a;
        this.h[i5] = f;
        if (i3 != -1) {
            int[] iArr6 = this.g;
            iArr6[i5] = iArr6[i3];
            iArr6[i3] = i5;
        } else {
            this.g[i5] = this.i;
            this.i = i5;
        }
        hVar.i++;
        hVar.a(this.f1259b);
        this.f1258a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f1258a >= this.f.length) {
            this.k = true;
        }
        int i9 = this.j;
        int[] iArr7 = this.f;
        if (i9 >= iArr7.length) {
            this.k = true;
            this.j = iArr7.length - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(h hVar, float f, boolean z) {
        if (f == 0.0f) {
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            this.h[0] = f;
            this.f[0] = hVar.f1345a;
            this.g[this.i] = -1;
            hVar.i++;
            hVar.a(this.f1259b);
            this.f1258a++;
            if (this.k) {
                return;
            }
            int i2 = this.j + 1;
            this.j = i2;
            int[] iArr = this.f;
            if (i2 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.f1258a; i4++) {
            if (this.f[i] == hVar.f1345a) {
                float[] fArr = this.h;
                fArr[i] = fArr[i] + f;
                if (fArr[i] == 0.0f) {
                    if (i == this.i) {
                        this.i = this.g[i];
                    } else {
                        int[] iArr2 = this.g;
                        iArr2[i3] = iArr2[i];
                    }
                    if (z) {
                        hVar.b(this.f1259b);
                    }
                    if (this.k) {
                        this.j = i;
                    }
                    hVar.i--;
                    this.f1258a--;
                    return;
                }
                return;
            }
            if (this.f[i] < hVar.f1345a) {
                i3 = i;
            }
            i = this.g[i];
        }
        int i5 = this.j;
        int i6 = i5 + 1;
        if (this.k) {
            int[] iArr3 = this.f;
            if (iArr3[i5] != -1) {
                i5 = iArr3.length;
            }
        } else {
            i5 = i6;
        }
        int[] iArr4 = this.f;
        if (i5 >= iArr4.length && this.f1258a < iArr4.length) {
            int i7 = 0;
            while (true) {
                int[] iArr5 = this.f;
                if (i7 >= iArr5.length) {
                    break;
                } else if (iArr5[i7] == -1) {
                    i5 = i7;
                    break;
                } else {
                    i7++;
                }
            }
        }
        int[] iArr6 = this.f;
        if (i5 >= iArr6.length) {
            i5 = iArr6.length;
            int i8 = this.f1261d * 2;
            this.f1261d = i8;
            this.k = false;
            this.j = i5 - 1;
            this.h = Arrays.copyOf(this.h, i8);
            this.f = Arrays.copyOf(this.f, this.f1261d);
            this.g = Arrays.copyOf(this.g, this.f1261d);
        }
        this.f[i5] = hVar.f1345a;
        this.h[i5] = f;
        if (i3 != -1) {
            int[] iArr7 = this.g;
            iArr7[i5] = iArr7[i3];
            iArr7[i3] = i5;
        } else {
            this.g[i5] = this.i;
            this.i = i5;
        }
        hVar.i++;
        hVar.a(this.f1259b);
        this.f1258a++;
        if (!this.k) {
            this.j++;
        }
        int i9 = this.j;
        int[] iArr8 = this.f;
        if (i9 >= iArr8.length) {
            this.k = true;
            this.j = iArr8.length - 1;
        }
    }

    public final float a(h hVar, boolean z) {
        if (this.f1262e == hVar) {
            this.f1262e = null;
        }
        int i = this.i;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f1258a) {
            if (this.f[i] == hVar.f1345a) {
                if (i == this.i) {
                    this.i = this.g[i];
                } else {
                    int[] iArr = this.g;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    hVar.b(this.f1259b);
                }
                hVar.i--;
                this.f1258a--;
                this.f[i] = -1;
                if (this.k) {
                    this.j = i;
                }
                return this.h[i];
            }
            i2++;
            i3 = i;
            i = this.g[i];
        }
        return 0.0f;
    }

    public final void a() {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f1258a; i2++) {
            h hVar = this.f1260c.f1330c[this.f[i]];
            if (hVar != null) {
                hVar.b(this.f1259b);
            }
            i = this.g[i];
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f1258a = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(h hVar) {
        int i = this.i;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.f1258a; i2++) {
            if (this.f[i] == hVar.f1345a) {
                return true;
            }
            i = this.g[i];
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f1258a; i2++) {
            float[] fArr = this.h;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.g[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f1258a; i2++) {
            float[] fArr = this.h;
            fArr[i] = fArr[i] / f;
            i = this.g[i];
        }
    }

    private boolean a(h hVar, e eVar) {
        return hVar.i <= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h a(e eVar) {
        boolean a2;
        boolean a3;
        int i = this.i;
        h hVar = null;
        h hVar2 = null;
        boolean z = false;
        boolean z2 = false;
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i2 = 0; i != -1 && i2 < this.f1258a; i2++) {
            float f3 = this.h[i];
            h hVar3 = this.f1260c.f1330c[this.f[i]];
            if (f3 < 0.0f) {
                if (f3 > -0.001f) {
                    this.h[i] = 0.0f;
                    hVar3.b(this.f1259b);
                    f3 = 0.0f;
                }
                if (f3 != 0.0f) {
                    if (hVar3.f == h.a.UNRESTRICTED) {
                        if (hVar2 == null) {
                            a3 = a(hVar3, eVar);
                        } else if (f > f3) {
                            a3 = a(hVar3, eVar);
                        } else if (!z && a(hVar3, eVar)) {
                            f = f3;
                            hVar2 = hVar3;
                            z = true;
                        }
                        z = a3;
                        f = f3;
                        hVar2 = hVar3;
                    } else if (hVar2 == null && f3 < 0.0f) {
                        if (hVar == null) {
                            a2 = a(hVar3, eVar);
                        } else if (f2 > f3) {
                            a2 = a(hVar3, eVar);
                        } else if (!z2 && a(hVar3, eVar)) {
                            f2 = f3;
                            hVar = hVar3;
                            z2 = true;
                        }
                        z2 = a2;
                        f2 = f3;
                        hVar = hVar3;
                    }
                }
                i = this.g[i];
            } else {
                if (f3 < 0.001f) {
                    this.h[i] = 0.0f;
                    hVar3.b(this.f1259b);
                    f3 = 0.0f;
                }
                if (f3 != 0.0f) {
                }
                i = this.g[i];
            }
        }
        return hVar2 != null ? hVar2 : hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(b bVar, b bVar2, boolean z) {
        int i = this.i;
        while (true) {
            for (int i2 = 0; i != -1 && i2 < this.f1258a; i2++) {
                if (this.f[i] == bVar2.f1323a.f1345a) {
                    float f = this.h[i];
                    a(bVar2.f1323a, z);
                    a aVar = bVar2.f1326d;
                    int i3 = aVar.i;
                    for (int i4 = 0; i3 != -1 && i4 < aVar.f1258a; i4++) {
                        a(this.f1260c.f1330c[aVar.f[i3]], aVar.h[i3] * f, z);
                        i3 = aVar.g[i3];
                    }
                    bVar.f1324b += bVar2.f1324b * f;
                    if (z) {
                        bVar2.f1323a.b(bVar);
                    }
                    i = this.i;
                } else {
                    i = this.g[i];
                }
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar, b[] bVarArr) {
        int i = this.i;
        while (true) {
            for (int i2 = 0; i != -1 && i2 < this.f1258a; i2++) {
                h hVar = this.f1260c.f1330c[this.f[i]];
                if (hVar.f1346b != -1) {
                    float f = this.h[i];
                    a(hVar, true);
                    b bVar2 = bVarArr[hVar.f1346b];
                    if (!bVar2.f1327e) {
                        a aVar = bVar2.f1326d;
                        int i3 = aVar.i;
                        for (int i4 = 0; i3 != -1 && i4 < aVar.f1258a; i4++) {
                            a(this.f1260c.f1330c[aVar.f[i3]], aVar.h[i3] * f, true);
                            i3 = aVar.g[i3];
                        }
                    }
                    bVar.f1324b += bVar2.f1324b * f;
                    bVar2.f1323a.b(bVar);
                    i = this.i;
                } else {
                    i = this.g[i];
                }
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h a(boolean[] zArr, h hVar) {
        int i = this.i;
        h hVar2 = null;
        float f = 0.0f;
        for (int i2 = 0; i != -1 && i2 < this.f1258a; i2++) {
            if (this.h[i] < 0.0f) {
                h hVar3 = this.f1260c.f1330c[this.f[i]];
                if ((zArr == null || !zArr[hVar3.f1345a]) && hVar3 != hVar && (hVar3.f == h.a.SLACK || hVar3.f == h.a.ERROR)) {
                    float f2 = this.h[i];
                    if (f2 < f) {
                        hVar2 = hVar3;
                        f = f2;
                    }
                }
            }
            i = this.g[i];
        }
        return hVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final h a(int i) {
        int i2 = this.i;
        for (int i3 = 0; i2 != -1 && i3 < this.f1258a; i3++) {
            if (i3 == i) {
                return this.f1260c.f1330c[this.f[i2]];
            }
            i2 = this.g[i2];
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float b(int i) {
        int i2 = this.i;
        for (int i3 = 0; i2 != -1 && i3 < this.f1258a; i3++) {
            if (i3 == i) {
                return this.h[i2];
            }
            i2 = this.g[i2];
        }
        return 0.0f;
    }

    public final float b(h hVar) {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f1258a; i2++) {
            if (this.f[i] == hVar.f1345a) {
                return this.h[i];
            }
            i = this.g[i];
        }
        return 0.0f;
    }

    public String toString() {
        int i = this.i;
        String str = "";
        for (int i2 = 0; i != -1 && i2 < this.f1258a; i2++) {
            str = ((str + " -> ") + this.h[i] + " : ") + this.f1260c.f1330c[this.f[i]];
            i = this.g[i];
        }
        return str;
    }
}
