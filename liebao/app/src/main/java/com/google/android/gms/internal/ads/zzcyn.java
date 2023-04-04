package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzcyn implements com.google.android.gms.ads.internal.zzg {
    private final /* synthetic */ zzdot zzgyd;
    private final /* synthetic */ zzdpi zzgyq;
    private final /* synthetic */ zzbbe zzgzu;
    private final /* synthetic */ zzcyt zzgzv;
    private final /* synthetic */ zzcyl zzgzw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcyn(zzcyl zzcylVar, zzbbe zzbbeVar, zzdpi zzdpiVar, zzdot zzdotVar, zzcyt zzcytVar) {
        this.zzgzw = zzcylVar;
        this.zzgzu = zzbbeVar;
        this.zzgyq = zzdpiVar;
        this.zzgyd = zzdotVar;
        this.zzgzv = zzcytVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkg() {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkh() {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzh(View view) {
        zzcym zzcymVar;
        zzbbe zzbbeVar = this.zzgzu;
        zzcymVar = this.zzgzw.zzgzt;
        zzbbeVar.set(zzcymVar.zza(this.zzgyq, this.zzgyd, view, this.zzgzv));
    }
}
