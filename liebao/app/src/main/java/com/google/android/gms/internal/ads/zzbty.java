package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbty extends zzbxq<zzbsy> {
    public zzbty(Set<zzbzl<zzbsy>> set) {
        super(set);
    }

    public final void onAdClosed() {
        zza(zzbtx.zzgbn);
    }

    public final void onAdLeftApplication() {
        zza(zzbua.zzgbn);
    }

    public final void onAdOpened() {
        zza(zzbtz.zzgbn);
    }

    public final void onRewardedVideoStarted() {
        zza(zzbuc.zzgbn);
    }

    public final void zzb(zzavd zzavdVar, String str, String str2) {
        zza(new zzbxs(zzavdVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzbub
            private final String zzdkl;
            private final String zzdmx;
            private final zzavd zzgbs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbs = zzavdVar;
                this.zzdkl = str;
                this.zzdmx = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbsy) obj).zzb(this.zzgbs, this.zzdkl, this.zzdmx);
            }
        });
    }

    public final void onRewardedVideoCompleted() {
        zza(zzbue.zzgbn);
    }
}
