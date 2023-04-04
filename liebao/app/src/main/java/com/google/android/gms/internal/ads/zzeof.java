package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeof<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void zza(zzemk zzemkVar, zzeoe<K, V> zzeoeVar, K k, V v) {
        zzemt.zza(zzemkVar, zzeoeVar.zzivn, 1, k);
        zzemt.zza(zzemkVar, zzeoeVar.zzivp, 2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int zza(zzeoe<K, V> zzeoeVar, K k, V v) {
        return zzemt.zza(zzeoeVar.zzivn, 1, k) + zzemt.zza(zzeoeVar.zzivp, 2, v);
    }
}
