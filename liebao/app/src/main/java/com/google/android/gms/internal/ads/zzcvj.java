package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcvj implements zzcth<zzcaj, zzaqa, zzcuv> {
    private final Context context;
    private final zzcbj zzgwq;

    public zzcvj(Context context, zzcbj zzcbjVar) {
        this.context = context;
        this.zzgwq = zzcbjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final void zza(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzaqa, zzcuv> zzctbVar) {
        try {
            zzctbVar.zzdoy.zzdn(zzdotVar.zzdpg);
            zzctbVar.zzdoy.zza(zzdotVar.zzewu, zzdotVar.zzhmk.toString(), zzdpiVar.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), new zzcvl(this, zzctbVar), zzctbVar.zzgvk);
        } catch (RemoteException e2) {
            throw new zzdpq(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final /* synthetic */ zzcaj zzb(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzaqa, zzcuv> zzctbVar) {
        zzcvf zzcvfVar = new zzcvf(zzdotVar, zzctbVar.zzdoy, false);
        zzcal zza = this.zzgwq.zza(new zzbps(zzdpiVar, zzdotVar, zzctbVar.zzcja), new zzcak(zzcvfVar));
        zzcvfVar.zza(zza.zzahk());
        zzctbVar.zzgvk.zzb(zza.zzahn());
        return zza.zzait();
    }
}
