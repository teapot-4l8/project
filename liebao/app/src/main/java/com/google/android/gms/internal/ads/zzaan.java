package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaan extends zzawe {
    @Override // com.google.android.gms.internal.ads.zzawf
    public final String getMediationAdapterClassName() {
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final boolean isLoaded() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(IObjectWrapper iObjectWrapper, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzawg zzawgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzawo zzawoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzaww zzawwVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzyw zzywVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzyx zzyxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final zzzc zzkm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final zzawa zzsb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zza(zzvq zzvqVar, zzawn zzawnVar) {
        zza(zzawnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final void zzb(zzvq zzvqVar, zzawn zzawnVar) {
        zza(zzawnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzawf
    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    private static void zza(zzawn zzawnVar) {
        zzbao.zzex("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbae.zzaah.post(new Runnable(zzawnVar) { // from class: com.google.android.gms.internal.ads.zzaam
            private final zzawn zzclz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzclz = zzawnVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzawn zzawnVar2 = this.zzclz;
                if (zzawnVar2 != null) {
                    try {
                        zzawnVar2.onRewardedAdFailedToLoad(1);
                    } catch (RemoteException e2) {
                        zzbao.zze("#007 Could not call remote method.", e2);
                    }
                }
            }
        });
    }
}
