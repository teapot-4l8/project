package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* loaded from: classes.dex */
public final class zzai extends zzag.zzb {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzai(zzag zzagVar, Bundle bundle) {
        super(zzagVar);
        this.zzd = zzagVar;
        this.zzc = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    final void zza() {
        zzv zzvVar;
        zzvVar = this.zzd.zzm;
        zzvVar.setConditionalUserProperty(this.zzc, this.zza);
    }
}
