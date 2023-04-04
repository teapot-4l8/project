package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzagy {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzdho;
    private final NativeCustomTemplateAd.OnCustomClickListener zzdhp;
    private NativeCustomTemplateAd zzdhq;

    public zzagy(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzdho = onCustomTemplateAdLoadedListener;
        this.zzdhp = onCustomClickListener;
    }

    public final zzagd zzuf() {
        return new zzahd(this);
    }

    public final zzafy zzug() {
        if (this.zzdhp == null) {
            return null;
        }
        return new zzaha(this);
    }

    public final synchronized NativeCustomTemplateAd zzb(zzafo zzafoVar) {
        if (this.zzdhq != null) {
            return this.zzdhq;
        }
        zzaft zzaftVar = new zzaft(zzafoVar);
        this.zzdhq = zzaftVar;
        return zzaftVar;
    }
}
