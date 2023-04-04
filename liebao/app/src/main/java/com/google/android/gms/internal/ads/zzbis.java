package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbis implements zzdjv {
    private final /* synthetic */ zzbie zzfhy;
    private zzesn<Context> zzfop;
    private zzesn<String> zzfoq;
    private zzesn<zzdmh<zzbmg, zzbmp>> zzfor;
    private zzesn<zzdkd> zzfos;
    private zzesn<zzdjn> zzfot;
    private zzesn<zzdjp> zzfou;
    private zzesn<zzdmh<zzbmt, zzbmz>> zzfov;
    private zzesn<zzdkr> zzfow;
    private zzesn<zzdkt> zzfox;

    private zzbis(zzbie zzbieVar, Context context, String str) {
        zzesn zzesnVar;
        zzesn zzesnVar2;
        zzesn zzesnVar3;
        zzesn zzesnVar4;
        zzesn zzesnVar5;
        zzesn zzesnVar6;
        zzesn zzesnVar7;
        zzesn zzesnVar8;
        zzesn zzesnVar9;
        zzesn zzesnVar10;
        zzesn zzesnVar11;
        zzesn zzesnVar12;
        this.zzfhy = zzbieVar;
        this.zzfop = zzesd.zzbb(context);
        this.zzfoq = zzesd.zzbb(str);
        zzesn<Context> zzesnVar13 = this.zzfop;
        zzesnVar = this.zzfhy.zzfba;
        zzesnVar2 = this.zzfhy.zzfbb;
        this.zzfor = new zzdmn(zzesnVar13, zzesnVar, zzesnVar2);
        zzesnVar3 = this.zzfhy.zzfba;
        this.zzfos = zzesb.zzas(new zzdks(zzesnVar3));
        zzesn<Context> zzesnVar14 = this.zzfop;
        zzesnVar4 = this.zzfhy.zzezf;
        zzesnVar5 = this.zzfhy.zzeym;
        this.zzfot = zzesb.zzas(new zzdjq(zzesnVar14, zzesnVar4, zzesnVar5, this.zzfor, this.zzfos, zzdpn.zzawc()));
        zzesnVar6 = this.zzfhy.zzeym;
        zzesn<Context> zzesnVar15 = this.zzfop;
        zzesn<String> zzesnVar16 = this.zzfoq;
        zzesn<zzdjn> zzesnVar17 = this.zzfot;
        zzesn<zzdkd> zzesnVar18 = this.zzfos;
        zzesnVar7 = this.zzfhy.zzeyy;
        this.zzfou = zzesb.zzas(new zzdjw(zzesnVar6, zzesnVar15, zzesnVar16, zzesnVar17, zzesnVar18, zzesnVar7));
        zzesn<Context> zzesnVar19 = this.zzfop;
        zzesnVar8 = this.zzfhy.zzfba;
        zzesnVar9 = this.zzfhy.zzfbb;
        this.zzfov = new zzdmo(zzesnVar19, zzesnVar8, zzesnVar9);
        zzesn<Context> zzesnVar20 = this.zzfop;
        zzesnVar10 = this.zzfhy.zzezf;
        zzesnVar11 = this.zzfhy.zzeym;
        this.zzfow = zzesb.zzas(new zzdku(zzesnVar20, zzesnVar10, zzesnVar11, this.zzfov, this.zzfos, zzdpn.zzawc()));
        zzesnVar12 = this.zzfhy.zzeym;
        this.zzfox = zzesb.zzas(new zzdkz(zzesnVar12, this.zzfop, this.zzfoq, this.zzfow, this.zzfos));
    }

    @Override // com.google.android.gms.internal.ads.zzdjv
    public final zzdjp zzaif() {
        return this.zzfou.get();
    }

    @Override // com.google.android.gms.internal.ads.zzdjv
    public final zzdkt zzaig() {
        return this.zzfox.get();
    }
}
