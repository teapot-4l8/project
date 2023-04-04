package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbxy implements zzesa<Set<zzbzl<zzve>>> {
    private final zzbxr zzgdc;

    private zzbxy(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbxy zzl(zzbxr zzbxrVar) {
        return new zzbxy(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzamy());
    }
}
