package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbss implements zzesa<zzbsp> {
    private final zzesn<zzctc> zzfcq;
    private final zzesn<zzdot> zzfxz;
    private final zzesn<String> zzgbj;

    private zzbss(zzesn<zzdot> zzesnVar, zzesn<String> zzesnVar2, zzesn<zzctc> zzesnVar3) {
        this.zzfxz = zzesnVar;
        this.zzgbj = zzesnVar2;
        this.zzfcq = zzesnVar3;
    }

    public static zzbss zzm(zzesn<zzdot> zzesnVar, zzesn<String> zzesnVar2, zzesn<zzctc> zzesnVar3) {
        return new zzbss(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbsp(this.zzfxz.get(), this.zzgbj.get(), this.zzfcq.get());
    }
}
