package androidx.fragment.app;

import androidx.lifecycle.h;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: FragmentTransaction.java */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: e  reason: collision with root package name */
    int f1923e;
    int f;
    int g;
    int h;
    int i;
    int j;
    boolean k;
    String m;
    int n;
    CharSequence o;
    int p;

    /* renamed from: q  reason: collision with root package name */
    CharSequence f1924q;
    ArrayList<String> r;
    ArrayList<String> s;
    ArrayList<Runnable> u;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<a> f1922d = new ArrayList<>();
    boolean l = true;
    boolean t = false;

    public abstract int b();

    public abstract int c();

    public abstract void d();

    public abstract void e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentTransaction.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f1925a;

        /* renamed from: b  reason: collision with root package name */
        d f1926b;

        /* renamed from: c  reason: collision with root package name */
        int f1927c;

        /* renamed from: d  reason: collision with root package name */
        int f1928d;

        /* renamed from: e  reason: collision with root package name */
        int f1929e;
        int f;
        h.b g;
        h.b h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, d dVar) {
            this.f1925a = i;
            this.f1926b = dVar;
            this.g = h.b.RESUMED;
            this.h = h.b.RESUMED;
        }

        a(int i, d dVar, h.b bVar) {
            this.f1925a = i;
            this.f1926b = dVar;
            this.g = dVar.mMaxState;
            this.h = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f1922d.add(aVar);
        aVar.f1927c = this.f1923e;
        aVar.f1928d = this.f;
        aVar.f1929e = this.g;
        aVar.f = this.h;
    }

    public p a(d dVar, String str) {
        a(0, dVar, str, 1);
        return this;
    }

    public p a(int i, d dVar, String str) {
        a(i, dVar, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, d dVar, String str, int i2) {
        Class<?> cls = dVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (dVar.mTag != null && !str.equals(dVar.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + dVar + ": was " + dVar.mTag + " now " + str);
            }
            dVar.mTag = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + dVar + " with tag " + str + " to container view with no id");
            } else if (dVar.mFragmentId != 0 && dVar.mFragmentId != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + dVar + ": was " + dVar.mFragmentId + " now " + i);
            } else {
                dVar.mFragmentId = i;
                dVar.mContainerId = i;
            }
        }
        a(new a(i2, dVar));
    }

    public p a(d dVar) {
        a(new a(3, dVar));
        return this;
    }

    public p b(d dVar) {
        a(new a(4, dVar));
        return this;
    }

    public p c(d dVar) {
        a(new a(5, dVar));
        return this;
    }

    public p d(d dVar) {
        a(new a(6, dVar));
        return this;
    }

    public p e(d dVar) {
        a(new a(7, dVar));
        return this;
    }

    public p a(d dVar, h.b bVar) {
        a(new a(10, dVar, bVar));
        return this;
    }

    public boolean i() {
        return this.f1922d.isEmpty();
    }

    public p j() {
        if (this.k) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.l = false;
        return this;
    }
}
