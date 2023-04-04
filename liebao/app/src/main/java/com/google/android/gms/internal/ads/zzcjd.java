package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcjd implements com.google.android.gms.ads.internal.zzm {
    private final /* synthetic */ zzcja zzgml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcjd(zzcja zzcjaVar) {
        this.zzgml = zzcjaVar;
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final void zzkr() {
        zzbve zzbveVar;
        zzbveVar = this.zzgml.zzgmh;
        zzbveVar.onPause();
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final void zzks() {
        zzbve zzbveVar;
        zzbveVar = this.zzgml.zzgmh;
        zzbveVar.onResume();
    }
}
