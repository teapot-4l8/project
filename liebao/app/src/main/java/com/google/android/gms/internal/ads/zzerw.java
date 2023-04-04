package com.google.android.gms.internal.ads;

import com.umeng.analytics.pro.d;
import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzerw<K, V, V2> {
    final LinkedHashMap<K, zzesn<V>> zzjey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzerw(int i) {
        this.zzjey = zzerz.zzin(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public zzerw<K, V, V2> zza(K k, zzesn<V> zzesnVar) {
        this.zzjey.put(zzesg.zza(k, "key"), zzesg.zza(zzesnVar, d.M));
        return this;
    }
}
