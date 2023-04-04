package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbjx implements zzesa<com.google.android.gms.ads.internal.util.zzay> {
    private final zzesn<Context> zzeyq;

    public zzbjx(zzesn<Context> zzesnVar) {
        this.zzeyq = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (com.google.android.gms.ads.internal.util.zzay) zzesg.zzbd(new com.google.android.gms.ads.internal.util.zzay(this.zzeyq.get()));
    }
}
