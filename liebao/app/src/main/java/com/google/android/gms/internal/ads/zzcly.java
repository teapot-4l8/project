package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcly implements zzesa<zzclz> {
    private final zzesn<zzcmg> zzezo;
    private final zzesn<zzbac> zzfby;

    private zzcly(zzesn<zzcmg> zzesnVar, zzesn<zzbac> zzesnVar2) {
        this.zzezo = zzesnVar;
        this.zzfby = zzesnVar2;
    }

    public static zzcly zzag(zzesn<zzcmg> zzesnVar, zzesn<zzbac> zzesnVar2) {
        return new zzcly(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzclz(this.zzezo.get(), this.zzfby.get());
    }
}
