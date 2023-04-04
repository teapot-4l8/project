package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdna implements zzesa<zzdmr> {
    private final zzesn<zzbhh> zzeym;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzczm> zzhbp;
    private final zzesn<Context> zzhie;
    private final zzesn<zzdpo> zzhig;
    private final zzesn<zzdnb> zzhla;

    public zzdna(zzesn<Context> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzbhh> zzesnVar3, zzesn<zzczm> zzesnVar4, zzesn<zzdnb> zzesnVar5, zzesn<zzdpo> zzesnVar6) {
        this.zzhie = zzesnVar;
        this.zzfxf = zzesnVar2;
        this.zzeym = zzesnVar3;
        this.zzhbp = zzesnVar4;
        this.zzhla = zzesnVar5;
        this.zzhig = zzesnVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdmr(this.zzhie.get(), this.zzfxf.get(), this.zzeym.get(), this.zzhbp.get(), this.zzhla.get(), this.zzhig.get());
    }
}
