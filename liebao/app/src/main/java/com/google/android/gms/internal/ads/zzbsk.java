package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbsk implements zzesa<Context> {
    private final zzesn<Context> zzece;
    private final zzbsj zzgbg;

    private zzbsk(zzbsj zzbsjVar, zzesn<Context> zzesnVar) {
        this.zzgbg = zzbsjVar;
        this.zzece = zzesnVar;
    }

    public static zzbsk zza(zzbsj zzbsjVar, zzesn<Context> zzesnVar) {
        return new zzbsk(zzbsjVar, zzesnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (Context) zzesg.zzbd(this.zzgbg.zzch(this.zzece.get()));
    }
}
