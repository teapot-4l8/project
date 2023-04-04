package com.google.android.gms.internal.ads;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzqp implements Runnable {
    private final /* synthetic */ zzqj zzbnk;
    private final /* synthetic */ Surface zzbnn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqp(zzqj zzqjVar, Surface surface) {
        this.zzbnk = zzqjVar;
        this.zzbnn = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        zzqkVar = this.zzbnk.zzbnj;
        zzqkVar.zzb(this.zzbnn);
    }
}
