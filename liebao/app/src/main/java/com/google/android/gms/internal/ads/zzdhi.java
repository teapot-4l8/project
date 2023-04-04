package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdhi<T> implements zzesa<zzdhd<T>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Set<zzdhe<? extends zzdhb<T>>>> zzhgt;

    private zzdhi(zzesn<Executor> zzesnVar, zzesn<Set<zzdhe<? extends zzdhb<T>>>> zzesnVar2) {
        this.zzeyl = zzesnVar;
        this.zzhgt = zzesnVar2;
    }

    public static <T> zzdhi<T> zzbc(zzesn<Executor> zzesnVar, zzesn<Set<zzdhe<? extends zzdhb<T>>>> zzesnVar2) {
        return new zzdhi<>(zzesnVar, zzesnVar2);
    }

    public static <T> zzdhd<T> zza(Executor executor, Set<zzdhe<? extends zzdhb<T>>> set) {
        return new zzdhd<>(executor, set);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzeyl.get(), this.zzhgt.get());
    }
}
