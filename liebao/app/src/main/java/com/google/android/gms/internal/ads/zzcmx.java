package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcmx implements zzesa<Set<zzbzl<zzve>>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcmy> zzgma;
    private final zzcmo zzgoz;

    private zzcmx(zzcmo zzcmoVar, zzesn<zzcmy> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzgoz = zzcmoVar;
        this.zzgma = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzcmx zzg(zzcmo zzcmoVar, zzesn<zzcmy> zzesnVar, zzesn<Executor> zzesnVar2) {
        return new zzcmx(zzcmoVar, zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(zzcmo.zzg(this.zzgma.get(), this.zzeyl.get()));
    }
}
