package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcnm implements zzesa<zzcna> {
    private final zzesn<zzckb> zzeyj;
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcmk> zzezp;
    private final zzesn<zzbyr> zzezt;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<Executor> zzfxf;
    private final zzesn<Context> zzgpv;
    private final zzesn<WeakReference<Context>> zzgpw;

    public zzcnm(zzesn<Executor> zzesnVar, zzesn<Context> zzesnVar2, zzesn<WeakReference<Context>> zzesnVar3, zzesn<Executor> zzesnVar4, zzesn<zzckb> zzesnVar5, zzesn<ScheduledExecutorService> zzesnVar6, zzesn<zzcmk> zzesnVar7, zzesn<zzbar> zzesnVar8, zzesn<zzbyr> zzesnVar9) {
        this.zzfxf = zzesnVar;
        this.zzgpv = zzesnVar2;
        this.zzgpw = zzesnVar3;
        this.zzeyl = zzesnVar4;
        this.zzeyj = zzesnVar5;
        this.zzfty = zzesnVar6;
        this.zzezp = zzesnVar7;
        this.zzfvj = zzesnVar8;
        this.zzezt = zzesnVar9;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcna(this.zzfxf.get(), this.zzgpv.get(), this.zzgpw.get(), this.zzeyl.get(), this.zzeyj.get(), this.zzfty.get(), this.zzezp.get(), this.zzfvj.get(), this.zzezt.get());
    }
}
