package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcil extends VideoController.VideoLifecycleCallbacks {
    private final zzcdr zzgeo;

    public zzcil(zzcdr zzcdrVar) {
        this.zzgeo = zzcdrVar;
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoStart() {
        zzzi zza = zza(this.zzgeo);
        if (zza == null) {
            return;
        }
        try {
            zza.onVideoStart();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Unable to call onVideoEnd()", e2);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoPause() {
        zzzi zza = zza(this.zzgeo);
        if (zza == null) {
            return;
        }
        try {
            zza.onVideoPause();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Unable to call onVideoEnd()", e2);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoEnd() {
        zzzi zza = zza(this.zzgeo);
        if (zza == null) {
            return;
        }
        try {
            zza.onVideoEnd();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Unable to call onVideoEnd()", e2);
        }
    }

    private static zzzi zza(zzcdr zzcdrVar) {
        zzzd videoController = zzcdrVar.getVideoController();
        if (videoController == null) {
            return null;
        }
        try {
            return videoController.zzrm();
        } catch (RemoteException unused) {
            return null;
        }
    }
}
