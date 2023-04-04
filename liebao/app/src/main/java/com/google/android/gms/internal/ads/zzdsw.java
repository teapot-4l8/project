package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdsw {
    private final E zzhsw;
    private final /* synthetic */ zzdss zzhta;

    private zzdsw(zzdss zzdssVar, E e2) {
        this.zzhta = zzdssVar;
        this.zzhsw = e2;
    }

    public final <O> zzdsy<O> zze(zzebt<O> zzebtVar) {
        zzebt zzebtVar2;
        zzdss zzdssVar = this.zzhta;
        E e2 = this.zzhsw;
        zzebtVar2 = zzdss.zzhsu;
        return new zzdsy<>(zzdssVar, e2, zzebtVar2, Collections.emptyList(), zzebtVar);
    }

    public final <O> zzdsy<O> zzc(Callable<O> callable) {
        zzebs zzebsVar;
        zzebsVar = this.zzhta.zzgka;
        return zza(callable, zzebsVar);
    }

    private final <O> zzdsy<O> zza(Callable<O> callable, zzebs zzebsVar) {
        zzebt zzebtVar;
        zzdss zzdssVar = this.zzhta;
        E e2 = this.zzhsw;
        zzebtVar = zzdss.zzhsu;
        return new zzdsy<>(zzdssVar, e2, zzebtVar, Collections.emptyList(), zzebsVar.zze(callable));
    }

    public final zzdsy<?> zza(zzdsq zzdsqVar, zzebs zzebsVar) {
        return zza(new Callable(zzdsqVar) { // from class: com.google.android.gms.internal.ads.zzdsz
            private final zzdsq zzhtd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhtd = zzdsqVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.zzhtd.run();
                return null;
            }
        }, zzebsVar);
    }
}
