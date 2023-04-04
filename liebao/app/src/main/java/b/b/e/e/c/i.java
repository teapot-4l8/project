package b.b.e.e.c;

/* compiled from: ObservableMap.java */
/* loaded from: classes.dex */
public final class i<T, U> extends b.b.e.e.c.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final b.b.d.e<? super T, ? extends U> f3340b;

    public i(b.b.f<T> fVar, b.b.d.e<? super T, ? extends U> eVar) {
        super(fVar);
        this.f3340b = eVar;
    }

    @Override // b.b.e
    public void b(b.b.h<? super U> hVar) {
        this.f3316a.a(new a(hVar, this.f3340b));
    }

    /* compiled from: ObservableMap.java */
    /* loaded from: classes.dex */
    static final class a<T, U> extends b.b.e.d.a<T, U> {
        final b.b.d.e<? super T, ? extends U> f;

        a(b.b.h<? super U> hVar, b.b.d.e<? super T, ? extends U> eVar) {
            super(hVar);
            this.f = eVar;
        }

        @Override // b.b.h
        public void a_(T t) {
            if (this.f3307d) {
                return;
            }
            if (this.f3308e != 0) {
                this.f3304a.a_(null);
                return;
            }
            try {
                this.f3304a.a_(b.b.e.b.b.a(this.f.a(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                b(th);
            }
        }

        @Override // b.b.e.c.b
        public int a(int i) {
            return b(i);
        }

        @Override // b.b.e.c.e
        public U m_() {
            T m_ = this.f3306c.m_();
            if (m_ != null) {
                return (U) b.b.e.b.b.a(this.f.a(m_), "The mapper function returned a null value.");
            }
            return null;
        }
    }
}
