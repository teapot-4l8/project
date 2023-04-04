package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbnw implements zzesa<zzaya> {
    private final zzesn<Context> zzeyq;
    private final zzbnl zzfxk;
    private final zzesn<zzdpm> zzfxn;

    public zzbnw(zzbnl zzbnlVar, zzesn<Context> zzesnVar, zzesn<zzdpm> zzesnVar2) {
        this.zzfxk = zzbnlVar;
        this.zzeyq = zzesnVar;
        this.zzfxn = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzaya) zzesg.zzbd(new zzaya(this.zzeyq.get(), this.zzfxn.get().zzhny));
    }
}
