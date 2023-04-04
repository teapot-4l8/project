package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbug;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcya<AdT, AdapterT, ListenerT extends zzbug> implements zzesa<zzcxw<AdT, AdapterT, ListenerT>> {
    private final zzesn<zzcta<AdapterT, ListenerT>> zzfsx;
    private final zzesn<zzebs> zzfxf;
    private final zzesn<zzdtg> zzfxq;
    private final zzesn<zzcth<AdT, AdapterT, ListenerT>> zzgzf;

    private zzcya(zzesn<zzdtg> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<zzcta<AdapterT, ListenerT>> zzesnVar3, zzesn<zzcth<AdT, AdapterT, ListenerT>> zzesnVar4) {
        this.zzfxq = zzesnVar;
        this.zzfxf = zzesnVar2;
        this.zzfsx = zzesnVar3;
        this.zzgzf = zzesnVar4;
    }

    public static <AdT, AdapterT, ListenerT extends zzbug> zzcya<AdT, AdapterT, ListenerT> zzf(zzesn<zzdtg> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<zzcta<AdapterT, ListenerT>> zzesnVar3, zzesn<zzcth<AdT, AdapterT, ListenerT>> zzesnVar4) {
        return new zzcya<>(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcxw(this.zzfxq.get(), this.zzfxf.get(), this.zzfsx.get(), this.zzgzf.get());
    }
}
