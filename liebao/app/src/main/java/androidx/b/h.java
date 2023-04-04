package androidx.b;

/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public class h<E> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1194a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1195b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f1196c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f1197d;

    /* renamed from: e  reason: collision with root package name */
    private int f1198e;

    public h() {
        this(10);
    }

    public h(int i) {
        this.f1195b = false;
        if (i == 0) {
            this.f1196c = c.f1162a;
            this.f1197d = c.f1164c;
            return;
        }
        int a2 = c.a(i);
        this.f1196c = new int[a2];
        this.f1197d = new Object[a2];
    }

    /* renamed from: a */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f1196c = (int[]) this.f1196c.clone();
            hVar.f1197d = (Object[]) this.f1197d.clone();
            return hVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E a(int i) {
        return a(i, null);
    }

    public E a(int i, E e2) {
        int a2 = c.a(this.f1196c, this.f1198e, i);
        if (a2 >= 0) {
            Object[] objArr = this.f1197d;
            if (objArr[a2] != f1194a) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public void b(int i) {
        int a2 = c.a(this.f1196c, this.f1198e, i);
        if (a2 >= 0) {
            Object[] objArr = this.f1197d;
            Object obj = objArr[a2];
            Object obj2 = f1194a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f1195b = true;
            }
        }
    }

    private void d() {
        int i = this.f1198e;
        int[] iArr = this.f1196c;
        Object[] objArr = this.f1197d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1194a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1195b = false;
        this.f1198e = i2;
    }

    public void b(int i, E e2) {
        int a2 = c.a(this.f1196c, this.f1198e, i);
        if (a2 >= 0) {
            this.f1197d[a2] = e2;
            return;
        }
        int i2 = a2 ^ (-1);
        if (i2 < this.f1198e) {
            Object[] objArr = this.f1197d;
            if (objArr[i2] == f1194a) {
                this.f1196c[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f1195b && this.f1198e >= this.f1196c.length) {
            d();
            i2 = c.a(this.f1196c, this.f1198e, i) ^ (-1);
        }
        int i3 = this.f1198e;
        if (i3 >= this.f1196c.length) {
            int a3 = c.a(i3 + 1);
            int[] iArr = new int[a3];
            Object[] objArr2 = new Object[a3];
            int[] iArr2 = this.f1196c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1197d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1196c = iArr;
            this.f1197d = objArr2;
        }
        int i4 = this.f1198e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f1196c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.f1197d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f1198e - i2);
        }
        this.f1196c[i2] = i;
        this.f1197d[i2] = e2;
        this.f1198e++;
    }

    public int b() {
        if (this.f1195b) {
            d();
        }
        return this.f1198e;
    }

    public int c(int i) {
        if (this.f1195b) {
            d();
        }
        return this.f1196c[i];
    }

    public E d(int i) {
        if (this.f1195b) {
            d();
        }
        return (E) this.f1197d[i];
    }

    public int e(int i) {
        if (this.f1195b) {
            d();
        }
        return c.a(this.f1196c, this.f1198e, i);
    }

    public int a(E e2) {
        if (this.f1195b) {
            d();
        }
        for (int i = 0; i < this.f1198e; i++) {
            if (this.f1197d[i] == e2) {
                return i;
            }
        }
        return -1;
    }

    public void c() {
        int i = this.f1198e;
        Object[] objArr = this.f1197d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1198e = 0;
        this.f1195b = false;
    }

    public void c(int i, E e2) {
        int i2 = this.f1198e;
        if (i2 != 0 && i <= this.f1196c[i2 - 1]) {
            b(i, e2);
            return;
        }
        if (this.f1195b && this.f1198e >= this.f1196c.length) {
            d();
        }
        int i3 = this.f1198e;
        if (i3 >= this.f1196c.length) {
            int a2 = c.a(i3 + 1);
            int[] iArr = new int[a2];
            Object[] objArr = new Object[a2];
            int[] iArr2 = this.f1196c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f1197d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1196c = iArr;
            this.f1197d = objArr;
        }
        this.f1196c[i3] = i;
        this.f1197d[i3] = e2;
        this.f1198e = i3 + 1;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1198e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1198e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(c(i));
            sb.append('=');
            E d2 = d(i);
            if (d2 != this) {
                sb.append(d2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
