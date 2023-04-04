package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzaag implements Runnable {
    private final /* synthetic */ zzaah zzclw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaag(zzaah zzaahVar) {
        this.zzclw = zzaahVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzxc zzxcVar;
        zzxc zzxcVar2;
        zzxcVar = this.zzclw.zzbqc;
        if (zzxcVar != null) {
            try {
                zzxcVar2 = this.zzclw.zzbqc;
                zzxcVar2.onAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbao.zzd("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
