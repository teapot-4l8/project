package e.a.a;

import e.r;

/* compiled from: ResultObservable.java */
/* loaded from: classes2.dex */
final class f<T> extends b.b.e<e<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final b.b.e<r<T>> f7001a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b.b.e<r<T>> eVar) {
        this.f7001a = eVar;
    }

    @Override // b.b.e
    protected void b(b.b.h<? super e<T>> hVar) {
        this.f7001a.a(new a(hVar));
    }

    /* compiled from: ResultObservable.java */
    /* loaded from: classes2.dex */
    private static class a<R> implements b.b.h<r<R>> {

        /* renamed from: a  reason: collision with root package name */
        private final b.b.h<? super e<R>> f7002a;

        a(b.b.h<? super e<R>> hVar) {
            this.f7002a = hVar;
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            this.f7002a.a(bVar);
        }

        @Override // b.b.h
        /* renamed from: a */
        public void a_(r<R> rVar) {
            this.f7002a.a_(e.a(rVar));
        }

        @Override // b.b.h
        public void a(Throwable th) {
            try {
                this.f7002a.a_(e.a(th));
                this.f7002a.b();
            } catch (Throwable th2) {
                try {
                    this.f7002a.a(th2);
                } catch (Throwable th3) {
                    b.b.c.b.b(th3);
                    b.b.g.a.a(new b.b.c.a(th2, th3));
                }
            }
        }

        @Override // b.b.h
        public void b() {
            this.f7002a.b();
        }
    }
}
