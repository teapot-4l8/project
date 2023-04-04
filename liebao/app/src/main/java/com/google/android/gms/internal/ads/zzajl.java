package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzajl implements Runnable {
    private final /* synthetic */ zzajg zzdjz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzajl(zzajg zzajgVar) {
        this.zzdjz = zzajgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdjz.disconnect();
    }
}
