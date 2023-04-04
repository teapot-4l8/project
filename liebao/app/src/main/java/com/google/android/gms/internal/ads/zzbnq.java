package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbnq implements zzesa<zzbne> {
    private final zzesn<zzbng> zzfpj;
    private final zzbnl zzfxk;

    public zzbnq(zzbnl zzbnlVar, zzesn<zzbng> zzesnVar) {
        this.zzfxk = zzbnlVar;
        this.zzfpj = zzesnVar;
    }

    public static zzbne zza(zzbnl zzbnlVar, Object obj) {
        return (zzbne) zzesg.zzbd((zzbng) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzfxk, this.zzfpj.get());
    }
}
