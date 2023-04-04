package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcog implements zzesa<String> {
    private final zzesn<Context> zzeyq;

    private zzcog(zzesn<Context> zzesnVar) {
        this.zzeyq = zzesnVar;
    }

    public static zzcog zzac(zzesn<Context> zzesnVar) {
        return new zzcog(zzesnVar);
    }

    public static String zzck(Context context) {
        return (String) zzesg.zzbd(context.getPackageName());
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return zzck(this.zzeyq.get());
    }
}
