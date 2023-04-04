package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzeay extends zzeax<V> {
    private final /* synthetic */ zzeav zzidj;
    private final Callable<V> zzidk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeay(zzeav zzeavVar, Callable<V> callable, Executor executor) {
        super(zzeavVar, executor);
        this.zzidj = zzeavVar;
        this.zzidk = (Callable) zzdyi.checkNotNull(callable);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [V, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzebp
    final V zzbba() {
        return this.zzidk.call();
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    final void setValue(V v) {
        this.zzidj.set(v);
    }

    @Override // com.google.android.gms.internal.ads.zzebp
    final String zzbbb() {
        return this.zzidk.toString();
    }
}
