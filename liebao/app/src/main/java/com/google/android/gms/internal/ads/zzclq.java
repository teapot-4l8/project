package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzclq implements zzesa<zzclr> {
    private final zzesn<zzcmg> zzezo;
    private final zzesn<zzclz> zzfbz;

    private zzclq(zzesn<zzclz> zzesnVar, zzesn<zzcmg> zzesnVar2) {
        this.zzfbz = zzesnVar;
        this.zzezo = zzesnVar2;
    }

    public static zzclq zzaf(zzesn<zzclz> zzesnVar, zzesn<zzcmg> zzesnVar2) {
        return new zzclq(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzclr(this.zzfbz.get(), this.zzezo.get());
    }
}
