package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbtv implements zzesa<zzbts> {
    private final zzesn<Set<zzbzl<zzbtp>>> zzfxl;

    private zzbtv(zzesn<Set<zzbzl<zzbtp>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbtv zzj(zzesn<Set<zzbzl<zzbtp>>> zzesnVar) {
        return new zzbtv(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbts(this.zzfxl.get());
    }
}
