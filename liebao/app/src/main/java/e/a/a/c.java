package e.a.a;

import e.r;

/* compiled from: CallExecuteObservable.java */
/* loaded from: classes2.dex */
final class c<T> extends b.b.e<r<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final e.b<T> f6996a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e.b<T> bVar) {
        this.f6996a = bVar;
    }

    @Override // b.b.e
    protected void b(b.b.h<? super r<T>> hVar) {
        boolean z;
        e.b<T> d2 = this.f6996a.d();
        a aVar = new a(d2);
        hVar.a(aVar);
        if (aVar.b()) {
            return;
        }
        try {
            r<T> a2 = d2.a();
            if (!aVar.b()) {
                hVar.a_(a2);
            }
            if (aVar.b()) {
                return;
            }
            try {
                hVar.b();
            } catch (Throwable th) {
                th = th;
                z = true;
                b.b.c.b.b(th);
                if (z) {
                    b.b.g.a.a(th);
                } else if (aVar.b()) {
                } else {
                    try {
                        hVar.a(th);
                    } catch (Throwable th2) {
                        b.b.c.b.b(th2);
                        b.b.g.a.a(new b.b.c.a(th, th2));
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    /* compiled from: CallExecuteObservable.java */
    /* loaded from: classes2.dex */
    private static final class a implements b.b.b.b {

        /* renamed from: a  reason: collision with root package name */
        private final e.b<?> f6997a;

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f6998b;

        a(e.b<?> bVar) {
            this.f6997a = bVar;
        }

        @Override // b.b.b.b
        public void a() {
            this.f6998b = true;
            this.f6997a.b();
        }

        public boolean b() {
            return this.f6998b;
        }
    }
}
