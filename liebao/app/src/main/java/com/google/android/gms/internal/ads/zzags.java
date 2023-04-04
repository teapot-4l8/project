package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public interface zzags extends IInterface {
    void cancelUnconfirmedClick();

    void destroy();

    String getAdvertiser();

    String getBody();

    String getCallToAction();

    Bundle getExtras();

    String getHeadline();

    List getImages();

    String getMediationAdapterClassName();

    List getMuteThisAdReasons();

    String getPrice();

    double getStarRating();

    String getStore();

    zzzd getVideoController();

    boolean isCustomClickGestureEnabled();

    boolean isCustomMuteThisAdEnabled();

    void performClick(Bundle bundle);

    void recordCustomClickGesture();

    boolean recordImpression(Bundle bundle);

    void reportTouchEvent(Bundle bundle);

    void zza(zzagr zzagrVar);

    void zza(zzyo zzyoVar);

    void zza(zzys zzysVar);

    void zza(zzyx zzyxVar);

    zzzc zzkm();

    IObjectWrapper zzts();

    zzaes zztt();

    zzaek zztu();

    IObjectWrapper zztv();

    void zzud();

    zzaer zzue();
}
