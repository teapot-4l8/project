package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzaom implements MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzant zzdov;
    private final /* synthetic */ Adapter zzdow;
    private final /* synthetic */ zzaon zzdox;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaom(zzaon zzaonVar, zzant zzantVar, Adapter adapter) {
        this.zzdox = zzaonVar;
        this.zzdov = zzantVar;
        this.zzdow = adapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza */
    public final MediationBannerAdCallback onSuccess(MediationInterscrollerAd mediationInterscrollerAd) {
        try {
            this.zzdox.zzdpf = mediationInterscrollerAd;
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
        try {
            String canonicalName = this.zzdow.getClass().getCanonicalName();
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
