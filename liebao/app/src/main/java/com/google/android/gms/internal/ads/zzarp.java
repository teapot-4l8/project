package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeCustomFormatAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzarp {
    private final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zzdrz;
    private final NativeCustomFormatAd.OnCustomClickListener zzdsa;
    private NativeCustomFormatAd zzdsb;

    public zzarp(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        this.zzdrz = onCustomFormatAdLoadedListener;
        this.zzdsa = onCustomClickListener;
    }

    public final zzagd zzwd() {
        return new zzarq(this);
    }

    public final zzafy zzug() {
        if (this.zzdsa == null) {
            return null;
        }
        return new zzarr(this);
    }

    public final synchronized NativeCustomFormatAd zzc(zzafo zzafoVar) {
        if (this.zzdsb != null) {
            return this.zzdsb;
        }
        zzart zzartVar = new zzart(zzafoVar);
        this.zzdsb = zzartVar;
        return zzartVar;
    }
}
