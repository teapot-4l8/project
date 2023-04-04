package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public final class zzaby {
    public static boolean zza(zzach zzachVar, zzacf zzacfVar, String... strArr) {
        if (zzachVar == null || zzacfVar == null || !zzachVar.zzdcl || zzacfVar == null) {
            return false;
        }
        return zzachVar.zza(zzacfVar, com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime(), strArr);
    }

    public static zzacf zzb(zzach zzachVar) {
        if (zzachVar == null) {
            return null;
        }
        return zzachVar.zzex(com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime());
    }
}
