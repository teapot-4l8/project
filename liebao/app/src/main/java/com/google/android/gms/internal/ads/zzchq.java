package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzchq implements zzesa<zzcho> {
    private final zzesn<Context> zzece;
    private final zzesn<zzcen> zzfku;
    private final zzesn<zzcdr> zzgff;
    private final zzesn<zzcdf> zzgld;

    private zzchq(zzesn<Context> zzesnVar, zzesn<zzcdr> zzesnVar2, zzesn<zzcen> zzesnVar3, zzesn<zzcdf> zzesnVar4) {
        this.zzece = zzesnVar;
        this.zzgff = zzesnVar2;
        this.zzfku = zzesnVar3;
        this.zzgld = zzesnVar4;
    }

    public static zzchq zzc(zzesn<Context> zzesnVar, zzesn<zzcdr> zzesnVar2, zzesn<zzcen> zzesnVar3, zzesn<zzcdf> zzesnVar4) {
        return new zzchq(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcho(this.zzece.get(), this.zzgff.get(), this.zzfku.get(), this.zzgld.get());
    }
}
