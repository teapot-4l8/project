package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzark implements NativeCustomFormatAd.DisplayOpenMeasurement {
    private final zzafo zzdrw;

    public zzark(zzafo zzafoVar) {
        this.zzdrw = zzafoVar;
        try {
            zzafoVar.zzua();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd.DisplayOpenMeasurement
    public final boolean start() {
        try {
            return this.zzdrw.zztz();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeCustomFormatAd.DisplayOpenMeasurement
    public final void setView(View view) {
        try {
            this.zzdrw.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
