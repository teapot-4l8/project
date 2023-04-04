package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdtz implements zzesa<zzdtw> {
    private final zzesn<zzduc> zzeza;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzdul> zzhur;

    public zzdtz(zzesn<zzduc> zzesnVar, zzesn<zzdul> zzesnVar2, zzesn<ScheduledExecutorService> zzesnVar3) {
        this.zzeza = zzesnVar;
        this.zzhur = zzesnVar2;
        this.zzfty = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        Object obj;
        zzeru zzat = zzesb.zzat(this.zzeza);
        zzeru zzat2 = zzesb.zzat(this.zzhur);
        ScheduledExecutorService scheduledExecutorService = this.zzfty.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbm)).booleanValue()) {
            obj = new zzdty((zzdtw) zzat.get(), scheduledExecutorService);
        } else {
            obj = (zzdtw) zzat2.get();
        }
        return (zzdtw) zzesg.zzbd(obj);
    }
}
