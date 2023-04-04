package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
public interface zzv extends IInterface {
    void beginAdUnitExposure(String str, long j);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j);

    void endAdUnitExposure(String str, long j);

    void generateEventId(zzw zzwVar);

    void getAppInstanceId(zzw zzwVar);

    void getCachedAppInstanceId(zzw zzwVar);

    void getConditionalUserProperties(String str, String str2, zzw zzwVar);

    void getCurrentScreenClass(zzw zzwVar);

    void getCurrentScreenName(zzw zzwVar);

    void getGmpAppId(zzw zzwVar);

    void getMaxUserProperties(String str, zzw zzwVar);

    void getTestFlag(zzw zzwVar, int i);

    void getUserProperties(String str, String str2, boolean z, zzw zzwVar);

    void initForTests(Map map);

    void initialize(IObjectWrapper iObjectWrapper, zzae zzaeVar, long j);

    void isDataCollectionEnabled(zzw zzwVar);

    void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j);

    void logEventAndBundle(String str, String str2, Bundle bundle, zzw zzwVar, long j);

    void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3);

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j);

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j);

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j);

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j);

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzw zzwVar, long j);

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j);

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j);

    void performAction(Bundle bundle, zzw zzwVar, long j);

    void registerOnMeasurementEventListener(zzab zzabVar);

    void resetAnalyticsData(long j);

    void setConditionalUserProperty(Bundle bundle, long j);

    void setConsent(Bundle bundle, long j);

    void setConsentThirdParty(Bundle bundle, long j);

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j);

    void setDataCollectionEnabled(boolean z);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(zzab zzabVar);

    void setInstanceIdProvider(zzac zzacVar);

    void setMeasurementEnabled(boolean z, long j);

    void setMinimumSessionDuration(long j);

    void setSessionTimeoutDuration(long j);

    void setUserId(String str, long j);

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j);

    void unregisterOnMeasurementEventListener(zzab zzabVar);
}
