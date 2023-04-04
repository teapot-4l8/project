package com.google.android.gms.internal.ads;

import java.lang.Throwable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeag<V, X extends Throwable> extends zzead<V, X, zzear<? super X, ? extends V>, zzebt<? extends V>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeag(zzebt<? extends V> zzebtVar, Class<X> cls, zzear<? super X, ? extends V> zzearVar) {
        super(zzebtVar, cls, zzearVar);
    }

    @Override // com.google.android.gms.internal.ads.zzead
    final /* synthetic */ void setResult(Object obj) {
        setFuture((zzebt) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzead
    final /* synthetic */ Object zza(Object obj, Throwable th) {
        zzear zzearVar = (zzear) obj;
        zzebt zzf = zzearVar.zzf(th);
        zzdyi.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzearVar);
        return zzf;
    }
}
