package androidx.lifecycle;

import androidx.lifecycle.h;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: c  reason: collision with root package name */
    static final Object f1983c = new Object();
    private boolean h;
    private boolean i;

    /* renamed from: b  reason: collision with root package name */
    final Object f1985b = new Object();

    /* renamed from: a  reason: collision with root package name */
    private androidx.a.a.b.b<s<? super T>, LiveData<T>.a> f1984a = new androidx.a.a.b.b<>();

    /* renamed from: d  reason: collision with root package name */
    int f1986d = 0;
    private volatile Object f = f1983c;

    /* renamed from: e  reason: collision with root package name */
    volatile Object f1987e = f1983c;
    private int g = -1;
    private final Runnable j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f1985b) {
                obj = LiveData.this.f1987e;
                LiveData.this.f1987e = LiveData.f1983c;
            }
            LiveData.this.b((LiveData) obj);
        }
    };

    protected void a() {
    }

    protected void c() {
    }

    private void b(LiveData<T>.a aVar) {
        if (aVar.f1992d) {
            if (!aVar.a()) {
                aVar.a(false);
                return;
            }
            int i = aVar.f1993e;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            aVar.f1993e = i2;
            aVar.f1991c.a((Object) this.f);
        }
    }

    void a(LiveData<T>.a aVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (aVar != null) {
                b((a) aVar);
                aVar = null;
            } else {
                androidx.a.a.b.b<s<? super T>, LiveData<T>.a>.d c2 = this.f1984a.c();
                while (c2.hasNext()) {
                    b((a) ((a) c2.next().getValue()));
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public void a(l lVar, s<? super T> sVar) {
        a("observe");
        if (lVar.getLifecycle().a() == h.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lVar, sVar);
        LiveData<T>.a a2 = this.f1984a.a(sVar, lifecycleBoundObserver);
        if (a2 != null && !a2.a(lVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (a2 != null) {
            return;
        }
        lVar.getLifecycle().a(lifecycleBoundObserver);
    }

    public void a(s<? super T> sVar) {
        a("removeObserver");
        LiveData<T>.a b2 = this.f1984a.b(sVar);
        if (b2 == null) {
            return;
        }
        b2.b();
        b2.a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        boolean z;
        synchronized (this.f1985b) {
            z = this.f1987e == f1983c;
            this.f1987e = t;
        }
        if (z) {
            androidx.a.a.a.a.a().b(this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(T t) {
        a("setValue");
        this.g++;
        this.f = t;
        a((a) null);
    }

    public T b() {
        T t = (T) this.f;
        if (t != f1983c) {
            return t;
        }
        return null;
    }

    public boolean d() {
        return this.f1986d > 0;
    }

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.a implements g {

        /* renamed from: a  reason: collision with root package name */
        final l f1989a;

        LifecycleBoundObserver(l lVar, s<? super T> sVar) {
            super(sVar);
            this.f1989a = lVar;
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean a() {
            return this.f1989a.getLifecycle().a().a(h.b.STARTED);
        }

        @Override // androidx.lifecycle.j
        public void onStateChanged(l lVar, h.a aVar) {
            if (this.f1989a.getLifecycle().a() == h.b.DESTROYED) {
                LiveData.this.a((s) this.f1991c);
            } else {
                a(a());
            }
        }

        @Override // androidx.lifecycle.LiveData.a
        boolean a(l lVar) {
            return this.f1989a == lVar;
        }

        @Override // androidx.lifecycle.LiveData.a
        void b() {
            this.f1989a.getLifecycle().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class a {

        /* renamed from: c  reason: collision with root package name */
        final s<? super T> f1991c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1992d;

        /* renamed from: e  reason: collision with root package name */
        int f1993e = -1;

        abstract boolean a();

        boolean a(l lVar) {
            return false;
        }

        void b() {
        }

        a(s<? super T> sVar) {
            this.f1991c = sVar;
        }

        void a(boolean z) {
            if (z == this.f1992d) {
                return;
            }
            this.f1992d = z;
            boolean z2 = LiveData.this.f1986d == 0;
            LiveData.this.f1986d += this.f1992d ? 1 : -1;
            if (z2 && this.f1992d) {
                LiveData.this.a();
            }
            if (LiveData.this.f1986d == 0 && !this.f1992d) {
                LiveData.this.c();
            }
            if (this.f1992d) {
                LiveData.this.a(this);
            }
        }
    }

    private static void a(String str) {
        if (androidx.a.a.a.a.a().c()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }
}
