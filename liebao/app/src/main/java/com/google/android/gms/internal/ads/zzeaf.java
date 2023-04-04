package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeaf<V, X extends Throwable> extends zzead<V, X, zzdxw<? super X, ? extends V>, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeaf(zzebt<? extends V> zzebtVar, Class<X> cls, zzdxw<? super X, ? extends V> zzdxwVar) {
        super(zzebtVar, cls, zzdxwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzead
    final void setResult(@NullableDecl V v) {
        set(v);
    }

    @Override // com.google.android.gms.internal.ads.zzead
    @NullableDecl
    final /* synthetic */ Object zza(Object obj, Throwable th) {
        return ((zzdxw) obj).apply(th);
    }
}
