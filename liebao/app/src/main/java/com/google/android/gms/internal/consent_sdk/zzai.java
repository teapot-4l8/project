package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import com.google.android.gms.internal.consent_sdk.zzc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzai implements zzc.zza {
    private Application zza;

    private zzai() {
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzc.zza
    public final zzc zza() {
        zzcu.zza(this.zza, Application.class);
        return new zzag(this.zza, null);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzc.zza
    public final /* synthetic */ zzc.zza zza(Application application) {
        this.zza = (Application) zzcu.zza(application);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzai(zzaf zzafVar) {
        this();
    }
}
