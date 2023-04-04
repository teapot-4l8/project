package b.b.e.b;

import java.util.Comparator;
import java.util.concurrent.Callable;

/* compiled from: Functions.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final b.b.d.e<Object, Object> f3297a = new h();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f3298b = new e();

    /* renamed from: c  reason: collision with root package name */
    public static final b.b.d.a f3299c = new b();

    /* renamed from: d  reason: collision with root package name */
    static final b.b.d.d<Object> f3300d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final b.b.d.d<Throwable> f3301e = new f();
    public static final b.b.d.d<Throwable> f = new l();
    public static final b.b.d.f g = new d();
    static final b.b.d.g<Object> h = new m();
    static final b.b.d.g<Object> i = new g();
    static final Callable<Object> j = new k();
    static final Comparator<Object> k = new j();
    public static final b.b.d.d<org.a.a> l = new i();

    public static <T1, T2, R> b.b.d.e<Object[], R> a(b.b.d.b<? super T1, ? super T2, ? extends R> bVar) {
        b.b.e.b.b.a(bVar, "f is null");
        return new C0070a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Functions.java */
    /* renamed from: b.b.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0070a<T1, T2, R> implements b.b.d.e<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final b.b.d.b<? super T1, ? super T2, ? extends R> f3302a;

        C0070a(b.b.d.b<? super T1, ? super T2, ? extends R> bVar) {
            this.f3302a = bVar;
        }

        @Override // b.b.d.e
        public R a(Object[] objArr) {
            if (objArr.length != 2) {
                throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
            }
            return this.f3302a.b(objArr[0], objArr[1]);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class h implements b.b.d.e<Object, Object> {
        @Override // b.b.d.e
        public Object a(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }

        h() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class e implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        e() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class b implements b.b.d.a {
        public String toString() {
            return "EmptyAction";
        }

        b() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class c implements b.b.d.d<Object> {
        @Override // b.b.d.d
        public void a(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        c() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class f implements b.b.d.d<Throwable> {
        f() {
        }

        @Override // b.b.d.d
        public void a(Throwable th) {
            b.b.g.a.a(th);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class l implements b.b.d.d<Throwable> {
        l() {
        }

        @Override // b.b.d.d
        public void a(Throwable th) {
            b.b.g.a.a(new b.b.c.d(th));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class d implements b.b.d.f {
        d() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class m implements b.b.d.g<Object> {
        @Override // b.b.d.g
        public boolean a(Object obj) {
            return true;
        }

        m() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class g implements b.b.d.g<Object> {
        @Override // b.b.d.g
        public boolean a(Object obj) {
            return false;
        }

        g() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class k implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }

        k() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class j implements Comparator<Object> {
        j() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes.dex */
    static final class i implements b.b.d.d<org.a.a> {
        i() {
        }

        @Override // b.b.d.d
        public void a(org.a.a aVar) {
            aVar.a(Long.MAX_VALUE);
        }
    }
}
