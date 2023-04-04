package com.google.android.gms.internal.ads;

import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcno {
    private final zzebs zzgka;
    private final zzebs zzgqb;
    private final zzcoz zzgqc;
    private final zzeru<zzcqb> zzgqd;

    public zzcno(zzebs zzebsVar, zzebs zzebsVar2, zzcoz zzcozVar, zzeru<zzcqb> zzeruVar) {
        this.zzgqb = zzebsVar;
        this.zzgka = zzebsVar2;
        this.zzgqc = zzcozVar;
        this.zzgqd = zzeruVar;
    }

    public final zzebt<InputStream> zze(zzauj zzaujVar) {
        zzebt zzb;
        String str = zzaujVar.packageName;
        com.google.android.gms.ads.internal.zzr.zzkv();
        if (com.google.android.gms.ads.internal.util.zzj.zzem(str)) {
            zzb = zzebh.immediateFailedFuture(new zzcpo(zzdqj.INTERNAL_ERROR));
        } else {
            zzb = zzebh.zzb(this.zzgqb.zze(new Callable(this, zzaujVar) { // from class: com.google.android.gms.internal.ads.zzcnr
                private final zzcno zzgqf;
                private final zzauj zzgqg;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgqf = this;
                    this.zzgqg = zzaujVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzgqf.zzf(this.zzgqg);
                }
            }), ExecutionException.class, zzcnq.zzbpa, this.zzgka);
        }
        return zzebh.zzb(zzb, zzcpo.class, new zzear(this, zzaujVar, Binder.getCallingUid()) { // from class: com.google.android.gms.internal.ads.zzcnt
            private final int zzehi;
            private final zzcno zzgqf;
            private final zzauj zzgqg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgqf = this;
                this.zzgqg = zzaujVar;
                this.zzehi = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                return this.zzgqf.zza(this.zzgqg, this.zzehi, (zzcpo) obj);
            }
        }, this.zzgka);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzauj zzaujVar, int i, zzcpo zzcpoVar) {
        return this.zzgqd.get().zzb(zzaujVar, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzf(zzauj zzaujVar) {
        return this.zzgqc.zzi(zzaujVar).get(((Integer) zzww.zzra().zzd(zzabq.zzcxi)).intValue(), TimeUnit.SECONDS);
    }
}
