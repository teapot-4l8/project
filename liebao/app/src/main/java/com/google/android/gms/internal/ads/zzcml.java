package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcml implements zzesa<zzcmg> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzdue> zzeyz;
    private final zzesn<zzbas> zzfab;
    private final zzesn<zzdug> zzgow;

    public zzcml(zzesn<Executor> zzesnVar, zzesn<zzbas> zzesnVar2, zzesn<zzdue> zzesnVar3, zzesn<zzdug> zzesnVar4) {
        this.zzeyl = zzesnVar;
        this.zzfab = zzesnVar2;
        this.zzeyz = zzesnVar3;
        this.zzgow = zzesnVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcmg(this.zzeyl.get(), this.zzfab.get(), this.zzeyz.get(), this.zzgow.get());
    }
}
