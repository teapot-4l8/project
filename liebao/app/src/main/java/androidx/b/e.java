package androidx.b;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class e<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<K, V> f1170a;

    /* renamed from: b  reason: collision with root package name */
    private int f1171b;

    /* renamed from: c  reason: collision with root package name */
    private int f1172c;

    /* renamed from: d  reason: collision with root package name */
    private int f1173d;

    /* renamed from: e  reason: collision with root package name */
    private int f1174e;
    private int f;
    private int g;
    private int h;

    protected void a(boolean z, K k, V v, V v2) {
    }

    protected int b(K k, V v) {
        return 1;
    }

    protected V b(K k) {
        return null;
    }

    public e(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f1172c = i;
        this.f1170a = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V a(K k) {
        V put;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.f1170a.get(k);
            if (v != null) {
                this.g++;
                return v;
            }
            this.h++;
            V b2 = b(k);
            if (b2 == null) {
                return null;
            }
            synchronized (this) {
                this.f1174e++;
                put = this.f1170a.put(k, b2);
                if (put != null) {
                    this.f1170a.put(k, put);
                } else {
                    this.f1171b += c(k, b2);
                }
            }
            if (put != null) {
                a(false, k, b2, put);
                return put;
            }
            a(this.f1172c);
            return b2;
        }
    }

    public final V a(K k, V v) {
        V put;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f1173d++;
            this.f1171b += c(k, v);
            put = this.f1170a.put(k, v);
            if (put != null) {
                this.f1171b -= c(k, put);
            }
        }
        if (put != null) {
            a(false, k, put, v);
        }
        a(this.f1172c);
        return put;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f1171b >= 0 && (!this.f1170a.isEmpty() || this.f1171b == 0)) {
                    if (this.f1171b <= i || this.f1170a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f1170a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f1170a.remove(key);
                    this.f1171b -= c(key, value);
                    this.f++;
                } else {
                    break;
                }
            }
            a(true, key, value, null);
        }
    }

    private int c(K k, V v) {
        int b2 = b(k, v);
        if (b2 >= 0) {
            return b2;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final synchronized String toString() {
        int i;
        i = this.g + this.h;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f1172c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i != 0 ? (this.g * 100) / i : 0));
    }
}
