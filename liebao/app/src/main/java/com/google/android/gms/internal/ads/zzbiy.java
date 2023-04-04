package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbiy implements zzdli {
    private final /* synthetic */ zzbie zzfhy;
    private final Context zzfob;
    private final String zzfoc;
    private zzesn<Context> zzfop;
    private final zzvt zzfqd;
    private zzesn<zzvt> zzfqm;
    private zzesn<zzczm> zzfqn;
    private zzesn<zzdaj> zzfqo;
    private zzesn<zzdlc> zzfqp;

    private zzbiy(zzbie zzbieVar, Context context, String str, zzvt zzvtVar) {
        zzesn zzesnVar;
        zzesn zzesnVar2;
        zzesn zzesnVar3;
        this.zzfhy = zzbieVar;
        this.zzfob = context;
        this.zzfqd = zzvtVar;
        this.zzfoc = str;
        this.zzfop = zzesd.zzbb(context);
        this.zzfqm = zzesd.zzbb(zzvtVar);
        zzesnVar = this.zzfhy.zzeze;
        this.zzfqn = zzesb.zzas(zzdae.zzaj(zzesnVar));
        this.zzfqo = zzesb.zzas(zzdai.zzath());
        zzesn<Context> zzesnVar4 = this.zzfop;
        zzesnVar2 = this.zzfhy.zzezf;
        zzesn<zzvt> zzesnVar5 = this.zzfqm;
        zzesnVar3 = this.zzfhy.zzeym;
        this.zzfqp = zzesb.zzas(new zzdlf(zzesnVar4, zzesnVar2, zzesnVar5, zzesnVar3, this.zzfqn, this.zzfqo, zzdpn.zzawc()));
    }

    @Override // com.google.android.gms.internal.ads.zzdli
    public final zzczk zzaiq() {
        return new zzczk(this.zzfob, this.zzfqd, this.zzfoc, this.zzfqp.get(), this.zzfqn.get());
    }
}
