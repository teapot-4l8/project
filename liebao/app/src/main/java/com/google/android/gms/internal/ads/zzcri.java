package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcri implements zzesa<zzcrj> {
    private final zzesn<Context> zzeyq;

    private zzcri(zzesn<Context> zzesnVar) {
        this.zzeyq = zzesnVar;
    }

    public static zzcri zzaf(zzesn<Context> zzesnVar) {
        return new zzcri(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcrj(this.zzeyq.get());
    }
}
