package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public interface zzaob extends IInterface {
    String getBody();

    String getCallToAction();

    Bundle getExtras();

    String getHeadline();

    List getImages();

    boolean getOverrideClickHandling();

    boolean getOverrideImpressionRecording();

    String getPrice();

    double getStarRating();

    String getStore();

    zzzd getVideoController();

    void recordImpression();

    void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3);

    zzaes zztt();

    zzaek zztu();

    IObjectWrapper zztv();

    void zzv(IObjectWrapper iObjectWrapper);

    IObjectWrapper zzvr();

    IObjectWrapper zzvs();

    void zzw(IObjectWrapper iObjectWrapper);

    void zzx(IObjectWrapper iObjectWrapper);
}
