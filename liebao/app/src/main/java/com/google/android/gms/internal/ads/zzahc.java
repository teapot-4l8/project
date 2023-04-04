package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.formats.OnAdManagerAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzahc extends zzagj {
    private final OnAdManagerAdViewLoadedListener zzdhs;

    public zzahc(OnAdManagerAdViewLoadedListener onAdManagerAdViewLoadedListener) {
        this.zzdhs = onAdManagerAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzagg
    public final void zza(zzxq zzxqVar, IObjectWrapper iObjectWrapper) {
        if (zzxqVar == null || iObjectWrapper == null) {
            return;
        }
        AdManagerAdView adManagerAdView = new AdManagerAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
        try {
            if (zzxqVar.zzko() instanceof zzvj) {
                zzvj zzvjVar = (zzvj) zzxqVar.zzko();
                adManagerAdView.setAdListener(zzvjVar != null ? zzvjVar.getAdListener() : null);
            }
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
        try {
            if (zzxqVar.zzkn() instanceof zzrl) {
                zzrl zzrlVar = (zzrl) zzxqVar.zzkn();
                adManagerAdView.setAppEventListener(zzrlVar != null ? zzrlVar.getAppEventListener() : null);
            }
        } catch (RemoteException e3) {
            zzbao.zzc("", e3);
        }
        zzbae.zzaah.post(new zzahf(this, adManagerAdView, zzxqVar));
    }
}
