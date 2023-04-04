package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdml {
    public static zzdmh<zzbmg, zzbmp> zza(Context context, zzdqs zzdqsVar, zzdrn zzdrnVar) {
        return zzc(context, zzdqsVar, zzdrnVar);
    }

    public static zzdmh<zzbmt, zzbmz> zzb(Context context, zzdqs zzdqsVar, zzdrn zzdrnVar) {
        return zzc(context, zzdqsVar, zzdrnVar);
    }

    private static <AppOpenAdRequestComponent extends zzbsh<AppOpenAd>, AppOpenAd extends zzbpc> zzdmh<AppOpenAdRequestComponent, AppOpenAd> zzc(Context context, zzdqs zzdqsVar, zzdrn zzdrnVar) {
        if (((Integer) zzww.zzra().zzd(zzabq.zzczn)).intValue() > 0) {
            zzdrm zza = zzdrnVar.zza(zzdrf.AppOpen, context, zzdqsVar, new zzdlp(new zzdlk()));
            return new zzdll(new zzdmc(new zzdlz()), new zzdlu(zza.zzhkm, zzbat.zzeke), zza.zzhrn, zzbat.zzeke);
        }
        return new zzdlz();
    }
}
