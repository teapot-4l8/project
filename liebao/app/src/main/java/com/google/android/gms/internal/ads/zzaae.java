package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzaae implements Runnable {
    private final /* synthetic */ zzaaf zzclu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaae(zzaaf zzaafVar) {
        this.zzclu = zzaafVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzaad.zza(this.zzclu.zzclv) != null) {
            try {
                zzaad.zza(this.zzclu.zzclv).onAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbao.zzd("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
