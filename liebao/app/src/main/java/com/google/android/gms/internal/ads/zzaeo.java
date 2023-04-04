package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaeo implements NativeCustomTemplateAd.DisplayOpenMeasurement {
    private final zzafo zzdgz;

    public zzaeo(zzafo zzafoVar) {
        this.zzdgz = zzafoVar;
        try {
            zzafoVar.zzua();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement
    public final boolean start() {
        try {
            return this.zzdgz.zztz();
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement
    public final void setView(View view) {
        try {
            this.zzdgz.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e2) {
            zzbao.zzc("", e2);
        }
    }
}
