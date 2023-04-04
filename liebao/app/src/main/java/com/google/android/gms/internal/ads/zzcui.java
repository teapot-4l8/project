package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcui extends zzapr {
    private zzctb<zzaqa, zzcuv> zzgwo;
    private final /* synthetic */ zzcue zzgwp;

    private zzcui(zzcue zzcueVar, zzctb<zzaqa, zzcuv> zzctbVar) {
        this.zzgwp = zzcueVar;
        this.zzgwo = zzctbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void zzy(IObjectWrapper iObjectWrapper) {
        zzcue.zza(this.zzgwp, (View) ObjectWrapper.unwrap(iObjectWrapper));
        this.zzgwo.zzgvk.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void zzdm(String str) {
        this.zzgwo.zzgvk.zzc(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void zzg(zzvh zzvhVar) {
        this.zzgwo.zzgvk.zzc(zzvhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapo
    public final void zza(zzanu zzanuVar) {
        zzcue.zza(this.zzgwp, zzanuVar);
        this.zzgwo.zzgvk.onAdLoaded();
    }
}
