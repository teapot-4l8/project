package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbzz implements zzesa<zzbzv> {
    private final zzesn<Set<zzbzl<zzaiw>>> zzfxl;

    public zzbzz(zzesn<Set<zzbzl<zzaiw>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbzv(this.zzfxl.get());
    }
}
