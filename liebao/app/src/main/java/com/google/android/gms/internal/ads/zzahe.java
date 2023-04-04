package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzahe extends zzafv {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzdht;

    public zzahe(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzdht = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafs
    public final void zza(zzafg zzafgVar) {
        this.zzdht.onAppInstallAdLoaded(new zzafl(zzafgVar));
    }
}
