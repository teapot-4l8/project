package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcsp implements zzesa<zzcsh> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzebs> zzgtb;

    public zzcsp(zzesn<Context> zzesnVar, zzesn<zzebs> zzesnVar2) {
        this.zzeyq = zzesnVar;
        this.zzgtb = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcsh(this.zzeyq.get(), this.zzgtb.get());
    }
}
