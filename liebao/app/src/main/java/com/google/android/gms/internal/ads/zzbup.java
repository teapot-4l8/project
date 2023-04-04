package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbup implements zzesa<zzbun> {
    private final zzesn<Set<zzbzl<zzbus>>> zzfxl;

    private zzbup(zzesn<Set<zzbzl<zzbus>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbup zzn(zzesn<Set<zzbzl<zzbus>>> zzesnVar) {
        return new zzbup(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbun(this.zzfxl.get());
    }
}
