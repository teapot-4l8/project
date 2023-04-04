package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbni implements zzesa<zzbng> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbzp> zzfjj;
    private final zzesn<zzbpf> zzfkj;
    private final zzesn<zzczg> zzfpi;
    private final zzesn<View> zzfub;
    private final zzesn<zzdow> zzfxb;
    private final zzesn<zzbfi> zzfxc;
    private final zzesn<zzbpd> zzfxd;
    private final zzesn<zzcdy> zzfxe;
    private final zzesn<Executor> zzfxf;

    public zzbni(zzesn<zzbpf> zzesnVar, zzesn<Context> zzesnVar2, zzesn<zzdow> zzesnVar3, zzesn<View> zzesnVar4, zzesn<zzbfi> zzesnVar5, zzesn<zzbpd> zzesnVar6, zzesn<zzcdy> zzesnVar7, zzesn<zzbzp> zzesnVar8, zzesn<zzczg> zzesnVar9, zzesn<Executor> zzesnVar10) {
        this.zzfkj = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzfxb = zzesnVar3;
        this.zzfub = zzesnVar4;
        this.zzfxc = zzesnVar5;
        this.zzfxd = zzesnVar6;
        this.zzfxe = zzesnVar7;
        this.zzfjj = zzesnVar8;
        this.zzfpi = zzesnVar9;
        this.zzfxf = zzesnVar10;
    }

    public static zzbng zza(zzbpf zzbpfVar, Context context, zzdow zzdowVar, View view, zzbfi zzbfiVar, zzbpd zzbpdVar, zzcdy zzcdyVar, zzbzp zzbzpVar, zzeru<zzczg> zzeruVar, Executor executor) {
        return new zzbng(zzbpfVar, context, zzdowVar, view, zzbfiVar, zzbpdVar, zzcdyVar, zzbzpVar, zzeruVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzfkj.get(), this.zzeyq.get(), this.zzfxb.get(), this.zzfub.get(), this.zzfxc.get(), this.zzfxd.get(), this.zzfxe.get(), this.zzfjj.get(), zzesb.zzat(this.zzfpi), this.zzfxf.get());
    }
}
