package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzddi implements zzesa<zzddg> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzbar> zzgbl;

    private zzddi(zzesn<zzebs> zzesnVar, zzesn<zzdpm> zzesnVar2, zzesn<zzbar> zzesnVar3) {
        this.zzeyl = zzesnVar;
        this.zzfxn = zzesnVar2;
        this.zzgbl = zzesnVar3;
    }

    public static zzddi zzz(zzesn<zzebs> zzesnVar, zzesn<zzdpm> zzesnVar2, zzesn<zzbar> zzesnVar3) {
        return new zzddi(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzddg(this.zzeyl.get(), this.zzfxn.get(), this.zzgbl.get());
    }
}
