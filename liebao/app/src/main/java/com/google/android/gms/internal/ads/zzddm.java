package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzddm implements zzesa<zzddh> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzazs> zzhdo;

    private zzddm(zzesn<Executor> zzesnVar, zzesn<zzazs> zzesnVar2) {
        this.zzeyl = zzesnVar;
        this.zzhdo = zzesnVar2;
    }

    public static zzddm zzat(zzesn<Executor> zzesnVar, zzesn<zzazs> zzesnVar2) {
        return new zzddm(zzesnVar, zzesnVar2);
    }

    public static zzddh zza(Executor executor, zzazs zzazsVar) {
        return new zzddh(executor, zzazsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzeyl.get(), this.zzhdo.get());
    }
}
