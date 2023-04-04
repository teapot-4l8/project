package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbnc implements zzesa<ViewGroup> {
    private final zzbnd zzfwt;

    private zzbnc(zzbnd zzbndVar) {
        this.zzfwt = zzbndVar;
    }

    public static zzbnc zze(zzbnd zzbndVar) {
        return new zzbnc(zzbndVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return this.zzfwt.zzaks();
    }
}
