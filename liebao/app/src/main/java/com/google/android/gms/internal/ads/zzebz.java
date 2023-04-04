package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzebz<V> extends zzebf<V> implements zzebt<V>, ScheduledFuture<V> {
    private final ScheduledFuture<?> zziea;

    public zzebz(zzebt<V> zzebtVar, ScheduledFuture<?> scheduledFuture) {
        super(zzebtVar);
        this.zziea = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzebd, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean cancel = super.cancel(z);
        if (cancel) {
            this.zziea.cancel(z);
        }
        return cancel;
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zziea.getDelay(timeUnit);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Delayed delayed) {
        return this.zziea.compareTo(delayed);
    }
}
