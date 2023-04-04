package androidx.constraintlayout.a;

import java.util.Arrays;

/* compiled from: SolverVariable.java */
/* loaded from: classes.dex */
public class h {
    private static int j = 1;
    private static int k = 1;
    private static int l = 1;
    private static int m = 1;
    private static int n = 1;

    /* renamed from: d  reason: collision with root package name */
    public float f1348d;
    a f;
    private String o;

    /* renamed from: a  reason: collision with root package name */
    public int f1345a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f1346b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f1347c = 0;

    /* renamed from: e  reason: collision with root package name */
    float[] f1349e = new float[7];
    b[] g = new b[8];
    int h = 0;
    public int i = 0;

    /* compiled from: SolverVariable.java */
    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        k++;
    }

    public h(a aVar, String str) {
        this.f = aVar;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i2 = this.h;
            if (i < i2) {
                if (this.g[i] == bVar) {
                    return;
                }
                i++;
            } else {
                b[] bVarArr = this.g;
                if (i2 >= bVarArr.length) {
                    this.g = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.g;
                int i3 = this.h;
                bVarArr2[i3] = bVar;
                this.h = i3 + 1;
                return;
            }
        }
    }

    public final void b(b bVar) {
        int i = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.g[i2] == bVar) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    b[] bVarArr = this.g;
                    int i4 = i2 + i3;
                    bVarArr[i4] = bVarArr[i4 + 1];
                }
                this.h--;
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i = this.h;
        for (int i2 = 0; i2 < i; i2++) {
            this.g[i2].f1326d.a(this.g[i2], bVar, false);
        }
        this.h = 0;
    }

    public void b() {
        this.o = null;
        this.f = a.UNKNOWN;
        this.f1347c = 0;
        this.f1345a = -1;
        this.f1346b = -1;
        this.f1348d = 0.0f;
        this.h = 0;
        this.i = 0;
    }

    public void a(a aVar, String str) {
        this.f = aVar;
    }

    public String toString() {
        return "" + this.o;
    }
}
