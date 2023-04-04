package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbuk implements zzesa<zzbui> {
    private final zzesn<Set<zzbzl<zzbuj>>> zzfxl;

    private zzbuk(zzesn<Set<zzbzl<zzbuj>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbuk zzl(zzesn<Set<zzbzl<zzbuj>>> zzesnVar) {
        return new zzbuk(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbui(this.zzfxl.get());
    }
}
