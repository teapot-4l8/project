package b.b.e.e.c;

/* compiled from: ObservableFilter.java */
/* loaded from: classes.dex */
public final class d<T> extends b.b.e.e.c.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final b.b.d.g<? super T> f3330b;

    public d(b.b.f<T> fVar, b.b.d.g<? super T> gVar) {
        super(fVar);
        this.f3330b = gVar;
    }

    @Override // b.b.e
    public void b(b.b.h<? super T> hVar) {
        this.f3316a.a(new a(hVar, this.f3330b));
    }

    /* compiled from: ObservableFilter.java */
    /* loaded from: classes.dex */
    static final class a<T> extends b.b.e.d.a<T, T> {
        final b.b.d.g<? super T> f;

        a(b.b.h<? super T> hVar, b.b.d.g<? super T> gVar) {
            super(hVar);
            this.f = gVar;
        }

        @Override // b.b.h
        public void a_(T t) {
            if (this.f3308e == 0) {
                try {
                    if (this.f.a(t)) {
                        this.f3304a.a_(t);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    b(th);
                    return;
                }
            }
            this.f3304a.a_(null);
        }

        @Override // b.b.e.c.b
        public int a(int i) {
            return b(i);
        }

        @Override // b.b.e.c.e
        public T m_() {
            T m_;
            do {
                m_ = this.f3306c.m_();
                if (m_ == null) {
                    break;
                }
            } while (!this.f.a(m_));
            return m_;
        }
    }
}
