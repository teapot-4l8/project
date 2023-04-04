package b.b.e.e.c;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableRefCount.java */
/* loaded from: classes.dex */
public final class m<T> extends b.b.e<T> {

    /* renamed from: a  reason: collision with root package name */
    final b.b.f.a<T> f3363a;

    /* renamed from: b  reason: collision with root package name */
    final int f3364b;

    /* renamed from: c  reason: collision with root package name */
    final long f3365c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f3366d;

    /* renamed from: e  reason: collision with root package name */
    final b.b.i f3367e;
    a f;

    public m(b.b.f.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, b.b.h.a.c());
    }

    public m(b.b.f.a<T> aVar, int i, long j, TimeUnit timeUnit, b.b.i iVar) {
        this.f3363a = aVar;
        this.f3364b = i;
        this.f3365c = j;
        this.f3366d = timeUnit;
        this.f3367e = iVar;
    }

    @Override // b.b.e
    protected void b(b.b.h<? super T> hVar) {
        a aVar;
        boolean z;
        synchronized (this) {
            aVar = this.f;
            if (aVar == null) {
                aVar = new a(this);
                this.f = aVar;
            }
            long j = aVar.f3370c;
            if (j == 0 && aVar.f3369b != null) {
                aVar.f3369b.a();
            }
            long j2 = j + 1;
            aVar.f3370c = j2;
            z = true;
            if (aVar.f3371d || j2 != this.f3364b) {
                z = false;
            } else {
                aVar.f3371d = true;
            }
        }
        this.f3363a.a(new b(hVar, this, aVar));
        if (z) {
            this.f3363a.a(aVar);
        }
    }

    void a(a aVar) {
        synchronized (this) {
            if (this.f != null && this.f == aVar) {
                long j = aVar.f3370c - 1;
                aVar.f3370c = j;
                if (j == 0 && aVar.f3371d) {
                    if (this.f3365c == 0) {
                        c(aVar);
                        return;
                    }
                    b.b.e.a.f fVar = new b.b.e.a.f();
                    aVar.f3369b = fVar;
                    fVar.a(this.f3367e.a(aVar, this.f3365c, this.f3366d));
                }
            }
        }
    }

    void b(a aVar) {
        synchronized (this) {
            if (this.f != null && this.f == aVar) {
                this.f = null;
                if (aVar.f3369b != null) {
                    aVar.f3369b.a();
                }
            }
            long j = aVar.f3370c - 1;
            aVar.f3370c = j;
            if (j == 0) {
                if (this.f3363a instanceof b.b.b.b) {
                    ((b.b.b.b) this.f3363a).a();
                } else if (this.f3363a instanceof b.b.e.a.e) {
                    ((b.b.e.a.e) this.f3363a).a(aVar.get());
                }
            }
        }
    }

    void c(a aVar) {
        synchronized (this) {
            if (aVar.f3370c == 0 && aVar == this.f) {
                this.f = null;
                b.b.b.b bVar = aVar.get();
                b.b.e.a.b.a(aVar);
                if (this.f3363a instanceof b.b.b.b) {
                    ((b.b.b.b) this.f3363a).a();
                } else if (this.f3363a instanceof b.b.e.a.e) {
                    if (bVar == null) {
                        aVar.f3372e = true;
                    } else {
                        ((b.b.e.a.e) this.f3363a).a(bVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableRefCount.java */
    /* loaded from: classes.dex */
    public static final class a extends AtomicReference<b.b.b.b> implements b.b.d.d<b.b.b.b>, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final m<?> f3368a;

        /* renamed from: b  reason: collision with root package name */
        b.b.b.b f3369b;

        /* renamed from: c  reason: collision with root package name */
        long f3370c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3371d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3372e;

        a(m<?> mVar) {
            this.f3368a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3368a.c(this);
        }

        @Override // b.b.d.d
        public void a(b.b.b.b bVar) {
            b.b.e.a.b.b(this, bVar);
            synchronized (this.f3368a) {
                if (this.f3372e) {
                    ((b.b.e.a.e) this.f3368a.f3363a).a(bVar);
                }
            }
        }
    }

    /* compiled from: ObservableRefCount.java */
    /* loaded from: classes.dex */
    static final class b<T> extends AtomicBoolean implements b.b.b.b, b.b.h<T> {

        /* renamed from: a  reason: collision with root package name */
        final b.b.h<? super T> f3373a;

        /* renamed from: b  reason: collision with root package name */
        final m<T> f3374b;

        /* renamed from: c  reason: collision with root package name */
        final a f3375c;

        /* renamed from: d  reason: collision with root package name */
        b.b.b.b f3376d;

        b(b.b.h<? super T> hVar, m<T> mVar, a aVar) {
            this.f3373a = hVar;
            this.f3374b = mVar;
            this.f3375c = aVar;
        }

        @Override // b.b.h
        public void a_(T t) {
            this.f3373a.a_(t);
        }

        @Override // b.b.h
        public void a(Throwable th) {
            if (compareAndSet(false, true)) {
                this.f3374b.b(this.f3375c);
                this.f3373a.a(th);
                return;
            }
            b.b.g.a.a(th);
        }

        @Override // b.b.h
        public void b() {
            if (compareAndSet(false, true)) {
                this.f3374b.b(this.f3375c);
                this.f3373a.b();
            }
        }

        @Override // b.b.b.b
        public void a() {
            this.f3376d.a();
            if (compareAndSet(false, true)) {
                this.f3374b.a(this.f3375c);
            }
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            if (b.b.e.a.b.a(this.f3376d, bVar)) {
                this.f3376d = bVar;
                this.f3373a.a(this);
            }
        }
    }
}
