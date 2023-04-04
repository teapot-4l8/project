package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbcu implements Runnable {
    private boolean zzbtm = false;
    private zzbcb zzemt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbcu(zzbcb zzbcbVar) {
        this.zzemt = zzbcbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzbtm) {
            return;
        }
        this.zzemt.zzabl();
        zzacj();
    }

    public final void pause() {
        this.zzbtm = true;
        this.zzemt.zzabl();
    }

    public final void resume() {
        this.zzbtm = false;
        zzacj();
    }

    private final void zzacj() {
        com.google.android.gms.ads.internal.util.zzj.zzegq.removeCallbacks(this);
        com.google.android.gms.ads.internal.util.zzj.zzegq.postDelayed(this, 250L);
    }
}
