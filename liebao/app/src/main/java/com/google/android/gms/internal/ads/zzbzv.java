package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbzv extends zzbxq<zzaiw> implements zzaiw {
    public zzbzv(Set<zzbzl<zzaiw>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzaiw
    public final synchronized void zzul() {
        zza(zzbzu.zzgbn);
    }

    @Override // com.google.android.gms.internal.ads.zzaiw
    public final void zza(zzavy zzavyVar) {
        zza(new zzbxs(zzavyVar) { // from class: com.google.android.gms.internal.ads.zzbzx
            private final zzavy zzgdk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgdk = zzavyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzaiw) obj).zza(this.zzgdk);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaiw
    public final void zzum() {
        zza(zzbzw.zzgbn);
    }
}
