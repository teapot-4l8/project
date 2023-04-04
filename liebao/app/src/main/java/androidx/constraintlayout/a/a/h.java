package androidx.constraintlayout.a.a;

import androidx.constraintlayout.a.a.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: ConstraintWidgetGroup.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public List<f> f1300a;

    /* renamed from: b  reason: collision with root package name */
    int f1301b;

    /* renamed from: c  reason: collision with root package name */
    int f1302c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1303d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f1304e;
    List<f> f;
    List<f> g;
    HashSet<f> h;
    HashSet<f> i;
    List<f> j;
    List<f> k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(List<f> list) {
        this.f1301b = -1;
        this.f1302c = -1;
        this.f1303d = false;
        this.f1304e = new int[]{-1, -1};
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new HashSet<>();
        this.i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f1300a = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(List<f> list, boolean z) {
        this.f1301b = -1;
        this.f1302c = -1;
        this.f1303d = false;
        this.f1304e = new int[]{-1, -1};
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new HashSet<>();
        this.i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f1300a = list;
        this.f1303d = z;
    }

    public List<f> a(int i) {
        if (i == 0) {
            return this.f;
        }
        if (i == 1) {
            return this.g;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<f> b(int i) {
        if (i == 0) {
            return this.h;
        }
        if (i == 1) {
            return this.i;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar, int i) {
        if (i == 0) {
            this.h.add(fVar);
        } else if (i == 1) {
            this.i.add(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<f> a() {
        if (!this.j.isEmpty()) {
            return this.j;
        }
        int size = this.f1300a.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.f1300a.get(i);
            if (!fVar.W) {
                a((ArrayList) this.j, fVar);
            }
        }
        this.k.clear();
        this.k.addAll(this.f1300a);
        this.k.removeAll(this.j);
        return this.j;
    }

    private void a(ArrayList<f> arrayList, f fVar) {
        if (fVar.Y) {
            return;
        }
        arrayList.add(fVar);
        fVar.Y = true;
        if (fVar.h()) {
            return;
        }
        if (fVar instanceof j) {
            j jVar = (j) fVar;
            int i = jVar.aj;
            for (int i2 = 0; i2 < i; i2++) {
                a(arrayList, jVar.ai[i2]);
            }
        }
        int length = fVar.A.length;
        for (int i3 = 0; i3 < length; i3++) {
            e eVar = fVar.A[i3].f1271c;
            if (eVar != null) {
                f fVar2 = eVar.f1269a;
                if (eVar != null && fVar2 != fVar.k()) {
                    a(arrayList, fVar2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            a(this.k.get(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(f fVar) {
        e eVar;
        int i;
        int e2;
        e eVar2;
        int e3;
        if (!fVar.W || fVar.h()) {
            return;
        }
        boolean z = fVar.u.f1271c != null;
        if (z) {
            eVar = fVar.u.f1271c;
        } else {
            eVar = fVar.s.f1271c;
        }
        if (eVar != null) {
            if (!eVar.f1269a.X) {
                a(eVar.f1269a);
            }
            if (eVar.f1270b == e.c.RIGHT) {
                i = eVar.f1269a.I + eVar.f1269a.p();
            } else if (eVar.f1270b == e.c.LEFT) {
                i = eVar.f1269a.I;
            }
            if (!z) {
                e2 = i - fVar.u.e();
            } else {
                e2 = i + fVar.s.e() + fVar.p();
            }
            fVar.c(e2 - fVar.p(), e2);
            if (fVar.w.f1271c == null) {
                e eVar3 = fVar.w.f1271c;
                if (!eVar3.f1269a.X) {
                    a(eVar3.f1269a);
                }
                int i2 = (eVar3.f1269a.J + eVar3.f1269a.O) - fVar.O;
                fVar.d(i2, fVar.F + i2);
                fVar.X = true;
                return;
            }
            boolean z2 = fVar.v.f1271c != null;
            if (z2) {
                eVar2 = fVar.v.f1271c;
            } else {
                eVar2 = fVar.t.f1271c;
            }
            if (eVar2 != null) {
                if (!eVar2.f1269a.X) {
                    a(eVar2.f1269a);
                }
                if (eVar2.f1270b == e.c.BOTTOM) {
                    e2 = eVar2.f1269a.J + eVar2.f1269a.r();
                } else if (eVar2.f1270b == e.c.TOP) {
                    e2 = eVar2.f1269a.J;
                }
            }
            if (z2) {
                e3 = e2 - fVar.v.e();
            } else {
                e3 = e2 + fVar.t.e() + fVar.r();
            }
            fVar.d(e3 - fVar.r(), e3);
            fVar.X = true;
            return;
        }
        i = 0;
        if (!z) {
        }
        fVar.c(e2 - fVar.p(), e2);
        if (fVar.w.f1271c == null) {
        }
    }
}
