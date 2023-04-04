package e.a.a;

import e.r;

/* compiled from: CallEnqueueObservable.java */
/* loaded from: classes2.dex */
final class b<T> extends b.b.e<r<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final e.b<T> f6991a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e.b<T> bVar) {
        this.f6991a = bVar;
    }

    @Override // b.b.e
    protected void b(b.b.h<? super r<T>> hVar) {
        e.b<T> d2 = this.f6991a.d();
        a aVar = new a(d2, hVar);
        hVar.a(aVar);
        if (aVar.b()) {
            return;
        }
        d2.a(aVar);
    }

    /* compiled from: CallEnqueueObservable.java */
    /* loaded from: classes2.dex */
    private static final class a<T> implements b.b.b.b, e.d<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f6992a = false;

        /* renamed from: b  reason: collision with root package name */
        private final e.b<?> f6993b;

        /* renamed from: c  reason: collision with root package name */
        private final b.b.h<? super r<T>> f6994c;

        /* renamed from: d  reason: collision with root package name */
        private volatile boolean f6995d;

        a(e.b<?> bVar, b.b.h<? super r<T>> hVar) {
            this.f6993b = bVar;
            this.f6994c = hVar;
        }

        @Override // e.d
        public void a(e.b<T> bVar, r<T> rVar) {
            if (this.f6995d) {
                return;
            }
            try {
                this.f6994c.a_(rVar);
                if (this.f6995d) {
                    return;
                }
                this.f6992a = true;
                this.f6994c.b();
            } catch (Throwable th) {
                if (this.f6992a) {
                    b.b.g.a.a(th);
                } else if (this.f6995d) {
                } else {
                    try {
                        this.f6994c.a(th);
                    } catch (Throwable th2) {
                        b.b.c.b.b(th2);
                        b.b.g.a.a(new b.b.c.a(th, th2));
                    }
                }
            }
        }

        @Override // e.d
        public void a(e.b<T> bVar, Throwable th) {
            if (bVar.c()) {
                return;
            }
            try {
                this.f6994c.a(th);
            } catch (Throwable th2) {
                b.b.c.b.b(th2);
                b.b.g.a.a(new b.b.c.a(th, th2));
            }
        }

        @Override // b.b.b.b
        public void a() {
            this.f6995d = true;
            this.f6993b.b();
        }

        public boolean b() {
            return this.f6995d;
        }
    }
}
