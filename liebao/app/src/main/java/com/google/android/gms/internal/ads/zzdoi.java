package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdoi implements zzesa<zzdnz> {
    private final zzesn<zzbhh> zzeym;
    private final zzesn<zzdph> zzfri;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdnb> zzhbp;
    private final zzesn<Context> zzhie;
    private final zzesn<zzdmh<zzcis, zzcip>> zzhif;
    private final zzesn<zzdpo> zzhig;

    public zzdoi(zzesn<Context> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzbhh> zzesnVar3, zzesn<zzdmh<zzcis, zzcip>> zzesnVar4, zzesn<zzdnb> zzesnVar5, zzesn<zzdpo> zzesnVar6, zzesn<zzdph> zzesnVar7) {
        this.zzhie = zzesnVar;
        this.zzfxf = zzesnVar2;
        this.zzeym = zzesnVar3;
        this.zzhif = zzesnVar4;
        this.zzhbp = zzesnVar5;
        this.zzhig = zzesnVar6;
        this.zzfri = zzesnVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdnz(this.zzhie.get(), this.zzfxf.get(), this.zzeym.get(), this.zzhif.get(), this.zzhbp.get(), this.zzhig.get(), this.zzfri.get());
    }
}
