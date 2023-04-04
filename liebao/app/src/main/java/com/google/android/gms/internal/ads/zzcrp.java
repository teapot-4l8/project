package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcrp implements zzbsz, zzbuj {
    private static final Object zzgte = new Object();
    private static int zzgtf = 0;
    private final com.google.android.gms.ads.internal.util.zzf zzeci;
    private final zzcru zzgtg;

    public zzcrp(zzcru zzcruVar, com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.zzgtg = zzcruVar;
        this.zzeci = zzfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final void onAdLoaded() {
        zzbm(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzd(zzvh zzvhVar) {
        zzbm(false);
    }

    private static boolean zzasq() {
        boolean z;
        synchronized (zzgte) {
            z = zzgtf < ((Integer) zzww.zzra().zzd(zzabq.zzcyu)).intValue();
        }
        return z;
    }

    private final void zzbm(boolean z) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue() && !this.zzeci.zzzn() && zzasq()) {
            this.zzgtg.zzbm(z);
            synchronized (zzgte) {
                zzgtf++;
            }
        }
    }
}
