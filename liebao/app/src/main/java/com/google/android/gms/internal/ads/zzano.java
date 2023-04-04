package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public interface zzano extends IInterface {
    void destroy();

    Bundle getInterstitialAdapterInfo();

    zzzd getVideoController();

    boolean isInitialized();

    void pause();

    void resume();

    void setImmersiveMode(boolean z);

    void showInterstitial();

    void showVideo();

    void zza(IObjectWrapper iObjectWrapper, zzajo zzajoVar, List<zzajw> list);

    void zza(IObjectWrapper iObjectWrapper, zzavu zzavuVar, List<String> list);

    void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzant zzantVar);

    void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzavu zzavuVar, String str2);

    void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, String str2, zzant zzantVar);

    void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, String str2, zzant zzantVar, zzaei zzaeiVar, List<String> list);

    void zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, zzvq zzvqVar, String str, zzant zzantVar);

    void zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, zzvq zzvqVar, String str, String str2, zzant zzantVar);

    void zza(zzvq zzvqVar, String str);

    void zza(zzvq zzvqVar, String str, String str2);

    void zzb(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzant zzantVar);

    void zzb(IObjectWrapper iObjectWrapper, zzvt zzvtVar, zzvq zzvqVar, String str, String str2, zzant zzantVar);

    void zzc(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzant zzantVar);

    void zzs(IObjectWrapper iObjectWrapper);

    void zzt(IObjectWrapper iObjectWrapper);

    void zzu(IObjectWrapper iObjectWrapper);

    IObjectWrapper zzve();

    zzaob zzvf();

    zzaoc zzvg();

    Bundle zzvh();

    Bundle zzvi();

    boolean zzvj();

    zzafo zzvk();

    zzaoh zzvl();

    zzaqr zzvm();

    zzaqr zzvn();

    zzanu zzvo();
}
