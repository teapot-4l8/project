package b.b.e.e.c;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableCombineLatest.java */
/* loaded from: classes.dex */
public final class b<T, R> extends b.b.e<R> {

    /* renamed from: a  reason: collision with root package name */
    final b.b.f<? extends T>[] f3317a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends b.b.f<? extends T>> f3318b;

    /* renamed from: c  reason: collision with root package name */
    final b.b.d.e<? super Object[], ? extends R> f3319c;

    /* renamed from: d  reason: collision with root package name */
    final int f3320d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f3321e;

    public b(b.b.f<? extends T>[] fVarArr, Iterable<? extends b.b.f<? extends T>> iterable, b.b.d.e<? super Object[], ? extends R> eVar, int i, boolean z) {
        this.f3317a = fVarArr;
        this.f3318b = iterable;
        this.f3319c = eVar;
        this.f3320d = i;
        this.f3321e = z;
    }

    @Override // b.b.e
    public void b(b.b.h<? super R> hVar) {
        int length;
        b.b.f<? extends T>[] fVarArr = this.f3317a;
        if (fVarArr == null) {
            fVarArr = new b.b.e[8];
            length = 0;
            for (b.b.f<? extends T> fVar : this.f3318b) {
                if (length == fVarArr.length) {
                    b.b.f<? extends T>[] fVarArr2 = new b.b.f[(length >> 2) + length];
                    System.arraycopy(fVarArr, 0, fVarArr2, 0, length);
                    fVarArr = fVarArr2;
                }
                fVarArr[length] = fVar;
                length++;
            }
        } else {
            length = fVarArr.length;
        }
        int i = length;
        if (i == 0) {
            b.b.e.a.c.a((b.b.h<?>) hVar);
        } else {
            new C0071b(hVar, this.f3319c, i, this.f3320d, this.f3321e).a(fVarArr);
        }
    }

    /* compiled from: ObservableCombineLatest.java */
    /* renamed from: b.b.e.e.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0071b<T, R> extends AtomicInteger implements b.b.b.b {

        /* renamed from: a  reason: collision with root package name */
        final b.b.h<? super R> f3324a;

        /* renamed from: b  reason: collision with root package name */
        final b.b.d.e<? super Object[], ? extends R> f3325b;

        /* renamed from: c  reason: collision with root package name */
        final a<T, R>[] f3326c;

        /* renamed from: d  reason: collision with root package name */
        Object[] f3327d;

        /* renamed from: e  reason: collision with root package name */
        final b.b.e.f.a<Object[]> f3328e;
        final boolean f;
        volatile boolean g;
        volatile boolean h;
        final b.b.e.h.b i = new b.b.e.h.b();
        int j;
        int k;

        C0071b(b.b.h<? super R> hVar, b.b.d.e<? super Object[], ? extends R> eVar, int i, int i2, boolean z) {
            this.f3324a = hVar;
            this.f3325b = eVar;
            this.f = z;
            this.f3327d = new Object[i];
            a<T, R>[] aVarArr = new a[i];
            for (int i3 = 0; i3 < i; i3++) {
                aVarArr[i3] = new a<>(this, i3);
            }
            this.f3326c = aVarArr;
            this.f3328e = new b.b.e.f.a<>(i2);
        }

        public void a(b.b.f<? extends T>[] fVarArr) {
            a<T, R>[] aVarArr = this.f3326c;
            int length = aVarArr.length;
            this.f3324a.a(this);
            for (int i = 0; i < length && !this.h && !this.g; i++) {
                fVarArr[i].a(aVarArr[i]);
            }
        }

        @Override // b.b.b.b
        public void a() {
            if (this.g) {
                return;
            }
            this.g = true;
            b();
            if (getAndIncrement() == 0) {
                a((b.b.e.f.a<?>) this.f3328e);
            }
        }

        void b() {
            for (a<T, R> aVar : this.f3326c) {
                aVar.a();
            }
        }

        void a(b.b.e.f.a<?> aVar) {
            synchronized (this) {
                this.f3327d = null;
            }
            aVar.d();
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            b.b.e.f.a<Object[]> aVar = this.f3328e;
            b.b.h<? super R> hVar = this.f3324a;
            boolean z = this.f;
            int i = 1;
            while (!this.g) {
                if (!z && this.i.get() != null) {
                    b();
                    a((b.b.e.f.a<?>) aVar);
                    hVar.a(this.i.a());
                    return;
                }
                boolean z2 = this.h;
                Object[] m_ = aVar.m_();
                boolean z3 = m_ == null;
                if (z2 && z3) {
                    a((b.b.e.f.a<?>) aVar);
                    Throwable a2 = this.i.a();
                    if (a2 == null) {
                        hVar.b();
                        return;
                    } else {
                        hVar.a(a2);
                        return;
                    }
                } else if (!z3) {
                    try {
                        hVar.a_((Object) b.b.e.b.b.a(this.f3325b.a(m_), "The combiner returned a null value"));
                    } catch (Throwable th) {
                        b.b.c.b.b(th);
                        this.i.a(th);
                        b();
                        a((b.b.e.f.a<?>) aVar);
                        hVar.a(this.i.a());
                        return;
                    }
                } else {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
            a((b.b.e.f.a<?>) aVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a(int i, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.f3327d;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i];
                int i2 = this.j;
                if (obj == null) {
                    i2++;
                    this.j = i2;
                }
                objArr[i] = t;
                if (i2 == objArr.length) {
                    this.f3328e.a((b.b.e.f.a<Object[]>) objArr.clone());
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    c();
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
            if (r1 == r4.length) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void a(int i, Throwable th) {
            if (this.i.a(th)) {
                boolean z = true;
                if (this.f) {
                    synchronized (this) {
                        Object[] objArr = this.f3327d;
                        if (objArr == null) {
                            return;
                        }
                        boolean z2 = objArr[i] == null;
                        if (!z2) {
                            int i2 = this.k + 1;
                            this.k = i2;
                        }
                        this.h = true;
                        z = z2;
                    }
                }
                if (z) {
                    b();
                }
                c();
                return;
            }
            b.b.g.a.a(th);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
            if (r2 == r0.length) goto L19;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void a(int i) {
            synchronized (this) {
                Object[] objArr = this.f3327d;
                if (objArr == null) {
                    return;
                }
                boolean z = objArr[i] == null;
                if (!z) {
                    int i2 = this.k + 1;
                    this.k = i2;
                }
                this.h = true;
                if (z) {
                    b();
                }
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableCombineLatest.java */
    /* loaded from: classes.dex */
    public static final class a<T, R> extends AtomicReference<b.b.b.b> implements b.b.h<T> {

        /* renamed from: a  reason: collision with root package name */
        final C0071b<T, R> f3322a;

        /* renamed from: b  reason: collision with root package name */
        final int f3323b;

        a(C0071b<T, R> c0071b, int i) {
            this.f3322a = c0071b;
            this.f3323b = i;
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            b.b.e.a.b.a(this, bVar);
        }

        @Override // b.b.h
        public void a_(T t) {
            this.f3322a.a(this.f3323b, (int) t);
        }

        @Override // b.b.h
        public void a(Throwable th) {
            this.f3322a.a(this.f3323b, th);
        }

        @Override // b.b.h
        public void b() {
            this.f3322a.a(this.f3323b);
        }

        public void a() {
            b.b.e.a.b.a(this);
        }
    }
}
