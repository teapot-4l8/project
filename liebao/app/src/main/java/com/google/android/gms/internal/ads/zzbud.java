package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbud implements zzesa<zzbty> {
    private final zzesn<Set<zzbzl<zzbsy>>> zzfxl;

    private zzbud(zzesn<Set<zzbzl<zzbsy>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbud zzk(zzesn<Set<zzbzl<zzbsy>>> zzesnVar) {
        return new zzbud(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbty(this.zzfxl.get());
    }
}
