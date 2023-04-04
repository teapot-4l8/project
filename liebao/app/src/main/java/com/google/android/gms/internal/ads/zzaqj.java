package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaqj extends zzaqd {
    private MediationInterstitialAd zzdpc;
    private MediationRewardedAd zzdpe;
    private String zzdpg = "";
    private final RtbAdapter zzdqb;

    public zzaqj(RtbAdapter rtbAdapter) {
        this.zzdqb = rtbAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zzz(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapo zzapoVar, zzant zzantVar, zzvt zzvtVar) {
        try {
            this.zzdqb.loadRtbBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvqVar), zzc(zzvqVar), zzvqVar.zzng, zzvqVar.zzadv, zzvqVar.zzadw, zza(str2, zzvqVar), com.google.android.gms.ads.zza.zza(zzvtVar.width, zzvtVar.height, zzvtVar.zzadd), this.zzdpg), new zzaqi(this, zzapoVar, zzantVar));
        } catch (Throwable th) {
            zzbao.zzc("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zzb(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapo zzapoVar, zzant zzantVar, zzvt zzvtVar) {
        try {
            this.zzdqb.loadRtbInterscrollerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvqVar), zzc(zzvqVar), zzvqVar.zzng, zzvqVar.zzadv, zzvqVar.zzadw, zza(str2, zzvqVar), com.google.android.gms.ads.zza.zza(zzvtVar.width, zzvtVar.height, zzvtVar.zzadd), this.zzdpg), new zzaql(this, zzapoVar, zzantVar));
        } catch (Throwable th) {
            zzbao.zzc("Adapter failed to render interscroller ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapt zzaptVar, zzant zzantVar) {
        try {
            this.zzdqb.loadRtbInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvqVar), zzc(zzvqVar), zzvqVar.zzng, zzvqVar.zzadv, zzvqVar.zzadw, zza(str2, zzvqVar), this.zzdpg), new zzaqk(this, zzaptVar, zzantVar));
        } catch (Throwable th) {
            zzbao.zzc("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapz zzapzVar, zzant zzantVar) {
        try {
            this.zzdqb.loadRtbRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvqVar), zzc(zzvqVar), zzvqVar.zzng, zzvqVar.zzadv, zzvqVar.zzadw, zza(str2, zzvqVar), this.zzdpg), zza(zzapzVar, zzantVar));
        } catch (Throwable th) {
            zzbao.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zzb(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapz zzapzVar, zzant zzantVar) {
        try {
            this.zzdqb.loadRtbRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvqVar), zzc(zzvqVar), zzvqVar.zzng, zzvqVar.zzadv, zzvqVar.zzadw, zza(str2, zzvqVar), this.zzdpg), zza(zzapzVar, zzantVar));
        } catch (Throwable th) {
            zzbao.zzc("Adapter failed to render rewarded interstitial ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapu zzapuVar, zzant zzantVar) {
        zza(str, str2, zzvqVar, iObjectWrapper, zzapuVar, zzantVar, (zzaei) null);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(String str, String str2, zzvq zzvqVar, IObjectWrapper iObjectWrapper, zzapu zzapuVar, zzant zzantVar, zzaei zzaeiVar) {
        try {
            this.zzdqb.loadRtbNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvqVar), zzc(zzvqVar), zzvqVar.zzng, zzvqVar.zzadv, zzvqVar.zzadw, zza(str2, zzvqVar), this.zzdpg, zzaeiVar), new zzaqn(this, zzapuVar, zzantVar));
        } catch (Throwable th) {
            zzbao.zzc("Adapter failed to render native ad.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final boolean zzaa(IObjectWrapper iObjectWrapper) {
        MediationInterstitialAd mediationInterstitialAd = this.zzdpc;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbao.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final boolean zzab(IObjectWrapper iObjectWrapper) {
        MediationRewardedAd mediationRewardedAd = this.zzdpe;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzbao.zzc("", th);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final zzzd getVideoController() {
        RtbAdapter rtbAdapter = this.zzdqb;
        if (rtbAdapter instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) rtbAdapter).getVideoController();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvt zzvtVar, zzaqf zzaqfVar) {
        AdFormat adFormat;
        try {
            zzaqm zzaqmVar = new zzaqm(this, zzaqfVar);
            RtbAdapter rtbAdapter = this.zzdqb;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals("banner")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1052618729:
                    if (str.equals("native")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 604727084:
                    if (str.equals("interstitial")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1911491517:
                    if (str.equals("rewarded_interstitial")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                adFormat = AdFormat.BANNER;
            } else if (c2 == 1) {
                adFormat = AdFormat.INTERSTITIAL;
            } else if (c2 == 2) {
                adFormat = AdFormat.REWARDED;
            } else if (c2 == 3) {
                adFormat = AdFormat.REWARDED_INTERSTITIAL;
            } else if (c2 == 4) {
                adFormat = AdFormat.NATIVE;
            } else {
                throw new IllegalArgumentException("Internal Error");
            }
            MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediationConfiguration);
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList, bundle, com.google.android.gms.ads.zza.zza(zzvtVar.width, zzvtVar.height, zzvtVar.zzadd)), zzaqmVar);
        } catch (Throwable th) {
            zzbao.zzc("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final zzaqr zzvm() {
        return zzaqr.zza(this.zzdqb.getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final zzaqr zzvn() {
        return zzaqr.zza(this.zzdqb.getSDKVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final void zzdn(String str) {
        this.zzdpg = str;
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzapz zzapzVar, zzant zzantVar) {
        return new zzaqp(this, zzapzVar, zzantVar);
    }

    private static Bundle zzdq(String str) {
        String valueOf = String.valueOf(str);
        zzbao.zzez(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                return bundle2;
            }
            return bundle;
        } catch (JSONException e2) {
            zzbao.zzc("", e2);
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

    private static String zza(String str, zzvq zzvqVar) {
        String str2 = zzvqVar.zzadx;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }

    private final Bundle zzd(zzvq zzvqVar) {
        Bundle bundle;
        return (zzvqVar.zzcih == null || (bundle = zzvqVar.zzcih.getBundle(this.zzdqb.getClass().getName())) == null) ? new Bundle() : bundle;
    }
}
