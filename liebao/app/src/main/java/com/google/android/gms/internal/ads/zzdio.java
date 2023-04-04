package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdio implements zzesa<zzdim> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zztk> zzfad;

    public zzdio(zzesn<zztk> zzesnVar, zzesn<zzebs> zzesnVar2, zzesn<Context> zzesnVar3) {
        this.zzfad = zzesnVar;
        this.zzeyl = zzesnVar2;
        this.zzeyq = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdim(this.zzfad.get(), this.zzeyl.get(), this.zzeyq.get());
    }
}
