package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzblj implements zzesa<zzblg> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzqt> zzfuw;

    private zzblj(zzesn<Context> zzesnVar, zzesn<zzqt> zzesnVar2) {
        this.zzeyq = zzesnVar;
        this.zzfuw = zzesnVar2;
    }

    public static zzblj zza(zzesn<Context> zzesnVar, zzesn<zzqt> zzesnVar2) {
        return new zzblj(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzblg(this.zzeyq.get(), this.zzfuw.get());
    }
}
