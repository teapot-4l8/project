package b.b.e.e.c;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableScalarXMap.java */
/* loaded from: classes.dex */
public final class n {

    /* compiled from: ObservableScalarXMap.java */
    /* loaded from: classes.dex */
    public static final class a<T> extends AtomicInteger implements b.b.e.c.a<T>, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final b.b.h<? super T> f3377a;

        /* renamed from: b  reason: collision with root package name */
        final T f3378b;

        public a(b.b.h<? super T> hVar, T t) {
            this.f3377a = hVar;
            this.f3378b = t;
        }

        @Override // b.b.e.c.e
        public boolean a(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // b.b.e.c.e
        public T m_() {
            if (get() == 1) {
                lazySet(3);
                return this.f3378b;
            }
            return null;
        }

        @Override // b.b.e.c.e
        public boolean c() {
            return get() != 1;
        }

        @Override // b.b.e.c.e
        public void d() {
            lazySet(3);
        }

        @Override // b.b.b.b
        public void a() {
            set(3);
        }

        @Override // b.b.e.c.b
        public int a(int i) {
            if ((i & 1) != 0) {
                lazySet(1);
                return 1;
            }
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f3377a.a_((T) this.f3378b);
                if (get() == 2) {
                    lazySet(3);
                    this.f3377a.b();
                }
            }
        }
    }
}
