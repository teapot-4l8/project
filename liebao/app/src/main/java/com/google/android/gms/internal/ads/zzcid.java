package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcid implements zzebi<zzbfi> {
    private final /* synthetic */ zzdot zzglp;
    private final /* synthetic */ zzdoy zzglq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcid(zzchu zzchuVar, zzdot zzdotVar, zzdoy zzdoyVar) {
        this.zzglp = zzdotVar;
        this.zzglq = zzdoyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzbfi zzbfiVar) {
        zzbfiVar.zza(this.zzglp, this.zzglq);
    }
}
