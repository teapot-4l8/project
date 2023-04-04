package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzarr extends zzagb {
    private final /* synthetic */ zzarp zzdsc;

    private zzarr(zzarp zzarpVar) {
        this.zzdsc = zzarpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zza(zzafo zzafoVar, String str) {
        if (zzarp.zzb(this.zzdsc) == null) {
            return;
        }
        zzarp.zzb(this.zzdsc).onCustomClick(zzarp.zza(this.zzdsc, zzafoVar), str);
    }
}
