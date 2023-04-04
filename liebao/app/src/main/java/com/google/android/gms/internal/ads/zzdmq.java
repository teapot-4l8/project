package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdmq implements zzesa<zzdmh<zzcis, zzcip>> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdqs> zzfba;
    private final zzesn<zzdrn> zzfbb;

    public zzdmq(zzesn<Context> zzesnVar, zzesn<zzdqs> zzesnVar2, zzesn<zzdrn> zzesnVar3) {
        this.zzeyq = zzesnVar;
        this.zzfba = zzesnVar2;
        this.zzfbb = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        Object zzdlzVar;
        Context context = this.zzeyq.get();
        zzdqs zzdqsVar = this.zzfba.get();
        zzdrn zzdrnVar = this.zzfbb.get();
        if (((Integer) zzww.zzra().zzd(zzabq.zzcyz)).intValue() > 0) {
            zzdrm zza = zzdrnVar.zza(zzdrf.Rewarded, context, zzdqsVar, new zzdlp(new zzdlk()));
            zzdlzVar = new zzdll(new zzdmc(new zzdlz()), new zzdlu(zza.zzhkm, zzbat.zzeke), zza.zzhrn, zzbat.zzeke);
        } else {
            zzdlzVar = new zzdlz();
        }
        return (zzdmh) zzesg.zzbd(zzdlzVar);
    }
}
