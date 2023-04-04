package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.instream.InstreamAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzakn extends zzakj {
    private final InstreamAd.InstreamAdLoadCallback zzdkj;

    public zzakn(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        this.zzdkj = instreamAdLoadCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void zza(zzaka zzakaVar) {
        this.zzdkj.onInstreamAdLoaded(new zzakl(zzakaVar));
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void onInstreamAdFailedToLoad(int i) {
        this.zzdkj.onInstreamAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzakg
    public final void zze(zzvh zzvhVar) {
        this.zzdkj.onInstreamAdFailedToLoad(zzvhVar.zzqi());
    }
}
