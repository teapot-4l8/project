package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcoj implements zzesa<zzcoz> {
    private final zzesn<Context> zzeyq;

    private zzcoj(zzesn<Context> zzesnVar) {
        this.zzeyq = zzesnVar;
    }

    public static zzcoj zzad(zzesn<Context> zzesnVar) {
        return new zzcoj(zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzcoz) zzesg.zzbd(new zzcoz(this.zzeyq.get()));
    }
}
