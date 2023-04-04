package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcyi implements zzesa<zzcyc> {
    private final zzesn<zzebs> zzfxf;
    private final zzesn<zzdtg> zzfxq;
    private final zzesn<zzboa> zzgvz;
    private final zzesn<Context> zzgzq;
    private final zzesn<zzacm> zzgzr;

    public zzcyi(zzesn<Context> zzesnVar, zzesn<zzboa> zzesnVar2, zzesn<zzdtg> zzesnVar3, zzesn<zzebs> zzesnVar4, zzesn<zzacm> zzesnVar5) {
        this.zzgzq = zzesnVar;
        this.zzgvz = zzesnVar2;
        this.zzfxq = zzesnVar3;
        this.zzfxf = zzesnVar4;
        this.zzgzr = zzesnVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcyc(this.zzgzq.get(), this.zzgvz.get(), this.zzfxq.get(), this.zzfxf.get(), this.zzgzr.get());
    }
}
