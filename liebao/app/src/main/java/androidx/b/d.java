package androidx.b;

/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1165a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1166b;

    /* renamed from: c  reason: collision with root package name */
    private long[] f1167c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f1168d;

    /* renamed from: e  reason: collision with root package name */
    private int f1169e;

    public d() {
        this(10);
    }

    public d(int i) {
        this.f1166b = false;
        if (i == 0) {
            this.f1167c = c.f1163b;
            this.f1168d = c.f1164c;
            return;
        }
        int b2 = c.b(i);
        this.f1167c = new long[b2];
        this.f1168d = new Object[b2];
    }

    /* renamed from: a */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f1167c = (long[]) this.f1167c.clone();
            dVar.f1168d = (Object[]) this.f1168d.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E a(long j) {
        return a(j, null);
    }

    public E a(long j, E e2) {
        int a2 = c.a(this.f1167c, this.f1169e, j);
        if (a2 >= 0) {
            Object[] objArr = this.f1168d;
            if (objArr[a2] != f1165a) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public void b(long j) {
        int a2 = c.a(this.f1167c, this.f1169e, j);
        if (a2 >= 0) {
            Object[] objArr = this.f1168d;
            Object obj = objArr[a2];
            Object obj2 = f1165a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f1166b = true;
            }
        }
    }

    public void a(int i) {
        Object[] objArr = this.f1168d;
        Object obj = objArr[i];
        Object obj2 = f1165a;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f1166b = true;
        }
    }

    private void e() {
        int i = this.f1169e;
        long[] jArr = this.f1167c;
        Object[] objArr = this.f1168d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1165a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1166b = false;
        this.f1169e = i2;
    }

    public void b(long j, E e2) {
        int a2 = c.a(this.f1167c, this.f1169e, j);
        if (a2 >= 0) {
            this.f1168d[a2] = e2;
            return;
        }
        int i = a2 ^ (-1);
        if (i < this.f1169e) {
            Object[] objArr = this.f1168d;
            if (objArr[i] == f1165a) {
                this.f1167c[i] = j;
                objArr[i] = e2;
                return;
            }
        }
        if (this.f1166b && this.f1169e >= this.f1167c.length) {
            e();
            i = c.a(this.f1167c, this.f1169e, j) ^ (-1);
        }
        int i2 = this.f1169e;
        if (i2 >= this.f1167c.length) {
            int b2 = c.b(i2 + 1);
            long[] jArr = new long[b2];
            Object[] objArr2 = new Object[b2];
            long[] jArr2 = this.f1167c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1168d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1167c = jArr;
            this.f1168d = objArr2;
        }
        int i3 = this.f1169e;
        if (i3 - i != 0) {
            long[] jArr3 = this.f1167c;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.f1168d;
            System.arraycopy(objArr4, i, objArr4, i4, this.f1169e - i);
        }
        this.f1167c[i] = j;
        this.f1168d[i] = e2;
        this.f1169e++;
    }

    public int b() {
        if (this.f1166b) {
            e();
        }
        return this.f1169e;
    }

    public boolean c() {
        return b() == 0;
    }

    public long b(int i) {
        if (this.f1166b) {
            e();
        }
        return this.f1167c[i];
    }

    public E c(int i) {
        if (this.f1166b) {
            e();
        }
        return (E) this.f1168d[i];
    }

    public int c(long j) {
        if (this.f1166b) {
            e();
        }
        return c.a(this.f1167c, this.f1169e, j);
    }

    public boolean d(long j) {
        return c(j) >= 0;
    }

    public void d() {
        int i = this.f1169e;
        Object[] objArr = this.f1168d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1169e = 0;
        this.f1166b = false;
    }

    public void c(long j, E e2) {
        int i = this.f1169e;
        if (i != 0 && j <= this.f1167c[i - 1]) {
            b(j, e2);
            return;
        }
        if (this.f1166b && this.f1169e >= this.f1167c.length) {
            e();
        }
        int i2 = this.f1169e;
        if (i2 >= this.f1167c.length) {
            int b2 = c.b(i2 + 1);
            long[] jArr = new long[b2];
            Object[] objArr = new Object[b2];
            long[] jArr2 = this.f1167c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f1168d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1167c = jArr;
            this.f1168d = objArr;
        }
        this.f1167c[i2] = j;
        this.f1168d[i2] = e2;
        this.f1169e = i2 + 1;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1169e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1169e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(b(i));
            sb.append('=');
            E c2 = c(i);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
