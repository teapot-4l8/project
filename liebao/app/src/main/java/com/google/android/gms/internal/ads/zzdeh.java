package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdeh implements zzesa<zzdor> {
    private final zzesn<Clock> zzfvh;

    public zzdeh(zzesn<Clock> zzesnVar) {
        this.zzfvh = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzdor) zzesg.zzbd(new zzdor(this.zzfvh.get()));
    }
}
