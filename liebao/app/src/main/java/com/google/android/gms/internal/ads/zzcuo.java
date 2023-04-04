package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcuo implements zzcsz<zzbne> {
    private final ScheduledExecutorService zzftq;
    private final zzbsx zzgcz;
    private final zzebs zzgka;
    private final zzboa zzgwu;
    private final zzcts zzgwv;

    public zzcuo(zzboa zzboaVar, zzcts zzctsVar, zzbsx zzbsxVar, ScheduledExecutorService scheduledExecutorService, zzebs zzebsVar) {
        this.zzgwu = zzboaVar;
        this.zzgwv = zzctsVar;
        this.zzgcz = zzbsxVar;
        this.zzftq = scheduledExecutorService;
        this.zzgka = zzebsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final boolean zza(zzdpi zzdpiVar, zzdot zzdotVar) {
        return zzdpiVar.zzhns.zzfzg.zzawb() != null && this.zzgwv.zza(zzdpiVar, zzdotVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcsz
    public final zzebt<zzbne> zzb(zzdpi zzdpiVar, zzdot zzdotVar) {
        return this.zzgka.zze(new Callable(this, zzdpiVar, zzdotVar) { // from class: com.google.android.gms.internal.ads.zzcur
            private final zzdot zzfxi;
            private final zzdpi zzgjy;
            private final zzcuo zzgwx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgwx = this;
                this.zzgjy = zzdpiVar;
                this.zzfxi = zzdotVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgwx.zzc(this.zzgjy, this.zzfxi);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbne zzc(zzdpi zzdpiVar, zzdot zzdotVar) {
        return this.zzgwu.zza(new zzbps(zzdpiVar, zzdotVar, null), new zzboo(zzdpiVar.zzhns.zzfzg.zzawb(), new Runnable(this, zzdpiVar, zzdotVar) { // from class: com.google.android.gms.internal.ads.zzcuq
            private final zzdot zzfxi;
            private final zzdpi zzgjy;
            private final zzcuo zzgwx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgwx = this;
                this.zzgjy = zzdpiVar;
                this.zzfxi = zzdotVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgwx.zzd(this.zzgjy, this.zzfxi);
            }
        })).zzaio();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzdpi zzdpiVar, zzdot zzdotVar) {
        zzebh.zza(zzebh.zza(this.zzgwv.zzb(zzdpiVar, zzdotVar), zzdotVar.zzhmr, TimeUnit.SECONDS, this.zzftq), new zzcut(this), this.zzgka);
    }
}
