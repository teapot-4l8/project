package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzctn implements zzesa<zzctg> {
    private final zzesn<Context> zzeyq;
    private final zzesn<Executor> zzfxf;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzbar> zzgbl;
    private final zzesn<zzcja> zzgiz;
    private final zzesn<zzbmt> zzgvz;
    private final zzesn<zzail> zzgwa;

    public zzctn(zzesn<zzbmt> zzesnVar, zzesn<Context> zzesnVar2, zzesn<Executor> zzesnVar3, zzesn<zzcja> zzesnVar4, zzesn<zzdpm> zzesnVar5, zzesn<zzbar> zzesnVar6, zzesn<zzail> zzesnVar7) {
        this.zzgvz = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzfxf = zzesnVar3;
        this.zzgiz = zzesnVar4;
        this.zzfxn = zzesnVar5;
        this.zzgbl = zzesnVar6;
        this.zzgwa = zzesnVar7;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzctg(this.zzgvz.get(), this.zzeyq.get(), this.zzfxf.get(), this.zzgiz.get(), this.zzfxn.get(), this.zzgbl.get(), this.zzgwa.get());
    }
}
