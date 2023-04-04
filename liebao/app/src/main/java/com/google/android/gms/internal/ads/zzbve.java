package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbve extends zzbxq<zzbvi> {
    private final Clock zzbqq;
    private boolean zzfux;
    private final ScheduledExecutorService zzfvp;
    private long zzfvr;
    private long zzfvs;
    private ScheduledFuture<?> zzgbx;

    public zzbve(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.zzfvr = -1L;
        this.zzfvs = -1L;
        this.zzfux = false;
        this.zzfvp = scheduledExecutorService;
        this.zzbqq = clock;
    }

    public final synchronized void onPause() {
        if (!this.zzfux) {
            if (this.zzgbx != null && !this.zzgbx.isCancelled()) {
                this.zzgbx.cancel(true);
                this.zzfvs = this.zzfvr - this.zzbqq.elapsedRealtime();
            } else {
                this.zzfvs = -1L;
            }
            this.zzfux = true;
        }
    }

    public final synchronized void onResume() {
        if (this.zzfux) {
            if (this.zzfvs > 0 && this.zzgbx.isCancelled()) {
                zzfe(this.zzfvs);
            }
            this.zzfux = false;
        }
    }

    public final synchronized void zzamm() {
        this.zzfux = false;
        zzfe(0L);
    }

    public final synchronized void zzef(int i) {
        if (i <= 0) {
            return;
        }
        long millis = TimeUnit.SECONDS.toMillis(i);
        if (this.zzfux) {
            if (this.zzfvs <= 0 || millis >= this.zzfvs) {
                millis = this.zzfvs;
            }
            this.zzfvs = millis;
            return;
        }
        if (this.zzbqq.elapsedRealtime() > this.zzfvr || this.zzfvr - this.zzbqq.elapsedRealtime() > millis) {
            zzfe(millis);
        }
    }

    private final synchronized void zzfe(long j) {
        if (this.zzgbx != null && !this.zzgbx.isDone()) {
            this.zzgbx.cancel(true);
        }
        this.zzfvr = this.zzbqq.elapsedRealtime() + j;
        this.zzgbx = this.zzfvp.schedule(new zzbvf(this), j, TimeUnit.MILLISECONDS);
    }

    public final void zzamn() {
        zza(zzbvd.zzgbn);
    }
}
