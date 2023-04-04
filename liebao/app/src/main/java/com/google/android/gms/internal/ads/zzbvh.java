package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbvh extends zzbxq<zzbvm> implements zzbvm {
    public zzbvh(Set<zzbzl<zzbvm>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzauj zzaujVar) {
        zza(new zzbxs(zzaujVar) { // from class: com.google.android.gms.internal.ads.zzbvk
            private final zzauj zzgca;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgca = zzaujVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbvm) obj).zzd(this.zzgca);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbvm
    public final void zzd(zzdpi zzdpiVar) {
        zza(new zzbxs(zzdpiVar) { // from class: com.google.android.gms.internal.ads.zzbvj
            private final zzdpi zzgbz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbz = zzdpiVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbvm) obj).zzd(this.zzgbz);
            }
        });
    }
}
