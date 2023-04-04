package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzavz implements MediationRewardedVideoAdListener {
    private final zzavu zzeat;

    public zzavz(zzavu zzavuVar) {
        this.zzeat = zzavuVar;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onInitializationSucceeded.");
        try {
            this.zzeat.zzag(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onInitializationFailed.");
        try {
            this.zzeat.zzd(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onAdLoaded.");
        try {
            this.zzeat.zzah(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onAdOpened.");
        try {
            this.zzeat.zzai(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onVideoStarted.");
        try {
            this.zzeat.zzaj(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onAdClosed.");
        try {
            this.zzeat.zzak(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onRewarded.");
        try {
            if (rewardItem != null) {
                this.zzeat.zza(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter), new zzavy(rewardItem));
            } else {
                this.zzeat.zza(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter), new zzavy("", 1));
            }
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onAdClicked.");
        try {
            this.zzeat.zzal(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onAdFailedToLoad.");
        try {
            this.zzeat.zze(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onAdLeftApplication.");
        try {
            this.zzeat.zzam(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void onVideoCompleted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onVideoCompleted.");
        try {
            this.zzeat.zzan(ObjectWrapper.wrap(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener
    public final void zzb(Bundle bundle) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbao.zzdz("Adapter called onAdMetadataChanged.");
        try {
            this.zzeat.zzb(bundle);
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }
}
