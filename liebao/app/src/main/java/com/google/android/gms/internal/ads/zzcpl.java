package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcpl implements zzesa<zzcpi> {
    private final zzesn<zzayd> zzecg;
    private final zzesn<Context> zzeyq;

    private zzcpl(zzesn<Context> zzesnVar, zzesn<zzayd> zzesnVar2) {
        this.zzeyq = zzesnVar;
        this.zzecg = zzesnVar2;
    }

    public static zzcpl zzal(zzesn<Context> zzesnVar, zzesn<zzayd> zzesnVar2) {
        return new zzcpl(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcpi(this.zzeyq.get(), this.zzecg.get());
    }
}
