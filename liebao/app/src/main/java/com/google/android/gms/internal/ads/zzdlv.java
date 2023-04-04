package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdlv implements zzebi<Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdlv(zzdlu zzdluVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        com.google.android.gms.ads.internal.util.zzd.zzed("Notification of cache hit failed.");
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(@NullableDecl Void r1) {
        com.google.android.gms.ads.internal.util.zzd.zzed("Notification of cache hit successful.");
    }
}
