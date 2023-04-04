package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcin implements zzaiw {
    private final zzbty zzfzc;
    private final zzavy zzgmc;
    private final String zzgmd;
    private final String zzgme;

    public zzcin(zzbty zzbtyVar, zzdot zzdotVar) {
        this.zzfzc = zzbtyVar;
        this.zzgmc = zzdotVar.zzdxw;
        this.zzgmd = zzdotVar.zzdoh;
        this.zzgme = zzdotVar.zzdoi;
    }

    @Override // com.google.android.gms.internal.ads.zzaiw
    public final void zzul() {
        this.zzfzc.onRewardedVideoStarted();
    }

    @Override // com.google.android.gms.internal.ads.zzaiw
    @ParametersAreNonnullByDefault
    public final void zza(zzavy zzavyVar) {
        String str;
        int i;
        zzavy zzavyVar2 = this.zzgmc;
        if (zzavyVar2 != null) {
            zzavyVar = zzavyVar2;
        }
        if (zzavyVar != null) {
            str = zzavyVar.type;
            i = zzavyVar.zzean;
        } else {
            str = "";
            i = 1;
        }
        this.zzfzc.zzb(new zzavb(str, i), this.zzgmd, this.zzgme);
    }

    @Override // com.google.android.gms.internal.ads.zzaiw
    public final void zzum() {
        this.zzfzc.onRewardedVideoCompleted();
    }
}
