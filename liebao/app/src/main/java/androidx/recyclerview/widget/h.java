package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: DiffUtil.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<f> f2288a = new Comparator<f>() { // from class: androidx.recyclerview.widget.h.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            int i = fVar.f2301a - fVar2.f2301a;
            return i == 0 ? fVar.f2302b - fVar2.f2302b : i;
        }
    };

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract int a();

        public abstract boolean a(int i, int i2);

        public abstract int b();

        public abstract boolean b(int i, int i2);

        public Object c(int i, int i2) {
            return null;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static abstract class c<T> {
        public abstract boolean a(T t, T t2);

        public abstract boolean b(T t, T t2);

        public Object c(T t, T t2) {
            return null;
        }
    }

    public static b a(a aVar) {
        return a(aVar, true);
    }

    public static b a(a aVar, boolean z) {
        int a2 = aVar.a();
        int b2 = aVar.b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new e(0, a2, 0, b2));
        int abs = a2 + b2 + Math.abs(a2 - b2);
        int i = abs * 2;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            e eVar = (e) arrayList2.remove(arrayList2.size() - 1);
            f a3 = a(aVar, eVar.f2297a, eVar.f2298b, eVar.f2299c, eVar.f2300d, iArr, iArr2, abs);
            if (a3 != null) {
                if (a3.f2303c > 0) {
                    arrayList.add(a3);
                }
                a3.f2301a += eVar.f2297a;
                a3.f2302b += eVar.f2299c;
                e eVar2 = arrayList3.isEmpty() ? new e() : (e) arrayList3.remove(arrayList3.size() - 1);
                eVar2.f2297a = eVar.f2297a;
                eVar2.f2299c = eVar.f2299c;
                if (a3.f2305e) {
                    eVar2.f2298b = a3.f2301a;
                    eVar2.f2300d = a3.f2302b;
                } else if (a3.f2304d) {
                    eVar2.f2298b = a3.f2301a - 1;
                    eVar2.f2300d = a3.f2302b;
                } else {
                    eVar2.f2298b = a3.f2301a;
                    eVar2.f2300d = a3.f2302b - 1;
                }
                arrayList2.add(eVar2);
                if (a3.f2305e) {
                    if (a3.f2304d) {
                        eVar.f2297a = a3.f2301a + a3.f2303c + 1;
                        eVar.f2299c = a3.f2302b + a3.f2303c;
                    } else {
                        eVar.f2297a = a3.f2301a + a3.f2303c;
                        eVar.f2299c = a3.f2302b + a3.f2303c + 1;
                    }
                } else {
                    eVar.f2297a = a3.f2301a + a3.f2303c;
                    eVar.f2299c = a3.f2302b + a3.f2303c;
                }
                arrayList2.add(eVar);
            } else {
                arrayList3.add(eVar);
            }
        }
        Collections.sort(arrayList, f2288a);
        return new b(aVar, arrayList, iArr, iArr2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r24[r13 - 1] < r24[r13 + r5]) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ba, code lost:
        if (r25[r12 - 1] < r25[r12 + 1]) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e3 A[LOOP:4: B:52:0x00cf->B:56:0x00e3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ee A[EDGE_INSN: B:88:0x00ee->B:58:0x00ee ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static f a(a aVar, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        int i6;
        int i7;
        boolean z;
        int i8;
        int i9;
        int i10;
        boolean z2;
        int i11;
        int i12 = i2 - i;
        int i13 = i4 - i3;
        int i14 = 1;
        if (i12 < 1 || i13 < 1) {
            return null;
        }
        int i15 = i12 - i13;
        int i16 = ((i12 + i13) + 1) / 2;
        int i17 = (i5 - i16) - 1;
        int i18 = i5 + i16 + 1;
        Arrays.fill(iArr, i17, i18, 0);
        Arrays.fill(iArr2, i17 + i15, i18 + i15, i12);
        boolean z3 = i15 % 2 != 0;
        int i19 = 0;
        while (i19 <= i16) {
            int i20 = -i19;
            int i21 = i20;
            while (i21 <= i19) {
                if (i21 != i20) {
                    if (i21 != i19) {
                        int i22 = i5 + i21;
                    }
                    i10 = iArr[(i5 + i21) - i14] + i14;
                    z2 = true;
                    for (i11 = i10 - i21; i10 < i12 && i11 < i13 && aVar.a(i + i10, i3 + i11); i11++) {
                        i10++;
                    }
                    int i23 = i5 + i21;
                    iArr[i23] = i10;
                    if (!z3 && i21 >= (i15 - i19) + 1 && i21 <= (i15 + i19) - 1 && iArr[i23] >= iArr2[i23]) {
                        f fVar = new f();
                        fVar.f2301a = iArr2[i23];
                        fVar.f2302b = fVar.f2301a - i21;
                        fVar.f2303c = iArr[i23] - iArr2[i23];
                        fVar.f2304d = z2;
                        fVar.f2305e = false;
                        return fVar;
                    }
                    i21 += 2;
                    i14 = 1;
                }
                i10 = iArr[i5 + i21 + i14];
                z2 = false;
                while (i10 < i12) {
                    i10++;
                }
                int i232 = i5 + i21;
                iArr[i232] = i10;
                if (!z3) {
                }
                i21 += 2;
                i14 = 1;
            }
            int i24 = i20;
            while (i24 <= i19) {
                int i25 = i24 + i15;
                if (i25 != i19 + i15) {
                    if (i25 != i20 + i15) {
                        int i26 = i5 + i25;
                        i6 = 1;
                    } else {
                        i6 = 1;
                    }
                    i7 = iArr2[(i5 + i25) + i6] - i6;
                    z = true;
                    i8 = i7 - i25;
                    while (i7 > 0 && i8 > 0) {
                        i9 = i12;
                        if (aVar.a((i + i7) - 1, (i3 + i8) - 1)) {
                            break;
                        }
                        i7--;
                        i8--;
                        i12 = i9;
                    }
                    i9 = i12;
                    int i27 = i5 + i25;
                    iArr2[i27] = i7;
                    if (z3 && i25 >= i20 && i25 <= i19 && iArr[i27] >= iArr2[i27]) {
                        f fVar2 = new f();
                        fVar2.f2301a = iArr2[i27];
                        fVar2.f2302b = fVar2.f2301a - i25;
                        fVar2.f2303c = iArr[i27] - iArr2[i27];
                        fVar2.f2304d = z;
                        fVar2.f2305e = true;
                        return fVar2;
                    }
                    i24 += 2;
                    i12 = i9;
                } else {
                    i6 = 1;
                }
                i7 = iArr2[(i5 + i25) - i6];
                z = false;
                i8 = i7 - i25;
                while (i7 > 0) {
                    i9 = i12;
                    if (aVar.a((i + i7) - 1, (i3 + i8) - 1)) {
                    }
                }
                i9 = i12;
                int i272 = i5 + i25;
                iArr2[i272] = i7;
                if (z3) {
                }
                i24 += 2;
                i12 = i9;
            }
            i19++;
            i12 = i12;
            i14 = 1;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        int f2301a;

        /* renamed from: b  reason: collision with root package name */
        int f2302b;

        /* renamed from: c  reason: collision with root package name */
        int f2303c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2304d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2305e;

        f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        int f2297a;

        /* renamed from: b  reason: collision with root package name */
        int f2298b;

        /* renamed from: c  reason: collision with root package name */
        int f2299c;

        /* renamed from: d  reason: collision with root package name */
        int f2300d;

        public e() {
        }

        public e(int i, int i2, int i3, int i4) {
            this.f2297a = i;
            this.f2298b = i2;
            this.f2299c = i3;
            this.f2300d = i4;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<f> f2289a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f2290b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f2291c;

        /* renamed from: d  reason: collision with root package name */
        private final a f2292d;

        /* renamed from: e  reason: collision with root package name */
        private final int f2293e;
        private final int f;
        private final boolean g;

        b(a aVar, List<f> list, int[] iArr, int[] iArr2, boolean z) {
            this.f2289a = list;
            this.f2290b = iArr;
            this.f2291c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(this.f2291c, 0);
            this.f2292d = aVar;
            this.f2293e = aVar.a();
            this.f = aVar.b();
            this.g = z;
            a();
            b();
        }

        private void a() {
            f fVar = this.f2289a.isEmpty() ? null : this.f2289a.get(0);
            if (fVar != null && fVar.f2301a == 0 && fVar.f2302b == 0) {
                return;
            }
            f fVar2 = new f();
            fVar2.f2301a = 0;
            fVar2.f2302b = 0;
            fVar2.f2304d = false;
            fVar2.f2303c = 0;
            fVar2.f2305e = false;
            this.f2289a.add(0, fVar2);
        }

        private void b() {
            int i = this.f2293e;
            int i2 = this.f;
            for (int size = this.f2289a.size() - 1; size >= 0; size--) {
                f fVar = this.f2289a.get(size);
                int i3 = fVar.f2301a + fVar.f2303c;
                int i4 = fVar.f2302b + fVar.f2303c;
                if (this.g) {
                    while (i > i3) {
                        a(i, i2, size);
                        i--;
                    }
                    while (i2 > i4) {
                        b(i, i2, size);
                        i2--;
                    }
                }
                for (int i5 = 0; i5 < fVar.f2303c; i5++) {
                    int i6 = fVar.f2301a + i5;
                    int i7 = fVar.f2302b + i5;
                    int i8 = this.f2292d.b(i6, i7) ? 1 : 2;
                    this.f2290b[i6] = (i7 << 5) | i8;
                    this.f2291c[i7] = (i6 << 5) | i8;
                }
                i = fVar.f2301a;
                i2 = fVar.f2302b;
            }
        }

        private void a(int i, int i2, int i3) {
            if (this.f2290b[i - 1] != 0) {
                return;
            }
            a(i, i2, i3, false);
        }

        private void b(int i, int i2, int i3) {
            if (this.f2291c[i2 - 1] != 0) {
                return;
            }
            a(i, i2, i3, true);
        }

        private boolean a(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6;
            if (z) {
                i2--;
                i5 = i;
                i4 = i2;
            } else {
                i4 = i - 1;
                i5 = i4;
            }
            while (i3 >= 0) {
                f fVar = this.f2289a.get(i3);
                int i7 = fVar.f2301a + fVar.f2303c;
                int i8 = fVar.f2302b + fVar.f2303c;
                if (z) {
                    for (int i9 = i5 - 1; i9 >= i7; i9--) {
                        if (this.f2292d.a(i9, i4)) {
                            i6 = this.f2292d.b(i9, i4) ? 8 : 4;
                            this.f2291c[i4] = (i9 << 5) | 16;
                            this.f2290b[i9] = (i4 << 5) | i6;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i10 = i2 - 1; i10 >= i8; i10--) {
                        if (this.f2292d.a(i4, i10)) {
                            i6 = this.f2292d.b(i4, i10) ? 8 : 4;
                            int i11 = i - 1;
                            this.f2290b[i11] = (i10 << 5) | 16;
                            this.f2291c[i10] = (i11 << 5) | i6;
                            return true;
                        }
                    }
                    continue;
                }
                i5 = fVar.f2301a;
                i2 = fVar.f2302b;
                i3--;
            }
            return false;
        }

        public void a(q qVar) {
            androidx.recyclerview.widget.e eVar;
            if (qVar instanceof androidx.recyclerview.widget.e) {
                eVar = (androidx.recyclerview.widget.e) qVar;
            } else {
                eVar = new androidx.recyclerview.widget.e(qVar);
            }
            ArrayList arrayList = new ArrayList();
            int i = this.f2293e;
            int i2 = this.f;
            for (int size = this.f2289a.size() - 1; size >= 0; size--) {
                f fVar = this.f2289a.get(size);
                int i3 = fVar.f2303c;
                int i4 = fVar.f2301a + i3;
                int i5 = fVar.f2302b + i3;
                if (i4 < i) {
                    b(arrayList, eVar, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    a(arrayList, eVar, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    if ((this.f2290b[fVar.f2301a + i6] & 31) == 2) {
                        eVar.a(fVar.f2301a + i6, 1, this.f2292d.c(fVar.f2301a + i6, fVar.f2302b + i6));
                    }
                }
                i = fVar.f2301a;
                i2 = fVar.f2302b;
            }
            eVar.a();
        }

        private static d a(List<d> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                d dVar = list.get(size);
                if (dVar.f2294a == i && dVar.f2296c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f2295b += z ? 1 : -1;
                        size++;
                    }
                    return dVar;
                }
                size--;
            }
            return null;
        }

        private void a(List<d> list, q qVar, int i, int i2, int i3) {
            if (!this.g) {
                qVar.a(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.f2291c[i5] & 31;
                if (i6 == 0) {
                    qVar.a(i, 1);
                    for (d dVar : list) {
                        dVar.f2295b++;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.f2291c[i5] >> 5;
                    qVar.c(a(list, i7, true).f2295b, i);
                    if (i6 == 4) {
                        qVar.a(i, 1, this.f2292d.c(i7, i5));
                    }
                } else if (i6 == 16) {
                    list.add(new d(i5, i, false));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString(i6));
                }
            }
        }

        private void b(List<d> list, q qVar, int i, int i2, int i3) {
            if (!this.g) {
                qVar.b(i, i2);
                return;
            }
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = i3 + i4;
                int i6 = this.f2290b[i5] & 31;
                if (i6 == 0) {
                    qVar.b(i + i4, 1);
                    for (d dVar : list) {
                        dVar.f2295b--;
                    }
                } else if (i6 == 4 || i6 == 8) {
                    int i7 = this.f2290b[i5] >> 5;
                    d a2 = a(list, i7, false);
                    qVar.c(i + i4, a2.f2295b - 1);
                    if (i6 == 4) {
                        qVar.a(a2.f2295b - 1, 1, this.f2292d.c(i5, i7));
                    }
                } else if (i6 == 16) {
                    list.add(new d(i5, i + i4, true));
                } else {
                    throw new IllegalStateException("unknown flag for pos " + i5 + " " + Long.toBinaryString(i6));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        int f2294a;

        /* renamed from: b  reason: collision with root package name */
        int f2295b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2296c;

        public d(int i, int i2, boolean z) {
            this.f2294a = i;
            this.f2295b = i2;
            this.f2296c = z;
        }
    }
}
