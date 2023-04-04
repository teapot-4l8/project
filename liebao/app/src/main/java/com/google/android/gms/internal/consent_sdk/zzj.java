package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzj implements ConsentInformation {
    private final zzal zza;
    private final zzp zzb;
    private final zzaz zzc;

    public zzj(zzal zzalVar, zzp zzpVar, zzaz zzazVar) {
        this.zza = zzalVar;
        this.zzb = zzpVar;
        this.zzc = zzazVar;
    }

    @Override // com.google.android.ump.ConsentInformation
    public final void reset() {
        this.zzc.zza(null);
        this.zza.zzf();
    }

    @Override // com.google.android.ump.ConsentInformation
    public final void requestConsentInfoUpdate(Activity activity, ConsentRequestParameters consentRequestParameters, ConsentInformation.OnConsentInfoUpdateSuccessListener onConsentInfoUpdateSuccessListener, ConsentInformation.OnConsentInfoUpdateFailureListener onConsentInfoUpdateFailureListener) {
        this.zzb.zza(activity, consentRequestParameters, onConsentInfoUpdateSuccessListener, onConsentInfoUpdateFailureListener);
    }

    @Override // com.google.android.ump.ConsentInformation
    public final int getConsentStatus() {
        return this.zza.zza();
    }

    @Override // com.google.android.ump.ConsentInformation
    public final int getConsentType() {
        return this.zza.zzb();
    }

    @Override // com.google.android.ump.ConsentInformation
    public final boolean isConsentFormAvailable() {
        return this.zzc.zza();
    }
}
