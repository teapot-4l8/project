package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdip implements zzesa<zzdin> {
    private final zzesn<Context> zzece;

    public zzdip(zzesn<Context> zzesnVar) {
        this.zzece = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzdin(this.zzece.get());
    }
}
