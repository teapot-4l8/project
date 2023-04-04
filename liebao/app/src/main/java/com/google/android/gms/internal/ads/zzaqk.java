package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzaqk implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    private final /* synthetic */ zzant zzdqa;
    private final /* synthetic */ zzapt zzdqc;
    private final /* synthetic */ zzaqj zzdqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqk(zzaqj zzaqjVar, zzapt zzaptVar, zzant zzantVar) {
        this.zzdqd = zzaqjVar;
        this.zzdqc = zzaptVar;
        this.zzdqa = zzantVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        if (mediationInterstitialAd == null) {
            zzbao.zzez("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdqc.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e2) {
                zzbao.zzc("", e2);
                return null;
            }
        }
        try {
            this.zzdqd.zzdpc = mediationInterstitialAd;
            this.zzdqc.zzvy();
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
            this.zzdqc.zzg(adError.zzdr());
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
