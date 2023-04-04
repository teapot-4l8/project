package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdor {
    private final Clock zzbqq;
    private final Object lock = new Object();
    private volatile int zzhlx = zzdou.zzhnc;
    private volatile long zzefc = 0;

    public zzdor(Clock clock) {
        this.zzbqq = clock;
    }

    private final void zzt(int i, int i2) {
        zzavv();
        long currentTimeMillis = this.zzbqq.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzhlx != i) {
                return;
            }
            this.zzhlx = i2;
            if (this.zzhlx == zzdou.zzhne) {
                this.zzefc = currentTimeMillis;
            }
        }
    }

    private final void zzavv() {
        long currentTimeMillis = this.zzbqq.currentTimeMillis();
        synchronized (this.lock) {
            if (this.zzhlx == zzdou.zzhne) {
                if (this.zzefc + ((Long) zzww.zzra().zzd(zzabq.zzcyg)).longValue() <= currentTimeMillis) {
                    this.zzhlx = zzdou.zzhnc;
                }
            }
        }
    }

    public final void zzbq(boolean z) {
        if (z) {
            zzt(zzdou.zzhnc, zzdou.zzhnd);
        } else {
            zzt(zzdou.zzhnd, zzdou.zzhnc);
        }
    }

    public final boolean zzavw() {
        boolean z;
        synchronized (this.lock) {
            zzavv();
            z = this.zzhlx == zzdou.zzhnd;
        }
        return z;
    }

    public final boolean zzavx() {
        boolean z;
        synchronized (this.lock) {
            zzavv();
            z = this.zzhlx == zzdou.zzhne;
        }
        return z;
    }

    public final void zzyh() {
        zzt(zzdou.zzhnd, zzdou.zzhne);
    }
}
