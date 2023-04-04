package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbci implements Runnable {
    private final /* synthetic */ zzbcb zzemr;
    private final /* synthetic */ boolean zzemu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbci(zzbcb zzbcbVar, boolean z) {
        this.zzemr = zzbcbVar;
        this.zzemu = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzemr.zzd("windowVisibilityChanged", "isVisible", String.valueOf(this.zzemu));
    }
}
