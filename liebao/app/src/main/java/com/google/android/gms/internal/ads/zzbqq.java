package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbqq implements zzesa<zzbqr> {
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzazr> zzfzv;

    private zzbqq(zzesn<Clock> zzesnVar, zzesn<zzazr> zzesnVar2) {
        this.zzfvh = zzesnVar;
        this.zzfzv = zzesnVar2;
    }

    public static zzbqq zzd(zzesn<Clock> zzesnVar, zzesn<zzazr> zzesnVar2) {
        return new zzbqq(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbqr(this.zzfvh.get(), this.zzfzv.get());
    }
}
