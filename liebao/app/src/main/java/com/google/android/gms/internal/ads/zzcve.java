package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcve implements zzcth<zzcaj, zzdqd, zzcuv> {
    private final Context context;
    private final zzbar zzbpj;
    private final Executor zzfur;
    private final zzcbj zzgwq;

    public zzcve(Context context, zzbar zzbarVar, zzcbj zzcbjVar, Executor executor) {
        this.context = context;
        this.zzbpj = zzbarVar;
        this.zzgwq = zzcbjVar;
        this.zzfur = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final void zza(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzdqd, zzcuv> zzctbVar) {
        zzctbVar.zzdoy.zza(this.context, zzdpiVar.zzhns.zzfzg.zzhnx, zzdotVar.zzhmk.toString(), com.google.android.gms.ads.internal.util.zzbh.zza(zzdotVar.zzhmh), zzctbVar.zzgvk);
    }

    @Override // com.google.android.gms.internal.ads.zzcth
    public final /* synthetic */ zzcaj zzb(zzdpi zzdpiVar, zzdot zzdotVar, zzctb<zzdqd, zzcuv> zzctbVar) {
        zzcal zza = this.zzgwq.zza(new zzbps(zzdpiVar, zzdotVar, zzctbVar.zzcja), new zzcak(new zzcbr(this, zzctbVar) { // from class: com.google.android.gms.internal.ads.zzcvh
            private final zzcve zzgxh;
            private final zzctb zzgxi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgxh = this;
                this.zzgxi = zzctbVar;
            }

            @Override // com.google.android.gms.internal.ads.zzcbr
            public final void zza(boolean z, Context context) {
                this.zzgxh.zza(this.zzgxi, z, context);
            }
        }));
        zza.zzahh().zza((zzbts) new zzbkx(zzctbVar.zzdoy), this.zzfur);
        zzctbVar.zzgvk.zzb(zza.zzahm());
        return zza.zzait();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzctb zzctbVar, boolean z, Context context) {
        try {
            ((zzdqd) zzctbVar.zzdoy).setImmersiveMode(z);
            if (this.zzbpj.zzekb < ((Integer) zzww.zzra().zzd(zzabq.zzcpm)).intValue()) {
                ((zzdqd) zzctbVar.zzdoy).showInterstitial();
            } else {
                ((zzdqd) zzctbVar.zzdoy).zzcl(context);
            }
        } catch (zzdpq e2) {
            com.google.android.gms.ads.internal.util.zzd.zzey("Cannot show interstitial.");
            throw new zzcbq(e2.getCause());
        }
    }
}
