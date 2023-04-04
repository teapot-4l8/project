package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzean implements Runnable {
    private final /* synthetic */ zzdyv zzicw;
    private final /* synthetic */ zzeal zzicx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzean(zzeal zzealVar, zzdyv zzdyvVar) {
        this.zzicx = zzealVar;
        this.zzicw = zzdyvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzicx.zza(this.zzicw);
    }
}
