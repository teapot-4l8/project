package com.google.android.gms.internal.ads;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public interface zzafo extends IInterface {
    void destroy();

    List<String> getAvailableAssetNames();

    String getCustomTemplateId();

    zzzd getVideoController();

    void performClick(String str);

    void recordImpression();

    String zzct(String str);

    zzaes zzcu(String str);

    boolean zzp(IObjectWrapper iObjectWrapper);

    void zzq(IObjectWrapper iObjectWrapper);

    IObjectWrapper zzts();

    IObjectWrapper zztx();

    boolean zzty();

    boolean zztz();

    void zzua();
}
