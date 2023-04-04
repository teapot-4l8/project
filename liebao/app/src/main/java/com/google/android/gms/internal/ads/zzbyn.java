package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbyn implements zzesa<Set<zzbzl<zzbzq>>> {
    private final zzbxr zzgdc;

    private zzbyn(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbyn zzab(zzbxr zzbxrVar) {
        return new zzbyn(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.emptySet());
    }
}
