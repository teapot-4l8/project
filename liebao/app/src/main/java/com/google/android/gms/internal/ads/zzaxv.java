package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaxv {
    private final zzayd zzbrf;
    private final com.google.android.gms.ads.internal.util.zzf zzecl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaxv(com.google.android.gms.ads.internal.util.zzf zzfVar, zzayd zzaydVar) {
        this.zzecl = zzfVar;
        this.zzbrf = zzaydVar;
    }

    public final void zzdg(int i) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpd)).booleanValue()) {
            return;
        }
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcpe)).booleanValue()) {
            this.zzecl.zzdk(-1);
        } else {
            this.zzecl.zzdk(i);
        }
        zzxo();
    }

    public final void zzxo() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpe)).booleanValue()) {
            this.zzbrf.isInitialized();
        }
    }
}
