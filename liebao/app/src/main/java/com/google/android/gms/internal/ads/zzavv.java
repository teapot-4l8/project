package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzavv implements RewardedVideoAd {
    private final Context context;
    private final zzavg zzeap;
    private String zzear;
    private String zzeas;
    private final Object lock = new Object();
    private final zzavq zzeaq = new zzavq(null);

    public zzavv(Context context, zzavg zzavgVar) {
        this.zzeap = zzavgVar == null ? new zzaap() : zzavgVar;
        this.context = context.getApplicationContext();
    }

    private final void zza(String str, zzzl zzzlVar) {
        synchronized (this.lock) {
            if (this.zzeap == null) {
                return;
            }
            try {
                this.zzeap.zza(zzvr.zza(this.context, zzzlVar, str));
            } catch (RemoteException e2) {
                zzbao.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, AdRequest adRequest) {
        zza(str, adRequest.zzdt());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        zza(str, publisherAdRequest.zzdt());
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void show() {
        synchronized (this.lock) {
            if (this.zzeap == null) {
                return;
            }
            try {
                this.zzeap.show();
            } catch (RemoteException e2) {
                zzbao.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.lock) {
            this.zzeaq.setRewardedVideoAdListener(rewardedVideoAdListener);
            if (this.zzeap != null) {
                try {
                    this.zzeap.zza(this.zzeaq);
                } catch (RemoteException e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.lock) {
            if (this.zzeap != null) {
                try {
                    this.zzeap.zza(new zzvn(adMetadataListener));
                } catch (RemoteException e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final Bundle getAdMetadata() {
        synchronized (this.lock) {
            if (this.zzeap != null) {
                try {
                    return this.zzeap.getAdMetadata();
                } catch (RemoteException e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
            return new Bundle();
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setUserId(String str) {
        synchronized (this.lock) {
            this.zzear = str;
            if (this.zzeap != null) {
                try {
                    this.zzeap.setUserId(str);
                } catch (RemoteException e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final boolean isLoaded() {
        synchronized (this.lock) {
            if (this.zzeap == null) {
                return false;
            }
            try {
                return this.zzeap.isLoaded();
            } catch (RemoteException e2) {
                zzbao.zze("#007 Could not call remote method.", e2);
                return false;
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause() {
        pause(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void pause(Context context) {
        synchronized (this.lock) {
            if (this.zzeap == null) {
                return;
            }
            try {
                this.zzeap.zzj(ObjectWrapper.wrap(context));
            } catch (RemoteException e2) {
                zzbao.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume() {
        resume(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void resume(Context context) {
        synchronized (this.lock) {
            if (this.zzeap == null) {
                return;
            }
            try {
                this.zzeap.zzk(ObjectWrapper.wrap(context));
            } catch (RemoteException e2) {
                zzbao.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy() {
        destroy(null);
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void destroy(Context context) {
        synchronized (this.lock) {
            this.zzeaq.setRewardedVideoAdListener(null);
            if (this.zzeap == null) {
                return;
            }
            try {
                this.zzeap.zzl(ObjectWrapper.wrap(context));
            } catch (RemoteException e2) {
                zzbao.zze("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.lock) {
            rewardedVideoAdListener = this.zzeaq.getRewardedVideoAdListener();
        }
        return rewardedVideoAdListener;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getUserId() {
        String str;
        synchronized (this.lock) {
            str = this.zzear;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getMediationAdapterClassName() {
        try {
            if (this.zzeap != null) {
                return this.zzeap.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setImmersiveMode(boolean z) {
        synchronized (this.lock) {
            if (this.zzeap != null) {
                try {
                    this.zzeap.setImmersiveMode(z);
                } catch (RemoteException e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final void setCustomData(String str) {
        synchronized (this.lock) {
            if (this.zzeap != null) {
                try {
                    this.zzeap.setCustomData(str);
                    this.zzeas = str;
                } catch (RemoteException e2) {
                    zzbao.zze("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final String getCustomData() {
        String str;
        synchronized (this.lock) {
            str = this.zzeas;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.reward.RewardedVideoAd
    public final ResponseInfo getResponseInfo() {
        zzzc zzzcVar = null;
        try {
            if (this.zzeap != null) {
                zzzcVar = this.zzeap.zzkm();
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
        return ResponseInfo.zza(zzzcVar);
    }
}
