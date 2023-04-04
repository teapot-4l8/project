package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzawq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public class RewardedAd {
    private zzawq zzhvf;

    public static void load(Context context, String str, AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        Preconditions.checkNotNull(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        new zzawq(context, str).zza(adRequest.zzdt(), rewardedAdLoadCallback);
    }

    public static void load(Context context, String str, AdManagerAdRequest adManagerAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adManagerAdRequest, "AdManagerAdRequest cannot be null.");
        Preconditions.checkNotNull(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        new zzawq(context, str).zza(adManagerAdRequest.zzdt(), rewardedAdLoadCallback);
    }

    @Deprecated
    public RewardedAd(Context context, String str) {
        this.zzhvf = null;
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(str, "adUnitID cannot be null");
        this.zzhvf = new zzawq(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RewardedAd() {
        this.zzhvf = null;
    }

    @Deprecated
    public void loadAd(AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            zzawqVar.zza(adRequest.zzdt(), rewardedAdLoadCallback);
        }
    }

    @Deprecated
    public void loadAd(PublisherAdRequest publisherAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            zzawqVar.zza(publisherAdRequest.zzdt(), rewardedAdLoadCallback);
        }
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            return zzawqVar.getMediationAdapterClassName();
        }
        return null;
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            zzawqVar.setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            zzawqVar.setOnAdMetadataChangedListener(onAdMetadataChangedListener);
        }
    }

    public OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            return zzawqVar.getOnAdMetadataChangedListener();
        }
        return null;
    }

    public Bundle getAdMetadata() {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            return zzawqVar.getAdMetadata();
        }
        return new Bundle();
    }

    @Deprecated
    public boolean isLoaded() {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            return zzawqVar.isLoaded();
        }
        return false;
    }

    @Deprecated
    public void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            zzawqVar.show(activity, rewardedAdCallback);
        }
    }

    @Deprecated
    public void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            zzawqVar.show(activity, rewardedAdCallback, z);
        }
    }

    public void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            zzawqVar.show(activity, onUserEarnedRewardListener);
        }
    }

    public RewardItem getRewardItem() {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            return zzawqVar.getRewardItem();
        }
        return null;
    }

    public ResponseInfo getResponseInfo() {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            return zzawqVar.getResponseInfo();
        }
        return null;
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            zzawqVar.setOnPaidEventListener(onPaidEventListener);
        }
    }

    public OnPaidEventListener getOnPaidEventListener() {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            zzawqVar.getOnPaidEventListener();
            return null;
        }
        return null;
    }

    public void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            zzawqVar.setFullScreenContentCallback(fullScreenContentCallback);
        }
    }

    public FullScreenContentCallback getFullScreenContentCallback() {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            zzawqVar.getFullScreenContentCallback();
            return null;
        }
        return null;
    }

    public String getAdUnitId() {
        zzawq zzawqVar = this.zzhvf;
        return zzawqVar != null ? zzawqVar.getAdUnitId() : "";
    }

    public void setImmersiveMode(boolean z) {
        zzawq zzawqVar = this.zzhvf;
        if (zzawqVar != null) {
            zzawqVar.setImmersiveMode(z);
        }
    }
}
