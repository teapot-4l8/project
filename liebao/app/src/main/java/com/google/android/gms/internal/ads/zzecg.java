package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzecg extends zzebp<V> {
    private final Callable<V> zzidk;
    private final /* synthetic */ zzece zzief;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzecg(zzece zzeceVar, Callable<V> callable) {
        this.zzief = zzeceVar;
        this.zzidk = (Callable) zzdyi.checkNotNull(callable);
    }

    @Override // com.google.android.gms.internal.ads.zzebp
    final boolean isDone() {
        return this.zzief.isDone();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [V, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzebp
    final V zzbba() {
        return this.zzidk.call();
    }

    @Override // com.google.android.gms.internal.ads.zzebp
    final void zzb(V v, Throwable th) {
        if (th == null) {
            this.zzief.set(v);
        } else {
            this.zzief.setException(th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebp
    final String zzbbb() {
        return this.zzidk.toString();
    }
}
