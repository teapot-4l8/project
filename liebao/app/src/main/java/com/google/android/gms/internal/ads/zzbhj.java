package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbhj implements zzesa<Context> {
    private final zzbhg zzeyi;

    public zzbhj(zzbhg zzbhgVar) {
        this.zzeyi = zzbhgVar;
    }

    public static Context zza(zzbhg zzbhgVar) {
        return (Context) zzesg.zzbd(zzbhgVar.zzafp());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zza(this.zzeyi);
    }
}
