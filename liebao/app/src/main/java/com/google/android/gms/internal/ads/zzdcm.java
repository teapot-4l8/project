package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcm implements zzdhe<Object> {
    private final Executor executor;
    private final zzebt<String> zzhdi;

    public zzdcm(zzebt<String> zzebtVar, Executor executor) {
        this.zzhdi = zzebtVar;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<Object> zzatu() {
        return zzebh.zzb(this.zzhdi, zzdcl.zzbpa, this.executor);
    }
}
