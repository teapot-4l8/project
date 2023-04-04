package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzsn extends AppOpenAd {
    private final String zzbvf;
    private final zzsp zzbvh;
    private final zzsm zzbvi = new zzsm();
    private FullScreenContentCallback zzbvj;
    private OnPaidEventListener zzbvk;

    public zzsn(zzsp zzspVar, String str) {
        this.zzbvh = zzspVar;
        this.zzbvf = str;
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void show(Activity activity, FullScreenContentCallback fullScreenContentCallback) {
        this.zzbvj = fullScreenContentCallback;
        this.zzbvi.setFullScreenContentCallback(fullScreenContentCallback);
        if (activity == null) {
            zzbao.zzez("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            this.zzbvh.zza(ObjectWrapper.wrap(activity), this.zzbvi);
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void show(Activity activity) {
        try {
            this.zzbvh.zza(ObjectWrapper.wrap(activity), this.zzbvi);
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final ResponseInfo getResponseInfo() {
        zzzc zzzcVar;
        try {
            zzzcVar = this.zzbvh.zzkm();
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            zzzcVar = null;
        }
        return ResponseInfo.zza(zzzcVar);
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final String getAdUnitId() {
        return this.zzbvf;
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zzbvj = fullScreenContentCallback;
        this.zzbvi.setFullScreenContentCallback(fullScreenContentCallback);
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzbvj;
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void setImmersiveMode(boolean z) {
        try {
            this.zzbvh.setImmersiveMode(z);
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final zzxq zzea() {
        try {
            return this.zzbvh.zzea();
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void zza(zzsv zzsvVar) {
        try {
            this.zzbvh.zza(zzsvVar);
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzbvk = onPaidEventListener;
        try {
            this.zzbvh.zza(new zzaaq(onPaidEventListener));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.appopen.AppOpenAd
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzbvk;
    }
}
