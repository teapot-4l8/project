package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbjs implements zzesa<zzbjr> {
    private final zzesn<zzayd> zzecg;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzckb> zzezj;
    private final zzesn<zzcna> zzezu;
    private final zzesn<zzckd> zzezw;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzcta<zzdqd, zzcuu>> zzfsx;
    private final zzesn<zzczb> zzfsy;

    public zzbjs(zzesn<Context> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<zzckb> zzesnVar3, zzesn<zzcta<zzdqd, zzcuu>> zzesnVar4, zzesn<zzczb> zzesnVar5, zzesn<zzcna> zzesnVar6, zzesn<zzayd> zzesnVar7, zzesn<zzckd> zzesnVar8) {
        this.zzeyq = zzesnVar;
        this.zzfsw = zzesnVar2;
        this.zzezj = zzesnVar3;
        this.zzfsx = zzesnVar4;
        this.zzfsy = zzesnVar5;
        this.zzezu = zzesnVar6;
        this.zzecg = zzesnVar7;
        this.zzezw = zzesnVar8;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbjr(this.zzeyq.get(), this.zzfsw.get(), this.zzezj.get(), this.zzfsx.get(), this.zzfsy.get(), this.zzezu.get(), this.zzecg.get(), this.zzezw.get());
    }
}
