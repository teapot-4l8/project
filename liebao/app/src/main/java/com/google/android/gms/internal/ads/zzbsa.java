package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzbsa implements zzbtp, zzbuj {
    private final Context context;
    private final zzaso zzboy;
    private final zzdot zzeux;

    public zzbsa(Context context, zzdot zzdotVar, zzaso zzasoVar) {
        this.context = context;
        this.zzeux = zzdotVar;
        this.zzboy = zzasoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzce(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzcf(Context context) {
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        if (this.zzeux.zzhmv == null || !this.zzeux.zzhmv.zzduu) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!this.zzeux.zzhmv.zzduv.isEmpty()) {
            arrayList.add(this.zzeux.zzhmv.zzduv);
        }
        this.zzboy.zza(this.context, arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzbtp
    public final void zzcg(Context context) {
        this.zzboy.detach();
    }
}
