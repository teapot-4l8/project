package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcn implements zzesa<zzdcm> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzebt<String>> zzhdj;

    private zzdcn(zzesn<zzebt<String>> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzhdj = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzdcn zzas(zzesn<zzebt<String>> zzesnVar, zzesn<Executor> zzesnVar2) {
        return new zzdcn(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdcm(this.zzhdj.get(), this.zzeyl.get());
    }
}
