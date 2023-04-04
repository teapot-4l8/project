package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcoa implements zzesa<ApplicationInfo> {
    private final zzesn<Context> zzeyq;

    private zzcoa(zzesn<Context> zzesnVar) {
        this.zzeyq = zzesnVar;
    }

    public static zzcoa zzab(zzesn<Context> zzesnVar) {
        return new zzcoa(zzesnVar);
    }

    public static ApplicationInfo zzcj(Context context) {
        return (ApplicationInfo) zzesg.zzbd(context.getApplicationInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzcj(this.zzeyq.get());
    }
}
