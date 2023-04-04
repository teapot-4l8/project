package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaoy<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzanr {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zzdpp;
    private final NETWORK_EXTRAS zzdpq;

    public zzaoy(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.zzdpp = mediationAdapter;
        this.zzdpq = network_extras;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzzd getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void showVideo() {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzajo zzajoVar, List<zzajw> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzavu zzavuVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzavu zzavuVar, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, String str2, zzant zzantVar, zzaei zzaeiVar, List<String> list) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(zzvq zzvqVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(zzvq zzvqVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzb(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzant zzantVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzb(IObjectWrapper iObjectWrapper, zzvt zzvtVar, zzvq zzvqVar, String str, String str2, zzant zzantVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzc(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzant zzantVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzs(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzt(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzu(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaob zzvf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaoc zzvg() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final boolean zzvj() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzafo zzvk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaoh zzvl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaqr zzvm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaqr zzvn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzanu zzvo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final IObjectWrapper zzve() {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdpp;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbao.zzez(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        try {
            return ObjectWrapper.wrap(((MediationBannerAdapter) mediationAdapter).getBannerView());
        } catch (Throwable th) {
            zzbao.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, zzvq zzvqVar, String str, zzant zzantVar) {
        zza(iObjectWrapper, zzvtVar, zzvqVar, str, null, zzantVar);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, zzvq zzvqVar, String str, String str2, zzant zzantVar) {
        AdSize adSize;
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdpp;
        if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbao.zzez(valueOf.length() != 0 ? "Not a MediationBannerAdapter: ".concat(valueOf) : new String("Not a MediationBannerAdapter: "));
            throw new RemoteException();
        }
        zzbao.zzdz("Requesting banner ad from adapter.");
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdpp;
            zzapb zzapbVar = new zzapb(zzantVar);
            Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
            SERVER_PARAMETERS zzdl = zzdl(str);
            int i = 0;
            AdSize[] adSizeArr = {AdSize.SMART_BANNER, AdSize.BANNER, AdSize.IAB_MRECT, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_WIDE_SKYSCRAPER};
            while (true) {
                if (i < 6) {
                    if (adSizeArr[i].getWidth() == zzvtVar.width && adSizeArr[i].getHeight() == zzvtVar.height) {
                        adSize = adSizeArr[i];
                        break;
                    }
                    i++;
                } else {
                    adSize = new AdSize(com.google.android.gms.ads.zza.zza(zzvtVar.width, zzvtVar.height, zzvtVar.zzadd));
                    break;
                }
            }
            mediationBannerAdapter.requestBannerAd(zzapbVar, activity, zzdl, adSize, zzapn.zza(zzvqVar, zzc(zzvqVar)), this.zzdpq);
        } catch (Throwable th) {
            zzbao.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final Bundle zzvh() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzant zzantVar) {
        zza(iObjectWrapper, zzvqVar, str, (String) null, zzantVar);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, String str2, zzant zzantVar) {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdpp;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbao.zzez(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbao.zzdz("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdpp).requestInterstitialAd(new zzapb(zzantVar), (Activity) ObjectWrapper.unwrap(iObjectWrapper), zzdl(str), zzapn.zza(zzvqVar, zzc(zzvqVar)), this.zzdpq);
        } catch (Throwable th) {
            zzbao.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final Bundle getInterstitialAdapterInfo() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void showInterstitial() {
        MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter = this.zzdpp;
        if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
            String valueOf = String.valueOf(mediationAdapter.getClass().getCanonicalName());
            zzbao.zzez(valueOf.length() != 0 ? "Not a MediationInterstitialAdapter: ".concat(valueOf) : new String("Not a MediationInterstitialAdapter: "));
            throw new RemoteException();
        }
        zzbao.zzdz("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdpp).showInterstitial();
        } catch (Throwable th) {
            zzbao.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final Bundle zzvi() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void destroy() {
        try {
            this.zzdpp.destroy();
        } catch (Throwable th) {
            zzbao.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void pause() {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void resume() {
        throw new RemoteException();
    }

    private final SERVER_PARAMETERS zzdl(String str) {
        HashMap hashMap;
        try {
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            } else {
                hashMap = new HashMap(0);
            }
            Class<SERVER_PARAMETERS> serverParametersType = this.zzdpp.getServerParametersType();
            if (serverParametersType != null) {
                SERVER_PARAMETERS newInstance = serverParametersType.newInstance();
                newInstance.load(hashMap);
                return newInstance;
            }
            return null;
        } catch (Throwable th) {
            zzbao.zzc("", th);
            throw new RemoteException();
        }
    }

    private static boolean zzc(zzvq zzvqVar) {
        if (zzvqVar.zzcid) {
            return true;
        }
        zzww.zzqw();
        return zzbae.zzaap();
    }
}
