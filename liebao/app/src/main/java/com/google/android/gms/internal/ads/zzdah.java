package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzdah implements zzbvb {
    private final AtomicReference<zzyx> zzhbf = new AtomicReference<>();

    public final void zzc(zzyx zzyxVar) {
        this.zzhbf.set(zzyxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvb
    public final void zzb(zzvv zzvvVar) {
        zzdlx.zza(this.zzhbf, new zzdma(zzvvVar) { // from class: com.google.android.gms.internal.ads.zzdag
            private final zzvv zzgch;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgch = zzvvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdma
            public final void zzp(Object obj) {
                ((zzyx) obj).zza(this.zzgch);
            }
        });
    }
}
