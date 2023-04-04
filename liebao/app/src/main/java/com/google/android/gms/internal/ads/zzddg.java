package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzddg implements zzdhe<zzddd> {
    private final zzbar zzdvi;
    private final zzdpm zzfzg;
    private final zzebs zzgka;

    public zzddg(zzebs zzebsVar, zzdpm zzdpmVar, zzbar zzbarVar) {
        this.zzgka = zzebsVar;
        this.zzfzg = zzdpmVar;
        this.zzdvi = zzbarVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzddd> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzddf
            private final zzddg zzhdz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhdz = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhdz.zzaua();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzddd zzaua() {
        return new zzddd(this.zzfzg.zzhob, this.zzdvi);
    }
}
