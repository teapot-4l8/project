package b.b.e.e.c;

/* compiled from: ObservableSkip.java */
/* loaded from: classes.dex */
public final class q<T> extends b.b.e.e.c.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f3382b;

    public q(b.b.f<T> fVar, long j) {
        super(fVar);
        this.f3382b = j;
    }

    @Override // b.b.e
    public void b(b.b.h<? super T> hVar) {
        this.f3316a.a(new a(hVar, this.f3382b));
    }

    /* compiled from: ObservableSkip.java */
    /* loaded from: classes.dex */
    static final class a<T> implements b.b.b.b, b.b.h<T> {

        /* renamed from: a  reason: collision with root package name */
        final b.b.h<? super T> f3383a;

        /* renamed from: b  reason: collision with root package name */
        long f3384b;

        /* renamed from: c  reason: collision with root package name */
        b.b.b.b f3385c;

        a(b.b.h<? super T> hVar, long j) {
            this.f3383a = hVar;
            this.f3384b = j;
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            if (b.b.e.a.b.a(this.f3385c, bVar)) {
                this.f3385c = bVar;
                this.f3383a.a(this);
            }
        }

        @Override // b.b.h
        public void a_(T t) {
            long j = this.f3384b;
            if (j != 0) {
                this.f3384b = j - 1;
            } else {
                this.f3383a.a_(t);
            }
        }

        @Override // b.b.h
        public void a(Throwable th) {
            this.f3383a.a(th);
        }

        @Override // b.b.h
        public void b() {
            this.f3383a.b();
        }

        @Override // b.b.b.b
        public void a() {
            this.f3385c.a();
        }
    }
}
