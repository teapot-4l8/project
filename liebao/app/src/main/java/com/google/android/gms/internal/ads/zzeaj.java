package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeaj<I, O> extends zzeak<I, O, zzear<? super I, ? extends O>, zzebt<? extends O>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeaj(zzebt<? extends I> zzebtVar, zzear<? super I, ? extends O> zzearVar) {
        super(zzebtVar, zzearVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeak
    final /* synthetic */ void setResult(Object obj) {
        setFuture((zzebt) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzeak
    final /* synthetic */ Object zzd(Object obj, @NullableDecl Object obj2) {
        zzear zzearVar = (zzear) obj;
        zzebt<O> zzf = zzearVar.zzf(obj2);
        zzdyi.zza(zzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzearVar);
        return zzf;
    }
}
