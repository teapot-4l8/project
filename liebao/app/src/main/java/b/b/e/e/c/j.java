package b.b.e.e.c;

import b.b.i;

/* compiled from: ObservableObserveOn.java */
/* loaded from: classes.dex */
public final class j<T> extends b.b.e.e.c.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final b.b.i f3341b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f3342c;

    /* renamed from: d  reason: collision with root package name */
    final int f3343d;

    public j(b.b.f<T> fVar, b.b.i iVar, boolean z, int i) {
        super(fVar);
        this.f3341b = iVar;
        this.f3342c = z;
        this.f3343d = i;
    }

    @Override // b.b.e
    protected void b(b.b.h<? super T> hVar) {
        b.b.i iVar = this.f3341b;
        if (iVar instanceof b.b.e.g.m) {
            this.f3316a.a(hVar);
            return;
        }
        this.f3316a.a(new a(hVar, iVar.a(), this.f3342c, this.f3343d));
    }

    /* compiled from: ObservableObserveOn.java */
    /* loaded from: classes.dex */
    static final class a<T> extends b.b.e.d.b<T> implements b.b.h<T>, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final b.b.h<? super T> f3344a;

        /* renamed from: b  reason: collision with root package name */
        final i.c f3345b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f3346c;

        /* renamed from: d  reason: collision with root package name */
        final int f3347d;

        /* renamed from: e  reason: collision with root package name */
        b.b.e.c.e<T> f3348e;
        b.b.b.b f;
        Throwable g;
        volatile boolean h;
        volatile boolean i;
        int j;
        boolean k;

        a(b.b.h<? super T> hVar, i.c cVar, boolean z, int i) {
            this.f3344a = hVar;
            this.f3345b = cVar;
            this.f3346c = z;
            this.f3347d = i;
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            if (b.b.e.a.b.a(this.f, bVar)) {
                this.f = bVar;
                if (bVar instanceof b.b.e.c.a) {
                    b.b.e.c.a aVar = (b.b.e.c.a) bVar;
                    int a2 = aVar.a(7);
                    if (a2 == 1) {
                        this.j = a2;
                        this.f3348e = aVar;
                        this.h = true;
                        this.f3344a.a(this);
                        e();
                        return;
                    } else if (a2 == 2) {
                        this.j = a2;
                        this.f3348e = aVar;
                        this.f3344a.a(this);
                        return;
                    }
                }
                this.f3348e = new b.b.e.f.a(this.f3347d);
                this.f3344a.a(this);
            }
        }

        @Override // b.b.h
        public void a_(T t) {
            if (this.h) {
                return;
            }
            if (this.j != 2) {
                this.f3348e.a(t);
            }
            e();
        }

        @Override // b.b.h
        public void a(Throwable th) {
            if (this.h) {
                b.b.g.a.a(th);
                return;
            }
            this.g = th;
            this.h = true;
            e();
        }

        @Override // b.b.h
        public void b() {
            if (this.h) {
                return;
            }
            this.h = true;
            e();
        }

        @Override // b.b.b.b
        public void a() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.f.a();
            this.f3345b.a();
            if (getAndIncrement() == 0) {
                this.f3348e.d();
            }
        }

        void e() {
            if (getAndIncrement() == 0) {
                this.f3345b.a(this);
            }
        }

        void f() {
            b.b.e.c.e<T> eVar = this.f3348e;
            b.b.h<? super T> hVar = this.f3344a;
            int i = 1;
            while (!a(this.h, eVar.c(), hVar)) {
                while (true) {
                    boolean z = this.h;
                    try {
                        Object obj = (T) eVar.m_();
                        boolean z2 = obj == null;
                        if (a(z, z2, hVar)) {
                            return;
                        }
                        if (!z2) {
                            hVar.a_(obj);
                        } else {
                            i = addAndGet(-i);
                            if (i == 0) {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        b.b.c.b.b(th);
                        this.i = true;
                        this.f.a();
                        eVar.d();
                        hVar.a(th);
                        this.f3345b.a();
                        return;
                    }
                }
            }
        }

        void g() {
            int i = 1;
            while (!this.i) {
                boolean z = this.h;
                Throwable th = this.g;
                if (!this.f3346c && z && th != null) {
                    this.i = true;
                    this.f3344a.a(this.g);
                    this.f3345b.a();
                    return;
                }
                this.f3344a.a_(null);
                if (z) {
                    this.i = true;
                    Throwable th2 = this.g;
                    if (th2 != null) {
                        this.f3344a.a(th2);
                    } else {
                        this.f3344a.b();
                    }
                    this.f3345b.a();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.k) {
                g();
            } else {
                f();
            }
        }

        boolean a(boolean z, boolean z2, b.b.h<? super T> hVar) {
            if (this.i) {
                this.f3348e.d();
                return true;
            } else if (z) {
                Throwable th = this.g;
                if (this.f3346c) {
                    if (z2) {
                        this.i = true;
                        if (th != null) {
                            hVar.a(th);
                        } else {
                            hVar.b();
                        }
                        this.f3345b.a();
                        return true;
                    }
                    return false;
                } else if (th != null) {
                    this.i = true;
                    this.f3348e.d();
                    hVar.a(th);
                    this.f3345b.a();
                    return true;
                } else if (z2) {
                    this.i = true;
                    hVar.b();
                    this.f3345b.a();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        @Override // b.b.e.c.b
        public int a(int i) {
            if ((i & 2) != 0) {
                this.k = true;
                return 2;
            }
            return 0;
        }

        @Override // b.b.e.c.e
        public T m_() {
            return this.f3348e.m_();
        }

        @Override // b.b.e.c.e
        public void d() {
            this.f3348e.d();
        }

        @Override // b.b.e.c.e
        public boolean c() {
            return this.f3348e.c();
        }
    }
}
