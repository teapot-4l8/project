package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcyt implements com.google.android.gms.ads.internal.zzg {
    private com.google.android.gms.ads.internal.zzg zzhaa;

    public final synchronized void zza(com.google.android.gms.ads.internal.zzg zzgVar) {
        this.zzhaa = zzgVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzh(View view) {
        if (this.zzhaa != null) {
            this.zzhaa.zzh(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzkg() {
        if (this.zzhaa != null) {
            this.zzhaa.zzkg();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzkh() {
        if (this.zzhaa != null) {
            this.zzhaa.zzkh();
        }
    }
}
