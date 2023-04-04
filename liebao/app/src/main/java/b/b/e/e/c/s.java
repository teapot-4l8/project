package b.b.e.e.c;

/* compiled from: ObservableTake.java */
/* loaded from: classes.dex */
public final class s<T> extends b.b.e.e.c.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f3391b;

    public s(b.b.f<T> fVar, long j) {
        super(fVar);
        this.f3391b = j;
    }

    @Override // b.b.e
    protected void b(b.b.h<? super T> hVar) {
        this.f3316a.a(new a(hVar, this.f3391b));
    }

    /* compiled from: ObservableTake.java */
    /* loaded from: classes.dex */
    static final class a<T> implements b.b.b.b, b.b.h<T> {

        /* renamed from: a  reason: collision with root package name */
        final b.b.h<? super T> f3392a;

        /* renamed from: b  reason: collision with root package name */
        boolean f3393b;

        /* renamed from: c  reason: collision with root package name */
        b.b.b.b f3394c;

        /* renamed from: d  reason: collision with root package name */
        long f3395d;

        a(b.b.h<? super T> hVar, long j) {
            this.f3392a = hVar;
            this.f3395d = j;
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            if (b.b.e.a.b.a(this.f3394c, bVar)) {
                this.f3394c = bVar;
                if (this.f3395d == 0) {
                    this.f3393b = true;
                    bVar.a();
                    b.b.e.a.c.a((b.b.h<?>) this.f3392a);
                    return;
                }
                this.f3392a.a(this);
            }
        }

        @Override // b.b.h
        public void a_(T t) {
            if (this.f3393b) {
                return;
            }
            long j = this.f3395d;
            long j2 = j - 1;
            this.f3395d = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.f3392a.a_(t);
                if (z) {
                    b();
                }
            }
        }

        @Override // b.b.h
        public void a(Throwable th) {
            if (this.f3393b) {
                b.b.g.a.a(th);
                return;
            }
            this.f3393b = true;
            this.f3394c.a();
            this.f3392a.a(th);
        }

        @Override // b.b.h
        public void b() {
            if (this.f3393b) {
                return;
            }
            this.f3393b = true;
            this.f3394c.a();
            this.f3392a.b();
        }

        @Override // b.b.b.b
        public void a() {
            this.f3394c.a();
        }
    }
}
