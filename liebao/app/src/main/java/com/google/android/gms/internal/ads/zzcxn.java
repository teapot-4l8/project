package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcxn implements zzesa<zzcxc> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzcja> zzgiz;
    private final zzesn<zzcis> zzgvz;
    private final zzesn<zzail> zzgwa;

    public zzcxn(zzesn<Context> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<zzdpm> zzesnVar3, zzesn<Executor> zzesnVar4, zzesn<zzcis> zzesnVar5, zzesn<zzcja> zzesnVar6, zzesn<zzail> zzesnVar7) {
        this.zzeyq = zzesnVar;
        this.zzfvj = zzesnVar2;
        this.zzfxn = zzesnVar3;
        this.zzfxf = zzesnVar4;
        this.zzgvz = zzesnVar5;
        this.zzgiz = zzesnVar6;
        this.zzgwa = zzesnVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcxc(this.zzeyq.get(), this.zzfvj.get(), this.zzfxn.get(), this.zzfxf.get(), this.zzgvz.get(), this.zzgiz.get(), this.zzgwa.get());
    }
}
