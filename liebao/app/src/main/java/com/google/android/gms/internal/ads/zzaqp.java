package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaqp implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzant zzdqa;
    private final /* synthetic */ zzaqj zzdqd;
    private final /* synthetic */ zzapz zzdqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqp(zzaqj zzaqjVar, zzapz zzapzVar, zzant zzantVar) {
        this.zzdqd = zzaqjVar;
        this.zzdqg = zzapzVar;
        this.zzdqa = zzantVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        if (mediationRewardedAd == null) {
            zzbao.zzez("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdqg.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e2) {
                zzbao.zzc("", e2);
                return null;
            }
        }
        try {
            this.zzdqd.zzdpe = mediationRewardedAd;
            this.zzdqg.zzvy();
        } catch (RemoteException e3) {
            zzbao.zzc("", e3);
        }
        return new zzaqo(this.zzdqa);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        onFailure(new AdError(0, str, AdError.UNDEFINED_DOMAIN));
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        try {
            this.zzdqg.zzg(adError.zzdr());
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
