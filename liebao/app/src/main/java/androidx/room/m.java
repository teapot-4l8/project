package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: RoomSQLiteQuery.java */
/* loaded from: classes.dex */
public class m implements androidx.e.a.d, androidx.e.a.e {
    static final TreeMap<Integer, m> g = new TreeMap<>();

    /* renamed from: a  reason: collision with root package name */
    final long[] f2474a;

    /* renamed from: b  reason: collision with root package name */
    final double[] f2475b;

    /* renamed from: c  reason: collision with root package name */
    final String[] f2476c;

    /* renamed from: d  reason: collision with root package name */
    final byte[][] f2477d;

    /* renamed from: e  reason: collision with root package name */
    final int f2478e;
    int f;
    private volatile String h;
    private final int[] i;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public static m a(String str, int i) {
        synchronized (g) {
            Map.Entry<Integer, m> ceilingEntry = g.ceilingEntry(Integer.valueOf(i));
            if (ceilingEntry != null) {
                g.remove(ceilingEntry.getKey());
                m value = ceilingEntry.getValue();
                value.b(str, i);
                return value;
            }
            m mVar = new m(i);
            mVar.b(str, i);
            return mVar;
        }
    }

    private m(int i) {
        this.f2478e = i;
        int i2 = i + 1;
        this.i = new int[i2];
        this.f2474a = new long[i2];
        this.f2475b = new double[i2];
        this.f2476c = new String[i2];
        this.f2477d = new byte[i2];
    }

    void b(String str, int i) {
        this.h = str;
        this.f = i;
    }

    public void a() {
        synchronized (g) {
            g.put(Integer.valueOf(this.f2478e), this);
            c();
        }
    }

    private static void c() {
        if (g.size() <= 15) {
            return;
        }
        int size = g.size() - 10;
        Iterator<Integer> it = g.descendingKeySet().iterator();
        while (true) {
            int i = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i;
        }
    }

    @Override // androidx.e.a.e
    public String b() {
        return this.h;
    }

    @Override // androidx.e.a.e
    public void a(androidx.e.a.d dVar) {
        for (int i = 1; i <= this.f; i++) {
            int i2 = this.i[i];
            if (i2 == 1) {
                dVar.a(i);
            } else if (i2 == 2) {
                dVar.a(i, this.f2474a[i]);
            } else if (i2 == 3) {
                dVar.a(i, this.f2475b[i]);
            } else if (i2 == 4) {
                dVar.a(i, this.f2476c[i]);
            } else if (i2 == 5) {
                dVar.a(i, this.f2477d[i]);
            }
        }
    }

    @Override // androidx.e.a.d
    public void a(int i) {
        this.i[i] = 1;
    }

    @Override // androidx.e.a.d
    public void a(int i, long j) {
        this.i[i] = 2;
        this.f2474a[i] = j;
    }

    @Override // androidx.e.a.d
    public void a(int i, double d2) {
        this.i[i] = 3;
        this.f2475b[i] = d2;
    }

    @Override // androidx.e.a.d
    public void a(int i, String str) {
        this.i[i] = 4;
        this.f2476c[i] = str;
    }

    @Override // androidx.e.a.d
    public void a(int i, byte[] bArr) {
        this.i[i] = 5;
        this.f2477d[i] = bArr;
    }
}
