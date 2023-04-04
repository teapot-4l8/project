package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwy implements zzesa<zzcwx> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzcis> zzgvz;

    public zzcwy(zzesn<Context> zzesnVar, zzesn<zzcis> zzesnVar2) {
        this.zzeyq = zzesnVar;
        this.zzgvz = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcwx(this.zzeyq.get(), this.zzgvz.get());
    }
}
