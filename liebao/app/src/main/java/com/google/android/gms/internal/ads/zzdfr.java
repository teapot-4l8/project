package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfr implements zzesa<zzdfp> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzebs> zzhdg;
    private final zzesn<Set<String>> zzhdt;

    private zzdfr(zzesn<zzebs> zzesnVar, zzesn<Context> zzesnVar2, zzesn<Set<String>> zzesnVar3) {
        this.zzhdg = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzhdt = zzesnVar3;
    }

    public static zzdfr zzaa(zzesn<zzebs> zzesnVar, zzesn<Context> zzesnVar2, zzesn<Set<String>> zzesnVar3) {
        return new zzdfr(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdfp(this.zzhdg.get(), this.zzeyq.get(), this.zzhdt.get());
    }
}
