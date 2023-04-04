package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbqa implements zzesa<zzbzl<zzbus>> {
    private final zzesn<zzbva> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzbqa(zzesn<zzbva> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzeyk = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzbqa zzb(zzesn<zzbva> zzesnVar, zzesn<Executor> zzesnVar2) {
        return new zzbqa(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
