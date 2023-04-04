package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcr implements zzesa<zzdcp> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzddz<zzdhh>> zzfak;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzazs> zzhdo;

    private zzdcr(zzesn<zzddz<zzdhh>> zzesnVar, zzesn<zzdpm> zzesnVar2, zzesn<Context> zzesnVar3, zzesn<zzazs> zzesnVar4) {
        this.zzfak = zzesnVar;
        this.zzfxn = zzesnVar2;
        this.zzeyq = zzesnVar3;
        this.zzhdo = zzesnVar4;
    }

    public static zzdcr zzg(zzesn<zzddz<zzdhh>> zzesnVar, zzesn<zzdpm> zzesnVar2, zzesn<Context> zzesnVar3, zzesn<zzazs> zzesnVar4) {
        return new zzdcr(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdcp(this.zzfak.get(), this.zzfxn.get(), this.zzeyq.get(), this.zzhdo.get());
    }
}
