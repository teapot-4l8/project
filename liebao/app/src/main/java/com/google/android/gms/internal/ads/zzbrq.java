package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbrq implements zzesa<zzbrr> {
    private final zzesn<Context> zzece;
    private final zzesn<com.google.android.gms.ads.internal.util.zzf> zzeck;
    private final zzesn<zzcna> zzezu;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<zzdpm> zzfxn;

    private zzbrq(zzesn<Context> zzesnVar, zzesn<zzdpm> zzesnVar2, zzesn<zzbar> zzesnVar3, zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar4, zzesn<zzcna> zzesnVar5) {
        this.zzece = zzesnVar;
        this.zzfxn = zzesnVar2;
        this.zzfvj = zzesnVar3;
        this.zzeck = zzesnVar4;
        this.zzezu = zzesnVar5;
    }

    public static zzbrq zzb(zzesn<Context> zzesnVar, zzesn<zzdpm> zzesnVar2, zzesn<zzbar> zzesnVar3, zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar4, zzesn<zzcna> zzesnVar5) {
        return new zzbrq(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbrr(this.zzece.get(), this.zzfxn.get(), this.zzfvj.get(), this.zzeck.get(), this.zzezu.get());
    }
}
