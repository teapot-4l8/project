package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbrf implements zzesa<zzbzl<zzbtc>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzclp> zzgab;
    private final zzesn<zzcqv> zzgac;

    private zzbrf(zzesn<zzclp> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzcqv> zzesnVar3) {
        this.zzgab = zzesnVar;
        this.zzeyl = zzesnVar2;
        this.zzgac = zzesnVar3;
    }

    public static zzbrf zzh(zzesn<zzclp> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzcqv> zzesnVar3) {
        return new zzbrf(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        zzbzl zzbzlVar;
        zzclp zzclpVar = this.zzgab.get();
        Executor executor = this.zzeyl.get();
        zzcqv zzcqvVar = this.zzgac.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            zzbzlVar = new zzbzl(zzcqvVar, executor);
        } else {
            zzbzlVar = new zzbzl(zzclpVar, executor);
        }
        return (zzbzl) zzesg.zzbd(zzbzlVar);
    }
}
