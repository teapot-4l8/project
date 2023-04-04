package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbxc implements zzesa<zzbwx> {
    private final zzesn<Set<zzbzl<zzbxb>>> zzfxl;

    private zzbxc(zzesn<Set<zzbzl<zzbxb>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbxc zzq(zzesn<Set<zzbzl<zzbxb>>> zzesnVar) {
        return new zzbxc(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbwx(this.zzfxl.get());
    }
}
