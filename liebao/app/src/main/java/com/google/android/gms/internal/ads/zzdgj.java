package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdgj implements zzesa<zzdgg> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzczb> zzezl;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<String> zzfvk;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzcyz> zzgzb;

    private zzdgj(zzesn<zzebs> zzesnVar, zzesn<ScheduledExecutorService> zzesnVar2, zzesn<String> zzesnVar3, zzesn<zzczb> zzesnVar4, zzesn<Context> zzesnVar5, zzesn<zzdpm> zzesnVar6, zzesn<zzcyz> zzesnVar7) {
        this.zzeyl = zzesnVar;
        this.zzfty = zzesnVar2;
        this.zzfvk = zzesnVar3;
        this.zzezl = zzesnVar4;
        this.zzeyq = zzesnVar5;
        this.zzfxn = zzesnVar6;
        this.zzgzb = zzesnVar7;
    }

    public static zzdgj zzc(zzesn<zzebs> zzesnVar, zzesn<ScheduledExecutorService> zzesnVar2, zzesn<String> zzesnVar3, zzesn<zzczb> zzesnVar4, zzesn<Context> zzesnVar5, zzesn<zzdpm> zzesnVar6, zzesn<zzcyz> zzesnVar7) {
        return new zzdgj(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5, zzesnVar6, zzesnVar7);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdgg(this.zzeyl.get(), this.zzfty.get(), this.zzfvk.get(), this.zzezl.get(), this.zzeyq.get(), this.zzfxn.get(), this.zzgzb.get());
    }
}
