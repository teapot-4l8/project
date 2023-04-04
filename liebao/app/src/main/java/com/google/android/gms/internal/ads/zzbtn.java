package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbtn implements zzesa<zzbtl> {
    private final zzesn<Set<zzbzl<zzbtq>>> zzfxl;

    private zzbtn(zzesn<Set<zzbzl<zzbtq>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbtn zzi(zzesn<Set<zzbzl<zzbtq>>> zzesnVar) {
        return new zzbtn(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbtl(this.zzfxl.get());
    }
}
