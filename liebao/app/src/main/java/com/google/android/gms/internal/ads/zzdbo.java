package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdbo implements zzebi<zzdcb> {
    private final /* synthetic */ zzazb zzhcr;
    private final /* synthetic */ zzdbf zzhcs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdbo(zzdbf zzdbfVar, zzazb zzazbVar) {
        this.zzhcs = zzdbfVar;
        this.zzhcr = zzazbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        try {
            zzazb zzazbVar = this.zzhcr;
            String valueOf = String.valueOf(th.getMessage());
            zzazbVar.onError(valueOf.length() != 0 ? "Internal error. ".concat(valueOf) : new String("Internal error. "));
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(zzdcb zzdcbVar) {
        zzbar zzbarVar;
        zzdcb zzdcbVar2 = zzdcbVar;
        try {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzdaa)).booleanValue()) {
                zzbarVar = this.zzhcs.zzbpj;
                if (zzbarVar.zzekb >= ((Integer) zzww.zzra().zzd(zzabq.zzdac)).intValue()) {
                    if (zzdcbVar2 == null) {
                        this.zzhcr.zza(null, null, null);
                        return;
                    } else {
                        this.zzhcr.zza(zzdcbVar2.zzhda, zzdcbVar2.zzhdb, zzdcbVar2.zzhdc);
                        return;
                    }
                }
            }
            if (zzdcbVar2 == null) {
                this.zzhcr.zzj(null, null);
            } else {
                this.zzhcr.zzj(zzdcbVar2.zzhda, zzdcbVar2.zzhdb);
            }
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
