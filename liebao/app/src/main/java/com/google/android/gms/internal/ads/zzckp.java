package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzckp implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<zzcku> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzckp(zzesn<zzcku> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzeyk = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzckp zzab(zzesn<zzcku> zzesnVar, zzesn<Executor> zzesnVar2) {
        return new zzckp(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
