package b.b.e.e.c;

/* compiled from: ObservableOnErrorReturn.java */
/* loaded from: classes.dex */
public final class k<T> extends b.b.e.e.c.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final b.b.d.e<? super Throwable, ? extends T> f3349b;

    public k(b.b.f<T> fVar, b.b.d.e<? super Throwable, ? extends T> eVar) {
        super(fVar);
        this.f3349b = eVar;
    }

    @Override // b.b.e
    public void b(b.b.h<? super T> hVar) {
        this.f3316a.a(new a(hVar, this.f3349b));
    }

    /* compiled from: ObservableOnErrorReturn.java */
    /* loaded from: classes.dex */
    static final class a<T> implements b.b.b.b, b.b.h<T> {

        /* renamed from: a  reason: collision with root package name */
        final b.b.h<? super T> f3350a;

        /* renamed from: b  reason: collision with root package name */
        final b.b.d.e<? super Throwable, ? extends T> f3351b;

        /* renamed from: c  reason: collision with root package name */
        b.b.b.b f3352c;

        a(b.b.h<? super T> hVar, b.b.d.e<? super Throwable, ? extends T> eVar) {
            this.f3350a = hVar;
            this.f3351b = eVar;
        }

        @Override // b.b.h
        public void a(b.b.b.b bVar) {
            if (b.b.e.a.b.a(this.f3352c, bVar)) {
                this.f3352c = bVar;
                this.f3350a.a(this);
            }
        }

        @Override // b.b.b.b
        public void a() {
            this.f3352c.a();
        }

        @Override // b.b.h
        public void a_(T t) {
            this.f3350a.a_(t);
        }

        @Override // b.b.h
        public void a(Throwable th) {
            try {
                T a2 = this.f3351b.a(th);
                if (a2 == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f3350a.a(nullPointerException);
                    return;
                }
                this.f3350a.a_(a2);
                this.f3350a.b();
            } catch (Throwable th2) {
                b.b.c.b.b(th2);
                this.f3350a.a(new b.b.c.a(th, th2));
            }
        }

        @Override // b.b.h
        public void b() {
            this.f3350a.b();
        }
    }
}
