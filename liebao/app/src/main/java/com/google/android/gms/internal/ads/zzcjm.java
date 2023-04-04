package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcjm implements zzari {
    private final /* synthetic */ zzcjc zzgmn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcjm(zzcjc zzcjcVar) {
        this.zzgmn = zzcjcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zza(int i, int i2, int i3, int i4) {
        zzbty zzbtyVar;
        zzbtyVar = this.zzgmn.zzfzc;
        zzbtyVar.onAdOpened();
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zzwb() {
        zzbty zzbtyVar;
        zzbtyVar = this.zzgmn.zzfzc;
        zzbtyVar.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzari
    public final void zzwc() {
        zzbwt zzbwtVar;
        zzbwtVar = this.zzgmn.zzgmk;
        zzbwtVar.zzakz();
    }
}
