package com.google.android.gms.internal.ads;

import androidx.b.a;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcfk implements zzbtq {
    private final zzcdr zzgeo;
    private final zzcdv zzgfq;

    public zzcfk(zzcdr zzcdrVar, zzcdv zzcdvVar) {
        this.zzgeo = zzcdrVar;
        this.zzgfq = zzcdvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void onAdImpression() {
        if (this.zzgeo.zzaov() == null) {
            return;
        }
        zzbfi zzaou = this.zzgeo.zzaou();
        zzbfi zzaot = this.zzgeo.zzaot();
        if (zzaou == null) {
            zzaou = zzaot != null ? zzaot : null;
        }
        if (!this.zzgfq.zzaok() || zzaou == null) {
            return;
        }
        zzaou.zza("onSdkImpression", new a());
    }
}
