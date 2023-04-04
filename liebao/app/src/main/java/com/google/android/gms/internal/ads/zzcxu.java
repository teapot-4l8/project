package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcxu extends zzcxb {
    private final zzbwx zzgza;

    public zzcxu(zzbst zzbstVar, zzbtl zzbtlVar, zzbty zzbtyVar, zzbui zzbuiVar, zzbtb zzbtbVar, zzbxe zzbxeVar, zzcaa zzcaaVar, zzbur zzburVar, zzbzv zzbzvVar, zzbwx zzbwxVar) {
        super(zzbstVar, zzbtlVar, zzbtyVar, zzbuiVar, zzbtbVar, zzbxeVar, zzcaaVar, zzburVar, zzbzvVar, zzbwxVar);
        this.zzgza = zzbwxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyd, com.google.android.gms.internal.ads.zzant
    public final void onAdImpression() {
        this.zzgza.zzaly();
    }
}
