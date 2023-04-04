package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzche implements zzesa<zzchb> {
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzblv> zzgja;
    private final zzesn<zzbzk> zzgla;

    public zzche(zzesn<Executor> zzesnVar, zzesn<zzblv> zzesnVar2, zzesn<zzbzk> zzesnVar3) {
        this.zzfxf = zzesnVar;
        this.zzgja = zzesnVar2;
        this.zzgla = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzchb(this.zzfxf.get(), this.zzgja.get(), this.zzgla.get());
    }
}
