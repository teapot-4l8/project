package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdhq implements zzesa<zzdho> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;

    private zzdhq(zzesn<zzebs> zzesnVar, zzesn<Context> zzesnVar2) {
        this.zzeyl = zzesnVar;
        this.zzeyq = zzesnVar2;
    }

    public static zzdhq zzbd(zzesn<zzebs> zzesnVar, zzesn<Context> zzesnVar2) {
        return new zzdhq(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdho(this.zzeyl.get(), this.zzeyq.get());
    }
}
