package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzahj implements Runnable {
    private final /* synthetic */ zzxq zzdhv;
    private final /* synthetic */ PublisherAdView zzdia;
    private final /* synthetic */ zzahg zzdib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahj(zzahg zzahgVar, PublisherAdView publisherAdView, zzxq zzxqVar) {
        this.zzdib = zzahgVar;
        this.zzdia = publisherAdView;
        this.zzdhv = zzxqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener;
        if (!this.zzdia.zza(this.zzdhv)) {
            zzbao.zzez("Could not bind.");
            return;
        }
        onPublisherAdViewLoadedListener = this.zzdib.zzdhx;
        onPublisherAdViewLoadedListener.onPublisherAdViewLoaded(this.zzdia);
    }
}
