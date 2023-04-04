package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgn implements zzesa<zzdgl> {
    private final zzesn<zzayd> zzecg;
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;

    private zzdgn(zzesn<zzayd> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<Context> zzesnVar3) {
        this.zzecg = zzesnVar;
        this.zzeyl = zzesnVar2;
        this.zzeyq = zzesnVar3;
    }

    public static zzdgn zzab(zzesn<zzayd> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<Context> zzesnVar3) {
        return new zzdgn(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdgl(this.zzecg.get(), this.zzeyl.get(), this.zzeyq.get());
    }
}
