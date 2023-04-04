package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzduc implements zzdtw {
    private final zzdue zzgom;
    private final zzdug zzgoq;
    private final zzdtt zzhuv;

    public zzduc(zzdtt zzdttVar, zzdug zzdugVar, zzdue zzdueVar) {
        this.zzhuv = zzdttVar;
        this.zzgoq = zzdugVar;
        this.zzgom = zzdueVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtw
    public final void zzb(zzdtx zzdtxVar) {
        this.zzhuv.zzgw(zzc(zzdtxVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdtw
    public final String zzc(zzdtx zzdtxVar) {
        zzdug zzdugVar = this.zzgoq;
        Map<String, String> zzlw = zzdtxVar.zzlw();
        this.zzgom.zzq(zzlw);
        return zzdugVar.zzr(zzlw);
    }
}
