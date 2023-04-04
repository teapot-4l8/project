package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbfn implements com.google.android.gms.ads.internal.overlay.zzp {
    private com.google.android.gms.ads.internal.overlay.zzp zzduf;
    private zzbfi zzets;

    public zzbfn(zzbfi zzbfiVar, com.google.android.gms.ads.internal.overlay.zzp zzpVar) {
        this.zzets = zzbfiVar;
        this.zzduf = zzpVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzvz() {
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzduf;
        if (zzpVar != null) {
            zzpVar.zzvz();
        }
        this.zzets.zzwm();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zza(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzduf;
        if (zzpVar != null) {
            zzpVar.zza(zzlVar);
        }
        this.zzets.zzady();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onUserLeaveHint() {
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzduf;
        if (zzpVar != null) {
            zzpVar.onUserLeaveHint();
        }
    }
}
