package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdhb;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzddz<S extends zzdhb<?>> implements zzdhe<S> {
    private final Clock zzbqq;
    private final AtomicReference<zzdec<S>> zzhek = new AtomicReference<>();
    private final zzdhe<S> zzhel;
    private final long zzhem;

    public zzddz(zzdhe<S> zzdheVar, long j, Clock clock) {
        this.zzbqq = clock;
        this.zzhel = zzdheVar;
        this.zzhem = j;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<S> zzatu() {
        zzdec<S> zzdecVar = this.zzhek.get();
        if (zzdecVar == null || zzdecVar.hasExpired()) {
            zzdecVar = new zzdec<>(this.zzhel.zzatu(), this.zzhem, this.zzbqq);
            this.zzhek.set(zzdecVar);
        }
        return zzdecVar.zzheo;
    }
}
