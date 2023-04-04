package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzmw implements Runnable {
    private final /* synthetic */ zzms zzbdv;
    private final /* synthetic */ IOException zzbfb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmw(zzms zzmsVar, IOException iOException) {
        this.zzbdv = zzmsVar;
        this.zzbfb = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzmz zzmzVar;
        zzmzVar = this.zzbdv.zzbdx;
        zzmzVar.zzb(this.zzbfb);
    }
}
