package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcpm implements zzebi<zzdpi> {
    private final /* synthetic */ zzcpk zzgrs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcpm(zzcpk zzcpkVar) {
        this.zzgrs = zzcpkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzdpi zzdpiVar) {
        zzbvh zzbvhVar;
        zzbvhVar = this.zzgrs.zzgrr;
        zzbvhVar.zzd(zzdpiVar);
    }
}
