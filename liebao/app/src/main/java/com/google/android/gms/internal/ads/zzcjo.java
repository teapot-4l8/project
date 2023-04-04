package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcjo implements zzesa<zzcja> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzacv> zzfft;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzbve> zzfxo;
    private final zzesn<zzei> zzgfg;
    private final zzesn<zztz> zzgku;
    private final zzesn<zzbfq> zzgly;
    private final zzesn<com.google.android.gms.ads.internal.zzb> zzgmo;

    private zzcjo(zzesn<zzbfq> zzesnVar, zzesn<Context> zzesnVar2, zzesn<zzei> zzesnVar3, zzesn<zzacv> zzesnVar4, zzesn<zzbar> zzesnVar5, zzesn<com.google.android.gms.ads.internal.zzb> zzesnVar6, zzesn<zztz> zzesnVar7, zzesn<zzbve> zzesnVar8) {
        this.zzgly = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzgfg = zzesnVar3;
        this.zzfft = zzesnVar4;
        this.zzfsw = zzesnVar5;
        this.zzgmo = zzesnVar6;
        this.zzgku = zzesnVar7;
        this.zzfxo = zzesnVar8;
    }

    public static zzcjo zza(zzesn<zzbfq> zzesnVar, zzesn<Context> zzesnVar2, zzesn<zzei> zzesnVar3, zzesn<zzacv> zzesnVar4, zzesn<zzbar> zzesnVar5, zzesn<com.google.android.gms.ads.internal.zzb> zzesnVar6, zzesn<zztz> zzesnVar7, zzesn<zzbve> zzesnVar8) {
        return new zzcjo(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5, zzesnVar6, zzesnVar7, zzesnVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcja(this.zzgly.get(), this.zzeyq.get(), this.zzgfg.get(), this.zzfft.get(), this.zzfsw.get(), this.zzgmo.get(), this.zzgku.get(), this.zzfxo.get());
    }
}
