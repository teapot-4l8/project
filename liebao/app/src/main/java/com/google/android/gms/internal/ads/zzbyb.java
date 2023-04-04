package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbyb implements zzesa<Set<zzbzl<zzbsz>>> {
    private final zzbxr zzgdc;

    private zzbyb(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbyb zzo(zzbxr zzbxrVar) {
        return new zzbyb(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzamu());
    }
}
