package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzclu implements zzesa<zzbzl<zzdtm>> {
    private final zzesn<Executor> zzeyl;
    private final zzesn<zzcmf> zzgab;
    private final zzesn<zzcrd> zzgac;

    private zzclu(zzesn<zzcmf> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzcrd> zzesnVar3) {
        this.zzgab = zzesnVar;
        this.zzeyl = zzesnVar2;
        this.zzgac = zzesnVar3;
    }

    public static zzclu zzu(zzesn<zzcmf> zzesnVar, zzesn<Executor> zzesnVar2, zzesn<zzcrd> zzesnVar3) {
        return new zzclu(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        zzbzl zzbzlVar;
        zzcmf zzcmfVar = this.zzgab.get();
        Executor executor = this.zzeyl.get();
        zzcrd zzcrdVar = this.zzgac.get();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbl)).booleanValue()) {
            zzbzlVar = new zzbzl(zzcrdVar, executor);
        } else {
            zzbzlVar = new zzbzl(zzcmfVar, executor);
        }
        return (zzbzl) zzesg.zzbd(zzbzlVar);
    }
}
