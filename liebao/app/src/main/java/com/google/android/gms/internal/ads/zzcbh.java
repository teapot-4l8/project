package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcbh implements com.google.android.gms.ads.internal.overlay.zzp {
    private final zzbur zzgds;
    private final zzbzh zzgdt;

    public zzcbh(zzbur zzburVar, zzbzh zzbzhVar) {
        this.zzgds = zzburVar;
        this.zzgdt = zzbzhVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zza(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.zzgds.zza(zzlVar);
        this.zzgdt.onHide();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
        this.zzgds.onPause();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
        this.zzgds.onResume();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzvz() {
        this.zzgds.zzvz();
        this.zzgdt.zzanj();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onUserLeaveHint() {
        this.zzgds.onUserLeaveHint();
    }
}
