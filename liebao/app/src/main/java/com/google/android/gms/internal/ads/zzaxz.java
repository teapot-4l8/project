package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaxz extends zzayt {
    private zzesn<Context> zzece;
    private zzesn<zzayd> zzecg;
    private zzesn<com.google.android.gms.ads.internal.util.zzf> zzeco;
    private zzesn<zzaxt> zzecp;
    private zzesn<zzaxv> zzecq;
    private zzesn<zzaxx> zzecr;
    private zzesn<zzayu> zzecs;

    private zzaxz(Context context, com.google.android.gms.ads.internal.util.zzf zzfVar, zzayd zzaydVar) {
        this.zzece = zzesd.zzbb(context);
        this.zzeco = zzesd.zzbb(zzfVar);
        zzesa zzbb = zzesd.zzbb(zzaydVar);
        this.zzecg = zzbb;
        this.zzecp = zzesb.zzas(new zzaxs(this.zzece, this.zzeco, zzbb));
        zzesn<zzaxv> zzas = zzesb.zzas(new zzaxu(this.zzeco, this.zzecg));
        this.zzecq = zzas;
        zzaxw zzaxwVar = new zzaxw(zzas);
        this.zzecr = zzaxwVar;
        this.zzecs = zzesb.zzas(new zzayy(this.zzece, zzaxwVar));
    }

    @Override // com.google.android.gms.internal.ads.zzayt
    final zzaxt zzxr() {
        return this.zzecp.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzayt
    public final zzaxx zzxs() {
        return new zzaxx(this.zzecq.get());
    }

    @Override // com.google.android.gms.internal.ads.zzayt
    final zzayu zzxt() {
        return this.zzecs.get();
    }
}
