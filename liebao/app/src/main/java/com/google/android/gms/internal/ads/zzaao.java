package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzaao implements Runnable {
    private final /* synthetic */ zzaap zzcma;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaao(zzaap zzaapVar) {
        this.zzcma = zzaapVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzavn zzavnVar;
        zzavn zzavnVar2;
        zzavnVar = this.zzcma.zzcmb;
        if (zzavnVar != null) {
            try {
                zzavnVar2 = this.zzcma.zzcmb;
                zzavnVar2.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbao.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e2);
            }
        }
    }
}
