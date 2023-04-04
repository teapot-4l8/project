package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzddr implements zzesa<zzddp> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;

    private zzddr(zzesn<zzebs> zzesnVar, zzesn<Context> zzesnVar2) {
        this.zzeyl = zzesnVar;
        this.zzeyq = zzesnVar2;
    }

    public static zzddr zzau(zzesn<zzebs> zzesnVar, zzesn<Context> zzesnVar2) {
        return new zzddr(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzddp(this.zzeyl.get(), this.zzeyq.get());
    }
}
