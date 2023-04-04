package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzzq extends zzwv {
    private final /* synthetic */ zzzn zzclf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzzq(zzzn zzznVar) {
        this.zzclf = zzznVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwv, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        VideoController videoController;
        videoController = this.zzclf.zzcks;
        videoController.zza(this.zzclf.zzdz());
        super.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzwv, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i) {
        VideoController videoController;
        videoController = this.zzclf.zzcks;
        videoController.zza(this.zzclf.zzdz());
        super.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzwv, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        VideoController videoController;
        videoController = this.zzclf.zzcks;
        videoController.zza(this.zzclf.zzdz());
        super.onAdFailedToLoad(loadAdError);
    }
}
