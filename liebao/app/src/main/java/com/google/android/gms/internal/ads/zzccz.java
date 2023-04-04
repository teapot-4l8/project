package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzccz implements zzesa<zzbzk> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdot> zzfxz;

    public zzccz(zzesn<Context> zzesnVar, zzesn<zzdot> zzesnVar2) {
        this.zzeyq = zzesnVar;
        this.zzfxz = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzbzk) zzesg.zzbd(new zzbzk(this.zzeyq.get(), new HashSet(), this.zzfxz.get()));
    }
}
