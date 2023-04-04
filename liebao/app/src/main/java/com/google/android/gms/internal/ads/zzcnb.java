package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcnb implements zzesa<zzcmy> {
    private final zzesn<zzbhh> zzeym;
    private final zzesn<zzcmm> zzgma;

    private zzcnb(zzesn<zzcmm> zzesnVar, zzesn<zzbhh> zzesnVar2) {
        this.zzgma = zzesnVar;
        this.zzeym = zzesnVar2;
    }

    public static zzcnb zzah(zzesn<zzcmm> zzesnVar, zzesn<zzbhh> zzesnVar2) {
        return new zzcnb(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcmy(this.zzgma.get(), this.zzeym.get());
    }
}
