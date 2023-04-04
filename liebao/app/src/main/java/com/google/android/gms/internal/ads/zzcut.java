package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcut implements zzebi<zzbne> {
    private final /* synthetic */ zzcuo zzgwz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcut(zzcuo zzcuoVar) {
        this.zzgwz = zzcuoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        zzboa zzboaVar;
        zzbsx zzbsxVar;
        zzboaVar = this.zzgwz.zzgwu;
        zzvh zze = zzboaVar.zzahd().zze(th);
        zzbsxVar = this.zzgwz.zzgcz;
        zzbsxVar.zzd(zze);
        zzdqa.zza(zze.errorCode, th, "DelayedBannerAd.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzbne zzbneVar) {
        zzbneVar.zzakv();
    }
}
