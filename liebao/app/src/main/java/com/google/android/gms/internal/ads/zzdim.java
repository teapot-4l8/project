package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdim implements zzdhe<zzdij> {
    Context context;
    private zzebs zzgka;
    zztk zzhhl;

    public zzdim(zztk zztkVar, zzebs zzebsVar, Context context) {
        this.zzhhl = zztkVar;
        this.zzgka = zzebsVar;
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdij> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdil
            private final zzdim zzhhk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhhk = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdim zzdimVar = this.zzhhk;
                return new zzdij(zzdimVar.zzhhl.zzf(zzdimVar.context));
            }
        });
    }
}
