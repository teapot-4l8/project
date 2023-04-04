package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbjg implements zzdol {
    private final /* synthetic */ zzbie zzfhy;
    private zzesn<Context> zzfop;
    private zzesn<String> zzfoq;
    private zzesn<zzdnb> zzfre;
    private zzesn<zzdmh<zzcis, zzcip>> zzfrh;
    private zzesn<zzdph> zzfri;
    private zzesn<zzdnz> zzfrj;
    private zzesn<zzdon> zzfrk;
    private zzesn<zzdoh> zzfrl;

    private zzbjg(zzbie zzbieVar, Context context, String str) {
        zzesn zzesnVar;
        zzesn zzesnVar2;
        zzesn zzesnVar3;
        zzesn zzesnVar4;
        zzesn zzesnVar5;
        this.zzfhy = zzbieVar;
        zzesa zzbb = zzesd.zzbb(context);
        this.zzfop = zzbb;
        zzesnVar = this.zzfhy.zzfba;
        zzesnVar2 = this.zzfhy.zzfbb;
        this.zzfrh = new zzdmq(zzbb, zzesnVar, zzesnVar2);
        zzesnVar3 = this.zzfhy.zzfba;
        this.zzfre = zzesb.zzas(zzdnx.zzaq(zzesnVar3));
        this.zzfri = zzesb.zzas(zzdpk.zzawa());
        zzesn<Context> zzesnVar6 = this.zzfop;
        zzesnVar4 = this.zzfhy.zzezf;
        zzesnVar5 = this.zzfhy.zzeym;
        zzesn<zzdnz> zzas = zzesb.zzas(new zzdoi(zzesnVar6, zzesnVar4, zzesnVar5, this.zzfrh, this.zzfre, zzdpn.zzawc(), this.zzfri));
        this.zzfrj = zzas;
        this.zzfrk = zzesb.zzas(new zzdos(zzas, this.zzfre, this.zzfri));
        zzesa zzbc = zzesd.zzbc(str);
        this.zzfoq = zzbc;
        this.zzfrl = zzesb.zzas(new zzdom(zzbc, this.zzfrj, this.zzfop, this.zzfre, this.zzfri));
    }

    @Override // com.google.android.gms.internal.ads.zzdol
    public final zzdon zzaiy() {
        return this.zzfrk.get();
    }

    @Override // com.google.android.gms.internal.ads.zzdol
    public final zzdoh zzaiz() {
        return this.zzfrl.get();
    }
}
