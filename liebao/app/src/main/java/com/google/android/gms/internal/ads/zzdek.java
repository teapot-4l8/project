package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdek implements zzdhe<zzdel> {
    private final Context zzaai;
    private final zzebs zzgka;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdek(Context context, zzebs zzebsVar) {
        this.zzaai = context;
        this.zzgka = zzebsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdel> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdej
            private final zzdek zzheu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzheu = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzheu.zzaue();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdel zzaue() {
        com.google.android.gms.ads.internal.zzr.zzkv();
        String zzay = com.google.android.gms.ads.internal.util.zzj.zzay(this.zzaai);
        String string = ((Boolean) zzww.zzra().zzd(zzabq.zzcyo)).booleanValue() ? this.zzaai.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", "") : "";
        com.google.android.gms.ads.internal.zzr.zzkv();
        return new zzdel(zzay, string, com.google.android.gms.ads.internal.util.zzj.zzaz(this.zzaai));
    }
}
