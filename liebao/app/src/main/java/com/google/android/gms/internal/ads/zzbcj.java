package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbcj {
    private long zzemw;
    private final long zzemv = TimeUnit.MILLISECONDS.toNanos(((Long) zzww.zzra().zzd(zzabq.zzcnr)).longValue());
    private boolean zzemx = true;

    public final void zzabe() {
        this.zzemx = true;
    }

    public final void zza(SurfaceTexture surfaceTexture, zzbca zzbcaVar) {
        if (zzbcaVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (this.zzemx || Math.abs(timestamp - this.zzemw) >= this.zzemv) {
            this.zzemx = false;
            this.zzemw = timestamp;
            com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbcm(this, zzbcaVar));
        }
    }
}
