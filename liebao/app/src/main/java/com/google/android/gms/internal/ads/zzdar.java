package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdar {
    private final zzczm zzgcc;
    private final zzcdy zzhbw;
    private final zzbsz zzhbx;

    public zzdar(zzcdy zzcdyVar, zzdtw zzdtwVar) {
        this.zzhbw = zzcdyVar;
        final zzczm zzczmVar = new zzczm(zzdtwVar);
        this.zzgcc = zzczmVar;
        final zzakg zzaph = this.zzhbw.zzaph();
        this.zzhbx = new zzbsz(zzczmVar, zzaph) { // from class: com.google.android.gms.internal.ads.zzdaq
            private final zzczm zzhbu;
            private final zzakg zzhbv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhbu = zzczmVar;
                this.zzhbv = zzaph;
            }

            @Override // com.google.android.gms.internal.ads.zzbsz
            public final void zzd(zzvh zzvhVar) {
                zzczm zzczmVar2 = this.zzhbu;
                zzakg zzakgVar = this.zzhbv;
                zzczmVar2.zzd(zzvhVar);
                if (zzakgVar != null) {
                    try {
                        zzakgVar.zze(zzvhVar);
                    } catch (RemoteException e2) {
                        zzbao.zze("#007 Could not call remote method.", e2);
                    }
                }
                if (zzakgVar != null) {
                    try {
                        zzakgVar.onInstreamAdFailedToLoad(zzvhVar.errorCode);
                    } catch (RemoteException e3) {
                        zzbao.zze("#007 Could not call remote method.", e3);
                    }
                }
            }
        };
    }

    public final void zzd(zzxc zzxcVar) {
        this.zzgcc.zzc(zzxcVar);
    }

    public final zzccb zzatk() {
        return new zzccb(this.zzhbw, this.zzgcc.zzate());
    }

    public final zzczm zzatl() {
        return this.zzgcc;
    }

    public final zzbuj zzatm() {
        return this.zzgcc;
    }

    public final zzbsz zzatn() {
        return this.zzhbx;
    }
}
