package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdto implements zzesa<zzdtj> {
    private final zzesn<Set<zzbzl<zzdtm>>> zzfxl;

    private zzdto(zzesn<Set<zzbzl<zzdtm>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzdto zzar(zzesn<Set<zzbzl<zzdtm>>> zzesnVar) {
        return new zzdto(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdtj(this.zzfxl.get());
    }
}
