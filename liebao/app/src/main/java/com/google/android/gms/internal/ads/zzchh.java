package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzchh implements zzesa<zzcgs> {
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzcja> zzgiz;

    public zzchh(zzesn<zzdpm> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzcja> zzesnVar3) {
        this.zzfxn = zzesnVar;
        this.zzfxf = zzesnVar2;
        this.zzgiz = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcgs(this.zzfxn.get(), this.zzfxf.get(), this.zzgiz.get());
    }
}
