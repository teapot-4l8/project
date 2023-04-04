package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbou implements zzesa<zzbov> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<zzbfi> zzfxc;
    private final zzesn<zzdot> zzfxz;

    public zzbou(zzesn<Context> zzesnVar, zzesn<zzbfi> zzesnVar2, zzesn<zzdot> zzesnVar3, zzesn<zzbar> zzesnVar4) {
        this.zzeyq = zzesnVar;
        this.zzfxc = zzesnVar2;
        this.zzfxz = zzesnVar3;
        this.zzfsw = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbov(this.zzeyq.get(), this.zzfxc.get(), this.zzfxz.get(), this.zzfsw.get());
    }
}
