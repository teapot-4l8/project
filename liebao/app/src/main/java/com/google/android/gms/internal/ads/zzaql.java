package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzaql implements MediationAdLoadCallback<MediationInterscrollerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzapo zzdpz;
    private final /* synthetic */ zzant zzdqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaql(zzaqj zzaqjVar, zzapo zzapoVar, zzant zzantVar) {
        this.zzdpz = zzapoVar;
        this.zzdqa = zzantVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    /* renamed from: zza */
    public final MediationBannerAdCallback onSuccess(MediationInterscrollerAd mediationInterscrollerAd) {
        if (mediationInterscrollerAd == null) {
            zzbao.zzez("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdpz.zzdm("Adapter returned null.");
                return null;
            } catch (RemoteException e2) {
                zzbao.zzc("", e2);
                return null;
            }
        }
        try {
            this.zzdpz.zza(new zzaos(mediationInterscrollerAd));
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
            this.zzdpz.zzg(adError.zzdr());
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
