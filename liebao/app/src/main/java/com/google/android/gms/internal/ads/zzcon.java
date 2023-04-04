package com.google.android.gms.internal.ads;

import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcon {
    private final ScheduledExecutorService zzftq;
    private final zzebs zzgka;
    private final zzeru<zzcqb> zzgqd;
    private final zzcpd zzgqs;

    public zzcon(ScheduledExecutorService scheduledExecutorService, zzebs zzebsVar, zzcpd zzcpdVar, zzeru<zzcqb> zzeruVar) {
        this.zzftq = scheduledExecutorService;
        this.zzgka = zzebsVar;
        this.zzgqs = zzcpdVar;
        this.zzgqd = zzeruVar;
    }

    public final zzebt<InputStream> zzg(zzauj zzaujVar) {
        zzebt<InputStream> zzj;
        String str = zzaujVar.packageName;
        com.google.android.gms.ads.internal.zzr.zzkv();
        if (com.google.android.gms.ads.internal.util.zzj.zzem(str)) {
            zzj = zzebh.immediateFailedFuture(new zzcpo(zzdqj.INTERNAL_ERROR));
        } else {
            zzj = this.zzgqs.zzj(zzaujVar);
        }
        int callingUid = Binder.getCallingUid();
        return zzebc.zzg(zzj).zza(((Integer) zzww.zzra().zzd(zzabq.zzcxi)).intValue(), TimeUnit.SECONDS, this.zzftq).zza(Throwable.class, new zzear(this, zzaujVar, callingUid) { // from class: com.google.android.gms.internal.ads.zzcom
            private final int zzehi;
            private final zzauj zzgqg;
            private final zzcon zzgqr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgqr = this;
                this.zzgqg = zzaujVar;
                this.zzehi = callingUid;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgqr.zza(this.zzgqg, this.zzehi, (Throwable) obj);
            }
        }, this.zzgka);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzauj zzaujVar, int i, Throwable th) {
        return this.zzgqd.get().zzd(zzaujVar, i);
    }
}
