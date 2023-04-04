package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzczj implements zzesa<zzczg> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzxc> zzhap;
    private final zzesn<zzbne> zzhaq;

    public zzczj(zzesn<Context> zzesnVar, zzesn<zzxc> zzesnVar2, zzesn<zzdpm> zzesnVar3, zzesn<zzbne> zzesnVar4) {
        this.zzeyq = zzesnVar;
        this.zzhap = zzesnVar2;
        this.zzfxn = zzesnVar3;
        this.zzhaq = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzczg(this.zzeyq.get(), this.zzhap.get(), this.zzfxn.get(), this.zzhaq.get());
    }
}
