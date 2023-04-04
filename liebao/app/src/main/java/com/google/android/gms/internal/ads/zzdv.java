package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdv implements Runnable {
    private final /* synthetic */ zzdw zzwg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdv(zzdw zzdwVar) {
        this.zzwg = zzdwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        boolean z;
        zzfc zzfcVar;
        ConditionVariable conditionVariable2;
        if (this.zzwg.zzwk != null) {
            return;
        }
        conditionVariable = zzdw.zzwi;
        synchronized (conditionVariable) {
            if (this.zzwg.zzwk != null) {
                return;
            }
            boolean z2 = false;
            try {
                z = zzabq.zzcsp.get().booleanValue();
            } catch (IllegalStateException unused) {
                z = false;
            }
            if (z) {
                try {
                    zzfcVar = this.zzwg.zzwh;
                    zzdw.zzwj = new zzue(zzfcVar.context, "ADSHIELD", null);
                } catch (Throwable unused2) {
                }
            }
            z2 = z;
            this.zzwg.zzwk = Boolean.valueOf(z2);
            conditionVariable2 = zzdw.zzwi;
            conditionVariable2.open();
        }
    }
}
