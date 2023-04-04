package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdon extends zzavj {
    private final zzdph zzgbf;
    private boolean zzhbk = false;
    private final zzdnz zzhlq;
    private final zzdnb zzhlr;
    private zzcip zzhls;

    public zzdon(zzdnz zzdnzVar, zzdnb zzdnbVar, zzdph zzdphVar) {
        this.zzhlq = zzdnzVar;
        this.zzhlr = zzdnbVar;
        this.zzgbf = zzdphVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void setAppPackageName(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final synchronized void zza(zzavt zzavtVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (zzabs.zzcp(zzavtVar.zzbvf)) {
            return;
        }
        if (zzati()) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcxc)).booleanValue()) {
                return;
            }
        }
        zzdoa zzdoaVar = new zzdoa(null);
        this.zzhls = null;
        this.zzhlq.zzek(zzdpe.zzhnl);
        this.zzhlq.zza(zzavtVar.zzdvn, zzavtVar.zzbvf, zzdoaVar, new zzdoq(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void destroy() {
        zzl(null);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final synchronized void zzl(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzhlr.zza(null);
        if (this.zzhls != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzhls.zzalk().zzcg(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void pause() {
        zzj(null);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzhls != null) {
            this.zzhls.zzalk().zzce(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void resume() {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzhls != null) {
            this.zzhls.zzalk().zzcf(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final synchronized void show() {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        Activity activity;
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.zzhls == null) {
            return;
        }
        if (iObjectWrapper != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof Activity) {
                activity = (Activity) unwrap;
                this.zzhls.zzb(this.zzhbk, activity);
            }
        }
        activity = null;
        this.zzhls.zzb(this.zzhbk, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final boolean zzsc() {
        zzcip zzcipVar = this.zzhls;
        return zzcipVar != null && zzcipVar.zzsc();
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final synchronized String getMediationAdapterClassName() {
        if (this.zzhls == null || this.zzhls.zzall() == null) {
            return null;
        }
        return this.zzhls.zzall().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final boolean isLoaded() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzati();
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zza(zzavn zzavnVar) {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzhlr.zzb(zzavnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zza(zzave zzaveVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzhlr.zzb(zzaveVar);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zza(zzxt zzxtVar) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzxtVar == null) {
            this.zzhlr.zza(null);
        } else {
            this.zzhlr.zza(new zzdop(this, zzxtVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzcip zzcipVar = this.zzhls;
        return zzcipVar != null ? zzcipVar.getAdMetadata() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final synchronized void setUserId(String str) {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzgbf.zzear = str;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final synchronized void setCustomData(String str) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpz)).booleanValue()) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
            this.zzgbf.zzeas = str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzhbk = z;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final synchronized zzzc zzkm() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzczt)).booleanValue()) {
            if (this.zzhls != null) {
                return this.zzhls.zzall();
            }
            return null;
        }
        return null;
    }

    private final synchronized boolean zzati() {
        boolean z;
        if (this.zzhls != null) {
            z = this.zzhls.isClosed() ? false : true;
        }
        return z;
    }
}
