package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbia implements zzesa<zzaux> {
    private final zzesn<Context> zzeyq;

    public zzbia(zzesn<Context> zzesnVar) {
        this.zzeyq = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        Context context = this.zzeyq.get();
        return (zzaux) zzesg.zzbd(new zzauv(context, new zzauy(context).zzwv()));
    }
}
