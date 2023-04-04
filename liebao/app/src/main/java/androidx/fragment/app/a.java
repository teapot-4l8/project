package androidx.fragment.app;

import android.util.Log;
import androidx.fragment.app.d;
import androidx.fragment.app.k;
import androidx.fragment.app.p;
import androidx.lifecycle.h;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
public final class a extends p implements k.e {

    /* renamed from: a  reason: collision with root package name */
    final k f1832a;

    /* renamed from: b  reason: collision with root package name */
    boolean f1833b;

    /* renamed from: c  reason: collision with root package name */
    int f1834c = -1;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1834c >= 0) {
            sb.append(" #");
            sb.append(this.f1834c);
        }
        if (this.m != null) {
            sb.append(" ");
            sb.append(this.m);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.m);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1834c);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1833b);
            if (this.i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.i));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.j));
            }
            if (this.f1923e != 0 || this.f != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1923e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (this.g != 0 || this.h != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (this.p != 0 || this.f1924q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1924q);
            }
        }
        if (this.f1922d.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1922d.size();
        for (int i = 0; i < size; i++) {
            p.a aVar = this.f1922d.get(i);
            switch (aVar.f1925a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f1925a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f1926b);
            if (z) {
                if (aVar.f1927c != 0 || aVar.f1928d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1927c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f1928d));
                }
                if (aVar.f1929e != 0 || aVar.f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f1929e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f));
                }
            }
        }
    }

    public a(k kVar) {
        this.f1832a = kVar;
    }

    @Override // androidx.fragment.app.p
    void a(int i, d dVar, String str, int i2) {
        super.a(i, dVar, str, i2);
        dVar.mFragmentManager = this.f1832a;
    }

    @Override // androidx.fragment.app.p
    public p a(d dVar) {
        if (dVar.mFragmentManager != null && dVar.mFragmentManager != this.f1832a) {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + dVar.toString() + " is already attached to a FragmentManager.");
        }
        return super.a(dVar);
    }

    @Override // androidx.fragment.app.p
    public p b(d dVar) {
        if (dVar.mFragmentManager != null && dVar.mFragmentManager != this.f1832a) {
            throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + dVar.toString() + " is already attached to a FragmentManager.");
        }
        return super.b(dVar);
    }

    @Override // androidx.fragment.app.p
    public p c(d dVar) {
        if (dVar.mFragmentManager != null && dVar.mFragmentManager != this.f1832a) {
            throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + dVar.toString() + " is already attached to a FragmentManager.");
        }
        return super.c(dVar);
    }

    @Override // androidx.fragment.app.p
    public p d(d dVar) {
        if (dVar.mFragmentManager != null && dVar.mFragmentManager != this.f1832a) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + dVar.toString() + " is already attached to a FragmentManager.");
        }
        return super.d(dVar);
    }

    @Override // androidx.fragment.app.p
    public p a(d dVar, h.b bVar) {
        if (dVar.mFragmentManager != this.f1832a) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f1832a);
        } else if (!bVar.a(h.b.CREATED)) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + h.b.CREATED);
        } else {
            return super.a(dVar, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.k) {
            if (k.f1866b) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f1922d.size();
            for (int i2 = 0; i2 < size; i2++) {
                p.a aVar = this.f1922d.get(i2);
                if (aVar.f1926b != null) {
                    aVar.f1926b.mBackStackNesting += i;
                    if (k.f1866b) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f1926b + " to " + aVar.f1926b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public void a() {
        if (this.u != null) {
            for (int i = 0; i < this.u.size(); i++) {
                this.u.get(i).run();
            }
            this.u = null;
        }
    }

    @Override // androidx.fragment.app.p
    public int b() {
        return a(false);
    }

    @Override // androidx.fragment.app.p
    public int c() {
        return a(true);
    }

    @Override // androidx.fragment.app.p
    public void d() {
        j();
        this.f1832a.b((k.e) this, false);
    }

    @Override // androidx.fragment.app.p
    public void e() {
        j();
        this.f1832a.b((k.e) this, true);
    }

    int a(boolean z) {
        if (this.f1833b) {
            throw new IllegalStateException("commit already called");
        }
        if (k.f1866b) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new androidx.core.g.b("FragmentManager"));
            a("  ", printWriter);
            printWriter.close();
        }
        this.f1833b = true;
        if (this.k) {
            this.f1834c = this.f1832a.a(this);
        } else {
            this.f1834c = -1;
        }
        this.f1832a.a(this, z);
        return this.f1834c;
    }

    @Override // androidx.fragment.app.k.e
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (k.f1866b) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.k) {
            this.f1832a.b(this);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i) {
        int size = this.f1922d.size();
        for (int i2 = 0; i2 < size; i2++) {
            p.a aVar = this.f1922d.get(i2);
            int i3 = aVar.f1926b != null ? aVar.f1926b.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f1922d.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            p.a aVar = this.f1922d.get(i4);
            int i5 = aVar.f1926b != null ? aVar.f1926b.mContainerId : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar2 = arrayList.get(i6);
                    int size2 = aVar2.f1922d.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        p.a aVar3 = aVar2.f1922d.get(i7);
                        if ((aVar3.f1926b != null ? aVar3.f1926b.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        int size = this.f1922d.size();
        for (int i = 0; i < size; i++) {
            p.a aVar = this.f1922d.get(i);
            d dVar = aVar.f1926b;
            if (dVar != null) {
                dVar.setNextTransition(this.i, this.j);
            }
            switch (aVar.f1925a) {
                case 1:
                    dVar.setNextAnim(aVar.f1927c);
                    this.f1832a.a(dVar, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1925a);
                case 3:
                    dVar.setNextAnim(aVar.f1928d);
                    this.f1832a.n(dVar);
                    break;
                case 4:
                    dVar.setNextAnim(aVar.f1928d);
                    this.f1832a.o(dVar);
                    break;
                case 5:
                    dVar.setNextAnim(aVar.f1927c);
                    this.f1832a.p(dVar);
                    break;
                case 6:
                    dVar.setNextAnim(aVar.f1928d);
                    this.f1832a.q(dVar);
                    break;
                case 7:
                    dVar.setNextAnim(aVar.f1927c);
                    this.f1832a.r(dVar);
                    break;
                case 8:
                    this.f1832a.u(dVar);
                    break;
                case 9:
                    this.f1832a.u(null);
                    break;
                case 10:
                    this.f1832a.a(dVar, aVar.h);
                    break;
            }
            if (!this.t && aVar.f1925a != 1 && dVar != null) {
                this.f1832a.k(dVar);
            }
        }
        if (this.t) {
            return;
        }
        k kVar = this.f1832a;
        kVar.a(kVar.m, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        for (int size = this.f1922d.size() - 1; size >= 0; size--) {
            p.a aVar = this.f1922d.get(size);
            d dVar = aVar.f1926b;
            if (dVar != null) {
                dVar.setNextTransition(k.d(this.i), this.j);
            }
            switch (aVar.f1925a) {
                case 1:
                    dVar.setNextAnim(aVar.f);
                    this.f1832a.n(dVar);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f1925a);
                case 3:
                    dVar.setNextAnim(aVar.f1929e);
                    this.f1832a.a(dVar, false);
                    break;
                case 4:
                    dVar.setNextAnim(aVar.f1929e);
                    this.f1832a.p(dVar);
                    break;
                case 5:
                    dVar.setNextAnim(aVar.f);
                    this.f1832a.o(dVar);
                    break;
                case 6:
                    dVar.setNextAnim(aVar.f1929e);
                    this.f1832a.r(dVar);
                    break;
                case 7:
                    dVar.setNextAnim(aVar.f);
                    this.f1832a.q(dVar);
                    break;
                case 8:
                    this.f1832a.u(null);
                    break;
                case 9:
                    this.f1832a.u(dVar);
                    break;
                case 10:
                    this.f1832a.a(dVar, aVar.g);
                    break;
            }
            if (!this.t && aVar.f1925a != 3 && dVar != null) {
                this.f1832a.k(dVar);
            }
        }
        if (this.t || !z) {
            return;
        }
        k kVar = this.f1832a;
        kVar.a(kVar.m, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d a(ArrayList<d> arrayList, d dVar) {
        d dVar2 = dVar;
        int i = 0;
        while (i < this.f1922d.size()) {
            p.a aVar = this.f1922d.get(i);
            int i2 = aVar.f1925a;
            if (i2 != 1) {
                if (i2 == 2) {
                    d dVar3 = aVar.f1926b;
                    int i3 = dVar3.mContainerId;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        d dVar4 = arrayList.get(size);
                        if (dVar4.mContainerId == i3) {
                            if (dVar4 == dVar3) {
                                z = true;
                            } else {
                                if (dVar4 == dVar2) {
                                    this.f1922d.add(i, new p.a(9, dVar4));
                                    i++;
                                    dVar2 = null;
                                }
                                p.a aVar2 = new p.a(3, dVar4);
                                aVar2.f1927c = aVar.f1927c;
                                aVar2.f1929e = aVar.f1929e;
                                aVar2.f1928d = aVar.f1928d;
                                aVar2.f = aVar.f;
                                this.f1922d.add(i, aVar2);
                                arrayList.remove(dVar4);
                                i++;
                            }
                        }
                    }
                    if (z) {
                        this.f1922d.remove(i);
                        i--;
                    } else {
                        aVar.f1925a = 1;
                        arrayList.add(dVar3);
                    }
                } else if (i2 == 3 || i2 == 6) {
                    arrayList.remove(aVar.f1926b);
                    if (aVar.f1926b == dVar2) {
                        this.f1922d.add(i, new p.a(9, aVar.f1926b));
                        i++;
                        dVar2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.f1922d.add(i, new p.a(9, dVar2));
                        i++;
                        dVar2 = aVar.f1926b;
                    }
                }
                i++;
            }
            arrayList.add(aVar.f1926b);
            i++;
        }
        return dVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d b(ArrayList<d> arrayList, d dVar) {
        for (int size = this.f1922d.size() - 1; size >= 0; size--) {
            p.a aVar = this.f1922d.get(size);
            int i = aVar.f1925a;
            if (i != 1) {
                if (i != 3) {
                    switch (i) {
                        case 8:
                            dVar = null;
                            break;
                        case 9:
                            dVar = aVar.f1926b;
                            break;
                        case 10:
                            aVar.h = aVar.g;
                            break;
                    }
                }
                arrayList.add(aVar.f1926b);
            }
            arrayList.remove(aVar.f1926b);
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        for (int i = 0; i < this.f1922d.size(); i++) {
            if (b(this.f1922d.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(d.c cVar) {
        for (int i = 0; i < this.f1922d.size(); i++) {
            p.a aVar = this.f1922d.get(i);
            if (b(aVar)) {
                aVar.f1926b.setOnStartEnterTransitionListener(cVar);
            }
        }
    }

    private static boolean b(p.a aVar) {
        d dVar = aVar.f1926b;
        return (dVar == null || !dVar.mAdded || dVar.mView == null || dVar.mDetached || dVar.mHidden || !dVar.isPostponed()) ? false : true;
    }

    public String h() {
        return this.m;
    }

    @Override // androidx.fragment.app.p
    public boolean i() {
        return this.f1922d.isEmpty();
    }
}
