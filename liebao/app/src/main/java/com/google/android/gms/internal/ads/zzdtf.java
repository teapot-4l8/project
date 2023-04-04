package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdtf implements zzebi<O> {
    private final /* synthetic */ zzdst zzhth;
    private final /* synthetic */ zzdsy zzhti;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdtf(zzdsy zzdsyVar, zzdst zzdstVar) {
        this.zzhti = zzdsyVar;
        this.zzhth = zzdstVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void onSuccess(O o) {
        zzdte zzdteVar;
        zzdteVar = this.zzhti.zzhta.zzhsv;
        zzdteVar.zzc(this.zzhth);
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        zzdte zzdteVar;
        zzdteVar = this.zzhti.zzhta.zzhsv;
        zzdteVar.zza(this.zzhth, th);
    }
}
