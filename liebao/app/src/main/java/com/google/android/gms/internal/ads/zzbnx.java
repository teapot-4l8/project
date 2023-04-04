package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbnx implements zzesa<Set<zzbzl<zzqw>>> {
    private final zzesn<zzbox> zzfvz;
    private final zzbnl zzfxk;

    public zzbnx(zzbnl zzbnlVar, zzesn<zzbox> zzesnVar) {
        this.zzfxk = zzbnlVar;
        this.zzfvz = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Set) zzesg.zzbd(Collections.singleton(new zzbzl(this.zzfvz.get(), zzbat.zzekj)));
    }
}
