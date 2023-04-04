package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbzr implements zzesa<zzbzp> {
    private final zzesn<Set<zzbzl<zzbzq>>> zzfxl;

    private zzbzr(zzesn<Set<zzbzl<zzbzq>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbzr zzu(zzesn<Set<zzbzl<zzbzq>>> zzesnVar) {
        return new zzbzr(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbzp(this.zzfxl.get());
    }
}
