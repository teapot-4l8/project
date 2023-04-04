package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbpj<AdT> implements zzesa<zzbpg<AdT>> {
    private final zzesn<Map<String, zzcsz<AdT>>> zzfyt;

    private zzbpj(zzesn<Map<String, zzcsz<AdT>>> zzesnVar) {
        this.zzfyt = zzesnVar;
    }

    public static <AdT> zzbpj<AdT> zzd(zzesn<Map<String, zzcsz<AdT>>> zzesnVar) {
        return new zzbpj<>(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbpg(this.zzfyt.get());
    }
}
