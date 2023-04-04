package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzciz implements zzesa<zzuh.zza.EnumC0120zza> {
    private final zzesn<zzdpm> zzfxn;

    public zzciz(zzesn<zzdpm> zzesnVar) {
        this.zzfxn = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        zzuh.zza.EnumC0120zza enumC0120zza;
        if (this.zzfxn.get().zzhof.zzhnj == zzdpe.zzhnn) {
            enumC0120zza = zzuh.zza.EnumC0120zza.REWARDED_INTERSTITIAL;
        } else {
            enumC0120zza = zzuh.zza.EnumC0120zza.REWARD_BASED_VIDEO_AD;
        }
        return (zzuh.zza.EnumC0120zza) zzesg.zzbd(enumC0120zza);
    }
}
