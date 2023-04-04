package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcjt implements zzbtp {
    private final zzbfi zzdkm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcjt(zzbfi zzbfiVar) {
        this.zzdkm = ((Boolean) zzww.zzra().zzd(zzabq.zzcpt)).booleanValue() ? zzbfiVar : null;
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzce(Context context) {
        zzbfi zzbfiVar = this.zzdkm;
        if (zzbfiVar != null) {
            zzbfiVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzcf(Context context) {
        zzbfi zzbfiVar = this.zzdkm;
        if (zzbfiVar != null) {
            zzbfiVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzcg(Context context) {
        zzbfi zzbfiVar = this.zzdkm;
        if (zzbfiVar != null) {
            zzbfiVar.destroy();
        }
    }
}
