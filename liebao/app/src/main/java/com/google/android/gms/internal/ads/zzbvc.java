package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbvc implements zzesa<zzbva> {
    private final zzesn<zzdot> zzfua;
    private final zzesn<Set<zzbzl<zzbvb>>> zzfxl;

    private zzbvc(zzesn<Set<zzbzl<zzbvb>>> zzesnVar, zzesn<zzdot> zzesnVar2) {
        this.zzfxl = zzesnVar;
        this.zzfua = zzesnVar2;
    }

    public static zzbvc zzr(zzesn<Set<zzbzl<zzbvb>>> zzesnVar, zzesn<zzdot> zzesnVar2) {
        return new zzbvc(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbva(this.zzfxl.get(), this.zzfua.get());
    }
}
