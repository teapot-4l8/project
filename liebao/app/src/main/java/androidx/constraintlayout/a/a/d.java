package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.f;
import java.util.ArrayList;

/* compiled from: ChainHead.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    protected f f1263a;

    /* renamed from: b  reason: collision with root package name */
    protected f f1264b;

    /* renamed from: c  reason: collision with root package name */
    protected f f1265c;

    /* renamed from: d  reason: collision with root package name */
    protected f f1266d;

    /* renamed from: e  reason: collision with root package name */
    protected f f1267e;
    protected f f;
    protected f g;
    protected ArrayList<f> h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    private int o;
    private boolean p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1268q;

    public d(f fVar, int i, boolean z) {
        this.p = false;
        this.f1263a = fVar;
        this.o = i;
        this.p = z;
    }

    private static boolean a(f fVar, int i) {
        return fVar.l() != 8 && fVar.C[i] == f.a.MATCH_CONSTRAINT && (fVar.g[i] == 0 || fVar.g[i] == 3);
    }

    private void b() {
        int i = this.o * 2;
        f fVar = this.f1263a;
        boolean z = false;
        f fVar2 = fVar;
        boolean z2 = false;
        while (!z2) {
            this.i++;
            f fVar3 = null;
            fVar.af[this.o] = null;
            fVar.ae[this.o] = null;
            if (fVar.l() != 8) {
                if (this.f1264b == null) {
                    this.f1264b = fVar;
                }
                this.f1266d = fVar;
                if (fVar.C[this.o] == f.a.MATCH_CONSTRAINT && (fVar.g[this.o] == 0 || fVar.g[this.o] == 3 || fVar.g[this.o] == 2)) {
                    this.j++;
                    float f = fVar.ad[this.o];
                    if (f > 0.0f) {
                        this.k += fVar.ad[this.o];
                    }
                    if (a(fVar, this.o)) {
                        if (f < 0.0f) {
                            this.l = true;
                        } else {
                            this.m = true;
                        }
                        if (this.h == null) {
                            this.h = new ArrayList<>();
                        }
                        this.h.add(fVar);
                    }
                    if (this.f == null) {
                        this.f = fVar;
                    }
                    f fVar4 = this.g;
                    if (fVar4 != null) {
                        fVar4.ae[this.o] = fVar;
                    }
                    this.g = fVar;
                }
            }
            if (fVar2 != fVar) {
                fVar2.af[this.o] = fVar;
            }
            e eVar = fVar.A[i + 1].f1271c;
            if (eVar != null) {
                f fVar5 = eVar.f1269a;
                if (fVar5.A[i].f1271c != null && fVar5.A[i].f1271c.f1269a == fVar) {
                    fVar3 = fVar5;
                }
            }
            if (fVar3 == null) {
                fVar3 = fVar;
                z2 = true;
            }
            fVar2 = fVar;
            fVar = fVar3;
        }
        this.f1265c = fVar;
        if (this.o == 0 && this.p) {
            this.f1267e = fVar;
        } else {
            this.f1267e = this.f1263a;
        }
        if (this.m && this.l) {
            z = true;
        }
        this.n = z;
    }

    public void a() {
        if (!this.f1268q) {
            b();
        }
        this.f1268q = true;
    }
}
