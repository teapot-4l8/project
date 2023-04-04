package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdtp implements zzesa<zzdtg> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<zzdtj> zzfcm;
    private final zzesn<ScheduledExecutorService> zzfwv;

    private zzdtp(zzesn<zzebs> zzesnVar, zzesn<ScheduledExecutorService> zzesnVar2, zzesn<zzdtj> zzesnVar3) {
        this.zzeyl = zzesnVar;
        this.zzfwv = zzesnVar2;
        this.zzfcm = zzesnVar3;
    }

    public static zzdtp zzad(zzesn<zzebs> zzesnVar, zzesn<ScheduledExecutorService> zzesnVar2, zzesn<zzdtj> zzesnVar3) {
        return new zzdtp(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdtg(this.zzeyl.get(), this.zzfwv.get(), this.zzfcm.get());
    }
}
