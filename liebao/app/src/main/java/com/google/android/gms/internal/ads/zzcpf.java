package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcpf implements zzesa<zzcpd> {
    private final zzesn<Context> zzeyq;

    public zzcpf(zzesn<Context> zzesnVar) {
        this.zzeyq = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcpd(this.zzeyq.get());
    }
}
