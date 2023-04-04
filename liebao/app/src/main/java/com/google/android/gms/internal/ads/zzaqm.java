package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
final class zzaqm implements SignalCallbacks {
    private final /* synthetic */ zzaqf zzdqe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqm(zzaqj zzaqjVar, zzaqf zzaqfVar) {
        this.zzdqe = zzaqfVar;
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onSuccess(String str) {
        try {
            this.zzdqe.zzdo(str);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onFailure(String str) {
        try {
            this.zzdqe.onFailure(str);
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onFailure(AdError adError) {
        try {
            this.zzdqe.zzh(adError.zzdr());
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
