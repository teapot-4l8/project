package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbsu implements zzesa<zzaxo> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdot> zzfvi;
    private final zzbsr zzgbk;
    private final zzesn<zzbar> zzgbl;
    private final zzesn<zzaxq> zzgbm;

    private zzbsu(zzbsr zzbsrVar, zzesn<Context> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<zzdot> zzesnVar3, zzesn<zzaxq> zzesnVar4) {
        this.zzgbk = zzbsrVar;
        this.zzeyq = zzesnVar;
        this.zzgbl = zzesnVar2;
        this.zzfvi = zzesnVar3;
        this.zzgbm = zzesnVar4;
    }

    public static zzbsu zza(zzbsr zzbsrVar, zzesn<Context> zzesnVar, zzesn<zzbar> zzesnVar2, zzesn<zzdot> zzesnVar3, zzesn<zzaxq> zzesnVar4) {
        return new zzbsu(zzbsrVar, zzesnVar, zzesnVar2, zzesnVar3, zzesnVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        Context context = this.zzeyq.get();
        zzbar zzbarVar = this.zzgbl.get();
        zzdot zzdotVar = this.zzfvi.get();
        zzaxq zzaxqVar = this.zzgbm.get();
        if (zzdotVar.zzhml != null) {
            return new zzaxf(context, zzbarVar, zzdotVar.zzhml, zzdotVar.zzhmh.zzdug, zzaxqVar);
        }
        return null;
    }
}
