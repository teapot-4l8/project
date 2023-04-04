package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbje implements zzdmz {
    private final /* synthetic */ zzbie zzfhy;
    private zzesn<Context> zzfop;
    private zzesn<String> zzfoq;
    private zzesn<zzvt> zzfqm;
    private zzesn<zzczm> zzfqn;
    private zzesn<zzdnb> zzfre;
    private zzesn<zzdmr> zzfrf;
    private zzesn<zzdak> zzfrg;

    private zzbje(zzbie zzbieVar, Context context, String str, zzvt zzvtVar) {
        zzesn zzesnVar;
        zzesn zzesnVar2;
        zzesn zzesnVar3;
        zzesn zzesnVar4;
        this.zzfhy = zzbieVar;
        this.zzfop = zzesd.zzbb(context);
        this.zzfqm = zzesd.zzbb(zzvtVar);
        this.zzfoq = zzesd.zzbb(str);
        zzesnVar = this.zzfhy.zzeze;
        this.zzfqn = zzesb.zzas(zzdae.zzaj(zzesnVar));
        zzesnVar2 = this.zzfhy.zzfba;
        this.zzfre = zzesb.zzas(zzdnx.zzaq(zzesnVar2));
        zzesn<Context> zzesnVar5 = this.zzfop;
        zzesnVar3 = this.zzfhy.zzezf;
        zzesnVar4 = this.zzfhy.zzeym;
        zzesn<zzdmr> zzas = zzesb.zzas(new zzdna(zzesnVar5, zzesnVar3, zzesnVar4, this.zzfqn, this.zzfre, zzdpn.zzawc()));
        this.zzfrf = zzas;
        this.zzfrg = zzesb.zzas(new zzdam(this.zzfop, this.zzfqm, this.zzfoq, zzas, this.zzfqn, this.zzfre));
    }

    @Override // com.google.android.gms.internal.ads.zzdmz
    public final zzdak zzaiw() {
        return this.zzfrg.get();
    }
}
