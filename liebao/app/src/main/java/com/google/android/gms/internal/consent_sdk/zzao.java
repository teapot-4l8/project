package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzao implements zzcp<zzal> {
    private final zzct<Application> zza;

    public zzao(zzct<Application> zzctVar) {
        this.zza = zzctVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzct
    public final /* synthetic */ Object zza() {
        return new zzal(this.zza.zza());
    }
}
