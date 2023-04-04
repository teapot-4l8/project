package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzclo implements zzesa<zzclp> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzcmb> zzfac;
    private final zzesn<zzdpz> zzfaq;
    private final zzesn<zzdot> zzfua;
    private final zzesn<zzcsh> zzglz;
    private final zzesn<zzdpi> zzgnw;

    private zzclo(zzesn<Context> zzesnVar, zzesn<zzdpz> zzesnVar2, zzesn<zzcmb> zzesnVar3, zzesn<zzdpi> zzesnVar4, zzesn<zzdot> zzesnVar5, zzesn<zzcsh> zzesnVar6) {
        this.zzeyq = zzesnVar;
        this.zzfaq = zzesnVar2;
        this.zzfac = zzesnVar3;
        this.zzgnw = zzesnVar4;
        this.zzfua = zzesnVar5;
        this.zzglz = zzesnVar6;
    }

    public static zzclo zza(zzesn<Context> zzesnVar, zzesn<zzdpz> zzesnVar2, zzesn<zzcmb> zzesnVar3, zzesn<zzdpi> zzesnVar4, zzesn<zzdot> zzesnVar5, zzesn<zzcsh> zzesnVar6) {
        return new zzclo(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5, zzesnVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzclp(this.zzeyq.get(), this.zzfaq.get(), this.zzfac.get(), this.zzgnw.get(), this.zzfua.get(), this.zzglz.get());
    }
}
