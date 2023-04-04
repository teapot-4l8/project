package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcqw implements zzesa<zzcqx> {
    private final zzesn<zzbac> zzfby;
    private final zzesn<zzdtw> zzgma;
    private final zzesn<zzdtx> zzgst;

    private zzcqw(zzesn<zzdtx> zzesnVar, zzesn<zzdtw> zzesnVar2, zzesn<zzbac> zzesnVar3) {
        this.zzgst = zzesnVar;
        this.zzgma = zzesnVar2;
        this.zzfby = zzesnVar3;
    }

    public static zzcqw zzy(zzesn<zzdtx> zzesnVar, zzesn<zzdtw> zzesnVar2, zzesn<zzbac> zzesnVar3) {
        return new zzcqw(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcqx(this.zzgst.get(), this.zzgma.get(), this.zzfby.get());
    }
}
