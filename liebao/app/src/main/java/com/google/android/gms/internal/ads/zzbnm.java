package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbnm implements zzesa<zzbui> {
    private final zzbnl zzfxk;
    private final zzesn<Set<zzbzl<zzbuj>>> zzfxl;

    public zzbnm(zzbnl zzbnlVar, zzesn<Set<zzbzl<zzbuj>>> zzesnVar) {
        this.zzfxk = zzbnlVar;
        this.zzfxl = zzesnVar;
    }

    public static zzbui zza(zzbnl zzbnlVar, Set<zzbzl<zzbuj>> set) {
        return (zzbui) zzesg.zzbd(zzbnlVar.zza(set));
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzfxk, this.zzfxl.get());
    }
}
