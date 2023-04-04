package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdqp implements zzesa<zzdqm> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbac> zzfby;

    private zzdqp(zzesn<Context> zzesnVar, zzesn<zzbac> zzesnVar2) {
        this.zzeyq = zzesnVar;
        this.zzfby = zzesnVar2;
    }

    public static zzdqp zzbe(zzesn<Context> zzesnVar, zzesn<zzbac> zzesnVar2) {
        return new zzdqp(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdqm(this.zzeyq.get(), this.zzfby.get());
    }
}
