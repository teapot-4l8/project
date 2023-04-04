package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcul implements zzesa<zzcue> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzboa> zzgvz;

    public zzcul(zzesn<Context> zzesnVar, zzesn<zzboa> zzesnVar2) {
        this.zzeyq = zzesnVar;
        this.zzgvz = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcue(this.zzeyq.get(), this.zzgvz.get());
    }
}
