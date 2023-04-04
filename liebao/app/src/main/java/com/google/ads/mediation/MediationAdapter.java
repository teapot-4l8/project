package com.google.ads.mediation;

import com.google.ads.mediation.MediationServerParameters;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public interface MediationAdapter<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS extends MediationServerParameters> {
    void destroy();

    Class<ADDITIONAL_PARAMETERS> getAdditionalParametersType();

    Class<SERVER_PARAMETERS> getServerParametersType();
}
