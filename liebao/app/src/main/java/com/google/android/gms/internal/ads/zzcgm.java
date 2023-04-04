package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcgm implements zzesa<zzcgf> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzcfw> zzffs;
    private final zzesn<zzcgs> zzffv;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzei> zzgfg;
    private final zzesn<com.google.android.gms.ads.internal.zzb> zzgkt;
    private final zzesn<zztz> zzgku;

    public zzcgm(zzesn<Context> zzesnVar, zzesn<zzcfw> zzesnVar2, zzesn<zzei> zzesnVar3, zzesn<zzbar> zzesnVar4, zzesn<com.google.android.gms.ads.internal.zzb> zzesnVar5, zzesn<zztz> zzesnVar6, zzesn<Executor> zzesnVar7, zzesn<zzdpm> zzesnVar8, zzesn<zzcgs> zzesnVar9, zzesn<ScheduledExecutorService> zzesnVar10) {
        this.zzeyq = zzesnVar;
        this.zzffs = zzesnVar2;
        this.zzgfg = zzesnVar3;
        this.zzfsw = zzesnVar4;
        this.zzgkt = zzesnVar5;
        this.zzgku = zzesnVar6;
        this.zzeyl = zzesnVar7;
        this.zzfxn = zzesnVar8;
        this.zzffv = zzesnVar9;
        this.zzfty = zzesnVar10;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcgf(this.zzeyq.get(), this.zzffs.get(), this.zzgfg.get(), this.zzfsw.get(), this.zzgkt.get(), this.zzgku.get(), this.zzeyl.get(), this.zzfxn.get(), this.zzffv.get(), this.zzfty.get());
    }
}
