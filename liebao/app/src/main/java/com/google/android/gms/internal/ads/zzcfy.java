package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcfy implements zzesa<zzcfw> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<com.google.android.gms.ads.internal.util.zzay> zzffr;
    private final zzesn<Clock> zzfvh;

    public zzcfy(zzesn<com.google.android.gms.ads.internal.util.zzay> zzesnVar, zzesn<Clock> zzesnVar2, zzesn<Executor> zzesnVar3) {
        this.zzffr = zzesnVar;
        this.zzfvh = zzesnVar2;
        this.zzeyl = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcfw(this.zzffr.get(), this.zzfvh.get(), this.zzeyl.get());
    }
}
