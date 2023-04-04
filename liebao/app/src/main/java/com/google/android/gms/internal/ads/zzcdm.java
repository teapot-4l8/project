package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcdm {
    private zzaer zzclt;

    public zzcdm(zzcdd zzcddVar) {
        this.zzclt = zzcddVar;
    }

    public final synchronized zzaer zzue() {
        return this.zzclt;
    }

    public final synchronized void zza(zzaer zzaerVar) {
        this.zzclt = zzaerVar;
    }
}
