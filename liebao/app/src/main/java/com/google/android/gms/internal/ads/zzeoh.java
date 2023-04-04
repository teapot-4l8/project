package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeoh<K, V> extends LinkedHashMap<K, V> {
    private static final zzeoh zzivq;
    private boolean zzior;

    private zzeoh() {
        this.zzior = true;
    }

    private zzeoh(Map<K, V> map) {
        super(map);
        this.zzior = true;
    }

    public static <K, V> zzeoh<K, V> zzbkr() {
        return zzivq;
    }

    public final void zza(zzeoh<K, V> zzeohVar) {
        zzbkt();
        if (zzeohVar.isEmpty()) {
            return;
        }
        putAll(zzeohVar);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzbkt();
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        zzbkt();
        zzenc.checkNotNull(k);
        zzenc.checkNotNull(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzbkt();
        for (K k : map.keySet()) {
            zzenc.checkNotNull(k);
            zzenc.checkNotNull(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzbkt();
        return (V) super.remove(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[RETURN] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        boolean z;
        boolean equals;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    for (Map.Entry<K, V> entry : entrySet()) {
                        if (map.containsKey(entry.getKey())) {
                            V value = entry.getValue();
                            Object obj2 = map.get(entry.getKey());
                            if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                                equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                                continue;
                            } else {
                                equals = value.equals(obj2);
                                continue;
                            }
                            if (!equals) {
                            }
                        }
                    }
                }
                z = false;
                if (!z) {
                    return true;
                }
            }
            z = true;
            if (!z) {
            }
        }
        return false;
    }

    private static int zzat(Object obj) {
        if (obj instanceof byte[]) {
            return zzenc.hashCode((byte[]) obj);
        }
        if (obj instanceof zzenf) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i += zzat(entry.getValue()) ^ zzat(entry.getKey());
        }
        return i;
    }

    public final zzeoh<K, V> zzbks() {
        return isEmpty() ? new zzeoh<>() : new zzeoh<>(this);
    }

    public final void zzbhe() {
        this.zzior = false;
    }

    public final boolean isMutable() {
        return this.zzior;
    }

    private final void zzbkt() {
        if (!this.zzior) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        zzeoh zzeohVar = new zzeoh();
        zzivq = zzeohVar;
        zzeohVar.zzior = false;
    }
}
