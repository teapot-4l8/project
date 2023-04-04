package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcvw implements zzcth<zzcdf, zzaqa, zzcuv> {
    private final Context context;
    private final zzbar zzbpj;
    private final zzccf zzgxk;
    private zzaoh zzgxs;

    public zzcvw(Context context, zzccf zzccfVar, zzbar zzbarVar) {
        this.context = context;
        this.zzgxk = zzccfVar;
        this.zzbpj = zzbarVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final void zza(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzaqa, zzcuv> zzctbVar) {
        try {
            zzctbVar.zzdoy.zzdn(zzdotVar.zzdpg);
            if (this.zzbpj.zzekb < ((Integer) zzww.zzra().zzd(zzabq.zzcrw)).intValue()) {
                zzctbVar.zzdoy.zza(zzdotVar.zzewu, zzdotVar.zzhmk.toString(), zzdpiVar.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), new zzcvy(this, zzctbVar), zzctbVar.zzgvk);
            } else {
                zzctbVar.zzdoy.zza(zzdotVar.zzewu, zzdotVar.zzhmk.toString(), zzdpiVar.zzhns.zzfzg.zzhnx, ObjectWrapper.wrap(this.context), new zzcvy(this, zzctbVar), zzctbVar.zzgvk, zzdpiVar.zzhns.zzfzg.zzdpr);
            }
        } catch (RemoteException e2) {
            throw new zzdpq(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final /* synthetic */ zzcdf zzb(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzaqa, zzcuv> zzctbVar) {
        if (!zzdpiVar.zzhns.zzfzg.zzhnz.contains(Integer.toString(6))) {
            throw new zzcwo(zzdqj.INVALID_REQUEST, "Unified must be used for RTB.");
        }
        zzcdr zzb = zzcdr.zzb(this.zzgxs);
        if (!zzdpiVar.zzhns.zzfzg.zzhnz.contains(Integer.toString(zzb.zzaoo()))) {
            throw new zzcwo(zzdqj.INTERNAL_ERROR, "No corresponding native ad listener");
        }
        zzcds zza = this.zzgxk.zza(new zzbps(zzdpiVar, zzdotVar, zzctbVar.zzcja), new zzced(zzb), new zzcfo(null, null, this.zzgxs));
        zzctbVar.zzgvk.zzb(zza.zzahn());
        return zza.zzaho();
    }
}
