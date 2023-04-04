package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzchn implements zzesa<zzchk> {
    private final zzesn<String> zzgbj;
    private final zzesn<zzcdr> zzgff;
    private final zzesn<zzcdf> zzgld;

    private zzchn(zzesn<String> zzesnVar, zzesn<zzcdf> zzesnVar2, zzesn<zzcdr> zzesnVar3) {
        this.zzgbj = zzesnVar;
        this.zzgld = zzesnVar2;
        this.zzgff = zzesnVar3;
    }

    public static zzchn zzp(zzesn<String> zzesnVar, zzesn<zzcdf> zzesnVar2, zzesn<zzcdr> zzesnVar3) {
        return new zzchn(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzchk(this.zzgbj.get(), this.zzgld.get(), this.zzgff.get());
    }
}
