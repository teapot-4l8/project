package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdee implements zzdhe<zzdeb> {
    private final zzdpm zzfzg;
    private final zzebs zzgka;
    private final String zzhcu;
    private final zzckd zzher;

    public zzdee(zzebs zzebsVar, zzckd zzckdVar, zzdpm zzdpmVar, String str) {
        this.zzgka = zzebsVar;
        this.zzher = zzckdVar;
        this.zzfzg = zzdpmVar;
        this.zzhcu = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdeb> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzded
            private final zzdee zzheq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzheq = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzheq.zzaud();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdeb zzaud() {
        return new zzdeb(this.zzher.zzr(this.zzfzg.zzhny, this.zzhcu), this.zzher.zzaqr());
    }
}
