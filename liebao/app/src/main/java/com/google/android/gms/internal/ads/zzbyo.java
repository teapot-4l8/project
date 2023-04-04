package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbyo implements zzesa<Set<zzbzl<VideoController.VideoLifecycleCallbacks>>> {
    private final zzbxr zzgdc;

    private zzbyo(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbyo zzac(zzbxr zzbxrVar) {
        return new zzbyo(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.emptySet());
    }
}
