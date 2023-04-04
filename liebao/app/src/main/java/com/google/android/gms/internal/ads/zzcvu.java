package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcvu implements zzcth<zzcdf, zzdqd, zzcuv> {
    private final Context context;
    private final Executor zzfur;
    private final zzccf zzgxk;

    public zzcvu(Context context, zzccf zzccfVar, Executor executor) {
        this.context = context;
        this.zzgxk = zzccfVar;
        this.zzfur = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final void zza(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzdqd, zzcuv> zzctbVar) {
        zzctbVar.zzdoy.zza(this.context, zzdpiVar.zzhns.zzfzg.zzhnx, zzdotVar.zzhmk.toString(), com.google.android.gms.ads.internal.util.zzbh.zza(zzdotVar.zzhmh), zzctbVar.zzgvk, zzdpiVar.zzhns.zzfzg.zzdpr, zzdpiVar.zzhns.zzfzg.zzhnz);
    }

    private static boolean zza(zzdpi zzdpiVar, int i) {
        return zzdpiVar.zzhns.zzfzg.zzhnz.contains(Integer.toString(i));
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final /* synthetic */ zzcdf zzb(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzdqd, zzcuv> zzctbVar) {
        zzcdr zza;
        zzaob zzvf = zzctbVar.zzdoy.zzvf();
        zzaoc zzvg = zzctbVar.zzdoy.zzvg();
        zzaoh zzvl = zzctbVar.zzdoy.zzvl();
        if (zzvl != null && zza(zzdpiVar, 6)) {
            zza = zzcdr.zzb(zzvl);
        } else if (zzvf != null && zza(zzdpiVar, 6)) {
            zza = zzcdr.zzb(zzvf);
        } else if (zzvf != null && zza(zzdpiVar, 2)) {
            zza = zzcdr.zza(zzvf);
        } else if (zzvg != null && zza(zzdpiVar, 6)) {
            zza = zzcdr.zzb(zzvg);
        } else if (zzvg != null && zza(zzdpiVar, 1)) {
            zza = zzcdr.zza(zzvg);
        } else {
            throw new zzcwo(zzdqj.INTERNAL_ERROR, "No native ad mappers");
        }
        if (!zzdpiVar.zzhns.zzfzg.zzhnz.contains(Integer.toString(zza.zzaoo()))) {
            throw new zzcwo(zzdqj.INTERNAL_ERROR, "No corresponding native ad listener");
        }
        zzcds zza2 = this.zzgxk.zza(new zzbps(zzdpiVar, zzdotVar, zzctbVar.zzcja), new zzced(zza), new zzcfo(zzvg, zzvf, zzvl));
        zzctbVar.zzgvk.zzb(zza2.zzahm());
        zza2.zzahh().zza((zzbts) new zzbkx(zzctbVar.zzdoy), this.zzfur);
        return zza2.zzaho();
    }
}
