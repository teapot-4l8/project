package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzgo implements Runnable {
    private final /* synthetic */ zzgl zzabv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgo(zzgl zzglVar) {
        this.zzabv = zzglVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzabv.zzdb();
    }
}
