package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcar implements zzesa<Set<zzbzl<zzbxb>>> {
    private final zzesn<zzbrx> zzfvz;
    private final zzcak zzgdr;

    private zzcar(zzcak zzcakVar, zzesn<zzbrx> zzesnVar) {
        this.zzgdr = zzcakVar;
        this.zzfvz = zzesnVar;
    }

    public static zzcar zzb(zzcak zzcakVar, zzesn<zzbrx> zzesnVar) {
        return new zzcar(zzcakVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.singleton(zzbzl.zzb(this.zzfvz.get(), zzbat.zzekj)));
    }
}
