package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdhs implements zzdhe<zzdhp> {
    private final Context context;
    private final Executor executor;
    private final ScheduledExecutorService zzftq;
    private final int zzgsm;
    private final zzazo zzhgy;

    public zzdhs(zzazo zzazoVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i) {
        this.zzhgy = zzazoVar;
        this.context = context;
        this.zzftq = scheduledExecutorService;
        this.executor = executor;
        this.zzgsm = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdhp> zzatu() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcqc)).booleanValue()) {
            return zzebc.zzg(this.zzhgy.zza(this.context, this.zzgsm)).zza(zzdhr.zzebv, this.executor).zza(((Long) zzww.zzra().zzd(zzabq.zzcqd)).longValue(), TimeUnit.MILLISECONDS, this.zzftq).zza(Throwable.class, new zzdxw(this) { // from class: com.google.android.gms.internal.ads.zzdhu
                private final zzdhs zzhha;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzhha = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdxw
                public final Object apply(Object obj) {
                    return this.zzhha.zzf((Throwable) obj);
                }
            }, this.executor);
        }
        return zzebh.immediateFailedFuture(new Exception("Did not ad Ad ID into query param."));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhp zzf(Throwable th) {
        zzww.zzqw();
        return new zzdhp(null, zzbae.zzbq(this.context));
    }
}
