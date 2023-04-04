package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzesc<K, V> extends zzerx<K, V, V> {
    private static final zzesn<Map<Object, Object>> zzjfd = zzesd.zzbb(Collections.emptyMap());

    public static <K, V> zzese<K, V> zzip(int i) {
        return new zzese<>(i);
    }

    private zzesc(Map<K, zzesn<V>> map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        LinkedHashMap zzin = zzerz.zzin(zzbnl().size());
        for (Map.Entry<K, zzesn<V>> entry : zzbnl().entrySet()) {
            zzin.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(zzin);
    }
}
