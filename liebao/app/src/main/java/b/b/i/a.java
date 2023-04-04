package b.b.i;

import b.b.e.h.a;
import b.b.e.h.c;
import b.b.e.h.e;
import b.b.h;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: BehaviorSubject.java */
/* loaded from: classes.dex */
public final class a<T> extends b<T> {

    /* renamed from: a  reason: collision with root package name */
    final AtomicReference<Object> f3511a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<C0076a<T>[]> f3512b;

    /* renamed from: e  reason: collision with root package name */
    final ReadWriteLock f3513e;
    final Lock f;
    final Lock g;
    final AtomicReference<Throwable> h;
    long i;
    private static final Object[] j = new Object[0];

    /* renamed from: c  reason: collision with root package name */
    static final C0076a[] f3509c = new C0076a[0];

    /* renamed from: d  reason: collision with root package name */
    static final C0076a[] f3510d = new C0076a[0];

    public static <T> a<T> i() {
        return new a<>();
    }

    a() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f3513e = reentrantReadWriteLock;
        this.f = reentrantReadWriteLock.readLock();
        this.g = this.f3513e.writeLock();
        this.f3512b = new AtomicReference<>(f3509c);
        this.f3511a = new AtomicReference<>();
        this.h = new AtomicReference<>();
    }

    @Override // b.b.e
    protected void b(h<? super T> hVar) {
        C0076a<T> c0076a = new C0076a<>(hVar, this);
        hVar.a(c0076a);
        if (a((C0076a) c0076a)) {
            if (c0076a.g) {
                b((C0076a) c0076a);
                return;
            } else {
                c0076a.b();
                return;
            }
        }
        Throwable th = this.h.get();
        if (th == c.f3485a) {
            hVar.b();
        } else {
            hVar.a(th);
        }
    }

    @Override // b.b.h
    public void a(b.b.b.b bVar) {
        if (this.h.get() != null) {
            bVar.a();
        }
    }

    @Override // b.b.h
    public void a_(T t) {
        b.b.e.b.b.a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.h.get() != null) {
            return;
        }
        Object a2 = e.a(t);
        d(a2);
        for (C0076a<T> c0076a : this.f3512b.get()) {
            c0076a.a(a2, this.i);
        }
    }

    @Override // b.b.h
    public void a(Throwable th) {
        b.b.e.b.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.h.compareAndSet(null, th)) {
            b.b.g.a.a(th);
            return;
        }
        Object a2 = e.a(th);
        for (C0076a<T> c0076a : c(a2)) {
            c0076a.a(a2, this.i);
        }
    }

    @Override // b.b.h
    public void b() {
        if (this.h.compareAndSet(null, c.f3485a)) {
            Object a2 = e.a();
            for (C0076a<T> c0076a : c(a2)) {
                c0076a.a(a2, this.i);
            }
        }
    }

    boolean a(C0076a<T> c0076a) {
        C0076a<T>[] c0076aArr;
        C0076a<T>[] c0076aArr2;
        do {
            c0076aArr = this.f3512b.get();
            if (c0076aArr == f3510d) {
                return false;
            }
            int length = c0076aArr.length;
            c0076aArr2 = new C0076a[length + 1];
            System.arraycopy(c0076aArr, 0, c0076aArr2, 0, length);
            c0076aArr2[length] = c0076a;
        } while (!this.f3512b.compareAndSet(c0076aArr, c0076aArr2));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void b(C0076a<T> c0076a) {
        C0076a<T>[] c0076aArr;
        C0076a[] c0076aArr2;
        do {
            c0076aArr = this.f3512b.get();
            int length = c0076aArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (c0076aArr[i2] == c0076a) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                c0076aArr2 = f3509c;
            } else {
                C0076a[] c0076aArr3 = new C0076a[length - 1];
                System.arraycopy(c0076aArr, 0, c0076aArr3, 0, i);
                System.arraycopy(c0076aArr, i + 1, c0076aArr3, i, (length - i) - 1);
                c0076aArr2 = c0076aArr3;
            }
        } while (!this.f3512b.compareAndSet(c0076aArr, c0076aArr2));
    }

    C0076a<T>[] c(Object obj) {
        C0076a<T>[] andSet = this.f3512b.getAndSet(f3510d);
        if (andSet != f3510d) {
            d(obj);
        }
        return andSet;
    }

    void d(Object obj) {
        this.g.lock();
        this.i++;
        this.f3511a.lazySet(obj);
        this.g.unlock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BehaviorSubject.java */
    /* renamed from: b.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0076a<T> implements b.b.b.b, a.InterfaceC0074a<Object> {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f3517a;

        /* renamed from: b  reason: collision with root package name */
        final a<T> f3518b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3519c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3520d;

        /* renamed from: e  reason: collision with root package name */
        b.b.e.h.a<Object> f3521e;
        boolean f;
        volatile boolean g;
        long h;

        C0076a(h<? super T> hVar, a<T> aVar) {
            this.f3517a = hVar;
            this.f3518b = aVar;
        }

        @Override // b.b.b.b
        public void a() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.f3518b.b((C0076a) this);
        }

        void b() {
            if (this.g) {
                return;
            }
            synchronized (this) {
                if (this.g) {
                    return;
                }
                if (this.f3519c) {
                    return;
                }
                a<T> aVar = this.f3518b;
                Lock lock = aVar.f;
                lock.lock();
                this.h = aVar.i;
                Object obj = aVar.f3511a.get();
                lock.unlock();
                this.f3520d = obj != null;
                this.f3519c = true;
                if (obj == null || a(obj)) {
                    return;
                }
                c();
            }
        }

        void a(Object obj, long j) {
            if (this.g) {
                return;
            }
            if (!this.f) {
                synchronized (this) {
                    if (this.g) {
                        return;
                    }
                    if (this.h == j) {
                        return;
                    }
                    if (this.f3520d) {
                        b.b.e.h.a<Object> aVar = this.f3521e;
                        if (aVar == null) {
                            aVar = new b.b.e.h.a<>(4);
                            this.f3521e = aVar;
                        }
                        aVar.a((b.b.e.h.a<Object>) obj);
                        return;
                    }
                    this.f3519c = true;
                    this.f = true;
                }
            }
            a(obj);
        }

        @Override // b.b.e.h.a.InterfaceC0074a, b.b.d.g
        public boolean a(Object obj) {
            return this.g || e.a(obj, this.f3517a);
        }

        void c() {
            b.b.e.h.a<Object> aVar;
            while (!this.g) {
                synchronized (this) {
                    aVar = this.f3521e;
                    if (aVar == null) {
                        this.f3520d = false;
                        return;
                    }
                    this.f3521e = null;
                }
                aVar.a((a.InterfaceC0074a<? super Object>) this);
            }
        }
    }
}
