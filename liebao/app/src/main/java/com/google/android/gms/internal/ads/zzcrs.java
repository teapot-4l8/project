package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcrs implements zzdtm {
    private final zzcrr zzgto;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcrs(zzcrr zzcrrVar) {
        this.zzgto = zzcrrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zza(zzdth zzdthVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zzb(zzdth zzdthVar, String str) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue() && zzdth.RENDERER == zzdthVar) {
            this.zzgto.zzff(com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zza(zzdth zzdthVar, String str, Throwable th) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue() && zzdth.RENDERER == zzdthVar && this.zzgto.zzass() != 0) {
            this.zzgto.zzep(com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - this.zzgto.zzass());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final void zzc(zzdth zzdthVar, String str) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue() && zzdth.RENDERER == zzdthVar && this.zzgto.zzass() != 0) {
            this.zzgto.zzep(com.google.android.gms.ads.internal.zzr.zzlc().elapsedRealtime() - this.zzgto.zzass());
        }
    }
}
