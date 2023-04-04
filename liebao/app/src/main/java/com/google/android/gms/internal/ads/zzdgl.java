package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgl implements zzdhe<zzdgm> {
    private final Context context;
    private final zzayd zzbrf;
    private final zzebs zzgka;

    public zzdgl(zzayd zzaydVar, zzebs zzebsVar, Context context) {
        this.zzbrf = zzaydVar;
        this.zzgka = zzebsVar;
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdgm> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdgo
            private final zzdgl zzhfz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhfz = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhfz.zzaum();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdgm zzaum() {
        if (!this.zzbrf.zzaa(this.context)) {
            return new zzdgm(null, null, null, null, null);
        }
        String zzad = this.zzbrf.zzad(this.context);
        String str = zzad == null ? "" : zzad;
        String zzae = this.zzbrf.zzae(this.context);
        String str2 = zzae == null ? "" : zzae;
        String zzaf = this.zzbrf.zzaf(this.context);
        String str3 = zzaf == null ? "" : zzaf;
        String zzag = this.zzbrf.zzag(this.context);
        return new zzdgm(str, str2, str3, zzag == null ? "" : zzag, "TIME_OUT".equals(str2) ? (Long) zzww.zzra().zzd(zzabq.zzcot) : null);
    }
}
