package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzahg extends zzagj {
    private final OnPublisherAdViewLoadedListener zzdhx;

    public zzahg(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzdhx = onPublisherAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void zza(zzxq zzxqVar, IObjectWrapper iObjectWrapper) {
        if (zzxqVar == null || iObjectWrapper == null) {
            return;
        }
        PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
        try {
            if (zzxqVar.zzko() instanceof zzvj) {
                zzvj zzvjVar = (zzvj) zzxqVar.zzko();
                publisherAdView.setAdListener(zzvjVar != null ? zzvjVar.getAdListener() : null);
            }
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
        try {
            if (zzxqVar.zzkn() instanceof zzvz) {
                zzvz zzvzVar = (zzvz) zzxqVar.zzkn();
                publisherAdView.setAppEventListener(zzvzVar != null ? zzvzVar.getAppEventListener() : null);
            }
        } catch (RemoteException e3) {
            zzbao.zzc("", e3);
        }
        zzbae.zzaah.post(new zzahj(this, publisherAdView, zzxqVar));
    }
}
