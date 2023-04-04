package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbya implements zzesa<Set<zzbzl<zzbtm>>> {
    private final zzbxr zzgdc;

    private zzbya(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbya zzn(zzbxr zzbxrVar) {
        return new zzbya(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzamv());
    }
}
