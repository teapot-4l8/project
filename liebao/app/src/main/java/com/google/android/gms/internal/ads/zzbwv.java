package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbwv implements zzesa<zzbwt> {
    private final zzesn<Set<zzbzl<zzbwy>>> zzfxl;

    private zzbwv(zzesn<Set<zzbzl<zzbwy>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbwv zzp(zzesn<Set<zzbzl<zzbwy>>> zzesnVar) {
        return new zzbwv(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbwt(this.zzfxl.get());
    }
}
