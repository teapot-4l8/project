package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcms implements zzesa<Set<zzbzl<zzbuj>>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcmy> zzgma;
    private final zzcmo zzgoz;

    private zzcms(zzcmo zzcmoVar, zzesn<zzcmy> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzgoz = zzcmoVar;
        this.zzgma = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzcms zzc(zzcmo zzcmoVar, zzesn<zzcmy> zzesnVar, zzesn<Executor> zzesnVar2) {
        return new zzcms(zzcmoVar, zzesnVar, zzesnVar2);
    }

    public static Set<zzbzl<zzbuj>> zza(zzcmo zzcmoVar, zzcmy zzcmyVar, Executor executor) {
        return (Set) zzesg.zzbd(zzcmo.zzc(zzcmyVar, executor));
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzgoz, this.zzgma.get(), this.zzeyl.get());
    }
}
