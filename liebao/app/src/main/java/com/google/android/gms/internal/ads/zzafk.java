package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public interface zzafk extends IInterface {
    void destroy();

    String getAdvertiser();

    String getBody();

    String getCallToAction();

    Bundle getExtras();

    String getHeadline();

    List getImages();

    String getMediationAdapterClassName();

    zzzd getVideoController();

    void performClick(Bundle bundle);

    boolean recordImpression(Bundle bundle);

    void reportTouchEvent(Bundle bundle);

    IObjectWrapper zzts();

    zzaek zztu();

    IObjectWrapper zztv();

    zzaes zztw();
}
