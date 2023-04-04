package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzalv extends zzbbh<zzamc> {
    private final Object lock = new Object();
    private final zzalz zzdlk;
    private boolean zzdll;

    public zzalv(zzalz zzalzVar) {
        this.zzdlk = zzalzVar;
    }

    public final void release() {
        synchronized (this.lock) {
            if (this.zzdll) {
                return;
            }
            this.zzdll = true;
            zza(new zzalu(this), new zzbbf());
            zza(new zzalx(this), new zzalw(this));
        }
    }
}
