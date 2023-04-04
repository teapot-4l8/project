package com.google.android.gms.ads.internal.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzc implements Runnable {
    private final /* synthetic */ zza zzeft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(zza zzaVar) {
        this.zzeft = zzaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzeft.thread = Thread.currentThread();
        this.zzeft.zzwp();
    }
}
