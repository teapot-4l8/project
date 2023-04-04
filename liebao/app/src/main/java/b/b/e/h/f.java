package b.b.e.h;

/* compiled from: OpenHashSet.java */
/* loaded from: classes.dex */
public final class f<T> {

    /* renamed from: a  reason: collision with root package name */
    final float f3489a;

    /* renamed from: b  reason: collision with root package name */
    int f3490b;

    /* renamed from: c  reason: collision with root package name */
    int f3491c;

    /* renamed from: d  reason: collision with root package name */
    int f3492d;

    /* renamed from: e  reason: collision with root package name */
    T[] f3493e;

    static int a(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public f() {
        this(16, 0.75f);
    }

    public f(int i, float f) {
        this.f3489a = f;
        int a2 = g.a(i);
        this.f3490b = a2 - 1;
        this.f3492d = (int) (f * a2);
        this.f3493e = (T[]) new Object[a2];
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.f3493e;
        int i = this.f3490b;
        int a2 = a(t.hashCode()) & i;
        T t3 = tArr[a2];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                a2 = (a2 + 1) & i;
                t2 = tArr[a2];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[a2] = t;
        int i2 = this.f3491c + 1;
        this.f3491c = i2;
        if (i2 >= this.f3492d) {
            a();
        }
        return true;
    }

    public boolean b(T t) {
        T t2;
        T[] tArr = this.f3493e;
        int i = this.f3490b;
        int a2 = a(t.hashCode()) & i;
        T t3 = tArr[a2];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(a2, tArr, i);
        }
        do {
            a2 = (a2 + 1) & i;
            t2 = tArr[a2];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(a2, tArr, i);
    }

    boolean a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f3491c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int a2 = a(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= a2 && a2 > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < a2 && a2 <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    void a() {
        T[] tArr = this.f3493e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.f3491c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 != 0) {
                do {
                    length--;
                } while (tArr[length] == null);
                int a2 = a(tArr[length].hashCode()) & i2;
                if (tArr2[a2] != null) {
                    do {
                        a2 = (a2 + 1) & i2;
                    } while (tArr2[a2] != null);
                }
                tArr2[a2] = tArr[length];
                i3 = i4;
            } else {
                this.f3490b = i2;
                this.f3492d = (int) (i * this.f3489a);
                this.f3493e = tArr2;
                return;
            }
        }
    }

    public Object[] b() {
        return this.f3493e;
    }
}
