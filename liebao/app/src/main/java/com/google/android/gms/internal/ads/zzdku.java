package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdku implements zzesa<zzdkr> {
    private final zzesn<zzbhh> zzeym;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdkd> zzhbp;
    private final zzesn<Context> zzhie;
    private final zzesn<zzdmh<zzbmt, zzbmz>> zzhif;
    private final zzesn<zzdpo> zzhig;

    public zzdku(zzesn<Context> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzbhh> zzesnVar3, zzesn<zzdmh<zzbmt, zzbmz>> zzesnVar4, zzesn<zzdkd> zzesnVar5, zzesn<zzdpo> zzesnVar6) {
        this.zzhie = zzesnVar;
        this.zzfxf = zzesnVar2;
        this.zzeym = zzesnVar3;
        this.zzhif = zzesnVar4;
        this.zzhbp = zzesnVar5;
        this.zzhig = zzesnVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdkr(this.zzhie.get(), this.zzfxf.get(), this.zzeym.get(), this.zzhif.get(), this.zzhbp.get(), this.zzhig.get());
    }
}
