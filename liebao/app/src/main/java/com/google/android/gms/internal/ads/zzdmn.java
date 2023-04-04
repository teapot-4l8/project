package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdmn implements zzesa<zzdmh<zzbmg, zzbmp>> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdqs> zzfba;
    private final zzesn<zzdrn> zzfbb;

    public zzdmn(zzesn<Context> zzesnVar, zzesn<zzdqs> zzesnVar2, zzesn<zzdrn> zzesnVar3) {
        this.zzeyq = zzesnVar;
        this.zzfba = zzesnVar2;
        this.zzfbb = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzdmh) zzesg.zzbd(zzdml.zza(this.zzeyq.get(), this.zzfba.get(), this.zzfbb.get()));
    }
}
