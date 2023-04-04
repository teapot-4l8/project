package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcub implements zzesa<zzcts> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzcja> zzgiz;
    private final zzesn<zzboa> zzgvz;
    private final zzesn<zzdxw<zzdot, com.google.android.gms.ads.internal.util.zzad>> zzgwi;

    public zzcub(zzesn<zzboa> zzesnVar, zzesn<Context> zzesnVar2, zzesn<Executor> zzesnVar3, zzesn<zzcja> zzesnVar4, zzesn<zzdpm> zzesnVar5, zzesn<zzdxw<zzdot, com.google.android.gms.ads.internal.util.zzad>> zzesnVar6) {
        this.zzgvz = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzfxf = zzesnVar3;
        this.zzgiz = zzesnVar4;
        this.zzfxn = zzesnVar5;
        this.zzgwi = zzesnVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcts(this.zzgvz.get(), this.zzeyq.get(), this.zzfxf.get(), this.zzgiz.get(), this.zzfxn.get(), this.zzgwi.get());
    }
}
