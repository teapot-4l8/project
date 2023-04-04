package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcda implements zzesa<zzblv> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzqt> zzgfl;

    public zzcda(zzesn<zzqt> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<Context> zzesnVar3, zzesn<Clock> zzesnVar4) {
        this.zzgfl = zzesnVar;
        this.zzeyl = zzesnVar2;
        this.zzeyq = zzesnVar3;
        this.zzfvh = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzblv) zzesg.zzbd(new zzblv(this.zzeyl.get(), new zzblg(this.zzeyq.get(), this.zzgfl.get()), this.zzfvh.get()));
    }
}
