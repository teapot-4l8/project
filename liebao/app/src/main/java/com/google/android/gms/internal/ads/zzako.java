package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzako<AdT> extends AdManagerInterstitialAd {
    private final Context context;
    private final zzvr zzacy = zzvr.zzciq;
    private AppEventListener zzbtf;
    private final String zzbvf;
    private FullScreenContentCallback zzbvj;
    private OnPaidEventListener zzbvk;
    private final zzxq zzbvo;

    public zzako(Context context, String str) {
        this.context = context;
        this.zzbvf = str;
        this.zzbvo = zzww.zzqx().zzb(context, new zzvt(), str, new zzank());
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final String getAdUnitId() {
        return this.zzbvf;
    }

    public final void zza(zzzl zzzlVar, AdLoadCallback<AdT> adLoadCallback) {
        try {
            this.zzbvo.zza(zzvr.zza(this.context, zzzlVar), new zzvm(adLoadCallback, this));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            adLoadCallback.onAdFailedToLoad(new LoadAdError(0, "Internal Error.", MobileAds.ERROR_DOMAIN, null, null));
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final ResponseInfo getResponseInfo() {
        zzzc zzzcVar = null;
        try {
            if (this.zzbvo != null) {
                zzzcVar = this.zzbvo.zzkm();
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
        return ResponseInfo.zza(zzzcVar);
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void show(Activity activity) {
        if (activity == null) {
            zzbao.zzez("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
        try {
            this.zzbvo.zze(ObjectWrapper.wrap(activity));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void setImmersiveMode(boolean z) {
        try {
            this.zzbvo.setImmersiveMode(z);
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzbvk = onPaidEventListener;
            this.zzbvo.zza(new zzaaq(onPaidEventListener));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzbvk;
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        try {
            this.zzbvj = fullScreenContentCallback;
            this.zzbvo.zza(new zzwy(fullScreenContentCallback));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.interstitial.InterstitialAd
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzbvj;
    }

    @Override // com.google.android.gms.ads.admanager.AdManagerInterstitialAd
    public final AppEventListener getAppEventListener() {
        return this.zzbtf;
    }

    @Override // com.google.android.gms.ads.admanager.AdManagerInterstitialAd
    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbtf = appEventListener;
            this.zzbvo.zza(appEventListener != null ? new zzrl(appEventListener) : null);
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }
}
