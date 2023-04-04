package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzchp implements zzesa<zzchm> {
    private final zzesn<String> zzgbj;
    private final zzesn<zzcdr> zzgff;
    private final zzesn<zzcdf> zzgld;

    private zzchp(zzesn<String> zzesnVar, zzesn<zzcdf> zzesnVar2, zzesn<zzcdr> zzesnVar3) {
        this.zzgbj = zzesnVar;
        this.zzgld = zzesnVar2;
        this.zzgff = zzesnVar3;
    }

    public static zzchp zzq(zzesn<String> zzesnVar, zzesn<zzcdf> zzesnVar2, zzesn<zzcdr> zzesnVar3) {
        return new zzchp(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzchm(this.zzgbj.get(), this.zzgld.get(), this.zzgff.get());
    }
}
