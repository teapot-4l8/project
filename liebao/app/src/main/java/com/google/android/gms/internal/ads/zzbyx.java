package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbyx implements zzesa<zzbyr> {
    private final zzesn<Set<zzbzl<zzbyw>>> zzfxl;

    public zzbyx(zzesn<Set<zzbzl<zzbyw>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbyr(this.zzfxl.get());
    }
}
