package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzces implements zzesa<zzceq> {
    private final zzesn<zzchu> zzflr;
    private final zzesn<Clock> zzfvh;

    public zzces(zzesn<zzchu> zzesnVar, zzesn<Clock> zzesnVar2) {
        this.zzflr = zzesnVar;
        this.zzfvh = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzceq(this.zzflr.get(), this.zzfvh.get());
    }
}
