package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzzp {
    private final Context context;
    private final zzvr zzacy;
    private AppEventListener zzboo;
    private String zzbvf;
    private OnPaidEventListener zzbvk;
    private zzxq zzbvo;
    private final zzank zzbvq;
    private zzve zzchr;
    private AdListener zzchw;
    private AdMetadataListener zzchz;
    private OnCustomRenderedAdLoadedListener zzckv;
    private RewardedVideoAdListener zzclc;
    private boolean zzcld;
    private Boolean zzcle;

    public zzzp(Context context) {
        this(context, zzvr.zzciq, null);
    }

    public zzzp(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzvr.zzciq, publisherInterstitialAd);
    }

    private zzzp(Context context, zzvr zzvrVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzbvq = new zzank();
        this.context = context;
        this.zzacy = zzvrVar;
    }

    public final AdListener getAdListener() {
        return this.zzchw;
    }

    public final String getAdUnitId() {
        return this.zzbvf;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzboo;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzckv;
    }

    public final boolean isLoaded() {
        try {
            if (this.zzbvo == null) {
                return false;
            }
            return this.zzbvo.isReady();
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzbvo == null) {
                return false;
            }
            return this.zzbvo.isLoading();
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            return false;
        }
    }

    public final void zza(zzzl zzzlVar) {
        try {
            if (this.zzbvo == null) {
                if (this.zzbvf == null) {
                    zzcn("loadAd");
                }
                zzxq zzb = zzww.zzqx().zzb(this.context, this.zzcld ? zzvt.zzql() : new zzvt(), this.zzbvf, this.zzbvq);
                this.zzbvo = zzb;
                if (this.zzchw != null) {
                    zzb.zza(new zzvj(this.zzchw));
                }
                if (this.zzchr != null) {
                    this.zzbvo.zza(new zzvg(this.zzchr));
                }
                if (this.zzchz != null) {
                    this.zzbvo.zza(new zzvn(this.zzchz));
                }
                if (this.zzboo != null) {
                    this.zzbvo.zza(new zzvz(this.zzboo));
                }
                if (this.zzckv != null) {
                    this.zzbvo.zza(new zzacr(this.zzckv));
                }
                if (this.zzclc != null) {
                    this.zzbvo.zza(new zzavq(this.zzclc));
                }
                this.zzbvo.zza(new zzaaq(this.zzbvk));
                if (this.zzcle != null) {
                    this.zzbvo.setImmersiveMode(this.zzcle.booleanValue());
                }
            }
            if (this.zzbvo.zza(zzvr.zza(this.context, zzzlVar))) {
                this.zzbvq.zzf(zzzlVar.zzrq());
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzchw = adListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza(adListener != null ? new zzvj(adListener) : null);
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(zzve zzveVar) {
        try {
            this.zzchr = zzveVar;
            if (this.zzbvo != null) {
                this.zzbvo.zza(zzveVar != null ? new zzvg(zzveVar) : null);
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzbvf != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzbvf = str;
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        try {
            this.zzchz = adMetadataListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza(adMetadataListener != null ? new zzvn(adMetadataListener) : null);
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    public final Bundle getAdMetadata() {
        try {
            if (this.zzbvo != null) {
                return this.zzbvo.getAdMetadata();
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
        return new Bundle();
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzboo = appEventListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza(appEventListener != null ? new zzvz(appEventListener) : null);
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzckv = onCustomRenderedAdLoadedListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza(onCustomRenderedAdLoadedListener != null ? new zzacr(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzclc = rewardedVideoAdListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza(rewardedVideoAdListener != null ? new zzavq(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zze(boolean z) {
        this.zzcld = true;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbvo != null) {
                return this.zzbvo.zzkl();
            }
            return null;
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

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

    public final void show() {
        try {
            zzcn("show");
            this.zzbvo.showInterstitial();
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzcle = Boolean.valueOf(z);
            if (this.zzbvo != null) {
                this.zzbvo.setImmersiveMode(z);
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzbvk = onPaidEventListener;
            if (this.zzbvo != null) {
                this.zzbvo.zza(new zzaaq(onPaidEventListener));
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    private final void zzcn(String str) {
        if (this.zzbvo != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
        sb.append("The ad unit ID must be set on InterstitialAd before ");
        sb.append(str);
        sb.append(" is called.");
        throw new IllegalStateException(sb.toString());
    }
}
