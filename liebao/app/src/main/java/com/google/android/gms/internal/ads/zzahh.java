package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzahh extends zzafw {
    private final NativeContentAd.OnContentAdLoadedListener zzdhy;

    public zzahh(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzdhy = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafx
    public final void zza(zzafk zzafkVar) {
        this.zzdhy.onContentAdLoaded(new zzafp(zzafkVar));
    }
}
