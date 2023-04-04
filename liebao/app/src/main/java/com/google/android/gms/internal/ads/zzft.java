package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzft extends zzgn {
    private long startTime;

    public zzft(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, long j, int i, int i2) {
        super(zzfcVar, str, str2, zzbVar, i, 25);
        this.startTime = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcx() {
        long longValue = ((Long) this.zzabq.invoke(null, new Object[0])).longValue();
        synchronized (this.zzabg) {
            this.zzabg.zzbr(longValue);
            if (this.startTime != 0) {
                this.zzabg.zzat(longValue - this.startTime);
                this.zzabg.zzaw(this.startTime);
            }
        }
    }
}
