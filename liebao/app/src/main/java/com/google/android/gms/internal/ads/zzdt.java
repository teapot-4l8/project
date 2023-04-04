package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdt implements Runnable {
    private final /* synthetic */ zzds zzwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdt(zzds zzdsVar) {
        this.zzwe = zzdsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        zzduv zzduvVar;
        Object obj2;
        obj = this.zzwe.zzwc;
        synchronized (obj) {
            z = this.zzwe.zzwd;
            if (z) {
                return;
            }
            this.zzwe.zzwd = true;
            try {
                this.zzwe.zzbt();
            } catch (Exception e2) {
                zzduvVar = this.zzwe.zzvx;
                zzduvVar.zza(2023, -1L, e2);
            }
            obj2 = this.zzwe.zzwc;
            synchronized (obj2) {
                this.zzwe.zzwd = false;
            }
        }
    }
}
