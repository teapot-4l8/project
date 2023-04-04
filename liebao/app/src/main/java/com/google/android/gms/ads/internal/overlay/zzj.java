package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzj extends com.google.android.gms.ads.internal.util.zza {
    final /* synthetic */ zze zzdtu;

    private zzj(zze zzeVar) {
        this.zzdtu = zzeVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void zzwp() {
        Bitmap zza = com.google.android.gms.ads.internal.zzr.zzlo().zza(Integer.valueOf(this.zzdtu.zzdtb.zzdum.zzbpt));
        if (zza != null) {
            final Drawable zza2 = com.google.android.gms.ads.internal.zzr.zzkx().zza(this.zzdtu.zzaax, zza, this.zzdtu.zzdtb.zzdum.zzbpr, this.zzdtu.zzdtb.zzdum.zzbps);
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(this, zza2) { // from class: com.google.android.gms.ads.internal.overlay.zzm
                private final zzj zzduc;
                private final Drawable zzdud;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzduc = this;
                    this.zzdud = zza2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzj zzjVar = this.zzduc;
                    zzjVar.zzdtu.zzaax.getWindow().setBackgroundDrawable(this.zzdud);
                }
            });
        }
    }
}
