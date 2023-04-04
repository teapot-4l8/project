package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzduh implements zzesa<zzdue> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfsw;

    public zzduh(zzesn<Context> zzesnVar, zzesn<zzbar> zzesnVar2) {
        this.zzeyq = zzesnVar;
        this.zzfsw = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdue(this.zzeyq.get(), this.zzfsw.get());
    }
}
