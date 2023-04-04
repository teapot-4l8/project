package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbxx implements zzesa<Set<zzbzl<zzbuj>>> {
    private final zzbxr zzgdc;

    private zzbxx(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbxx zzj(zzbxr zzbxrVar) {
        return new zzbxx(zzbxrVar);
    }

    public static Set<zzbzl<zzbuj>> zzk(zzbxr zzbxrVar) {
        return (Set) zzesg.zzbd(Collections.emptySet());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzk(this.zzgdc);
    }
}
