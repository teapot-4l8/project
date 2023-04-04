package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbla implements zzesa<zzbkz> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdun> zzffe;
    private final zzesn<zzacv> zzfft;
    private final zzesn<zzdpu> zzfij;
    private final zzesn<ScheduledExecutorService> zzfty;
    private final zzesn<zzdpi> zzftz;
    private final zzesn<zzdot> zzfua;
    private final zzesn<View> zzfub;
    private final zzesn<zzei> zzfuc;
    private final zzesn<zzacw> zzfud;

    private zzbla(zzesn<Context> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<ScheduledExecutorService> zzesnVar3, zzesn<zzdpi> zzesnVar4, zzesn<zzdot> zzesnVar5, zzesn<zzdun> zzesnVar6, zzesn<zzdpu> zzesnVar7, zzesn<View> zzesnVar8, zzesn<zzei> zzesnVar9, zzesn<zzacv> zzesnVar10, zzesn<zzacw> zzesnVar11) {
        this.zzeyq = zzesnVar;
        this.zzeyl = zzesnVar2;
        this.zzfty = zzesnVar3;
        this.zzftz = zzesnVar4;
        this.zzfua = zzesnVar5;
        this.zzffe = zzesnVar6;
        this.zzfij = zzesnVar7;
        this.zzfub = zzesnVar8;
        this.zzfuc = zzesnVar9;
        this.zzfft = zzesnVar10;
        this.zzfud = zzesnVar11;
    }

    public static zzbla zza(zzesn<Context> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<ScheduledExecutorService> zzesnVar3, zzesn<zzdpi> zzesnVar4, zzesn<zzdot> zzesnVar5, zzesn<zzdun> zzesnVar6, zzesn<zzdpu> zzesnVar7, zzesn<View> zzesnVar8, zzesn<zzei> zzesnVar9, zzesn<zzacv> zzesnVar10, zzesn<zzacw> zzesnVar11) {
        return new zzbla(zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4, zzesnVar5, zzesnVar6, zzesnVar7, zzesnVar8, zzesnVar9, zzesnVar10, zzesnVar11);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzbkz(this.zzeyq.get(), this.zzeyl.get(), this.zzfty.get(), this.zzftz.get(), this.zzfua.get(), this.zzffe.get(), this.zzfij.get(), this.zzfub.get(), this.zzfuc.get(), this.zzfft.get(), this.zzfud.get());
    }
}
