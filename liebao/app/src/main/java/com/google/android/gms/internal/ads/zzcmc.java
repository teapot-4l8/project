package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcmc implements zzesa<zzcmb> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcmg> zzezo;

    public zzcmc(zzesn<zzcmg> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzezo = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcmb(this.zzezo.get(), this.zzeyl.get());
    }
}
