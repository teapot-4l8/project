package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbxz implements zzesa<Set<zzbzl<zzbwy>>> {
    private final zzbxr zzgdc;

    private zzbxz(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbxz zzm(zzbxr zzbxrVar) {
        return new zzbxz(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.emptySet());
    }
}
