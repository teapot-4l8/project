package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcxx extends zzcyd {
    private final zzbwx zzgza;

    public zzcxx(zzbst zzbstVar, zzbtl zzbtlVar, zzbty zzbtyVar, zzbui zzbuiVar, zzbxe zzbxeVar, zzbur zzburVar, zzcaa zzcaaVar, zzbwx zzbwxVar, zzbtb zzbtbVar) {
        super(zzbstVar, zzbtlVar, zzbtyVar, zzbuiVar, zzbxeVar, zzburVar, zzcaaVar, zzbwxVar, zzbtbVar);
        this.zzgza = zzbwxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyd, com.google.android.gms.internal.ads.zzant
    public final void onAdImpression() {
        this.zzgza.zzaly();
    }
}
