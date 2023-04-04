package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzccr implements zzaig<Object> {
    private WeakReference<zzccn> zzgfd;

    private zzccr(zzccn zzccnVar) {
        this.zzgfd = new WeakReference<>(zzccnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final void zza(Object obj, Map<String, String> map) {
        zzccn zzccnVar = this.zzgfd.get();
        if (zzccnVar == null) {
            return;
        }
        zzccnVar.zzgep.onAdImpression();
    }
}
