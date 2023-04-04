package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbei implements Runnable {
    private final /* synthetic */ zzbef zzerr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbei(zzbef zzbefVar) {
        this.zzerr = zzbefVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzr.zzlr().zzb(this.zzerr);
    }
}
