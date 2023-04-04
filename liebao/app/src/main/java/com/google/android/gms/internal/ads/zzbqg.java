package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbqg implements zzebi<Void> {
    private final /* synthetic */ zzbqd zzfzs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbqg(zzbqd zzbqdVar) {
        this.zzfzs = zzbqdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        zzbxf zzbxfVar;
        zzbxfVar = this.zzfzs.zzfzk;
        zzbxfVar.zzbk(false);
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(@NullableDecl Void r2) {
        zzbxf zzbxfVar;
        zzbxfVar = this.zzfzs.zzfzk;
        zzbxfVar.zzbk(true);
    }
}
