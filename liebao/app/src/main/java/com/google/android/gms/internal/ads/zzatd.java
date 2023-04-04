package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public class zzatd {
    private static zzazc zzduy;
    private final Context context;
    private final zzzl zzadb;
    private final AdFormat zzdux;

    public static zzazc zzp(Context context) {
        zzazc zzazcVar;
        synchronized (zzatd.class) {
            if (zzduy == null) {
                zzduy = zzww.zzqx().zza(context, new zzank());
            }
            zzazcVar = zzduy;
        }
        return zzazcVar;
    }

    public zzatd(Context context, AdFormat adFormat, zzzl zzzlVar) {
        this.context = context;
        this.zzdux = adFormat;
        this.zzadb = zzzlVar;
    }

    public final void zza(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzvq zza;
        zzazc zzp = zzp(this.context);
        if (zzp == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        IObjectWrapper wrap = ObjectWrapper.wrap(this.context);
        zzzl zzzlVar = this.zzadb;
        if (zzzlVar == null) {
            zza = new zzvp().zzqj();
        } else {
            zza = zzvr.zza(this.context, zzzlVar);
        }
        try {
            zzp.zza(wrap, new zzazi(null, this.zzdux.name(), null, zza), new zzatc(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
