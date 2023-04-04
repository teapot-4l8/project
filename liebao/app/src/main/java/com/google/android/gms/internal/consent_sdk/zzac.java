package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzac implements zzcp<zzz> {
    private final zzct<zze> zza;
    private final zzct<zzaj> zzb;
    private final zzct<zzal> zzc;

    public zzac(zzct<zze> zzctVar, zzct<zzaj> zzctVar2, zzct<zzal> zzctVar3) {
        this.zza = zzctVar;
        this.zzb = zzctVar2;
        this.zzc = zzctVar3;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzct
    public final /* synthetic */ Object zza() {
        return new zzz(this.zza.zza(), this.zzb.zza(), this.zzc.zza());
    }
}
