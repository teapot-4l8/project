package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzctt implements zzesa<zzctp> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzcja> zzgiz;
    private final zzesn<zzbmg> zzgvz;

    public zzctt(zzesn<zzbmg> zzesnVar, zzesn<Context> zzesnVar2, zzesn<Executor> zzesnVar3, zzesn<zzcja> zzesnVar4) {
        this.zzgvz = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzfxf = zzesnVar3;
        this.zzgiz = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzctp(this.zzgvz.get(), this.zzeyq.get(), this.zzfxf.get(), this.zzgiz.get());
    }
}
