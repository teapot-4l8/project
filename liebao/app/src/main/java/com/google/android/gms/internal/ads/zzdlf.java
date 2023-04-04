package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdlf implements zzesa<zzdlc> {
    private final zzesn<zzbhh> zzeym;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzczm> zzhbp;
    private final zzesn<Context> zzhie;
    private final zzesn<zzdpo> zzhig;
    private final zzesn<zzvt> zzhjo;
    private final zzesn<zzdaj> zzhjp;

    public zzdlf(zzesn<Context> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzvt> zzesnVar3, zzesn<zzbhh> zzesnVar4, zzesn<zzczm> zzesnVar5, zzesn<zzdaj> zzesnVar6, zzesn<zzdpo> zzesnVar7) {
        this.zzhie = zzesnVar;
        this.zzfxf = zzesnVar2;
        this.zzhjo = zzesnVar3;
        this.zzeym = zzesnVar4;
        this.zzhbp = zzesnVar5;
        this.zzhjp = zzesnVar6;
        this.zzhig = zzesnVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdlc(this.zzhie.get(), this.zzfxf.get(), this.zzhjo.get(), this.zzeym.get(), this.zzhbp.get(), this.zzhjp.get(), this.zzhig.get());
    }
}
