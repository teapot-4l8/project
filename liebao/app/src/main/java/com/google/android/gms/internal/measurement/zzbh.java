package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.0 */
/* loaded from: classes.dex */
final class zzbh extends zzag.zzb {
    private final /* synthetic */ zzt zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbh(zzag zzagVar, zzt zztVar) {
        super(zzagVar);
        this.zzd = zzagVar;
        this.zzc = zztVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    final void zza() {
        zzv zzvVar;
        zzvVar = this.zzd.zzm;
        zzvVar.getAppInstanceId(this.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    protected final void zzb() {
        this.zzc.zza((Bundle) null);
    }
}
