package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbtb extends zzbxq<zzbtc> implements zzbtc {
    public zzbtb(zzbtf zzbtfVar, Set<zzbzl<zzbtc>> set, Executor executor) {
        super(set);
        zza(zzbtfVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzl(zzvh zzvhVar) {
        zza(new zzbxs(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzbte
            private final zzvh zzgbo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbo = zzvhVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbtc) obj).zzl(this.zzgbo);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zza(zzcbq zzcbqVar) {
        zza(new zzbxs(zzcbqVar) { // from class: com.google.android.gms.internal.ads.zzbtd
            private final zzcbq zzgbp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbp = zzcbqVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbtc) obj).zza(this.zzgbp);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzamj() {
        zza(zzbtg.zzgbn);
    }
}
