package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbcm implements Runnable {
    private final /* synthetic */ zzbca zzeng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcm(zzbcj zzbcjVar, zzbca zzbcaVar) {
        this.zzeng = zzbcaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzeng.zzabh();
    }
}
