package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdei implements zzesa<zzddz<zzdhh>> {
    private final zzesn<zzdhk> zzfak;
    private final zzesn<Clock> zzfvh;

    public zzdei(zzesn<zzdhk> zzesnVar, zzesn<Clock> zzesnVar2) {
        this.zzfak = zzesnVar;
        this.zzfvh = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzddz) zzesg.zzbd(new zzddz(this.zzfak.get(), zzadf.zzdea.get().longValue(), this.zzfvh.get()));
    }
}
