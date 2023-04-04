package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzedw extends zzecx<zzege, zzegb> {
    private final /* synthetic */ zzedu zzify;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzedw(zzedu zzeduVar, Class cls) {
        super(cls);
        this.zzify = zzeduVar;
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final /* synthetic */ zzegb zze(zzege zzegeVar) {
        zzege zzegeVar2 = zzegeVar;
        return (zzegb) ((zzena) zzegb.zzbcm().zzc(new zzedv().zzbbn().zze(zzegeVar2.zzbco())).zzc(new zzefm().zzbbn().zze(zzegeVar2.zzbcp())).zzff(0).zzbjv());
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final /* synthetic */ zzege zzr(zzelq zzelqVar) {
        return zzege.zzf(zzelqVar, zzemn.zzbiv());
    }

    @Override // com.google.android.gms.internal.ads.zzecx
    public final /* synthetic */ void zzd(zzege zzegeVar) {
        zzege zzegeVar2 = zzegeVar;
        new zzedv().zzbbn().zzd(zzegeVar2.zzbco());
        new zzefm().zzbbn().zzd(zzegeVar2.zzbcp());
        zzeku.zzgc(zzegeVar2.zzbco().getKeySize());
    }
}
