package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcre implements zzesa<zzbzl<zzbsz>> {
    private final zzesn<zzcrp> zzeyk;
    private final zzesn<Executor> zzeyl;

    private zzcre(zzesn<zzcrp> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzeyk = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzcre zzam(zzesn<zzcrp> zzesnVar, zzesn<Executor> zzesnVar2) {
        return new zzcre(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzeyk.get(), this.zzeyl.get()));
    }
}
