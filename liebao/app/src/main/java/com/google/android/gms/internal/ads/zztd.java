package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zztd implements Runnable {
    private final /* synthetic */ zzta zzbvr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztd(zzta zztaVar) {
        this.zzbvr = zztaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbvr.disconnect();
    }
}
