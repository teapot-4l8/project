package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgr implements zzesa<zzdgp> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfsw;

    private zzdgr(zzesn<zzebs> zzesnVar, zzesn<Context> zzesnVar2, zzesn<zzbar> zzesnVar3) {
        this.zzeyl = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzfsw = zzesnVar3;
    }

    public static zzdgr zzac(zzesn<zzebs> zzesnVar, zzesn<Context> zzesnVar2, zzesn<zzbar> zzesnVar3) {
        return new zzdgr(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdgp(this.zzeyl.get(), this.zzeyq.get(), this.zzfsw.get());
    }
}
