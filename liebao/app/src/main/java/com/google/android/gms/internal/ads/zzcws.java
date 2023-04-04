package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcws implements zzcth<zzcip, zzdqd, zzcuv> {
    private final Context context;
    private final Executor zzfur;
    private final zzcis zzgyj;

    public zzcws(Context context, Executor executor, zzcis zzcisVar) {
        this.context = context;
        this.zzfur = executor;
        this.zzgyj = zzcisVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final void zza(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzdqd, zzcuv> zzctbVar) {
        try {
            zzdpm zzdpmVar = zzdpiVar.zzhns.zzfzg;
            if (zzdpmVar.zzhof.zzhnj == zzdpe.zzhnn) {
                zzctbVar.zzdoy.zzb(this.context, zzdpmVar.zzhnx, zzdotVar.zzhmk.toString(), zzctbVar.zzgvk);
            } else {
                zzctbVar.zzdoy.zza(this.context, zzdpmVar.zzhnx, zzdotVar.zzhmk.toString(), zzctbVar.zzgvk);
            }
        } catch (Exception e2) {
            String valueOf = String.valueOf(zzctbVar.zzcja);
            com.google.android.gms.ads.internal.util.zzd.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final /* synthetic */ zzcip zzb(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzdqd, zzcuv> zzctbVar) {
        zzcir zza = this.zzgyj.zza(new zzbps(zzdpiVar, zzdotVar, zzctbVar.zzcja), new zzciq(new zzcbr(zzctbVar) { // from class: com.google.android.gms.internal.ads.zzcwv
            private final zzctb zzgwn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgwn = zzctbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzcbr
            public final void zza(boolean z, Context context) {
                zzctb zzctbVar2 = this.zzgwn;
                try {
                    ((zzdqd) zzctbVar2.zzdoy).setImmersiveMode(z);
                    ((zzdqd) zzctbVar2.zzdoy).zzcm(context);
                } catch (zzdpq e2) {
                    throw new zzcbq(e2.getCause());
                }
            }
        }));
        zza.zzahh().zza((zzbts) new zzbkx(zzctbVar.zzdoy), this.zzfur);
        zzctbVar.zzgvk.zzb(zza.zzajc());
        return zza.zzaja();
    }
}
