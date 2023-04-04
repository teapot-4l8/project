package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcvk implements zzesa<zzcvj> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzcbj> zzgvz;

    public zzcvk(zzesn<Context> zzesnVar, zzesn<zzcbj> zzesnVar2) {
        this.zzeyq = zzesnVar;
        this.zzgvz = zzesnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcvj(this.zzeyq.get(), this.zzgvz.get());
    }
}
