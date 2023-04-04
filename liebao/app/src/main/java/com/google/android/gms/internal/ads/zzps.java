package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzps implements zzpk {
    private boolean started;
    private zzhz zzafp = zzhz.zzaik;
    private long zzbkv;
    private long zzbkw;

    public final void start() {
        if (this.started) {
            return;
        }
        this.zzbkw = SystemClock.elapsedRealtime();
        this.started = true;
    }

    public final void stop() {
        if (this.started) {
            zzel(zzgg());
            this.started = false;
        }
    }

    public final void zzel(long j) {
        this.zzbkv = j;
        if (this.started) {
            this.zzbkw = SystemClock.elapsedRealtime();
        }
    }

    public final void zza(zzpk zzpkVar) {
        zzel(zzpkVar.zzgg());
        this.zzafp = zzpkVar.zzfw();
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final long zzgg() {
        long zzdu;
        long j = this.zzbkv;
        if (this.started) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzbkw;
            if (this.zzafp.zzail == 1.0f) {
                zzdu = zzhf.zzdp(elapsedRealtime);
            } else {
                zzdu = this.zzafp.zzdu(elapsedRealtime);
            }
            return j + zzdu;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final zzhz zzb(zzhz zzhzVar) {
        if (this.started) {
            zzel(zzgg());
        }
        this.zzafp = zzhzVar;
        return zzhzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpk
    public final zzhz zzfw() {
        return this.zzafp;
    }
}
