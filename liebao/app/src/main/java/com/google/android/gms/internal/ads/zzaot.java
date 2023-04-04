package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaot implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzant zzdov;
    private final /* synthetic */ zzaon zzdox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaot(zzaon zzaonVar, zzant zzantVar) {
        this.zzdox = zzaonVar;
        this.zzdov = zzantVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            this.zzdox.zzdpe = mediationRewardedAd;
            this.zzdov.onAdLoaded();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
        return new zzawy(this.zzdov);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        Object obj;
        try {
            obj = this.zzdox.zzdoy;
            String canonicalName = obj.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 31 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ");
            sb.append(str);
            zzbao.zzdz(sb.toString());
            this.zzdov.zzc(0, str);
            this.zzdov.onAdFailedToLoad(0);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
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
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 85 + String.valueOf(message).length() + String.valueOf(domain).length());
            sb.append(canonicalName);
            sb.append("failed to load mediation ad: ErrorCode = ");
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
