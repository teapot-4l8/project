package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzaop implements InitializationCompleteCallback {
    private final /* synthetic */ zzajo zzdph;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaop(zzaon zzaonVar, zzajo zzajoVar) {
        this.zzdph = zzajoVar;
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationSucceeded() {
        try {
            this.zzdph.onInitializationSucceeded();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationFailed(String str) {
        try {
            this.zzdph.onInitializationFailed(str);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
