package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcup implements zzesa<zzcuk> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzcbj> zzgvz;
    private final zzesn<zzdor> zzgww;

    public zzcup(zzesn<Context> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzcbj> zzesnVar3, zzesn<zzdor> zzesnVar4) {
        this.zzeyq = zzesnVar;
        this.zzfxf = zzesnVar2;
        this.zzgvz = zzesnVar3;
        this.zzgww = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcuk(this.zzeyq.get(), this.zzfxf.get(), this.zzgvz.get(), this.zzgww.get());
    }
}
