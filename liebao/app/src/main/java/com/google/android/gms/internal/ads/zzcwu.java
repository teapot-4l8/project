package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwu implements zzesa<zzcws> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzcis> zzgvz;

    public zzcwu(zzesn<Context> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzcis> zzesnVar3) {
        this.zzeyq = zzesnVar;
        this.zzfxf = zzesnVar2;
        this.zzgvz = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcws(this.zzeyq.get(), this.zzfxf.get(), this.zzgvz.get());
    }
}
