package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdsu {
    private final E zzhsw;
    private final List<zzebt<?>> zzhsz;
    private final /* synthetic */ zzdss zzhta;

    private zzdsu(zzdss zzdssVar, E e2, List<zzebt<?>> list) {
        this.zzhta = zzdssVar;
        this.zzhsw = e2;
        this.zzhsz = list;
    }

    public final <O> zzdsy<O> zzb(Callable<O> callable) {
        zzebs zzebsVar;
        zzebm zzk = zzebh.zzk(this.zzhsz);
        zzebt zzb = zzk.zzb(zzdsx.zzhez, zzbat.zzekj);
        zzdss zzdssVar = this.zzhta;
        E e2 = this.zzhsw;
        List<zzebt<?>> list = this.zzhsz;
        zzebsVar = zzdssVar.zzgka;
        return new zzdsy<>(zzdssVar, e2, zzb, list, zzk.zzb(callable, zzebsVar));
    }
}
