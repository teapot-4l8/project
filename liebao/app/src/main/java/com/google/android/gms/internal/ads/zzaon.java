package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaon extends zzanr {
    private View view;
    private final Object zzdoy;
    private zzaov zzdoz;
    private zzavu zzdpa;
    private IObjectWrapper zzdpb;
    private MediationInterstitialAd zzdpc;
    private UnifiedNativeAdMapper zzdpd;
    private MediationRewardedAd zzdpe;
    private MediationInterscrollerAd zzdpf;
    private String zzdpg = "";

    public zzaon(MediationAdapter mediationAdapter) {
        this.zzdoy = mediationAdapter;
    }

    public zzaon(Adapter adapter) {
        this.zzdoy = adapter;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final IObjectWrapper zzve() {
        Object obj = this.zzdoy;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return ObjectWrapper.wrap(this.view);
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, zzvq zzvqVar, String str, zzant zzantVar) {
        zza(iObjectWrapper, zzvtVar, zzvqVar, str, null, zzantVar);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvt zzvtVar, zzvq zzvqVar, String str, String str2, zzant zzantVar) {
        AdSize zza;
        RemoteException remoteException;
        Object obj = this.zzdoy;
        if (!(obj instanceof MediationBannerAdapter) && !(obj instanceof Adapter)) {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
        zzbao.zzdz("Requesting banner ad from adapter.");
        if (zzvtVar.zzciy) {
            zza = com.google.android.gms.ads.zza.zzb(zzvtVar.width, zzvtVar.height);
        } else {
            zza = com.google.android.gms.ads.zza.zza(zzvtVar.width, zzvtVar.height, zzvtVar.zzadd);
        }
        AdSize adSize = zza;
        Object obj2 = this.zzdoy;
        if (obj2 instanceof MediationBannerAdapter) {
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) obj2;
                mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaov(zzantVar), zza(str, zzvqVar, str2), adSize, new zzaok(zzvqVar.zzcia == -1 ? null : new Date(zzvqVar.zzcia), zzvqVar.zzcib, zzvqVar.zzcic != null ? new HashSet(zzvqVar.zzcic) : null, zzvqVar.zzng, zzc(zzvqVar), zzvqVar.zzadv, zzvqVar.zzcim, zzvqVar.zzadw, zza(str, zzvqVar)), zzvqVar.zzcih != null ? zzvqVar.zzcih.getBundle(mediationBannerAdapter.getClass().getName()) : null);
            } finally {
            }
        } else if (obj2 instanceof Adapter) {
            try {
                ((Adapter) obj2).loadBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza(str, zzvqVar, str2), zzd(zzvqVar), zzc(zzvqVar), zzvqVar.zzng, zzvqVar.zzadv, zzvqVar.zzadw, zza(str, zzvqVar), adSize, this.zzdpg), new zzaoo(this, zzantVar));
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final Bundle zzvh() {
        Object obj = this.zzdoy;
        if (!(obj instanceof zzbhe)) {
            String canonicalName = zzbhe.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            return new Bundle();
        }
        return ((zzbhe) obj).zzvh();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzant zzantVar) {
        zza(iObjectWrapper, zzvqVar, str, (String) null, zzantVar);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, String str2, zzant zzantVar) {
        RemoteException remoteException;
        Object obj = this.zzdoy;
        if (!(obj instanceof MediationInterstitialAdapter) && !(obj instanceof Adapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
        zzbao.zzdz("Requesting interstitial ad from adapter.");
        Object obj2 = this.zzdoy;
        if (obj2 instanceof MediationInterstitialAdapter) {
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) obj2;
                mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaov(zzantVar), zza(str, zzvqVar, str2), new zzaok(zzvqVar.zzcia == -1 ? null : new Date(zzvqVar.zzcia), zzvqVar.zzcib, zzvqVar.zzcic != null ? new HashSet(zzvqVar.zzcic) : null, zzvqVar.zzng, zzc(zzvqVar), zzvqVar.zzadv, zzvqVar.zzcim, zzvqVar.zzadw, zza(str, zzvqVar)), zzvqVar.zzcih != null ? zzvqVar.zzcih.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
            } finally {
            }
        } else if (obj2 instanceof Adapter) {
            try {
                ((Adapter) obj2).loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza(str, zzvqVar, str2), zzd(zzvqVar), zzc(zzvqVar), zzvqVar.zzng, zzvqVar.zzadv, zzvqVar.zzadw, zza(str, zzvqVar), this.zzdpg), new zzaor(this, zzantVar));
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.zzdoy;
        if (!(obj instanceof zzbhf)) {
            String canonicalName = zzbhf.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            return new Bundle();
        }
        return ((zzbhf) obj).getInterstitialAdapterInfo();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, String str2, zzant zzantVar, zzaei zzaeiVar, List<String> list) {
        RemoteException remoteException;
        Object obj = this.zzdoy;
        if (!(obj instanceof MediationNativeAdapter) && !(obj instanceof Adapter)) {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
        zzbao.zzdz("Requesting native ad from adapter.");
        Object obj2 = this.zzdoy;
        if (obj2 instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj2;
                zzaoz zzaozVar = new zzaoz(zzvqVar.zzcia == -1 ? null : new Date(zzvqVar.zzcia), zzvqVar.zzcib, zzvqVar.zzcic != null ? new HashSet(zzvqVar.zzcic) : null, zzvqVar.zzng, zzc(zzvqVar), zzvqVar.zzadv, zzaeiVar, list, zzvqVar.zzcim, zzvqVar.zzadw, zza(str, zzvqVar));
                Bundle bundle = zzvqVar.zzcih != null ? zzvqVar.zzcih.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.zzdoz = new zzaov(zzantVar);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzdoz, zza(str, zzvqVar, str2), zzaozVar, bundle);
            } finally {
            }
        } else if (obj2 instanceof Adapter) {
            try {
                ((Adapter) obj2).loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza(str, zzvqVar, str2), zzd(zzvqVar), zzc(zzvqVar), zzvqVar.zzng, zzvqVar.zzadv, zzvqVar.zzadw, zza(str, zzvqVar), this.zzdpg, zzaeiVar), new zzaoq(this, zzantVar));
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final Bundle zzvi() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaob zzvf() {
        zzaov zzaovVar = this.zzdoz;
        if (zzaovVar != null) {
            NativeAdMapper zzvt = zzaovVar.zzvt();
            if (zzvt instanceof NativeAppInstallAdMapper) {
                return new zzaox((NativeAppInstallAdMapper) zzvt);
            }
            return null;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaoh zzvl() {
        UnifiedNativeAdMapper zzvu;
        Object obj = this.zzdoy;
        if (obj instanceof MediationNativeAdapter) {
            zzaov zzaovVar = this.zzdoz;
            if (zzaovVar == null || (zzvu = zzaovVar.zzvu()) == null) {
                return null;
            }
            return new zzapp(zzvu);
        } else if (!(obj instanceof Adapter) || this.zzdpd == null) {
            return null;
        } else {
            return new zzapp(this.zzdpd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaoc zzvg() {
        zzaov zzaovVar = this.zzdoz;
        if (zzaovVar != null) {
            NativeAdMapper zzvt = zzaovVar.zzvt();
            if (zzvt instanceof NativeContentAdMapper) {
                return new zzaow((NativeContentAdMapper) zzvt);
            }
            return null;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzafo zzvk() {
        zzaov zzaovVar = this.zzdoz;
        if (zzaovVar != null) {
            NativeCustomTemplateAd zzvv = zzaovVar.zzvv();
            if (zzvv instanceof zzaft) {
                return ((zzaft) zzvv).zzub();
            }
            return null;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final boolean zzvj() {
        return this.zzdoy instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzavu zzavuVar, String str2) {
        zzaok zzaokVar;
        Bundle bundle;
        Object obj = this.zzdoy;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbao.zzdz("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdoy;
                Bundle zza = zza(str2, zzvqVar, (String) null);
                if (zzvqVar != null) {
                    zzaok zzaokVar2 = new zzaok(zzvqVar.zzcia == -1 ? null : new Date(zzvqVar.zzcia), zzvqVar.zzcib, zzvqVar.zzcic != null ? new HashSet(zzvqVar.zzcic) : null, zzvqVar.zzng, zzc(zzvqVar), zzvqVar.zzadv, zzvqVar.zzcim, zzvqVar.zzadw, zza(str2, zzvqVar));
                    bundle = zzvqVar.zzcih != null ? zzvqVar.zzcih.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    zzaokVar = zzaokVar2;
                } else {
                    zzaokVar = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzaokVar, str, new zzavz(zzavuVar), zza, bundle);
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        } else if (!(obj instanceof Adapter)) {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        } else {
            this.zzdpb = iObjectWrapper;
            this.zzdpa = zzavuVar;
            zzavuVar.zzag(ObjectWrapper.wrap(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzavu zzavuVar, List<String> list) {
        if (!(this.zzdoy instanceof InitializableMediationRewardedVideoAdAdapter)) {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
        zzbao.zzdz("Initialize rewarded video adapter.");
        try {
            InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzdoy;
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                arrayList.add(zza(str, (zzvq) null, (String) null));
            }
            initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzavz(zzavuVar), arrayList);
        } catch (Throwable th) {
            zzbao.zzd("Could not initialize rewarded video adapter.", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(zzvq zzvqVar, String str) {
        zza(zzvqVar, str, (String) null);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(zzvq zzvqVar, String str, String str2) {
        Object obj = this.zzdoy;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbao.zzdz("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdoy;
                mediationRewardedVideoAdAdapter.loadAd(new zzaok(zzvqVar.zzcia == -1 ? null : new Date(zzvqVar.zzcia), zzvqVar.zzcib, zzvqVar.zzcic != null ? new HashSet(zzvqVar.zzcic) : null, zzvqVar.zzng, zzc(zzvqVar), zzvqVar.zzadv, zzvqVar.zzcim, zzvqVar.zzadw, zza(str, zzvqVar)), zza(str, zzvqVar, str2), zzvqVar.zzcih != null ? zzvqVar.zzcih.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null);
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        } else if (!(obj instanceof Adapter)) {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        } else {
            zzb(this.zzdpb, zzvqVar, str, new zzaou((Adapter) this.zzdoy, this.zzdpa));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void showVideo() {
        Object obj = this.zzdoy;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbao.zzdz("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzdoy).showVideo();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        } else if (!(obj instanceof Adapter)) {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        } else {
            MediationRewardedAd mediationRewardedAd = this.zzdpe;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzdpb));
            } else {
                zzbao.zzex("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final boolean isInitialized() {
        Object obj = this.zzdoy;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzbao.zzdz("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzdoy).isInitialized();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return this.zzdpa != null;
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzb(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzant zzantVar) {
        if (!(this.zzdoy instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
        zzbao.zzdz("Requesting rewarded ad from adapter.");
        try {
            ((Adapter) this.zzdoy).loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza(str, zzvqVar, (String) null), zzd(zzvqVar), zzc(zzvqVar), zzvqVar.zzng, zzvqVar.zzadv, zzvqVar.zzadw, zza(str, zzvqVar), ""), zza(zzantVar));
        } catch (Exception e2) {
            zzbao.zzc("", e2);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzc(IObjectWrapper iObjectWrapper, zzvq zzvqVar, String str, zzant zzantVar) {
        if (!(this.zzdoy instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
        zzbao.zzdz("Requesting rewarded interstitial ad from adapter.");
        try {
            ((Adapter) this.zzdoy).loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza(str, zzvqVar, (String) null), zzd(zzvqVar), zzc(zzvqVar), zzvqVar.zzng, zzvqVar.zzadv, zzvqVar.zzadw, zza(str, zzvqVar), ""), zza(zzantVar));
        } catch (Exception e2) {
            zzbao.zzc("", e2);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzb(IObjectWrapper iObjectWrapper, zzvt zzvtVar, zzvq zzvqVar, String str, String str2, zzant zzantVar) {
        if (!(this.zzdoy instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
        zzbao.zzdz("Requesting interscroller ad from adapter.");
        try {
            Adapter adapter = (Adapter) this.zzdoy;
            adapter.loadInterscrollerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza(str, zzvqVar, str2), zzd(zzvqVar), zzc(zzvqVar), zzvqVar.zzng, zzvqVar.zzadv, zzvqVar.zzadw, zza(str, zzvqVar), com.google.android.gms.ads.zza.zzc(zzvtVar.width, zzvtVar.height), ""), new zzaom(this, zzantVar, adapter));
        } catch (Exception e2) {
            zzbao.zzc("", e2);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzanu zzvo() {
        if (this.zzdpf != null) {
            return new zzaos(this.zzdpf);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzt(IObjectWrapper iObjectWrapper) {
        if (!(this.zzdoy instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
        zzbao.zzdz("Show rewarded ad from adapter.");
        MediationRewardedAd mediationRewardedAd = this.zzdpe;
        if (mediationRewardedAd != null) {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
        } else {
            zzbao.zzex("Can not show null mediation rewarded ad.");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void setImmersiveMode(boolean z) {
        Object obj = this.zzdoy;
        if (!(obj instanceof OnImmersiveModeUpdatedListener)) {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzdz(sb.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzbao.zzc("", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzzd getVideoController() {
        Object obj = this.zzdoy;
        if (obj instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) obj).getVideoController();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzu(IObjectWrapper iObjectWrapper) {
        Object obj = this.zzdoy;
        if (!(obj instanceof Adapter) && !(obj instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        } else if (this.zzdoy instanceof MediationInterstitialAdapter) {
            showInterstitial();
        } else {
            zzbao.zzdz("Show interstitial ad from adapter.");
            MediationInterstitialAd mediationInterstitialAd = this.zzdpc;
            if (mediationInterstitialAd != null) {
                mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzbao.zzex("Can not show null mediation interstitial ad.");
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void showInterstitial() {
        if (!(this.zzdoy instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdoy.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzbao.zzez(sb.toString());
            throw new RemoteException();
        }
        zzbao.zzdz("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.zzdoy).showInterstitial();
        } catch (Throwable th) {
            zzbao.zzc("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void destroy() {
        Object obj = this.zzdoy;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void pause() {
        Object obj = this.zzdoy;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void resume() {
        Object obj = this.zzdoy;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzbao.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzs(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zzdoy;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zza(IObjectWrapper iObjectWrapper, zzajo zzajoVar, List<zzajw> list) {
        AdFormat adFormat;
        if (!(this.zzdoy instanceof Adapter)) {
            throw new RemoteException();
        }
        zzaop zzaopVar = new zzaop(this, zzajoVar);
        ArrayList arrayList = new ArrayList();
        for (zzajw zzajwVar : list) {
            String str = zzajwVar.zzdke;
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
            } else {
                adFormat = c2 != 4 ? null : AdFormat.NATIVE;
            }
            if (adFormat != null) {
                arrayList.add(new MediationConfiguration(adFormat, zzajwVar.extras));
            }
        }
        ((Adapter) this.zzdoy).initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzaopVar, arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaqr zzvm() {
        Object obj = this.zzdoy;
        if (obj instanceof Adapter) {
            return zzaqr.zza(((Adapter) obj).getVersionInfo());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaqr zzvn() {
        Object obj = this.zzdoy;
        if (obj instanceof Adapter) {
            return zzaqr.zza(((Adapter) obj).getSDKVersionInfo());
        }
        return null;
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzant zzantVar) {
        return new zzaot(this, zzantVar);
    }

    private final Bundle zza(String str, zzvq zzvqVar, String str2) {
        String valueOf = String.valueOf(str);
        zzbao.zzdz(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
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
                bundle = bundle2;
            }
            if (this.zzdoy instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzvqVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzvqVar.zzadv);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
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
        return (zzvqVar.zzcih == null || (bundle = zzvqVar.zzcih.getBundle(this.zzdoy.getClass().getName())) == null) ? new Bundle() : bundle;
    }
}
