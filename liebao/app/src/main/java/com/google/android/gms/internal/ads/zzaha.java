package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzaha extends zzagb {
    private final /* synthetic */ zzagy zzdhr;

    private zzaha(zzagy zzagyVar) {
        this.zzdhr = zzagyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zza(zzafo zzafoVar, String str) {
        if (zzagy.zzb(this.zzdhr) == null) {
            return;
        }
        zzagy.zzb(this.zzdhr).onCustomClick(zzagy.zza(this.zzdhr, zzafoVar), str);
    }
}
