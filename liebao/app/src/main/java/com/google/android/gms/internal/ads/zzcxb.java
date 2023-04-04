package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzcxb extends zzcyd {
    private zzbzv zzgyl;

    public zzcxb(zzbst zzbstVar, zzbtl zzbtlVar, zzbty zzbtyVar, zzbui zzbuiVar, zzbtb zzbtbVar, zzbxe zzbxeVar, zzcaa zzcaaVar, zzbur zzburVar, zzbzv zzbzvVar, zzbwx zzbwxVar) {
        super(zzbstVar, zzbtlVar, zzbtyVar, zzbuiVar, zzbxeVar, zzburVar, zzcaaVar, zzbwxVar, zzbtbVar);
        this.zzgyl = zzbzvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcyd, com.google.android.gms.internal.ads.zzant
    public final void zzvp() {
        this.zzgyl.zzul();
    }

    @Override // com.google.android.gms.internal.ads.zzcyd, com.google.android.gms.internal.ads.zzant
    public final void zzvq() {
        this.zzgyl.zzum();
    }

    @Override // com.google.android.gms.internal.ads.zzcyd, com.google.android.gms.internal.ads.zzant
    public final void zza(zzawa zzawaVar) {
        super.zza(zzawaVar);
        this.zzgyl.zza(new zzavy(zzawaVar.getType(), zzawaVar.getAmount()));
    }

    @Override // com.google.android.gms.internal.ads.zzcyd, com.google.android.gms.internal.ads.zzant
    public final void zzb(zzavy zzavyVar) {
        super.zzb(zzavyVar);
        this.zzgyl.zza(zzavyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcyd, com.google.android.gms.internal.ads.zzant
    public final void onVideoEnd() {
        this.zzgyl.zzum();
    }
}
