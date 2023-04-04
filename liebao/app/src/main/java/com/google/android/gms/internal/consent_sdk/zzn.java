package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzn {
    private final Application zza;
    private final zzb zzb;
    private final zzal zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(Application application, zzb zzbVar, zzal zzalVar) {
        this.zza = application;
        this.zzb = zzbVar;
        this.zzc = zzalVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbn zza(Activity activity, ConsentRequestParameters consentRequestParameters) {
        ConsentDebugSettings consentDebugSettings = consentRequestParameters.getConsentDebugSettings();
        if (consentDebugSettings == null) {
            consentDebugSettings = new ConsentDebugSettings.Builder(this.zza).build();
        }
        return zzl.zza(new zzl(this, activity, consentDebugSettings, consentRequestParameters));
    }
}
