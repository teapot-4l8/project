package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcag implements zzesa<zzcaa> {
    private final zzesn<Set<zzbzl<VideoController.VideoLifecycleCallbacks>>> zzfxl;

    private zzcag(zzesn<Set<zzbzl<VideoController.VideoLifecycleCallbacks>>> zzesnVar) {
        this.zzfxl = zzesnVar;
    }

    public static zzcag zzv(zzesn<Set<zzbzl<VideoController.VideoLifecycleCallbacks>>> zzesnVar) {
        return new zzcag(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcaa(this.zzfxl.get());
    }
}
