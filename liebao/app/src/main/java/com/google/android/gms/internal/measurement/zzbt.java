package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* loaded from: classes.dex */
final class zzbt extends zzag.zzb {
    private final /* synthetic */ Activity zzc;
    private final /* synthetic */ zzag.zzc zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbt(zzag.zzc zzcVar, Activity activity) {
        super(zzag.this);
        this.zzd = zzcVar;
        this.zzc = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    final void zza() {
        zzv zzvVar;
        zzvVar = zzag.this.zzm;
        zzvVar.onActivityStopped(ObjectWrapper.wrap(this.zzc), this.zzb);
    }
}