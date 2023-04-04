package androidx.a.a.b;

import androidx.a.a.b.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FastSafeIterableMap.java */
/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* renamed from: b  reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f491b = new HashMap<>();

    @Override // androidx.a.a.b.b
    protected b.c<K, V> a(K k) {
        return this.f491b.get(k);
    }

    @Override // androidx.a.a.b.b
    public V a(K k, V v) {
        b.c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f497b;
        }
        this.f491b.put(k, b(k, v));
        return null;
    }

    @Override // androidx.a.a.b.b
    public V b(K k) {
        V v = (V) super.b(k);
        this.f491b.remove(k);
        return v;
    }

    public boolean c(K k) {
        return this.f491b.containsKey(k);
    }

    public Map.Entry<K, V> d(K k) {
        if (c(k)) {
            return this.f491b.get(k).f499d;
        }
        return null;
    }
}
