package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzdss<E> {
    private static final zzebt<?> zzhsu = zzebh.zzag(null);
    private final ScheduledExecutorService zzfvp;
    private final zzebs zzgka;
    private final zzdte<E> zzhsv;

    public zzdss(zzebs zzebsVar, ScheduledExecutorService scheduledExecutorService, zzdte<E> zzdteVar) {
        this.zzgka = zzebsVar;
        this.zzfvp = scheduledExecutorService;
        this.zzhsv = zzdteVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String zzu(E e2);

    public final zzdsw zzt(E e2) {
        return new zzdsw(this, e2);
    }

    public final <I> zzdsy<I> zza(E e2, zzebt<I> zzebtVar) {
        return new zzdsy<>(this, e2, zzebtVar, Collections.singletonList(zzebtVar), zzebtVar);
    }

    public final zzdsu zza(E e2, zzebt<?>... zzebtVarArr) {
        return new zzdsu(this, e2, Arrays.asList(zzebtVarArr));
    }
}
