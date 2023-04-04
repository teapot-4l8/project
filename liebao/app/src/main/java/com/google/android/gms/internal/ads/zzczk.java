package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzczk extends zzxp implements zzbvi {
    private final String zzbvf;
    private zzbne zzhah;
    private final Context zzham;
    private final zzdpo zzhan;
    private final zzdlc zzhar;
    private final zzczm zzhas;
    private zzvt zzhat;

    public zzczk(Context context, zzvt zzvtVar, String str, zzdlc zzdlcVar, zzczm zzczmVar) {
        this.zzham = context;
        this.zzhar = zzdlcVar;
        this.zzhat = zzvtVar;
        this.zzbvf = str;
        this.zzhas = zzczmVar;
        this.zzhan = zzdlcVar.zzavi();
        zzdlcVar.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void showInterstitial() {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzasr zzasrVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzasx zzasxVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzavn zzavnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzsq zzsqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzvq zzvqVar, zzxd zzxdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzwc zzwcVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzyg zzygVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzzj zzzjVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzbl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final IObjectWrapper zzki() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzhar.zzavh());
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized boolean zza(zzvq zzvqVar) {
        zzf(this.zzhat);
        return zzg(zzvqVar);
    }

    private final synchronized void zzf(zzvt zzvtVar) {
        this.zzhan.zzg(zzvtVar);
        this.zzhan.zzbr(this.zzhat.zzciy);
    }

    private final synchronized boolean zzg(zzvq zzvqVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzr.zzkv();
        if (com.google.android.gms.ads.internal.util.zzj.zzbc(this.zzham) && zzvqVar.zzcip == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Failed to load the ad because app ID is missing.");
            if (this.zzhas != null) {
                this.zzhas.zzd(zzdqh.zza(zzdqj.APP_ID_MISSING, null, null));
            }
            return false;
        }
        zzdqa.zze(this.zzham, zzvqVar.zzcid);
        return this.zzhar.zza(zzvqVar, this.zzbvf, null, new zzczn(this));
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzhah != null) {
            this.zzhah.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzhah != null) {
            this.zzhah.zzalk().zzce(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzhah != null) {
            this.zzhah.zzalk().zzcf(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxc zzxcVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzhas.zzc(zzxcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxc zzko() {
        return this.zzhas.zzate();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxy zzxyVar) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzhas.zzb(zzxyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxy zzkn() {
        return this.zzhas.zzatf();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zzkj() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        if (this.zzhah != null) {
            this.zzhah.zzkj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized zzvt zzkk() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzhah != null) {
            return zzdpr.zzb(this.zzham, Collections.singletonList(this.zzhah.zzakk()));
        }
        return this.zzhan.zzkk();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zza(zzvt zzvtVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzhan.zzg(zzvtVar);
        this.zzhat = zzvtVar;
        if (this.zzhah != null) {
            this.zzhah.zza(this.zzhar.zzavh(), zzvtVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized String getMediationAdapterClassName() {
        if (this.zzhah == null || this.zzhah.zzall() == null) {
            return null;
        }
        return this.zzhah.zzall().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized String zzkl() {
        if (this.zzhah == null || this.zzhah.zzall() == null) {
            return null;
        }
        return this.zzhah.zzall().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized zzzc zzkm() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzczt)).booleanValue()) {
            if (this.zzhah == null) {
                return null;
            }
            return this.zzhah.zzall();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zza(zzye zzyeVar) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzhan.zzc(zzyeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzhan.zzbs(z);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized boolean isLoading() {
        return this.zzhar.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized zzzd getVideoController() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        if (this.zzhah != null) {
            return this.zzhah.getVideoController();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized String getAdUnitId() {
        return this.zzbvf;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zza(zzaaz zzaazVar) {
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.zzhan.zzc(zzaazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzwx zzwxVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzhar.zza(zzwxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zza(zzacm zzacmVar) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzhar.zza(zzacmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzamo() {
        if (this.zzhar.zzavj()) {
            zzvt zzkk = this.zzhan.zzkk();
            if (this.zzhah != null && this.zzhah.zzakt() != null && this.zzhan.zzawh()) {
                zzkk = zzdpr.zzb(this.zzham, Collections.singletonList(this.zzhah.zzakt()));
            }
            zzf(zzkk);
            try {
                zzg(this.zzhan.zzawd());
                return;
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Failed to refresh the banner ad.");
                return;
            }
        }
        this.zzhar.zzavk();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzyx zzyxVar) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zzhas.zzb(zzyxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxt zzxtVar) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }
}
