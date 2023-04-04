package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdja implements zzdhe<zzdix> {
    private Context context;
    private ScheduledExecutorService zzftq;
    private zzasp zzhhu;

    public zzdja(zzasp zzaspVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzhhu = zzaspVar;
        this.zzftq = scheduledExecutorService;
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdix> zzatu() {
        return zzebh.zzb(zzebh.zza(this.zzhhu.zzo(this.context), ((Long) zzww.zzra().zzd(zzabq.zzcuq)).longValue(), TimeUnit.MILLISECONDS, this.zzftq), zzdiz.zzebv, zzbat.zzeke);
    }
}
