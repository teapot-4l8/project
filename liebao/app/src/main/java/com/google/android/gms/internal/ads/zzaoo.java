package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaoo implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzant zzdov;
    private final /* synthetic */ zzaon zzdox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaoo(zzaon zzaonVar, zzant zzantVar) {
        this.zzdox = zzaonVar;
        this.zzdov = zzantVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        try {
            this.zzdox.view = mediationBannerAd.getView();
            this.zzdov.onAdLoaded();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
        return new zzaol(this.zzdov);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        onFailure(new AdError(0, str, AdError.UNDEFINED_DOMAIN));
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        Object obj;
        try {
            obj = this.zzdox.zzdoy;
            String canonicalName = obj.getClass().getCanonicalName();
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 87 + String.valueOf(message).length() + String.valueOf(domain).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ErrorCode = ");
            sb.append(code);
            sb.append(". ErrorMessage = ");
            sb.append(message);
            sb.append(". ErrorDomain = ");
            sb.append(domain);
            zzbao.zzdz(sb.toString());
            this.zzdov.zzc(adError.zzdr());
            this.zzdov.zzc(adError.getCode(), adError.getMessage());
            this.zzdov.onAdFailedToLoad(adError.getCode());
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
