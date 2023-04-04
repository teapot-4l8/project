package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfg implements zzdhe<zzdfd> {
    private final zzdor zzfti;
    private final zzebs zzgka;

    public zzdfg(zzebs zzebsVar, zzdor zzdorVar) {
        this.zzgka = zzebsVar;
        this.zzfti = zzdorVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdfd> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdff
            private final zzdfg zzhfe;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhfe = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhfe.zzaug();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdfd zzaug() {
        return new zzdfd(this.zzfti);
    }
}
