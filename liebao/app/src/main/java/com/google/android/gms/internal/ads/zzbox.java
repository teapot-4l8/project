package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbox implements zzbuj, zzqw {
    private final zzdot zzftr;
    private final zzbtl zzfye;
    private final zzbun zzfyf;
    private final AtomicBoolean zzfyg = new AtomicBoolean();
    private final AtomicBoolean zzfyh = new AtomicBoolean();

    public zzbox(zzdot zzdotVar, zzbtl zzbtlVar, zzbun zzbunVar) {
        this.zzftr = zzdotVar;
        this.zzfye = zzbtlVar;
        this.zzfyf = zzbunVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final synchronized void onAdLoaded() {
        if (this.zzftr.zzhma != 1) {
            zzali();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zza(zzqx zzqxVar) {
        if (this.zzftr.zzhma == 1 && zzqxVar.zzbrt) {
            zzali();
        }
        if (zzqxVar.zzbrt && this.zzfyh.compareAndSet(false, true)) {
            this.zzfyf.zzamk();
        }
    }

    private final void zzali() {
        if (this.zzfyg.compareAndSet(false, true)) {
            this.zzfye.onAdImpression();
        }
    }
}
