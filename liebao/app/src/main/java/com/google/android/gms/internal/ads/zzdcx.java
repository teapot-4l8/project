package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcx implements zzdhe<zzdcv> {
    private final zzcna zzfsu;
    private final zzckb zzgph;
    private final zzebs zzhdd;
    private final zzdcz zzhdu;

    public zzdcx(zzebs zzebsVar, zzckb zzckbVar, zzcna zzcnaVar, zzdcz zzdczVar) {
        this.zzhdd = zzebsVar;
        this.zzgph = zzckbVar;
        this.zzfsu = zzcnaVar;
        this.zzhdu = zzdczVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdcv> zzatu() {
        if (zzdyq.zzar((String) zzww.zzra().zzd(zzabq.zzcrm)) || this.zzhdu.zzatx() || !this.zzfsu.zzary()) {
            return zzebh.zzag(new zzdcv(new Bundle()));
        }
        this.zzhdu.zzbp(true);
        return this.zzhdd.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdda
            private final zzdcx zzhdw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhdw = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhdw.zzatw();
            }
        });
    }

    private static Bundle zzb(zzdqd zzdqdVar) {
        Bundle bundle = new Bundle();
        try {
            zzaqr zzvn = zzdqdVar.zzvn();
            if (zzvn != null) {
                bundle.putString("sdk_version", zzvn.toString());
            }
        } catch (zzdpq unused) {
        }
        try {
            zzaqr zzvm = zzdqdVar.zzvm();
            if (zzvm != null) {
                bundle.putString("adapter_version", zzvm.toString());
            }
        } catch (zzdpq unused2) {
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdcv zzatw() {
        List<String> asList = Arrays.asList(((String) zzww.zzra().zzd(zzabq.zzcrm)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : asList) {
            try {
                zzdqd zzd = this.zzgph.zzd(str, new JSONObject());
                zzd.isInitialized();
                bundle.putBundle(str, zzb(zzd));
            } catch (zzdpq unused) {
            }
        }
        return new zzdcv(bundle);
    }
}
