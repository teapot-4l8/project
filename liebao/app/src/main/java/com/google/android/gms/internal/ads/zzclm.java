package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzclm implements zzesa<zzcll> {
    private final zzesn<zztz> zzgma;
    private final zzesn<Map<zzdth, zzcln>> zzgns;

    private zzclm(zzesn<zztz> zzesnVar, zzesn<Map<zzdth, zzcln>> zzesnVar2) {
        this.zzgma = zzesnVar;
        this.zzgns = zzesnVar2;
    }

    public static zzclm zzae(zzesn<zztz> zzesnVar, zzesn<Map<zzdth, zzcln>> zzesnVar2) {
        return new zzclm(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcll(this.zzgma.get(), this.zzgns.get());
    }
}
