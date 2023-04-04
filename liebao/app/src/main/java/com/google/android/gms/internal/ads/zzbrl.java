package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbrl implements zzesa<zzbzl<zzbvb>> {
    private final zzesn<zzbvl> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzbrl(zzesn<zzbvl> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzeyk = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzbrl zzq(zzesn<zzbvl> zzesnVar, zzesn<Executor> zzesnVar2) {
        return new zzbrl(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
