package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbpn {
    private final Executor executor;
    private volatile boolean zzafk = true;
    private final ScheduledExecutorService zzftq;
    private final zzebt<zzbpi> zzfyv;

    public zzbpn(Executor executor, ScheduledExecutorService scheduledExecutorService, zzebt<zzbpi> zzebtVar) {
        this.executor = executor;
        this.zzftq = scheduledExecutorService;
        this.zzfyv = zzebtVar;
    }

    public final void zza(zzebi<zzbpc> zzebiVar) {
        zzebh.zza(this.zzfyv, new zzbpq(this, zzebiVar), this.executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(List<? extends zzebt<? extends zzbpc>> list, final zzebi<zzbpc> zzebiVar) {
        if (list == null || list.isEmpty()) {
            this.executor.execute(new Runnable(zzebiVar) { // from class: com.google.android.gms.internal.ads.zzbpm
                private final zzebi zzfyu;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfyu = zzebiVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzfyu.zzb(new zzcnp(zzdqj.NO_FILL));
                }
            });
            return;
        }
        zzebt zzag = zzebh.zzag(null);
        for (zzebt<? extends zzbpc> zzebtVar : list) {
            zzag = zzebh.zzb(zzebh.zzb(zzag, Throwable.class, new zzear(zzebiVar) { // from class: com.google.android.gms.internal.ads.zzbpp
                private final zzebi zzfyu;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfyu = zzebiVar;
                }

                @Override // com.google.android.gms.internal.ads.zzear
                public final zzebt zzf(Object obj) {
                    this.zzfyu.zzb((Throwable) obj);
                    return zzebh.zzag(null);
                }
            }, this.executor), new zzear(this, zzebiVar, zzebtVar) { // from class: com.google.android.gms.internal.ads.zzbpo
                private final zzbpn zzfyw;
                private final zzebi zzfyx;
                private final zzebt zzfyy;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzfyw = this;
                    this.zzfyx = zzebiVar;
                    this.zzfyy = zzebtVar;
                }

                @Override // com.google.android.gms.internal.ads.zzear
                public final zzebt zzf(Object obj) {
                    return this.zzfyw.zza(this.zzfyx, this.zzfyy, (zzbpc) obj);
                }
            }, this.executor);
        }
        zzebh.zza(zzag, new zzbpt(this, zzebiVar), this.executor);
    }

    public final boolean isLoading() {
        return this.zzafk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzalo() {
        zzbat.zzeki.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbpr
            private final zzbpn zzfyw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfyw = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfyw.zzalp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzalp() {
        this.zzafk = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zza(zzebi zzebiVar, zzebt zzebtVar, zzbpc zzbpcVar) {
        if (zzbpcVar != null) {
            zzebiVar.onSuccess(zzbpcVar);
        }
        return zzebh.zza(zzebtVar, zzadw.zzdgd.get().longValue(), TimeUnit.MILLISECONDS, this.zzftq);
    }
}
