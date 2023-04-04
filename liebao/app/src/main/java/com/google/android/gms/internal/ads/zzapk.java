package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzapk implements Runnable {
    private final /* synthetic */ zzapb zzdpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapk(zzapb zzapbVar) {
        this.zzdpu = zzapbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzant zzantVar;
        try {
            zzantVar = this.zzdpu.zzdpk;
            zzantVar.onAdLeftApplication();
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }
}
