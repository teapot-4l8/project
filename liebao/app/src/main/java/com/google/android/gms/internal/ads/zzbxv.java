package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbxv implements zzesa<zzbsx> {
    private final zzbxr zzgdc;
    private final zzesn<Set<zzbzl<zzbsz>>> zzgdd;

    private zzbxv(zzbxr zzbxrVar, zzesn<Set<zzbzl<zzbsz>>> zzesnVar) {
        this.zzgdc = zzbxrVar;
        this.zzgdd = zzesnVar;
    }

    public static zzbxv zza(zzbxr zzbxrVar, zzesn<Set<zzbzl<zzbsz>>> zzesnVar) {
        return new zzbxv(zzbxrVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbsx) zzesg.zzbd(this.zzgdc.zzc(this.zzgdd.get()));
    }
}
