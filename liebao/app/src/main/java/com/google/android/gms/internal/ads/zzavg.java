package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public interface zzavg extends IInterface {
    void destroy();

    Bundle getAdMetadata();

    String getMediationAdapterClassName();

    boolean isLoaded();

    void pause();

    void resume();

    void setAppPackageName(String str);

    void setCustomData(String str);

    void setImmersiveMode(boolean z);

    void setUserId(String str);

    void show();

    void zza(zzave zzaveVar);

    void zza(zzavn zzavnVar);

    void zza(zzavt zzavtVar);

    void zza(zzxt zzxtVar);

    void zzi(IObjectWrapper iObjectWrapper);

    void zzj(IObjectWrapper iObjectWrapper);

    void zzk(IObjectWrapper iObjectWrapper);

    zzzc zzkm();

    void zzl(IObjectWrapper iObjectWrapper);

    boolean zzsc();
}
