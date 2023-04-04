package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfx implements zzdhe<zzdfy> {
    private final Bundle zzgbd;
    private final zzebs zzgka;

    public zzdfx(zzebs zzebsVar, Bundle bundle) {
        this.zzgka = zzebsVar;
        this.zzgbd = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdfy> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdga
            private final zzdfx zzhfm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhfm = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhfm.zzauj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdfy zzauj() {
        return new zzdfy(this.zzgbd);
    }
}
