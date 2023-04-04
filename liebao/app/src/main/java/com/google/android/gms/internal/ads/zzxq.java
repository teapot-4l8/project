package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public interface zzxq extends IInterface {
    void destroy();

    Bundle getAdMetadata();

    String getAdUnitId();

    String getMediationAdapterClassName();

    zzzd getVideoController();

    boolean isLoading();

    boolean isReady();

    void pause();

    void resume();

    void setImmersiveMode(boolean z);

    void setManualImpressionsEnabled(boolean z);

    void setUserId(String str);

    void showInterstitial();

    void stopLoading();

    void zza(zzaaz zzaazVar);

    void zza(zzacm zzacmVar);

    void zza(zzasr zzasrVar);

    void zza(zzasx zzasxVar, String str);

    void zza(zzavn zzavnVar);

    void zza(zzsq zzsqVar);

    void zza(zzvq zzvqVar, zzxd zzxdVar);

    void zza(zzvt zzvtVar);

    void zza(zzwc zzwcVar);

    void zza(zzwx zzwxVar);

    void zza(zzxc zzxcVar);

    void zza(zzxt zzxtVar);

    void zza(zzxy zzxyVar);

    void zza(zzye zzyeVar);

    void zza(zzyg zzygVar);

    void zza(zzyx zzyxVar);

    void zza(zzzj zzzjVar);

    boolean zza(zzvq zzvqVar);

    void zzbl(String str);

    void zze(IObjectWrapper iObjectWrapper);

    IObjectWrapper zzki();

    void zzkj();

    zzvt zzkk();

    String zzkl();

    zzzc zzkm();

    zzxy zzkn();

    zzxc zzko();
}
