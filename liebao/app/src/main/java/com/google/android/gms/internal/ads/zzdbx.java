package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdbx implements zzesa<zzebt<zzdcb>> {
    private final zzesn<zzdtg> zzfxq;
    private final zzesn<zzdca> zzhcx;
    private final zzesn<zzbsc> zzhcy;

    public zzdbx(zzesn<zzdtg> zzesnVar, zzesn<zzdca> zzesnVar2, zzesn<zzbsc> zzesnVar3) {
        this.zzfxq = zzesnVar;
        this.zzhcx = zzesnVar2;
        this.zzhcy = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzebt) zzesg.zzbd(this.zzfxq.get().zza((zzdtg) zzdth.GENERATE_SIGNALS, (zzebt) this.zzhcy.get().zzamd()).zza(this.zzhcx.get()).zza(((Integer) zzww.zzra().zzd(zzabq.zzcxi)).intValue(), TimeUnit.SECONDS).zzayi());
    }
}
