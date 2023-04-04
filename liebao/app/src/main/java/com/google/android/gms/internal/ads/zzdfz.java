package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdfz implements zzesa<zzdfx> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Bundle> zzhfl;

    private zzdfz(zzesn<zzebs> zzesnVar, zzesn<Bundle> zzesnVar2) {
        this.zzeyl = zzesnVar;
        this.zzhfl = zzesnVar2;
    }

    public static zzdfz zzaz(zzesn<zzebs> zzesnVar, zzesn<Bundle> zzesnVar2) {
        return new zzdfz(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdfx(this.zzeyl.get(), this.zzhfl.get());
    }
}
