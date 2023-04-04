package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
abstract class zzerx<K, V, V2> implements zzesa<Map<K, V2>> {
    private final Map<K, zzesn<V>> zzjez;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzerx(Map<K, zzesn<V>> map) {
        this.zzjez = Collections.unmodifiableMap(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<K, zzesn<V>> zzbnl() {
        return this.zzjez;
    }
}
