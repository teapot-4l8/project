package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbsd implements zzesa<zzbsa> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdot> zzfxz;
    private final zzesn<zzaso> zzgau;

    private zzbsd(zzesn<Context> zzesnVar, zzesn<zzdot> zzesnVar2, zzesn<zzaso> zzesnVar3) {
        this.zzeyq = zzesnVar;
        this.zzfxz = zzesnVar2;
        this.zzgau = zzesnVar3;
    }

    public static zzbsd zzl(zzesn<Context> zzesnVar, zzesn<zzdot> zzesnVar2, zzesn<zzaso> zzesnVar3) {
        return new zzbsd(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbsa(this.zzeyq.get(), this.zzfxz.get(), this.zzgau.get());
    }
}
