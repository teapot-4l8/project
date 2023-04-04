package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdeq implements zzdhe<zzden> {
    private final Context context;
    private final zzebs zzgka;

    public zzdeq(Context context, zzebs zzebsVar) {
        this.context = context;
        this.zzgka = zzebsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzden> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdep
            private final zzdeq zzhey;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhey = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String zzzc;
                String zzze;
                String str;
                com.google.android.gms.ads.internal.zzr.zzkv();
                zzrq zzza = com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzza();
                Bundle bundle = null;
                if (zzza != null && zzza != null && (!com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzb() || !com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzd())) {
                    if (zzza.zzms()) {
                        zzza.wakeup();
                    }
                    zzrk zzmq = zzza.zzmq();
                    if (zzmq != null) {
                        zzzc = zzmq.zzmf();
                        str = zzmq.zzmg();
                        zzze = zzmq.zzmh();
                        if (zzzc != null) {
                            com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzee(zzzc);
                        }
                        if (zzze != null) {
                            com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzef(zzze);
                        }
                    } else {
                        zzzc = com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzc();
                        zzze = com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzze();
                        str = null;
                    }
                    Bundle bundle2 = new Bundle(1);
                    if (!com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzd()) {
                        if (zzze != null && !TextUtils.isEmpty(zzze)) {
                            bundle2.putString("v_fp_vertical", zzze);
                        } else {
                            bundle2.putString("v_fp_vertical", "no_hash");
                        }
                    }
                    if (zzzc != null && !com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzb()) {
                        bundle2.putString("fingerprint", zzzc);
                        if (!zzzc.equals(str)) {
                            bundle2.putString("v_fp", str);
                        }
                    }
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                }
                return new zzden(bundle);
            }
        });
    }
}
