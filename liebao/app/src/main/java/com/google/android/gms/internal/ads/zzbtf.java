package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbtf extends zzbxq<zzbtm> implements zzbtc {
    public zzbtf(Set<zzbzl<zzbtm>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zza(zzcbq zzcbqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzl(zzvh zzvhVar) {
        zza(new zzbxs(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzbti
            private final zzvh zzgbo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbo = zzvhVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbtm) obj).zzk(this.zzgbo);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzamj() {
        zza(zzbth.zzgbn);
    }
}
