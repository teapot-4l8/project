package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaxs implements zzesa<zzaxt> {
    private final zzesn<Context> zzece;
    private final zzesn<com.google.android.gms.ads.internal.util.zzf> zzecf;
    private final zzesn<zzayd> zzecg;

    public zzaxs(zzesn<Context> zzesnVar, zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar2, zzesn<zzayd> zzesnVar3) {
        this.zzece = zzesnVar;
        this.zzecf = zzesnVar2;
        this.zzecg = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzaxt(this.zzece.get(), this.zzecf.get(), this.zzecg.get());
    }
}
