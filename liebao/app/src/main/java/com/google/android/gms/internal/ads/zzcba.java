package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcba implements zzesa<Set<zzbzl<zzbze>>> {
    private final zzesn<zzcbv> zzfvz;

    private zzcba(zzesn<zzcbv> zzesnVar) {
        this.zzfvz = zzesnVar;
    }

    public static zzcba zzw(zzesn<zzcbv> zzesnVar) {
        return new zzcba(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.singleton(zzbzl.zzb(this.zzfvz.get(), zzbat.zzekj)));
    }
}
