package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzag;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* loaded from: classes.dex */
public final class zzbj extends zzag.zzb {
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbj(zzag zzagVar, boolean z) {
        super(zzagVar);
        this.zzd = zzagVar;
        this.zzc = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    final void zza() {
        zzv zzvVar;
        zzvVar = this.zzd.zzm;
        zzvVar.setDataCollectionEnabled(this.zzc);
    }
}
