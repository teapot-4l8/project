package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdql implements zzesa<Clock> {
    private final zzdqi zzhpk;

    public zzdql(zzdqi zzdqiVar) {
        this.zzhpk = zzdqiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Clock) zzesg.zzbd(DefaultClock.getInstance());
    }
}
