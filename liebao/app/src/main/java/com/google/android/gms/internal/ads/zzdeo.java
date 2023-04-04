package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdeo implements zzesa<zzdek> {
    private final zzesn<Context> zzece;
    private final zzesn<zzebs> zzeyl;

    private zzdeo(zzesn<Context> zzesnVar, zzesn<zzebs> zzesnVar2) {
        this.zzece = zzesnVar;
        this.zzeyl = zzesnVar2;
    }

    public static zzdeo zzav(zzesn<Context> zzesnVar, zzesn<zzebs> zzesnVar2) {
        return new zzdeo(zzesnVar, zzesnVar2);
    }

    public static zzdek zza(Context context, zzebs zzebsVar) {
        return new zzdek(context, zzebsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzece.get(), this.zzeyl.get());
    }
}
