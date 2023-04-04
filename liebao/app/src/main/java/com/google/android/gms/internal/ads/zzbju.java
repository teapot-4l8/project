package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbju implements zzesa<zzdvj> {
    private final zzesn<Context> zzeyq;

    public zzbju(zzesn<Context> zzesnVar) {
        this.zzeyq = zzesnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzdvj) zzesg.zzbd(new zzdvj(this.zzeyq.get(), com.google.android.gms.ads.internal.zzr.zzlj().zzaai()));
    }
}
