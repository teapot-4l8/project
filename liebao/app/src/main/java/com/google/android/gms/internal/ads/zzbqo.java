package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbqo implements zzesa<zzazr> {
    private final zzesn<zzbac> zzfby;
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzdpm> zzfxn;

    private zzbqo(zzesn<Clock> zzesnVar, zzesn<zzbac> zzesnVar2, zzesn<zzdpm> zzesnVar3) {
        this.zzfvh = zzesnVar;
        this.zzfby = zzesnVar2;
        this.zzfxn = zzesnVar3;
    }

    public static zzbqo zzg(zzesn<Clock> zzesnVar, zzesn<zzbac> zzesnVar2, zzesn<zzdpm> zzesnVar3) {
        return new zzbqo(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzazr) zzesg.zzbd(this.zzfby.get().zza(this.zzfvh.get(), this.zzfxn.get().zzhny));
    }
}
