package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcvg implements zzesa<zzcve> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzcbj> zzgvz;

    public zzcvg(zzesn<Context> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<zzcbj> zzesnVar3, zzesn<Executor> zzesnVar4) {
        this.zzeyq = zzesnVar;
        this.zzfvj = zzesnVar2;
        this.zzgvz = zzesnVar3;
        this.zzfxf = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcve(this.zzeyq.get(), this.zzfvj.get(), this.zzgvz.get(), this.zzfxf.get());
    }
}
