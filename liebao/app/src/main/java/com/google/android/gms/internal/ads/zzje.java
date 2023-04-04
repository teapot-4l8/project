package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzje implements zziz {
    private final /* synthetic */ zzjc zzang;

    private zzje(zzjc zzjcVar) {
        this.zzang = zzjcVar;
    }

    @Override // com.google.android.gms.internal.ads.zziz
    public final void zzaa(int i) {
        zzjc.zza(this.zzang).zzz(i);
        zzjc.zzaa(i);
    }

    @Override // com.google.android.gms.internal.ads.zziz
    public final void zzen() {
        zzjc.zzgh();
        zzjc.zza(this.zzang, true);
    }

    @Override // com.google.android.gms.internal.ads.zziz
    public final void zzc(int i, long j, long j2) {
        zzjc.zza(this.zzang).zza(i, j, j2);
        zzjc.zzb(i, j, j2);
    }
}
