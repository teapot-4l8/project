package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcii implements zzesa<zzcih> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdup> zzfab;
    private final zzesn<zzcmb> zzfac;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzbar> zzgbl;
    private final zzesn<zzei> zzgfg;
    private final zzesn<com.google.android.gms.ads.internal.zzb> zzgkt;
    private final zzesn<zzbfq> zzgly;
    private final zzesn<zzcsh> zzglz;
    private final zzesn<zzdtw> zzgma;

    public zzcii(zzesn<Context> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzei> zzesnVar3, zzesn<zzbar> zzesnVar4, zzesn<com.google.android.gms.ads.internal.zzb> zzesnVar5, zzesn<zzbfq> zzesnVar6, zzesn<zzcsh> zzesnVar7, zzesn<zzdup> zzesnVar8, zzesn<zzcmb> zzesnVar9, zzesn<zzdtw> zzesnVar10) {
        this.zzeyq = zzesnVar;
        this.zzfxf = zzesnVar2;
        this.zzgfg = zzesnVar3;
        this.zzgbl = zzesnVar4;
        this.zzgkt = zzesnVar5;
        this.zzgly = zzesnVar6;
        this.zzglz = zzesnVar7;
        this.zzfab = zzesnVar8;
        this.zzfac = zzesnVar9;
        this.zzgma = zzesnVar10;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcih(this.zzeyq.get(), this.zzfxf.get(), this.zzgfg.get(), this.zzgbl.get(), this.zzgkt.get(), this.zzgly.get(), this.zzglz.get(), this.zzfab.get(), this.zzfac.get(), this.zzgma.get());
    }
}
