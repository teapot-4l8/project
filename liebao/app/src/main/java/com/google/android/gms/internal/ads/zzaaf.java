package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaaf extends zzxh {
    final /* synthetic */ zzaad zzclv;

    private zzaaf(zzaad zzaadVar) {
        this.zzclv = zzaadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final String getMediationAdapterClassName() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final boolean isLoading() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final String zzkl() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zzb(zzvq zzvqVar) {
        zza(zzvqVar, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzxi
    public final void zza(zzvq zzvqVar, int i) {
        zzbao.zzex("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbae.zzaah.post(new zzaae(this));
    }
}
