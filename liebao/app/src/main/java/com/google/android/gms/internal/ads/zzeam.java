package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeam<I, O> extends zzeak<I, O, zzdxw<? super I, ? extends O>, O> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeam(zzebt<? extends I> zzebtVar, zzdxw<? super I, ? extends O> zzdxwVar) {
        super(zzebtVar, zzdxwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeak
    final void setResult(@NullableDecl O o) {
        set(o);
    }

    @Override // com.google.android.gms.internal.ads.zzeak
    @NullableDecl
    final /* synthetic */ Object zzd(Object obj, @NullableDecl Object obj2) {
        return ((zzdxw) obj).apply(obj2);
    }
}
