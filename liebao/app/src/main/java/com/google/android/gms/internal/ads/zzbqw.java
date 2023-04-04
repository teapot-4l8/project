package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbqw implements zzesa<zzbzl<zzbuj>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzbkz> zzfvz;

    private zzbqw(zzesn<zzbkz> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzfvz = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzbqw zzi(zzesn<zzbkz> zzesnVar, zzesn<Executor> zzesnVar2) {
        return new zzbqw(zzesnVar, zzesnVar2);
    }

    public static zzbzl<zzbuj> zza(zzbkz zzbkzVar, Executor executor) {
        return (zzbzl) zzesg.zzbd(new zzbzl(zzbkzVar, executor));
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzfvz.get(), this.zzeyl.get());
    }
}
