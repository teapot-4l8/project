package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcbg implements zzesa<zzcbh> {
    private final zzesn<zzbur> zzfjr;
    private final zzesn<zzbzh> zzfnp;

    private zzcbg(zzesn<zzbur> zzesnVar, zzesn<zzbzh> zzesnVar2) {
        this.zzfjr = zzesnVar;
        this.zzfnp = zzesnVar2;
    }

    public static zzcbg zzt(zzesn<zzbur> zzesnVar, zzesn<zzbzh> zzesnVar2) {
        return new zzcbg(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcbh(this.zzfjr.get(), this.zzfnp.get());
    }
}
