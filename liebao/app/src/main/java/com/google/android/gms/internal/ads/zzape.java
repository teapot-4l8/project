package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzape implements Runnable {
    private final /* synthetic */ zzapb zzdpu;
    private final /* synthetic */ AdRequest.ErrorCode zzdpv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzape(zzapb zzapbVar, AdRequest.ErrorCode errorCode) {
        this.zzdpu = zzapbVar;
        this.zzdpv = errorCode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzant zzantVar;
        try {
            zzantVar = this.zzdpu.zzdpk;
            zzantVar.onAdFailedToLoad(zzapn.zza(this.zzdpv));
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }
}
