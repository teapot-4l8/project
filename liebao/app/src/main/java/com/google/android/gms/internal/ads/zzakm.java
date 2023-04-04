package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzakm {
    private final Context context;
    private final zzvr zzacy;
    private final zzxi zzacz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakm(Context context, zzxi zzxiVar) {
        this(context, zzxiVar, zzvr.zzciq);
    }

    private zzakm(Context context, zzxi zzxiVar, zzvr zzvrVar) {
        this.context = context;
        this.zzacz = zzxiVar;
        this.zzacy = zzvrVar;
    }

    private final void zza(zzzl zzzlVar) {
        try {
            this.zzacz.zzb(zzvr.zza(this.context, zzzlVar));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdt());
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdt());
    }
}
