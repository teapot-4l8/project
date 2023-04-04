package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdak extends zzxp {
    private final zzvt zzbpy;
    private final String zzbvf;
    private final Context zzham;
    private final zzczm zzhas;
    private final zzdmr zzhbh;
    private final zzdnb zzhbi;
    private zzcaj zzhbj;
    private boolean zzhbk = ((Boolean) zzww.zzra().zzd(zzabq.zzcpl)).booleanValue();

    public zzdak(Context context, zzvt zzvtVar, String str, zzdmr zzdmrVar, zzczm zzczmVar, zzdnb zzdnbVar) {
        this.zzbpy = zzvtVar;
        this.zzbvf = str;
        this.zzham = context;
        this.zzhbh = zzdmrVar;
        this.zzhas = zzczmVar;
        this.zzhbi = zzdnbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzzd getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setManualImpressionsEnabled(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzaaz zzaazVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzasr zzasrVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzasx zzasxVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzsq zzsqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzvt zzvtVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzwc zzwcVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzwx zzwxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzye zzyeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzzj zzzjVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzbl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final IObjectWrapper zzki() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzkj() {
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzvt zzkk() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized boolean zza(zzvq zzvqVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        com.google.android.gms.ads.internal.zzr.zzkv();
        if (com.google.android.gms.ads.internal.util.zzj.zzbc(this.zzham) && zzvqVar.zzcip == null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Failed to load the ad because app ID is missing.");
            if (this.zzhas != null) {
                this.zzhas.zzd(zzdqh.zza(zzdqj.APP_ID_MISSING, null, null));
            }
            return false;
        } else if (zzati()) {
            return false;
        } else {
            zzdqa.zze(this.zzham, zzvqVar.zzcid);
            this.zzhbj = null;
            return this.zzhbh.zza(zzvqVar, this.zzbvf, new zzdms(this.zzbpy), new zzdan(this));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzvq zzvqVar, zzxd zzxdVar) {
        this.zzhas.zza(zzxdVar);
        zza(zzvqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        if (this.zzhbj == null) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Interstitial can not be shown before loaded.");
            this.zzhas.zzk(zzdqh.zza(zzdqj.NOT_READY, null, null));
            return;
        }
        this.zzhbj.zzb(this.zzhbk, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzyg zzygVar) {
        this.zzhas.zzb(zzygVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzhbj != null) {
            this.zzhbj.zzalk().zzcg(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzhbj != null) {
            this.zzhbj.zzalk().zzce(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzhbj != null) {
            this.zzhbj.zzalk().zzcf(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxc zzxcVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzhas.zzc(zzxcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxy zzxyVar) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzhas.zzb(zzxyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void showInterstitial() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.zzhbj == null) {
            return;
        }
        this.zzhbj.zzb(this.zzhbk, null);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized String getMediationAdapterClassName() {
        if (this.zzhbj == null || this.zzhbj.zzall() == null) {
            return null;
        }
        return this.zzhbj.zzall().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized String zzkl() {
        if (this.zzhbj == null || this.zzhbj.zzall() == null) {
            return null;
        }
        return this.zzhbj.zzall().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized zzzc zzkm() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzczt)).booleanValue()) {
            if (this.zzhbj == null) {
                return null;
            }
            return this.zzhbj.zzall();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized boolean isLoading() {
        return this.zzhbh.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized boolean isReady() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzati();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized String getAdUnitId() {
        return this.zzbvf;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxy zzkn() {
        return this.zzhas.zzatf();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxc zzko() {
        return this.zzhas.zzate();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzhbk = z;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final synchronized void zza(zzacm zzacmVar) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzhbh.zza(zzacmVar);
    }

    private final synchronized boolean zzati() {
        boolean z;
        if (this.zzhbj != null) {
            z = this.zzhbj.isClosed() ? false : true;
        }
        return z;
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

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzavn zzavnVar) {
        this.zzhbi.zzb(zzavnVar);
    }
}
