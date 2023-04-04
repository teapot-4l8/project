package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzalz extends zzbbh<zzakv> {
    private com.google.android.gms.ads.internal.util.zzar<zzakv> zzdkt;
    private final Object lock = new Object();
    private boolean zzdlo = false;
    private int zzdlp = 0;

    public zzalz(com.google.android.gms.ads.internal.util.zzar<zzakv> zzarVar) {
        this.zzdkt = zzarVar;
    }

    public final zzalv zzuw() {
        zzalv zzalvVar = new zzalv(this);
        synchronized (this.lock) {
            zza(new zzaly(this, zzalvVar), new zzamb(this, zzalvVar));
            Preconditions.checkState(this.zzdlp >= 0);
            this.zzdlp++;
        }
        return zzalvVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzux() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdlp > 0);
            com.google.android.gms.ads.internal.util.zzd.zzed("Releasing 1 reference for JS Engine");
            this.zzdlp--;
            zzuz();
        }
    }

    public final void zzuy() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdlp >= 0);
            com.google.android.gms.ads.internal.util.zzd.zzed("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzdlo = true;
            zzuz();
        }
    }

    private final void zzuz() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdlp >= 0);
            if (this.zzdlo && this.zzdlp == 0) {
                com.google.android.gms.ads.internal.util.zzd.zzed("No reference is left (including root). Cleaning up engine.");
                zza(new zzama(this), new zzbbf());
            } else {
                com.google.android.gms.ads.internal.util.zzd.zzed("There are still references to the engine. Not destroying.");
            }
        }
    }
}
