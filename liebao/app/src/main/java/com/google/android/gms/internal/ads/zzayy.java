package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzayy implements zzesa<zzayu> {
    private final zzesn<Context> zzece;
    private final zzesn<zzaxx> zzecr;

    public zzayy(zzesn<Context> zzesnVar, zzesn<zzaxx> zzesnVar2) {
        this.zzece = zzesnVar;
        this.zzecr = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzayu(this.zzece.get(), this.zzecr.get());
    }
}
