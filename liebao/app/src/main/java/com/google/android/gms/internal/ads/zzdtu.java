package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdtu implements zzesa<zzdts> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbas> zzfab;

    public zzdtu(zzesn<Executor> zzesnVar, zzesn<zzbas> zzesnVar2) {
        this.zzeyl = zzesnVar;
        this.zzfab = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdts(this.zzeyl.get(), this.zzfab.get());
    }
}