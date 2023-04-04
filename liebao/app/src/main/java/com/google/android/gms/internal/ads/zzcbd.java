package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcbd implements zzesa<zzbzl<zzbwy>> {
    private final zzesn<Executor> zzeyl;
    private final zzcak zzgdr;

    private zzcbd(zzcak zzcakVar, zzesn<Executor> zzesnVar) {
        this.zzgdr = zzcakVar;
        this.zzeyl = zzesnVar;
    }

    public static zzcbd zzf(zzcak zzcakVar, zzesn<Executor> zzesnVar) {
        return new zzcbd(zzcakVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzl) zzesg.zzbd(this.zzgdr.zzb(this.zzeyl.get()));
    }
}
