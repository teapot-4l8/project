package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbqr implements zzbsy, zzbtq, zzbuj, zzbvm, zzve {
    private final Clock zzbqq;
    private final zzazr zzfzw;

    public zzbqr(Clock clock, zzazr zzazrVar) {
        this.zzbqq = clock;
        this.zzfzw = zzazrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzb(zzavd zzavdVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzauj zzaujVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void onAdClicked() {
        this.zzfzw.zzyc();
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        this.zzfzw.zzar(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void onAdImpression() {
        this.zzfzw.zzyb();
    }

    public final void zzf(zzvq zzvqVar) {
        this.zzfzw.zze(zzvqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzdpi zzdpiVar) {
        this.zzfzw.zzey(this.zzbqq.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void onAdClosed() {
        this.zzfzw.zzyd();
    }

    public final String zzye() {
        return this.zzfzw.zzye();
    }
}
