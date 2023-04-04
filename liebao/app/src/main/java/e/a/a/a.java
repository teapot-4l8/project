package e.a.a;

import e.r;

/* compiled from: BodyObservable.java */
/* loaded from: classes2.dex */
final class a<T> extends b.b.e<T> {

    /* renamed from: a  reason: collision with root package name */
    private final b.b.e<r<T>> f6988a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b.b.e<r<T>> eVar) {
        this.f6988a = eVar;
    }

    @Override // b.b.e
    protected void b(b.b.h<? super T> hVar) {
        this.f6988a.a(new C0178a(hVar));
    }

    /* compiled from: BodyObservable.java */
    /* renamed from: e.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0178a<R> implements b.b.h<r<R>> {

        /* renamed from: a  reason: collision with root package name */
        private final b.b.h<? super R> f6989a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f6990b;

        C0178a(b.b.h<? super R> hVar) {
            this.f6989a = hVar;
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            this.f6989a.a(bVar);
        }

        @Override // b.b.h
        /* renamed from: a */
        public void a_(r<R> rVar) {
            if (rVar.c()) {
                this.f6989a.a_(rVar.d());
                return;
            }
            this.f6990b = true;
            d dVar = new d(rVar);
            try {
                this.f6989a.a(dVar);
            } catch (Throwable th) {
                b.b.c.b.b(th);
                b.b.g.a.a(new b.b.c.a(dVar, th));
            }
        }

        @Override // b.b.h
        public void b() {
            if (this.f6990b) {
                return;
            }
            this.f6989a.b();
        }

        @Override // b.b.h
        public void a(Throwable th) {
            if (!this.f6990b) {
                this.f6989a.a(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            b.b.g.a.a(assertionError);
        }
    }
}
