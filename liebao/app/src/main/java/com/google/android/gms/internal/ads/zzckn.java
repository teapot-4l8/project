package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzckn implements zzesa<zzbzl<zzbtq>> {
    private final zzesn<zzcku> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzckn(zzesn<zzcku> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzeyk = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzckn zzz(zzesn<zzcku> zzesnVar, zzesn<Executor> zzesnVar2) {
        return new zzckn(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
