package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcls implements zzesa<zzbzl<zzbsz>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzclr> zzgab;
    private final zzesn<zzcqx> zzgac;

    private zzcls(zzesn<zzclr> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzcqx> zzesnVar3) {
        this.zzgab = zzesnVar;
        this.zzeyl = zzesnVar2;
        this.zzgac = zzesnVar3;
    }

    public static zzcls zzs(zzesn<zzclr> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzcqx> zzesnVar3) {
        return new zzcls(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        zzbzl zzbzlVar;
        zzclr zzclrVar = this.zzgab.get();
        Executor executor = this.zzeyl.get();
        zzcqx zzcqxVar = this.zzgac.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            zzbzlVar = new zzbzl(zzcqxVar, executor);
        } else {
            zzbzlVar = new zzbzl(zzclrVar, executor);
        }
        return (zzbzl) zzesg.zzbd(zzbzlVar);
    }
}
