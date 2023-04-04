package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcfp implements zzesa<zzcfm> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbst> zzfiv;
    private final zzesn<zzbtl> zzfjf;
    private final zzesn<zzaoh> zzfkm;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzdot> zzfxz;
    private final zzesn<zzaob> zzgjq;
    private final zzesn<zzaoc> zzgjr;

    public zzcfp(zzesn<zzaob> zzesnVar, zzesn<zzaoc> zzesnVar2, zzesn<zzaoh> zzesnVar3, zzesn<zzbtl> zzesnVar4, zzesn<zzbst> zzesnVar5, zzesn<Context> zzesnVar6, zzesn<zzdot> zzesnVar7, zzesn<zzbar> zzesnVar8, zzesn<zzdpm> zzesnVar9) {
        this.zzgjq = zzesnVar;
        this.zzgjr = zzesnVar2;
        this.zzfkm = zzesnVar3;
        this.zzfjf = zzesnVar4;
        this.zzfiv = zzesnVar5;
        this.zzeyq = zzesnVar6;
        this.zzfxz = zzesnVar7;
        this.zzfsw = zzesnVar8;
        this.zzfxn = zzesnVar9;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcfm(this.zzgjq.get(), this.zzgjr.get(), this.zzfkm.get(), this.zzfjf.get(), this.zzfiv.get(), this.zzeyq.get(), this.zzfxz.get(), this.zzfsw.get(), this.zzfxn.get());
    }
}
