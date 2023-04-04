package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzec implements Runnable {
    private final /* synthetic */ Context zzxq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzec(zzea zzeaVar, Context context) {
        this.zzxq = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzduv zzduvVar;
        zzds zzdsVar;
        try {
            zzdsVar = zzea.zzxf;
            zzdsVar.zzb(this.zzxq);
        } catch (Exception e2) {
            zzduvVar = zzea.zzxh;
            zzduvVar.zza(2019, -1L, e2);
        }
    }
}
