package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcoq implements zzear {
    static final zzear zzbpa = new zzcoq();

    private zzcoq() {
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final zzebt zzf(Object obj) {
        TimeoutException timeoutException = (TimeoutException) obj;
        return zzebh.immediateFailedFuture(new zzcnp(zzdqj.NETWORK_ERROR));
    }
}
