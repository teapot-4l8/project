package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcqu implements zzesa<zzcqv> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdpz> zzfaq;
    private final zzesn<zzdot> zzfua;
    private final zzesn<zzcsh> zzglz;
    private final zzesn<zzdtw> zzgma;
    private final zzesn<String> zzgno;
    private final zzesn<zzdpi> zzgnw;

    private zzcqu(zzesn<Context> zzesnVar, zzesn<zzdpz> zzesnVar2, zzesn<zzdpi> zzesnVar3, zzesn<zzdot> zzesnVar4, zzesn<zzcsh> zzesnVar5, zzesn<zzdtw> zzesnVar6, zzesn<String> zzesnVar7) {
        this.zzeyq = zzesnVar;
        this.zzfaq = zzesnVar2;
        this.zzgnw = zzesnVar3;
        this.zzfua = zzesnVar4;
        this.zzglz = zzesnVar5;
        this.zzgma = zzesnVar6;
        this.zzgno = zzesnVar7;
    }

    public static zzcqu zzb(zzesn<Context> zzesnVar, zzesn<zzdpz> zzesnVar2, zzesn<zzdpi> zzesnVar3, zzesn<zzdot> zzesnVar4, zzesn<zzcsh> zzesnVar5, zzesn<zzdtw> zzesnVar6, zzesn<String> zzesnVar7) {
        return new zzcqu(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5, zzesnVar6, zzesnVar7);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcqv(this.zzeyq.get(), this.zzfaq.get(), this.zzgnw.get(), this.zzfua.get(), this.zzglz.get(), this.zzgma.get(), this.zzgno.get());
    }
}
