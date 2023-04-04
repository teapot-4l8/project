package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zztb {
    private final Context context;
    private final int orientation;
    private final zzzl zzadb;
    private final String zzbvf;
    private zzxq zzbvo;
    private final AppOpenAd.AppOpenAdLoadCallback zzbvp;
    private final zzank zzbvq = new zzank();
    private final zzvr zzacy = zzvr.zzciq;

    public zztb(Context context, String str, zzzl zzzlVar, int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.context = context;
        this.zzbvf = str;
        this.zzadb = zzzlVar;
        this.orientation = i;
        this.zzbvp = appOpenAdLoadCallback;
    }

    public final void zznb() {
        try {
            this.zzbvo = zzww.zzqx().zza(this.context, zzvt.zzqm(), this.zzbvf, this.zzbvq);
            this.zzbvo.zza(new zzwc(this.orientation));
            this.zzbvo.zza(new zzsl(this.zzbvp, this.zzbvf));
            this.zzbvo.zza(zzvr.zza(this.context, this.zzadb));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }
}
