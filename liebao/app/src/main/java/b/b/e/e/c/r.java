package b.b.e.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ObservableSubscribeOn.java */
/* loaded from: classes.dex */
public final class r<T> extends b.b.e.e.c.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final b.b.i f3386b;

    public r(b.b.f<T> fVar, b.b.i iVar) {
        super(fVar);
        this.f3386b = iVar;
    }

    @Override // b.b.e
    public void b(b.b.h<? super T> hVar) {
        a aVar = new a(hVar);
        hVar.a(aVar);
        aVar.b(this.f3386b.a(new b(aVar)));
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes.dex */
    static final class a<T> extends AtomicReference<b.b.b.b> implements b.b.b.b, b.b.h<T> {

        /* renamed from: a  reason: collision with root package name */
        final b.b.h<? super T> f3387a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<b.b.b.b> f3388b = new AtomicReference<>();

        a(b.b.h<? super T> hVar) {
            this.f3387a = hVar;
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            b.b.e.a.b.a(this.f3388b, bVar);
        }

        @Override // b.b.h
        public void a_(T t) {
            this.f3387a.a_(t);
        }

        @Override // b.b.h
        public void a(Throwable th) {
            this.f3387a.a(th);
        }

        @Override // b.b.h
        public void b() {
            this.f3387a.b();
        }

        @Override // b.b.b.b
        public void a() {
            b.b.e.a.b.a(this.f3388b);
            b.b.e.a.b.a((AtomicReference<b.b.b.b>) this);
        }

        void b(b.b.b.b bVar) {
            b.b.e.a.b.a((AtomicReference<b.b.b.b>) this, bVar);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes.dex */
    final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final a<T> f3390b;

        b(a<T> aVar) {
            this.f3390b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.f3316a.a(this.f3390b);
        }
    }
}
