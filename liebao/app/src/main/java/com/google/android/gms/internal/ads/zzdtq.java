package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdtq implements zzesa<zzamo> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzgbl;
    private final zzdtr zzhuj;

    public zzdtq(zzdtr zzdtrVar, zzesn<Context> zzesnVar, zzesn<zzbar> zzesnVar2) {
        this.zzhuj = zzdtrVar;
        this.zzeyq = zzesnVar;
        this.zzgbl = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzamo) zzesg.zzbd(new zzamj().zzb(this.zzeyq.get(), this.zzgbl.get()));
    }
}
