package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbxw implements zzesa<Set<zzbzl<com.google.android.gms.ads.internal.overlay.zzp>>> {
    private final zzbxr zzgdc;

    private zzbxw(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbxw zzi(zzbxr zzbxrVar) {
        return new zzbxw(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzand());
    }
}
