package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdhb;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdec<S extends zzdhb<?>> {
    private final Clock zzbqq;
    public final zzebt<S> zzheo;
    private final long zzhep;

    public zzdec(zzebt<S> zzebtVar, long j, Clock clock) {
        this.zzheo = zzebtVar;
        this.zzbqq = clock;
        this.zzhep = clock.elapsedRealtime() + j;
    }

    public final boolean hasExpired() {
        return this.zzhep < this.zzbqq.elapsedRealtime();
    }
}
