package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbtk implements zzesa<zzbtf> {
    private final zzesn<Set<zzbzl<zzbtm>>> zzfxl;

    private zzbtk(zzesn<Set<zzbzl<zzbtm>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbtk zzh(zzesn<Set<zzbzl<zzbtm>>> zzesnVar) {
        return new zzbtk(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbtf(this.zzfxl.get());
    }
}
