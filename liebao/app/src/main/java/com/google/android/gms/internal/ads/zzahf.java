package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzahf implements Runnable {
    private final /* synthetic */ AdManagerAdView zzdhu;
    private final /* synthetic */ zzxq zzdhv;
    private final /* synthetic */ zzahc zzdhw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahf(zzahc zzahcVar, AdManagerAdView adManagerAdView, zzxq zzxqVar) {
        this.zzdhw = zzahcVar;
        this.zzdhu = adManagerAdView;
        this.zzdhv = zzxqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener;
        if (!this.zzdhu.zza(this.zzdhv)) {
            zzbao.zzez("Could not bind.");
            return;
        }
        onAdManagerAdViewLoadedListener = this.zzdhw.zzdhs;
        onAdManagerAdViewLoadedListener.onAdManagerAdViewLoaded(this.zzdhu);
    }
}
