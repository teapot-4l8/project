package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcay implements zzesa<zzbzl<zzbsy>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcbx> zzfvz;
    private final zzcak zzgdr;

    private zzcay(zzcak zzcakVar, zzesn<zzcbx> zzesnVar, zzesn<Executor> zzesnVar2) {
        this.zzgdr = zzcakVar;
        this.zzfvz = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzcay zzb(zzcak zzcakVar, zzesn<zzcbx> zzesnVar, zzesn<Executor> zzesnVar2) {
        return new zzcay(zzcakVar, zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(new zzbzl(this.zzfvz.get(), this.zzeyl.get()));
    }
}
