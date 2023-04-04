package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdig implements zzdhe<zzdid> {
    private final Context context;
    private final Executor executor;
    private final zzazs zzbqn;
    private final ScheduledExecutorService zzftq;
    private final int zzgsm;
    private final zzazo zzhgy;

    public zzdig(zzazo zzazoVar, int i, Context context, zzazs zzazsVar, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zzhgy = zzazoVar;
        this.zzgsm = i;
        this.context = context;
        this.zzbqn = zzazsVar;
        this.zzftq = scheduledExecutorService;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdid> zzatu() {
        return zzebc.zzg(zzebh.zza(new zzeas(this) { // from class: com.google.android.gms.internal.ads.zzdif
            private final zzdig zzhhi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhhi = this;
            }

            @Override // com.google.android.gms.internal.ads.zzeas
            public final zzebt zzauk() {
                return this.zzhhi.zzaut();
            }
        }, this.executor)).zza(zzdii.zzebv, this.executor).zza(((Long) zzww.zzra().zzd(zzabq.zzcqd)).longValue(), TimeUnit.MILLISECONDS, this.zzftq).zza(Exception.class, new zzdxw(this) { // from class: com.google.android.gms.internal.ads.zzdih
            private final zzdig zzhhi;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhhi = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj) {
                return this.zzhhi.zzb((Exception) obj);
            }
        }, zzebv.zzbbe());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdid zzb(Exception exc) {
        this.zzbqn.zza(exc, "AttestationTokenSignal");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzebt zzaut() {
        return this.zzhgy.zzb(this.context, this.zzgsm);
    }
}
