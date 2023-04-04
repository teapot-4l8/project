package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbxu implements zzesa<Set<zzbzl<zzbtp>>> {
    private final zzbxr zzgdc;

    private zzbxu(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbxu zzh(zzbxr zzbxrVar) {
        return new zzbxu(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.emptySet());
    }
}
