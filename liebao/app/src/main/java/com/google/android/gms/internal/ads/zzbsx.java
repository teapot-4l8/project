package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbsx extends zzbxq<zzbsz> implements zzbsz {
    public zzbsx(Set<zzbzl<zzbsz>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzd(final zzvh zzvhVar) {
        zza(new zzbxs(zzvhVar) { // from class: com.google.android.gms.internal.ads.zzbta
            private final zzvh zzgbo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgbo = zzvhVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbxs
            public final void zzo(Object obj) {
                ((zzbsz) obj).zzd(this.zzgbo);
            }
        });
    }
}
