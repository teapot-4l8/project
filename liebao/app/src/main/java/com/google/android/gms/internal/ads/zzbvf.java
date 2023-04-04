package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbvf implements Runnable {
    private final WeakReference<zzbve> zzgby;

    private zzbvf(zzbve zzbveVar) {
        this.zzgby = new WeakReference<>(zzbveVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbve zzbveVar = this.zzgby.get();
        if (zzbveVar != null) {
            zzbve.zza(zzbveVar);
        }
    }
}
