package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcsw implements zzesa<zzcsr> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzcmb> zzfac;
    private final zzesn<zzcsh> zzglz;
    private final zzesn<zzdtw> zzgma;
    private final zzesn<zzbas> zzgve;

    public zzcsw(zzesn<Context> zzesnVar, zzesn<zzcsh> zzesnVar2, zzesn<zzbas> zzesnVar3, zzesn<zzcmb> zzesnVar4, zzesn<zzdtw> zzesnVar5) {
        this.zzeyq = zzesnVar;
        this.zzglz = zzesnVar2;
        this.zzgve = zzesnVar3;
        this.zzfac = zzesnVar4;
        this.zzgma = zzesnVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcsr(this.zzeyq.get(), this.zzglz.get(), this.zzgve.get(), this.zzfac.get(), this.zzgma.get());
    }
}
