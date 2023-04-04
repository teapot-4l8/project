package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbyh implements zzesa<Set<zzbzl<zzbus>>> {
    private final zzbxr zzgdc;

    private zzbyh(zzbxr zzbxrVar) {
        this.zzgdc = zzbxrVar;
    }

    public static zzbyh zzv(zzbxr zzbxrVar) {
        return new zzbyh(zzbxrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(this.zzgdc.zzana());
    }
}
