package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcxq extends zzavx {
    private final /* synthetic */ zzbur zzgyt;
    private final /* synthetic */ zzbst zzgyu;
    private final /* synthetic */ zzbty zzgyv;
    private final /* synthetic */ zzbzv zzgyw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcxq(zzcxm zzcxmVar, zzbur zzburVar, zzbst zzbstVar, zzbty zzbtyVar, zzbzv zzbzvVar) {
        this.zzgyt = zzburVar;
        this.zzgyu = zzbstVar;
        this.zzgyv = zzbtyVar;
        this.zzgyw = zzbzvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzag(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzah(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzb(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zze(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzai(IObjectWrapper iObjectWrapper) {
        this.zzgyt.zzvz();
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.zzgyt.zza(com.google.android.gms.ads.internal.overlay.zzl.OTHER);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzal(IObjectWrapper iObjectWrapper) {
        this.zzgyu.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzam(IObjectWrapper iObjectWrapper) {
        this.zzgyv.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zza(IObjectWrapper iObjectWrapper, zzavy zzavyVar) {
        this.zzgyw.zza(zzavyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzaj(IObjectWrapper iObjectWrapper) {
        this.zzgyw.zzul();
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzan(IObjectWrapper iObjectWrapper) {
        this.zzgyv.onRewardedVideoCompleted();
    }
}
