package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcnq implements zzear {
    static final zzear zzbpa = new zzcnq();

    private zzcnq() {
    }

    @Override // com.google.android.gms.internal.ads.zzear
    public final zzebt zzf(Object obj) {
        return zzebh.immediateFailedFuture(((ExecutionException) obj).getCause());
    }
}
