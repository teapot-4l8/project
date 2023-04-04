package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdes implements zzesa<zzdeq> {
    private final zzesn<zzebs> zzeyl;
    private final zzesn<Context> zzeyq;

    private zzdes(zzesn<Context> zzesnVar, zzesn<zzebs> zzesnVar2) {
        this.zzeyq = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzdes zzaw(zzesn<Context> zzesnVar, zzesn<zzebs> zzesnVar2) {
        return new zzdes(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdeq(this.zzeyq.get(), this.zzeyl.get());
    }
}
