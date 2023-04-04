package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdam implements zzesa<zzdak> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzvt> zzhbm;
    private final zzesn<String> zzhbn;
    private final zzesn<zzdmr> zzhbo;
    private final zzesn<zzczm> zzhbp;
    private final zzesn<zzdnb> zzhbq;

    public zzdam(zzesn<Context> zzesnVar, zzesn<zzvt> zzesnVar2, zzesn<String> zzesnVar3, zzesn<zzdmr> zzesnVar4, zzesn<zzczm> zzesnVar5, zzesn<zzdnb> zzesnVar6) {
        this.zzeyq = zzesnVar;
        this.zzhbm = zzesnVar2;
        this.zzhbn = zzesnVar3;
        this.zzhbo = zzesnVar4;
        this.zzhbp = zzesnVar5;
        this.zzhbq = zzesnVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdak(this.zzeyq.get(), this.zzhbm.get(), this.zzhbn.get(), this.zzhbo.get(), this.zzhbp.get(), this.zzhbq.get());
    }
}
