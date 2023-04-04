package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzakp {
    private final Context context;
    private final zzxj zzacx;

    public zzakp(Context context, String str) {
        this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzww.zzqx().zzb(context, str, new zzank()));
    }

    private zzakp(Context context, zzxj zzxjVar) {
        this.context = context;
        this.zzacx = zzxjVar;
    }

    public final zzakp zza(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        try {
            this.zzacx.zza(new zzakn(instreamAdLoadCallback));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
        return this;
    }

    public final zzakp zza(zzakk zzakkVar) {
        try {
            this.zzacx.zza(new zzajy(zzakkVar));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
        return this;
    }

    public final zzakm zzus() {
        try {
            return new zzakm(this.context, this.zzacx.zzrf());
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }
}
