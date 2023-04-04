package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcmh implements zzesa<zzcmf> {
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzclz> zzgon;
    private final zzesn<Set<zzcme>> zzgoo;

    private zzcmh(zzesn<zzclz> zzesnVar, zzesn<Set<zzcme>> zzesnVar2, zzesn<Clock> zzesnVar3) {
        this.zzgon = zzesnVar;
        this.zzgoo = zzesnVar2;
        this.zzfvh = zzesnVar3;
    }

    public static zzcmh zzw(zzesn<zzclz> zzesnVar, zzesn<Set<zzcme>> zzesnVar2, zzesn<Clock> zzesnVar3) {
        return new zzcmh(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcmf(this.zzgon.get(), this.zzgoo.get(), this.zzfvh.get());
    }
}
