package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbuo implements zzesa<zzbum> {
    private final zzesn<Set<zzbzl<AdMetadataListener>>> zzfxl;

    private zzbuo(zzesn<Set<zzbzl<AdMetadataListener>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzbuo zzm(zzesn<Set<zzbzl<AdMetadataListener>>> zzesnVar) {
        return new zzbuo(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbum(this.zzfxl.get());
    }
}
