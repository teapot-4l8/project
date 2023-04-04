package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdhc implements zzesa<zzdgv> {
    private final zzesn<Context> zzece;
    private final zzesn<zzebs> zzeyl;

    private zzdhc(zzesn<zzebs> zzesnVar, zzesn<Context> zzesnVar2) {
        this.zzeyl = zzesnVar;
        this.zzece = zzesnVar2;
    }

    public static zzdhc zzbb(zzesn<zzebs> zzesnVar, zzesn<Context> zzesnVar2) {
        return new zzdhc(zzesnVar, zzesnVar2);
    }

    public static zzdgv zza(zzebs zzebsVar, Context context) {
        return new zzdgv(zzebsVar, context);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzeyl.get(), this.zzece.get());
    }
}
