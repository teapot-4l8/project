package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbkx implements zzbtp {
    private final zzdqd zzfto;

    public zzbkx(zzdqd zzdqdVar) {
        this.zzfto = zzdqdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzce(Context context) {
        try {
            this.zzfto.pause();
        } catch (zzdpq e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Cannot invoke onPause for the mediation adapter.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzcf(Context context) {
        try {
            this.zzfto.resume();
            if (context != null) {
                this.zzfto.onContextChanged(context);
            }
        } catch (zzdpq e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Cannot invoke onResume for the mediation adapter.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzcg(Context context) {
        try {
            this.zzfto.destroy();
        } catch (zzdpq e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Cannot invoke onDestroy for the mediation adapter.", e2);
        }
    }
}
