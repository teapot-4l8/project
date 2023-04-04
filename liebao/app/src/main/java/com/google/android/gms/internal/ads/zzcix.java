package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcix implements zzesa<zzcsz<zzcip>> {
    private final zzesn<zzcxw<zzcip, zzdqd, zzcuu>> zzfvf;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzcxw<zzcip, zzdqd, zzcuv>> zzgmg;

    public zzcix(zzesn<zzcxw<zzcip, zzdqd, zzcuu>> zzesnVar, zzesn<zzcxw<zzcip, zzdqd, zzcuv>> zzesnVar2, zzesn<zzdpm> zzesnVar3) {
        this.zzfvf = zzesnVar;
        this.zzgmg = zzesnVar2;
        this.zzfxn = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        zzcxw<zzcip, zzdqd, zzcuu> zzcxwVar;
        zzesn<zzcxw<zzcip, zzdqd, zzcuu>> zzesnVar = this.zzfvf;
        zzesn<zzcxw<zzcip, zzdqd, zzcuv>> zzesnVar2 = this.zzgmg;
        if (zzciu.zzgmf[this.zzfxn.get().zzhof.zzhnj - 1] == 1) {
            zzcxwVar = zzesnVar.get();
        } else {
            zzcxwVar = zzesnVar2.get();
        }
        return (zzcsz) zzesg.zzbd(zzcxwVar);
    }
}
