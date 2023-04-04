package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdjw implements zzesa<zzdjp> {
    private final zzesn<zzbhh> zzeym;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<String> zzhbn;
    private final zzesn<zzdjn> zzhbo;
    private final zzesn<zzdkd> zzhij;

    public zzdjw(zzesn<zzbhh> zzesnVar, zzesn<Context> zzesnVar2, zzesn<String> zzesnVar3, zzesn<zzdjn> zzesnVar4, zzesn<zzdkd> zzesnVar5, zzesn<zzbar> zzesnVar6) {
        this.zzeym = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzhbn = zzesnVar3;
        this.zzhbo = zzesnVar4;
        this.zzhij = zzesnVar5;
        this.zzfvj = zzesnVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdjp(this.zzeym.get(), this.zzeyq.get(), this.zzhbn.get(), this.zzhbo.get(), this.zzhij.get(), this.zzfvj.get());
    }
}
