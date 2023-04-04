package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaaq extends zzza {
    private final OnPaidEventListener zzcmc;

    public zzaaq(OnPaidEventListener onPaidEventListener) {
        this.zzcmc = onPaidEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzyx
    public final void zza(zzvv zzvvVar) {
        if (this.zzcmc != null) {
            this.zzcmc.onPaidEvent(AdValue.zza(zzvvVar.zzadj, zzvvVar.zzadk, zzvvVar.zzadl));
        }
    }
}
