package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzfe implements Runnable {
    private final /* synthetic */ zzfc zzzt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfe(zzfc zzfcVar) {
        this.zzzt = zzfcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzzt.zzcr();
    }
}
