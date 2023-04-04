package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.aa;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManagerViewModel.java */
/* loaded from: classes.dex */
public class m extends x {

    /* renamed from: a  reason: collision with root package name */
    private static final y.b f1908a = new y.b() { // from class: androidx.fragment.app.m.1
        @Override // androidx.lifecycle.y.b
        public <T extends x> T a(Class<T> cls) {
            return new m(true);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1912e;

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<d> f1909b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, m> f1910c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, aa> f1911d = new HashMap<>();
    private boolean f = false;
    private boolean g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(aa aaVar) {
        return (m) new y(aaVar, f1908a).a(m.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(boolean z) {
        this.f1912e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.x
    public void a() {
        if (k.f1866b) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(d dVar) {
        return this.f1909b.add(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<d> c() {
        return this.f1909b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(d dVar) {
        if (this.f1909b.contains(dVar)) {
            if (this.f1912e) {
                return this.f;
            }
            return !this.g;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(d dVar) {
        return this.f1909b.remove(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m d(d dVar) {
        m mVar = this.f1910c.get(dVar.mWho);
        if (mVar == null) {
            m mVar2 = new m(this.f1912e);
            this.f1910c.put(dVar.mWho, mVar2);
            return mVar2;
        }
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa e(d dVar) {
        aa aaVar = this.f1911d.get(dVar.mWho);
        if (aaVar == null) {
            aa aaVar2 = new aa();
            this.f1911d.put(dVar.mWho, aaVar2);
            return aaVar2;
        }
        return aaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(d dVar) {
        if (k.f1866b) {
            Log.d("FragmentManager", "Clearing non-config state for " + dVar);
        }
        m mVar = this.f1910c.get(dVar.mWho);
        if (mVar != null) {
            mVar.a();
            this.f1910c.remove(dVar.mWho);
        }
        aa aaVar = this.f1911d.get(dVar.mWho);
        if (aaVar != null) {
            aaVar.a();
            this.f1911d.remove(dVar.mWho);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return this.f1909b.equals(mVar.f1909b) && this.f1910c.equals(mVar.f1910c) && this.f1911d.equals(mVar.f1911d);
    }

    public int hashCode() {
        return (((this.f1909b.hashCode() * 31) + this.f1910c.hashCode()) * 31) + this.f1911d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<d> it = this.f1909b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1910c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1911d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
