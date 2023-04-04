package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzanf extends zzbgz {
    private final AppMeasurementSdk zzdmv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzanf(AppMeasurementSdk appMeasurementSdk) {
        this.zzdmv = appMeasurementSdk;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void performAction(Bundle bundle) {
        this.zzdmv.performAction(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final Bundle performActionWithResponse(Bundle bundle) {
        return this.zzdmv.performActionWithResponse(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void logEvent(String str, String str2, Bundle bundle) {
        this.zzdmv.logEvent(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zza(String str, String str2, IObjectWrapper iObjectWrapper) {
        this.zzdmv.setUserProperty(str, str2, iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final Map getUserProperties(String str, String str2, boolean z) {
        return this.zzdmv.getUserProperties(str, str2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final int getMaxUserProperties(String str) {
        return this.zzdmv.getMaxUserProperties(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void setConditionalUserProperty(Bundle bundle) {
        this.zzdmv.setConditionalUserProperty(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzdmv.clearConditionalUserProperty(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final List getConditionalUserProperties(String str, String str2) {
        return this.zzdmv.getConditionalUserProperties(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String getAppInstanceId() {
        return this.zzdmv.getAppInstanceId();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String getGmpAppId() {
        return this.zzdmv.getGmpAppId();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final long generateEventId() {
        return this.zzdmv.generateEventId();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void beginAdUnitExposure(String str) {
        this.zzdmv.beginAdUnitExposure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void endAdUnitExposure(String str) {
        this.zzdmv.endAdUnitExposure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void setConsent(Bundle bundle) {
        this.zzdmv.setConsent(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzb(IObjectWrapper iObjectWrapper, String str, String str2) {
        this.zzdmv.setCurrentScreen(iObjectWrapper != null ? (Activity) ObjectWrapper.unwrap(iObjectWrapper) : null, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String getCurrentScreenName() {
        return this.zzdmv.getCurrentScreenName();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String getCurrentScreenClass() {
        return this.zzdmv.getCurrentScreenClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String getAppIdOrigin() {
        return this.zzdmv.getAppIdOrigin();
    }
}
