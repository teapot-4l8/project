package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzmx implements zznn {
    private final int track;
    private final /* synthetic */ zzms zzbdv;

    public zzmx(zzms zzmsVar, int i) {
        this.zzbdv = zzmsVar;
        this.track = i;
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final boolean isReady() {
        return this.zzbdv.zzbc(this.track);
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void zzhw() {
        this.zzbdv.zzhw();
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final int zzb(zzhv zzhvVar, zzjp zzjpVar, boolean z) {
        return this.zzbdv.zza(this.track, zzhvVar, zzjpVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void zzeh(long j) {
        this.zzbdv.zze(this.track, j);
    }
}
