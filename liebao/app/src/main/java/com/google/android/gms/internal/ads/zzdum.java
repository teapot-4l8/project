package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdum implements zzesa<zzdun> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdph> zzfri;
    private final zzesn<zzei> zzfuc;
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<String> zzhec;
    private final zzesn<String> zzhed;
    private final zzesn<zzcwk> zzhuy;

    private zzdum(zzesn<zzcwk> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<String> zzesnVar3, zzesn<String> zzesnVar4, zzesn<Context> zzesnVar5, zzesn<zzdph> zzesnVar6, zzesn<Clock> zzesnVar7, zzesn<zzei> zzesnVar8) {
        this.zzhuy = zzesnVar;
        this.zzfvj = zzesnVar2;
        this.zzhec = zzesnVar3;
        this.zzhed = zzesnVar4;
        this.zzeyq = zzesnVar5;
        this.zzfri = zzesnVar6;
        this.zzfvh = zzesnVar7;
        this.zzfuc = zzesnVar8;
    }

    public static zzdum zzb(zzesn<zzcwk> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<String> zzesnVar3, zzesn<String> zzesnVar4, zzesn<Context> zzesnVar5, zzesn<zzdph> zzesnVar6, zzesn<Clock> zzesnVar7, zzesn<zzei> zzesnVar8) {
        return new zzdum(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5, zzesnVar6, zzesnVar7, zzesnVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdun(this.zzhuy.get(), this.zzfvj.get(), this.zzhec.get(), this.zzhed.get(), this.zzeyq.get(), this.zzfri.get(), this.zzfvh.get(), this.zzfuc.get());
    }
}
