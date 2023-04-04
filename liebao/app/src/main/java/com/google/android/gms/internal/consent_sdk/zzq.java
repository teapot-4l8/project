package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzq implements zzcp<zzn> {
    private final zzct<Application> zza;
    private final zzct<zzb> zzb;
    private final zzct<zzal> zzc;

    public zzq(zzct<Application> zzctVar, zzct<zzb> zzctVar2, zzct<zzal> zzctVar3) {
        this.zza = zzctVar;
        this.zzb = zzctVar2;
        this.zzc = zzctVar3;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzct
    public final /* synthetic */ Object zza() {
        return new zzn(this.zza.zza(), this.zzb.zza(), this.zzc.zza());
    }
}
