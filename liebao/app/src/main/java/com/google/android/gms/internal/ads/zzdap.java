package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdap {
    private zzzc zzaec;
    private boolean zzafk = false;
    private final String zzbvf;
    private final zzdat<zzbpc> zzhbt;

    public zzdap(zzdat<zzbpc> zzdatVar, String str) {
        this.zzhbt = zzdatVar;
        this.zzbvf = str;
    }

    public final synchronized boolean isLoading() {
        return this.zzhbt.isLoading();
    }

    public final synchronized void zza(zzvq zzvqVar, int i) {
        this.zzaec = null;
        this.zzafk = this.zzhbt.zza(zzvqVar, this.zzbvf, new zzdau(i), new zzdao(this));
    }

    public final synchronized String getMediationAdapterClassName() {
        try {
            if (this.zzaec != null) {
                return this.zzaec.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final synchronized String zzkl() {
        try {
            if (this.zzaec != null) {
                return this.zzaec.getMediationAdapterClassName();
            }
            return null;
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }
}
