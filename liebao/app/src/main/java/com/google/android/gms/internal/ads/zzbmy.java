package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbmy extends zzso {
    private boolean zzbpu = false;
    private final zzxq zzbvo;
    private final zzbmz zzfwo;
    private final zzdkd zzfwp;

    public zzbmy(zzbmz zzbmzVar, zzxq zzxqVar, zzdkd zzdkdVar) {
        this.zzfwo = zzbmzVar;
        this.zzbvo = zzxqVar;
        this.zzfwp = zzdkdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(zzsv zzsvVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final zzxq zzea() {
        return this.zzbvo;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(IObjectWrapper iObjectWrapper, zzsw zzswVar) {
        try {
            this.zzfwp.zza(zzswVar);
            this.zzfwo.zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzswVar, this.zzbpu);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.zzd.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final zzzc zzkm() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzczt)).booleanValue()) {
            return this.zzfwo.zzall();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void setImmersiveMode(boolean z) {
        this.zzbpu = z;
    }

    @Override // com.google.android.gms.internal.ads.zzsp
    public final void zza(zzyx zzyxVar) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        zzdkd zzdkdVar = this.zzfwp;
        if (zzdkdVar != null) {
            zzdkdVar.zzb(zzyxVar);
        }
    }
}
