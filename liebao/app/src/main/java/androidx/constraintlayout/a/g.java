package androidx.constraintlayout.a;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
final class g {

    /* compiled from: Pools.java */
    /* loaded from: classes.dex */
    interface a<T> {
        T a();

        void a(T[] tArr, int i);

        boolean a(T t);
    }

    /* compiled from: Pools.java */
    /* loaded from: classes.dex */
    static class b<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f1343a;

        /* renamed from: b  reason: collision with root package name */
        private int f1344b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f1343a = new Object[i];
        }

        @Override // androidx.constraintlayout.a.g.a
        public T a() {
            int i = this.f1344b;
            if (i > 0) {
                int i2 = i - 1;
                Object[] objArr = this.f1343a;
                T t = (T) objArr[i2];
                objArr[i2] = null;
                this.f1344b = i - 1;
                return t;
            }
            return null;
        }

        @Override // androidx.constraintlayout.a.g.a
        public boolean a(T t) {
            int i = this.f1344b;
            Object[] objArr = this.f1343a;
            if (i < objArr.length) {
                objArr[i] = t;
                this.f1344b = i + 1;
                return true;
            }
            return false;
        }

        @Override // androidx.constraintlayout.a.g.a
        public void a(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                int i3 = this.f1344b;
                Object[] objArr = this.f1343a;
                if (i3 < objArr.length) {
                    objArr[i3] = t;
                    this.f1344b = i3 + 1;
                }
            }
        }
    }
}
