package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbns implements zzesa<Set<zzbzl<zzbuj>>> {
    private final zzesn<zzbox> zzfvz;
    private final zzbnl zzfxk;

    public zzbns(zzbnl zzbnlVar, zzesn<zzbox> zzesnVar) {
        this.zzfxk = zzbnlVar;
        this.zzfvz = zzesnVar;
    }

    public static Set<zzbzl<zzbuj>> zza(zzbnl zzbnlVar, zzbox zzboxVar) {
        return (Set) zzesg.zzbd(Collections.singleton(new zzbzl(zzboxVar, zzbat.zzekj)));
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzfxk, this.zzfvz.get());
    }
}
