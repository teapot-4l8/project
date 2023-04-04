package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbzm implements zzesa<zzbzk> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Set<zzbzl<zzqw>>> zzfxl;
    private final zzesn<zzdot> zzfxz;

    private zzbzm(zzesn<Context> zzesnVar, zzesn<Set<zzbzl<zzqw>>> zzesnVar2, zzesn<zzdot> zzesnVar3) {
        this.zzeyq = zzesnVar;
        this.zzfxl = zzesnVar2;
        this.zzfxz = zzesnVar3;
    }

    public static zzbzm zzo(zzesn<Context> zzesnVar, zzesn<Set<zzbzl<zzqw>>> zzesnVar2, zzesn<zzdot> zzesnVar3) {
        return new zzbzm(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbzk(this.zzeyq.get(), this.zzfxl.get(), this.zzfxz.get());
    }
}
