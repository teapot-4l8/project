package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbyf implements zzesa<Set<zzbzl<zzbuj>>> {
    private final zzbxr zzgdc;

    private zzbyf(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbyf zzs(zzbxr zzbxrVar) {
        return new zzbyf(zzbxrVar);
    }

    public static Set<zzbzl<zzbuj>> zzt(zzbxr zzbxrVar) {
        return (Set) zzesg.zzbd(zzbxrVar.zzamt());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzt(this.zzgdc);
    }
}
