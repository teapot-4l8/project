package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbcf implements Runnable {
    private final /* synthetic */ zzbcb zzemr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcf(zzbcb zzbcbVar) {
        this.zzemr = zzbcbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzemr.zzd("surfaceDestroyed", new String[0]);
    }
}