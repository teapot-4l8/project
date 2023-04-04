package androidx.core.g;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public final class e {

    /* compiled from: Pools.java */
    /* loaded from: classes.dex */
    public interface a<T> {
        T a();

        boolean a(T t);
    }

    /* compiled from: Pools.java */
    /* loaded from: classes.dex */
    public static class b<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f1597a;

        /* renamed from: b  reason: collision with root package name */
        private int f1598b;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f1597a = new Object[i];
        }

        @Override // androidx.core.g.e.a
        public T a() {
            int i = this.f1598b;
            if (i > 0) {
                int i2 = i - 1;
                Object[] objArr = this.f1597a;
                T t = (T) objArr[i2];
                objArr[i2] = null;
                this.f1598b = i - 1;
                return t;
            }
            return null;
        }

        @Override // androidx.core.g.e.a
        public boolean a(T t) {
            if (b(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.f1598b;
            Object[] objArr = this.f1597a;
            if (i < objArr.length) {
                objArr[i] = t;
                this.f1598b = i + 1;
                return true;
            }
            return false;
        }

        private boolean b(T t) {
            for (int i = 0; i < this.f1598b; i++) {
                if (this.f1597a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: Pools.java */
    /* loaded from: classes.dex */
    public static class c<T> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f1599a;

        public c(int i) {
            super(i);
            this.f1599a = new Object();
        }

        @Override // androidx.core.g.e.b, androidx.core.g.e.a
        public T a() {
            T t;
            synchronized (this.f1599a) {
                t = (T) super.a();
            }
            return t;
        }

        @Override // androidx.core.g.e.b, androidx.core.g.e.a
        public boolean a(T t) {
            boolean a2;
            synchronized (this.f1599a) {
                a2 = super.a(t);
            }
            return a2;
        }
    }
}
