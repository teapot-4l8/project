package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbtl extends zzbxq<zzbtq> {
    private boolean zzgbq;

    public zzbtl(Set<zzbzl<zzbtq>> set) {
        super(set);
        this.zzgbq = false;
    }

    public final synchronized void onAdImpression() {
        if (!this.zzgbq) {
            zza(zzbto.zzgbn);
            this.zzgbq = true;
        }
    }
}
