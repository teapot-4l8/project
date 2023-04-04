package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzchl implements zzesa<zzchg> {
    private final zzesn<zzcdr> zzgff;
    private final zzesn<zzcdf> zzgld;

    private zzchl(zzesn<zzcdf> zzesnVar, zzesn<zzcdr> zzesnVar2) {
        this.zzgld = zzesnVar;
        this.zzgff = zzesnVar2;
    }

    public static zzchl zzv(zzesn<zzcdf> zzesnVar, zzesn<zzcdr> zzesnVar2) {
        return new zzchl(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzchg(this.zzgld.get(), this.zzgff.get());
    }
}
