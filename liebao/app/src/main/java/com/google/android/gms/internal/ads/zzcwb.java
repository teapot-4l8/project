package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcwb implements zzesa<zzcvw> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<zzccf> zzgvz;

    public zzcwb(zzesn<Context> zzesnVar, zzesn<zzccf> zzesnVar2, zzesn<zzbar> zzesnVar3) {
        this.zzeyq = zzesnVar;
        this.zzgvz = zzesnVar2;
        this.zzfvj = zzesnVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzcvw(this.zzeyq.get(), this.zzgvz.get(), this.zzfvj.get());
    }
}
