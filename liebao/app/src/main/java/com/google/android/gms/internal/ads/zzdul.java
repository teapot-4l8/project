package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdul implements zzdtw {
    private final zzdue zzgom;
    private final zzdug zzgoq;

    public zzdul(zzdug zzdugVar, zzdue zzdueVar) {
        this.zzgoq = zzdugVar;
        this.zzgom = zzdueVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtw
    public final void zzb(zzdtx zzdtxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdtw
    public final String zzc(zzdtx zzdtxVar) {
        zzdug zzdugVar = this.zzgoq;
        Map<String, String> zzlw = zzdtxVar.zzlw();
        this.zzgom.zzq(zzlw);
        return zzdugVar.zzr(zzlw);
    }
}
