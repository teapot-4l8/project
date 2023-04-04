package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbrb implements zzesa<com.google.android.gms.ads.internal.zza> {
    private final zzesn<Context> zzeyq;
    private final zzbqy zzfzz;
    private final zzesn<zzaxo> zzgaa;

    private zzbrb(zzbqy zzbqyVar, zzesn<Context> zzesnVar, zzesn<zzaxo> zzesnVar2) {
        this.zzfzz = zzbqyVar;
        this.zzeyq = zzesnVar;
        this.zzgaa = zzesnVar2;
    }

    public static zzbrb zza(zzbqy zzbqyVar, zzesn<Context> zzesnVar, zzesn<zzaxo> zzesnVar2) {
        return new zzbrb(zzbqyVar, zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (com.google.android.gms.ads.internal.zza) zzesg.zzbd(new com.google.android.gms.ads.internal.zza(this.zzeyq.get(), this.zzgaa.get(), null));
    }
}
