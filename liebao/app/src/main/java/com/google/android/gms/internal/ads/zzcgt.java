package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcgt implements zzesa<zzcgp> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcgf> zzgkd;

    public zzcgt(zzesn<Executor> zzesnVar, zzesn<zzcgf> zzesnVar2) {
        this.zzeyl = zzesnVar;
        this.zzgkd = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcgp(this.zzeyl.get(), this.zzgkd.get());
    }
}
