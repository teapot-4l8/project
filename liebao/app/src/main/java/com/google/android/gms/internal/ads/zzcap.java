package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcap implements zzesa<Set<zzbzl<zzbtm>>> {
    private final zzesn<zzbrx> zzfvz;
    private final zzcak zzgdr;

    private zzcap(zzcak zzcakVar, zzesn<zzbrx> zzesnVar) {
        this.zzgdr = zzcakVar;
        this.zzfvz = zzesnVar;
    }

    public static zzcap zza(zzcak zzcakVar, zzesn<zzbrx> zzesnVar) {
        return new zzcap(zzcakVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.singleton(zzbzl.zzb(this.zzfvz.get(), zzbat.zzekj)));
    }
}
