package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcyx implements com.google.android.gms.ads.internal.zzg {
    private final /* synthetic */ zzcal zzhac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcyx(zzcys zzcysVar, zzcal zzcalVar) {
        this.zzhac = zzcalVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzh(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkg() {
        this.zzhac.zzahj().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkh() {
        this.zzhac.zzahk().onAdImpression();
        this.zzhac.zzahl().zzanl();
    }
}
