package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwx implements zzcth<zzcip, zzaqa, zzcuv> {
    private final Context context;
    private final zzcis zzgyj;

    public zzcwx(Context context, zzcis zzcisVar) {
        this.context = context;
        this.zzgyj = zzcisVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final void zza(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzaqa, zzcuv> zzctbVar) {
        try {
            zzctbVar.zzdoy.zzdn(zzdotVar.zzdpg);
            if (zzdpiVar.zzhns.zzfzg.zzhof.zzhnj == zzdpe.zzhnn) {
                zzctbVar.zzdoy.zzb(zzdotVar.zzewu, zzdotVar.zzhmk.toString(), zzdpiVar.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), new zzcwz(this, zzctbVar), zzctbVar.zzgvk);
            } else {
                zzctbVar.zzdoy.zza(zzdotVar.zzewu, zzdotVar.zzhmk.toString(), zzdpiVar.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), new zzcwz(this, zzctbVar), zzctbVar.zzgvk);
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Remote exception loading a rewarded RTB ad", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final /* synthetic */ zzcip zzb(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzaqa, zzcuv> zzctbVar) {
        zzcvf zzcvfVar = new zzcvf(zzdotVar, zzctbVar.zzdoy, true);
        zzcir zza = this.zzgyj.zza(new zzbps(zzdpiVar, zzdotVar, zzctbVar.zzcja), new zzciq(zzcvfVar));
        zzcvfVar.zza(zza.zzahk());
        zzctbVar.zzgvk.zzb(zza.zzajd());
        return zza.zzaja();
    }
}
