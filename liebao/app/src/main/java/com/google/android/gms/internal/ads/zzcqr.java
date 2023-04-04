package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcqr implements zzesa<zzcqb> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzauw> zzgsn;
    private final zzesn<zzbki> zzgso;
    private final zzesn<zzaux> zzgsp;
    private final zzesn<HashMap<String, zzcqm>> zzgsq;

    private zzcqr(zzesn<Context> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzauw> zzesnVar3, zzesn<zzbki> zzesnVar4, zzesn<zzaux> zzesnVar5, zzesn<HashMap<String, zzcqm>> zzesnVar6) {
        this.zzeyq = zzesnVar;
        this.zzfxf = zzesnVar2;
        this.zzgsn = zzesnVar3;
        this.zzgso = zzesnVar4;
        this.zzgsp = zzesnVar5;
        this.zzgsq = zzesnVar6;
    }

    public static zzcqr zzb(zzesn<Context> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzauw> zzesnVar3, zzesn<zzbki> zzesnVar4, zzesn<zzaux> zzesnVar5, zzesn<HashMap<String, zzcqm>> zzesnVar6) {
        return new zzcqr(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5, zzesnVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcqb(this.zzeyq.get(), this.zzfxf.get(), this.zzgsn.get(), this.zzgso.get(), this.zzgsp.get(), this.zzgsq.get());
    }
}
