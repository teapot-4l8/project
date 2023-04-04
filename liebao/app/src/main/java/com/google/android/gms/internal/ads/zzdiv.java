package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdiv implements zzdhe<zzdiw> {
    List<String> zzdvy;
    private zzebs zzgka;
    zzabc zzhhr;

    public zzdiv(zzabc zzabcVar, zzebs zzebsVar, List<String> list) {
        this.zzhhr = zzabcVar;
        this.zzgka = zzebsVar;
        this.zzdvy = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdiw> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdiy
            private final zzdiv zzhht;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhht = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdiv zzdivVar = this.zzhht;
                return new zzdiw(zzdivVar.zzhhr.zzf(zzdivVar.zzdvy));
            }
        });
    }
}
