package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbrz implements zzebi<Boolean> {
    private final /* synthetic */ zzbrx zzgap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbrz(zzbrx zzbrxVar) {
        this.zzgap = zzbrxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(@NullableDecl Boolean bool) {
        zzbtl zzbtlVar;
        zzbtlVar = this.zzgap.zzgah;
        zzbtlVar.onAdImpression();
    }
}
