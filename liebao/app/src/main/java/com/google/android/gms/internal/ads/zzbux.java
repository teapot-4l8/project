package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbux implements zzesa<zzbur> {
    private final zzesn<Set<zzbzl<com.google.android.gms.ads.internal.overlay.zzp>>> zzfxl;

    private zzbux(zzesn<Set<zzbzl<com.google.android.gms.ads.internal.overlay.zzp>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbux zzo(zzesn<Set<zzbzl<com.google.android.gms.ads.internal.overlay.zzp>>> zzesnVar) {
        return new zzbux(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbur(this.zzfxl.get());
    }
}
