package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbyd implements zzesa<Set<zzbzl<zzbtq>>> {
    private final zzbxr zzgdc;

    private zzbyd(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbyd zzq(zzbxr zzbxrVar) {
        return new zzbyd(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzamz());
    }
}