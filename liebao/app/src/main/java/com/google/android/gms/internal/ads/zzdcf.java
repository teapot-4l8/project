package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcf implements zzesa<zzdcd> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<ViewGroup> zzgxx;
    private final zzesn<zzebs> zzhdg;

    public zzdcf(zzesn<zzebs> zzesnVar, zzesn<Context> zzesnVar2, zzesn<zzdpm> zzesnVar3, zzesn<ViewGroup> zzesnVar4) {
        this.zzhdg = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzfxn = zzesnVar3;
        this.zzgxx = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdcd(this.zzhdg.get(), this.zzeyq.get(), this.zzfxn.get(), this.zzgxx.get());
    }
}
