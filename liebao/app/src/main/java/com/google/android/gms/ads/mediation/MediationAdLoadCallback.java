package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public interface MediationAdLoadCallback<MediationAdT, MediationAdCallbackT> {
    void onFailure(AdError adError);

    @Deprecated
    void onFailure(String str);

    MediationAdCallbackT onSuccess(MediationAdT mediationadt);
}
