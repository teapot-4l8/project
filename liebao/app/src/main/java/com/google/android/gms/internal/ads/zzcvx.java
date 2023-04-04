package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcvx implements zzesa<zzcvu> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzccf> zzgvz;

    public zzcvx(zzesn<Context> zzesnVar, zzesn<zzccf> zzesnVar2, zzesn<Executor> zzesnVar3) {
        this.zzeyq = zzesnVar;
        this.zzgvz = zzesnVar2;
        this.zzfxf = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcvu(this.zzeyq.get(), this.zzgvz.get(), this.zzfxf.get());
    }
}
