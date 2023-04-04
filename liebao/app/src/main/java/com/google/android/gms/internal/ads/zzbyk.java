package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbyk implements zzesa<Set<zzbzl<zzqw>>> {
    private final zzbxr zzgdc;

    private zzbyk(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbyk zzy(zzbxr zzbxrVar) {
        return new zzbyk(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.emptySet());
    }
}
