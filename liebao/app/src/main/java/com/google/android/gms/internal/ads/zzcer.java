package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcer implements zzesa<zzcen> {
    private final zzesn<com.google.android.gms.ads.internal.util.zzf> zzeck;
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcdv> zzfkp;
    private final zzesn<zzcev> zzfkq;
    private final zzesn<zzcfd> zzfkr;
    private final zzesn<zzcdm> zzfkt;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzcdr> zzgff;

    private zzcer(zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar, zzesn<zzdpm> zzesnVar2, zzesn<zzcdv> zzesnVar3, zzesn<zzcdr> zzesnVar4, zzesn<zzcev> zzesnVar5, zzesn<zzcfd> zzesnVar6, zzesn<Executor> zzesnVar7, zzesn<Executor> zzesnVar8, zzesn<zzcdm> zzesnVar9) {
        this.zzeck = zzesnVar;
        this.zzfxn = zzesnVar2;
        this.zzfkp = zzesnVar3;
        this.zzgff = zzesnVar4;
        this.zzfkq = zzesnVar5;
        this.zzfkr = zzesnVar6;
        this.zzfxf = zzesnVar7;
        this.zzeyl = zzesnVar8;
        this.zzfkt = zzesnVar9;
    }

    public static zzcer zza(zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar, zzesn<zzdpm> zzesnVar2, zzesn<zzcdv> zzesnVar3, zzesn<zzcdr> zzesnVar4, zzesn<zzcev> zzesnVar5, zzesn<zzcfd> zzesnVar6, zzesn<Executor> zzesnVar7, zzesn<Executor> zzesnVar8, zzesn<zzcdm> zzesnVar9) {
        return new zzcer(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5, zzesnVar6, zzesnVar7, zzesnVar8, zzesnVar9);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcen(this.zzeck.get(), this.zzfxn.get(), this.zzfkp.get(), this.zzgff.get(), this.zzfkq.get(), this.zzfkr.get(), this.zzfxf.get(), this.zzeyl.get(), this.zzfkt.get());
    }
}
