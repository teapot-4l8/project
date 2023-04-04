package b.b.e.f;

import b.b.e.c.d;
import b.b.e.h.g;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscLinkedArrayQueue.java */
/* loaded from: classes.dex */
public final class a<T> implements d<T> {

    /* renamed from: a  reason: collision with root package name */
    static final int f3402a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    private static final Object j = new Object();

    /* renamed from: c  reason: collision with root package name */
    int f3404c;

    /* renamed from: d  reason: collision with root package name */
    long f3405d;

    /* renamed from: e  reason: collision with root package name */
    final int f3406e;
    AtomicReferenceArray<Object> f;
    final int g;
    AtomicReferenceArray<Object> h;

    /* renamed from: b  reason: collision with root package name */
    final AtomicLong f3403b = new AtomicLong();
    final AtomicLong i = new AtomicLong();

    private static int b(int i) {
        return i;
    }

    public a(int i) {
        int a2 = g.a(Math.max(8, i));
        int i2 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.f = atomicReferenceArray;
        this.f3406e = i2;
        a(a2);
        this.h = atomicReferenceArray;
        this.g = i2;
        this.f3405d = i2 - 1;
        a(0L);
    }

    @Override // b.b.e.c.e
    public boolean a(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.f;
        long f = f();
        int i = this.f3406e;
        int a2 = a(f, i);
        if (f < this.f3405d) {
            return a(atomicReferenceArray, t, f, a2);
        }
        long j2 = this.f3404c + f;
        if (b(atomicReferenceArray, a(j2, i)) == null) {
            this.f3405d = j2 - 1;
            return a(atomicReferenceArray, t, f, a2);
        } else if (b(atomicReferenceArray, a(1 + f, i)) == null) {
            return a(atomicReferenceArray, t, f, a2);
        } else {
            a(atomicReferenceArray, f, a2, t, i);
            return true;
        }
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i) {
        a(atomicReferenceArray, i, t);
        a(j2 + 1);
        return true;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f = atomicReferenceArray2;
        this.f3405d = (j3 + j2) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, j);
        a(j2 + 1);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        int b2 = b(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) b(atomicReferenceArray, b2);
        a(atomicReferenceArray, b2, (Object) null);
        return atomicReferenceArray2;
    }

    @Override // b.b.e.c.e
    public T m_() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.h;
        long g = g();
        int i = this.g;
        int a2 = a(g, i);
        T t = (T) b(atomicReferenceArray, a2);
        boolean z = t == j;
        if (t == null || z) {
            if (z) {
                return a(a(atomicReferenceArray, i + 1), g, i);
            }
            return null;
        }
        a(atomicReferenceArray, a2, (Object) null);
        b(g + 1);
        return t;
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i) {
        this.h = atomicReferenceArray;
        int a2 = a(j2, i);
        T t = (T) b(atomicReferenceArray, a2);
        if (t != null) {
            a(atomicReferenceArray, a2, (Object) null);
            b(j2 + 1);
        }
        return t;
    }

    @Override // b.b.e.c.e
    public void d() {
        while (true) {
            if (m_() == null && c()) {
                return;
            }
        }
    }

    @Override // b.b.e.c.e
    public boolean c() {
        return a() == e();
    }

    private void a(int i) {
        this.f3404c = Math.min(i / 4, f3402a);
    }

    private long a() {
        return this.f3403b.get();
    }

    private long e() {
        return this.i.get();
    }

    private long f() {
        return this.f3403b.get();
    }

    private long g() {
        return this.i.get();
    }

    private void a(long j2) {
        this.f3403b.lazySet(j2);
    }

    private void b(long j2) {
        this.i.lazySet(j2);
    }

    private static int a(long j2, int i) {
        return b(((int) j2) & i);
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }
}
