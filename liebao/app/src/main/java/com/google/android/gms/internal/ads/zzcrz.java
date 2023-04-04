package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcrz implements zzesa<zzcru> {
    private final zzesn<com.google.android.gms.ads.internal.util.zzf> zzecf;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzcrr> zzfci;
    private final zzesn<zzcrl> zzfex;
    private final zzesn<zzbsc> zzgub;

    private zzcrz(zzesn<Context> zzesnVar, zzesn<zzbsc> zzesnVar2, zzesn<zzcrr> zzesnVar3, zzesn<zzcrl> zzesnVar4, zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar5) {
        this.zzeyq = zzesnVar;
        this.zzgub = zzesnVar2;
        this.zzfci = zzesnVar3;
        this.zzfex = zzesnVar4;
        this.zzecf = zzesnVar5;
    }

    public static zzcrz zzg(zzesn<Context> zzesnVar, zzesn<zzbsc> zzesnVar2, zzesn<zzcrr> zzesnVar3, zzesn<zzcrl> zzesnVar4, zzesn<com.google.android.gms.ads.internal.util.zzf> zzesnVar5) {
        return new zzcrz(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcru(this.zzeyq.get(), this.zzgub.get(), this.zzfci.get(), this.zzfex.get(), this.zzecf.get());
    }
}
