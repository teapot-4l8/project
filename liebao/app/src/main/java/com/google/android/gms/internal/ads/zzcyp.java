package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcyp<AdT> implements zzesa<zzcyl<AdT>> {
    private final zzesn<zzebs> zzfxf;
    private final zzesn<zzdtg> zzfxq;
    private final zzesn<zzacm> zzgzr;
    private final zzesn<zzcym<AdT>> zzgzy;

    public zzcyp(zzesn<zzdtg> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<zzacm> zzesnVar3, zzesn<zzcym<AdT>> zzesnVar4) {
        this.zzfxq = zzesnVar;
        this.zzfxf = zzesnVar2;
        this.zzgzr = zzesnVar3;
        this.zzgzy = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcyl(this.zzfxq.get(), this.zzfxf.get(), this.zzgzr.get(), this.zzgzy.get());
    }
}
