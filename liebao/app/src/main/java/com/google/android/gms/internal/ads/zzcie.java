package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzcie implements com.google.android.gms.ads.internal.overlay.zzx {
    private final zzbty zzglr;

    private zzcie(zzbty zzbtyVar) {
        this.zzglr = zzbtyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.gms.ads.internal.overlay.zzx zza(zzbty zzbtyVar) {
        return new zzcie(zzbtyVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzx
    public final void zzws() {
        this.zzglr.onAdLeftApplication();
    }
}
