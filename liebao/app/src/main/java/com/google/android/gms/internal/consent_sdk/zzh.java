package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzh implements zzcp<zze> {
    private final zzct<Executor> zza;

    public zzh(zzct<Executor> zzctVar) {
        this.zza = zzctVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzct
    public final /* synthetic */ Object zza() {
        return new zze(this.zza.zza());
    }
}
