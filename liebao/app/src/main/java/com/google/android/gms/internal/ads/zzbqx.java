package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbqx implements zzesa<zzbzl<zzbtq>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbkz> zzfvz;

    private zzbqx(zzesn<zzbkz> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzfvz = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzbqx zzj(zzesn<zzbkz> zzesnVar, zzesn<Executor> zzesnVar2) {
        return new zzbqx(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), this.zzeyl.get()));
    }
}