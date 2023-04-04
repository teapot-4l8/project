package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcoh implements zzesa<PackageInfo> {
    private final zzesn<Context> zzeyq;
    private final zzesn<ApplicationInfo> zzgqp;

    private zzcoh(zzesn<Context> zzesnVar, zzesn<ApplicationInfo> zzesnVar2) {
        this.zzeyq = zzesnVar;
        this.zzgqp = zzesnVar2;
    }

    public static zzcoh zzak(zzesn<Context> zzesnVar, zzesn<ApplicationInfo> zzesnVar2) {
        return new zzcoh(zzesnVar, zzesnVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzcnv.zza(this.zzeyq.get(), this.zzgqp.get());
    }
}
