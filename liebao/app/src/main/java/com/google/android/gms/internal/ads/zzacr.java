package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzacr extends zzacp {
    private final OnCustomRenderedAdLoadedListener zzckv;

    public zzacr(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzckv = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zza(zzacl zzaclVar) {
        this.zzckv.onCustomRenderedAdLoaded(new zzaci(zzaclVar));
    }
}
