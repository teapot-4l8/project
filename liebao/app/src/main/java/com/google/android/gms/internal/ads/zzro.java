package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzro implements Runnable {
    private final /* synthetic */ zzrp zzbtl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzro(zzrp zzrpVar) {
        this.zzbtl = zzrpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        List<zzrr> list;
        obj = this.zzbtl.lock;
        synchronized (obj) {
            z = this.zzbtl.foreground;
            if (z) {
                z2 = this.zzbtl.zzbtm;
                if (z2) {
                    this.zzbtl.foreground = false;
                    com.google.android.gms.ads.internal.util.zzd.zzdz("App went background");
                    list = this.zzbtl.zzbtn;
                    for (zzrr zzrrVar : list) {
                        try {
                            zzrrVar.zzq(false);
                        } catch (Exception e2) {
                            zzbao.zzc("", e2);
                        }
                    }
                }
            }
            com.google.android.gms.ads.internal.util.zzd.zzdz("App is still foreground");
        }
    }
}
