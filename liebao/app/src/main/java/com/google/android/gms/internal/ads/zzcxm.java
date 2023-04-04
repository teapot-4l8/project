package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcxm implements zzcth<zzcip, zzdqd, zzcuu> {
    private final Context context;
    private final Executor zzfur;
    private final zzcis zzgyj;

    public zzcxm(Context context, Executor executor, zzcis zzcisVar) {
        this.context = context;
        this.zzfur = executor;
        this.zzgyj = zzcisVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final void zza(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzdqd, zzcuu> zzctbVar) {
        if (!zzctbVar.zzdoy.isInitialized()) {
            zzctbVar.zzgvk.zza(new zzcxo(this, zzdpiVar, zzdotVar, zzctbVar));
            zzctbVar.zzdoy.zza(this.context, zzdpiVar.zzhns.zzfzg.zzhnx, (String) null, zzctbVar.zzgvk, zzdotVar.zzhmk.toString());
            return;
        }
        zzc(zzdpiVar, zzdotVar, zzctbVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzdqd, zzcuu> zzctbVar) {
        try {
            zzctbVar.zzdoy.zza(zzdpiVar.zzhns.zzfzg.zzhnx, zzdotVar.zzhmk.toString());
        } catch (Exception e2) {
            String valueOf = String.valueOf(zzctbVar.zzcja);
            com.google.android.gms.ads.internal.util.zzd.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final /* synthetic */ zzcip zzb(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzdqd, zzcuu> zzctbVar) {
        zzcir zza = this.zzgyj.zza(new zzbps(zzdpiVar, zzdotVar, zzctbVar.zzcja), new zzciq(new zzcbr(zzctbVar) { // from class: com.google.android.gms.internal.ads.zzcxp
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
                    ((zzdqd) zzctbVar2.zzdoy).showVideo();
                } catch (zzdpq e2) {
                    com.google.android.gms.ads.internal.util.zzd.zzd("Cannot show rewarded video.", e2);
                    throw new zzcbq(e2.getCause());
                }
            }
        }));
        zza.zzahh().zza((zzbts) new zzbkx(zzctbVar.zzdoy), this.zzfur);
        zzbty zzahi = zza.zzahi();
        zzbst zzahj = zza.zzahj();
        zzctbVar.zzgvk.zza(new zzcxq(this, zza.zzaiu(), zzahj, zzahi, zza.zzajb()));
        return zza.zzaja();
    }
}
