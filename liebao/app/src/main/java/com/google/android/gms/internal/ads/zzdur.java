package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdur implements zzesa<zzdup> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbas> zzeyu;

    public zzdur(zzesn<Executor> zzesnVar, zzesn<zzbas> zzesnVar2) {
        this.zzeyl = zzesnVar;
        this.zzeyu = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdup(this.zzeyl.get(), this.zzeyu.get());
    }
}
