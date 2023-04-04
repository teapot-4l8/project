package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcc implements zzesa<zzdca> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcon> zzgqi;

    public zzdcc(zzesn<Executor> zzesnVar, zzesn<zzcon> zzesnVar2) {
        this.zzeyl = zzesnVar;
        this.zzgqi = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdca(this.zzeyl.get(), this.zzgqi.get());
    }
}
