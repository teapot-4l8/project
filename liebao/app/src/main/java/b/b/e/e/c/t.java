package b.b.e.e.c;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableTakeUntil.java */
/* loaded from: classes.dex */
public final class t<T, U> extends b.b.e.e.c.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final b.b.f<? extends U> f3396b;

    public t(b.b.f<T> fVar, b.b.f<? extends U> fVar2) {
        super(fVar);
        this.f3396b = fVar2;
    }

    @Override // b.b.e
    public void b(b.b.h<? super T> hVar) {
        a aVar = new a(hVar);
        hVar.a(aVar);
        this.f3396b.a(aVar.f3399c);
        this.f3316a.a(aVar);
    }

    /* compiled from: ObservableTakeUntil.java */
    /* loaded from: classes.dex */
    static final class a<T, U> extends AtomicInteger implements b.b.b.b, b.b.h<T> {

        /* renamed from: a  reason: collision with root package name */
        final b.b.h<? super T> f3397a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<b.b.b.b> f3398b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        final a<T, U>.C0072a f3399c = new C0072a();

        /* renamed from: d  reason: collision with root package name */
        final b.b.e.h.b f3400d = new b.b.e.h.b();

        a(b.b.h<? super T> hVar) {
            this.f3397a = hVar;
        }

        @Override // b.b.b.b
        public void a() {
            b.b.e.a.b.a(this.f3398b);
            b.b.e.a.b.a(this.f3399c);
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            b.b.e.a.b.a(this.f3398b, bVar);
        }

        @Override // b.b.h
        public void a_(T t) {
            b.b.e.h.d.a(this.f3397a, t, this, this.f3400d);
        }

        @Override // b.b.h
        public void a(Throwable th) {
            b.b.e.a.b.a(this.f3399c);
            b.b.e.h.d.a((b.b.h<?>) this.f3397a, th, (AtomicInteger) this, this.f3400d);
        }

        @Override // b.b.h
        public void b() {
            b.b.e.a.b.a(this.f3399c);
            b.b.e.h.d.a(this.f3397a, this, this.f3400d);
        }

        void b(Throwable th) {
            b.b.e.a.b.a(this.f3398b);
            b.b.e.h.d.a((b.b.h<?>) this.f3397a, th, (AtomicInteger) this, this.f3400d);
        }

        void c() {
            b.b.e.a.b.a(this.f3398b);
            b.b.e.h.d.a(this.f3397a, this, this.f3400d);
        }

        /* compiled from: ObservableTakeUntil.java */
        /* renamed from: b.b.e.e.c.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        final class C0072a extends AtomicReference<b.b.b.b> implements b.b.h<U> {
            C0072a() {
            }

            @Override // b.b.h
            public void a(b.b.b.b bVar) {
                b.b.e.a.b.a(this, bVar);
            }

            @Override // b.b.h
            public void a_(U u) {
                b.b.e.a.b.a(this);
                a.this.c();
            }

            @Override // b.b.h
            public void a(Throwable th) {
                a.this.b(th);
            }

            @Override // b.b.h
            public void b() {
                a.this.c();
            }
        }
    }
}
