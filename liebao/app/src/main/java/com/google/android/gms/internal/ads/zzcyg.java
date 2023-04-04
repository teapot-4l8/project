package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcyg implements com.google.android.gms.ads.internal.zzg {
    private final zzbzp zzfwy;
    private final zzbtl zzgep;
    private final zzbst zzgeq;
    private final zzbli zzger;
    private final zzbzk zzget;
    private AtomicBoolean zzgzp = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcyg(zzbst zzbstVar, zzbtl zzbtlVar, zzbzp zzbzpVar, zzbzk zzbzkVar, zzbli zzbliVar) {
        this.zzgeq = zzbstVar;
        this.zzgep = zzbtlVar;
        this.zzfwy = zzbzpVar;
        this.zzget = zzbzkVar;
        this.zzger = zzbliVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzh(View view) {
        if (this.zzgzp.compareAndSet(false, true)) {
            this.zzger.onAdImpression();
            this.zzget.zzv(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkg() {
        if (this.zzgzp.get()) {
            this.zzgeq.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkh() {
        if (this.zzgzp.get()) {
            this.zzgep.onAdImpression();
            this.zzfwy.zzanl();
        }
    }
}
