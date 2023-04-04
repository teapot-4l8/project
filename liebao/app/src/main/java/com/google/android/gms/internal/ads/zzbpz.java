package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbpz implements com.google.android.gms.ads.internal.overlay.zzp {
    private final zzbty zzfzc;
    private AtomicBoolean zzfzd = new AtomicBoolean(false);

    public zzbpz(zzbty zzbtyVar) {
        this.zzfzc = zzbtyVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onUserLeaveHint() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zza(com.google.android.gms.ads.internal.overlay.zzl zzlVar) {
        this.zzfzd.set(true);
        this.zzfzc.onAdClosed();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzvz() {
        this.zzfzc.onAdOpened();
    }

    public final boolean isClosed() {
        return this.zzfzd.get();
    }
}
