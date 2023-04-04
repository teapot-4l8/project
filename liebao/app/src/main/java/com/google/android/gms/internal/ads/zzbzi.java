package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbzi implements zzesa<zzbzh> {
    private final zzesn<Set<zzbzl<zzbze>>> zzfxl;

    private zzbzi(zzesn<Set<zzbzl<zzbze>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbzi zzt(zzesn<Set<zzbzl<zzbze>>> zzesnVar) {
        return new zzbzi(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbzh(this.zzfxl.get());
    }
}
