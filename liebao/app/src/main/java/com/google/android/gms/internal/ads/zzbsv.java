package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbsv implements zzesa<zzbst> {
    private final zzesn<Set<zzbzl<zzve>>> zzfxl;

    private zzbsv(zzesn<Set<zzbzl<zzve>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbsv zzg(zzesn<Set<zzbzl<zzve>>> zzesnVar) {
        return new zzbsv(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbst(this.zzfxl.get());
    }
}
