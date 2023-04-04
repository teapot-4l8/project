package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdqq implements zzesa<Context> {
    private final zzesn<Context> zzece;
    private final zzdqo zzhpn;

    private zzdqq(zzdqo zzdqoVar, zzesn<Context> zzesnVar) {
        this.zzhpn = zzdqoVar;
        this.zzece = zzesnVar;
    }

    public static zzdqq zza(zzdqo zzdqoVar, zzesn<Context> zzesnVar) {
        return new zzdqq(zzdqoVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Context) zzesg.zzbd(this.zzece.get());
    }
}
