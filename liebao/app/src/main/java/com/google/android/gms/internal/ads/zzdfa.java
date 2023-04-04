package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfa implements zzesa<zzdey> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzebs> zzhdg;
    private final zzesn<Set<String>> zzhdt;
    private final zzesn<ViewGroup> zzhfd;

    private zzdfa(zzesn<zzebs> zzesnVar, zzesn<ViewGroup> zzesnVar2, zzesn<Context> zzesnVar3, zzesn<Set<String>> zzesnVar4) {
        this.zzhdg = zzesnVar;
        this.zzhfd = zzesnVar2;
        this.zzeyq = zzesnVar3;
        this.zzhdt = zzesnVar4;
    }

    public static zzdfa zzj(zzesn<zzebs> zzesnVar, zzesn<ViewGroup> zzesnVar2, zzesn<Context> zzesnVar3, zzesn<Set<String>> zzesnVar4) {
        return new zzdfa(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdey(this.zzhdg.get(), this.zzhfd.get(), this.zzeyq.get(), this.zzhdt.get());
    }
}
