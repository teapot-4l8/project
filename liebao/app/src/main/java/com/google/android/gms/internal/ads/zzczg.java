package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzczg extends zzxp {
    private final Context context;
    private final ViewGroup zzfwu;
    private final zzdpm zzfzg;
    private final zzxc zzgef;
    private final zzbne zzhah;

    public zzczg(Context context, zzxc zzxcVar, zzdpm zzdpmVar, zzbne zzbneVar) {
        this.context = context;
        this.zzgef = zzxcVar;
        this.zzfzg = zzdpmVar;
        this.zzhah = zzbneVar;
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.removeAllViews();
        frameLayout.addView(this.zzhah.zzakl(), com.google.android.gms.ads.internal.zzr.zzkx().zzzw());
        frameLayout.setMinimumHeight(zzkk().heightPixels);
        frameLayout.setMinimumWidth(zzkk().widthPixels);
        this.zzfwu = frameLayout;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean isLoading() {
        return false;
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
        return ObjectWrapper.wrap(this.zzfwu);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzhah.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final boolean zza(zzvq zzvqVar) {
        com.google.android.gms.ads.internal.util.zzd.zzey("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void pause() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzhah.zzalk().zzce(null);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void resume() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzhah.zzalk().zzcf(null);
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zzkj() {
        this.zzhah.zzkj();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzvt zzkk() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzdpr.zzb(this.context, Collections.singletonList(this.zzhah.zzakk()));
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final String getMediationAdapterClassName() {
        if (this.zzhah.zzall() != null) {
            return this.zzhah.zzall().getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzzd getVideoController() {
        return this.zzhah.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final String getAdUnitId() {
        return this.zzfzg.zzhny;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxy zzkn() {
        return this.zzfzg.zzhoe;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzxc zzko() {
        return this.zzgef;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final String zzkl() {
        if (this.zzhah.zzall() != null) {
            return this.zzhah.zzall().getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final zzzc zzkm() {
        return this.zzhah.zzall();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzaaz zzaazVar) {
        com.google.android.gms.ads.internal.util.zzd.zzey("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzvt zzvtVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzbne zzbneVar = this.zzhah;
        if (zzbneVar != null) {
            zzbneVar.zza(this.zzfwu, zzvtVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzacm zzacmVar) {
        com.google.android.gms.ads.internal.util.zzd.zzey("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzwx zzwxVar) {
        com.google.android.gms.ads.internal.util.zzd.zzey("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzye zzyeVar) {
        com.google.android.gms.ads.internal.util.zzd.zzey("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void setManualImpressionsEnabled(boolean z) {
        com.google.android.gms.ads.internal.util.zzd.zzey("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxc zzxcVar) {
        com.google.android.gms.ads.internal.util.zzd.zzey("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxy zzxyVar) {
        com.google.android.gms.ads.internal.util.zzd.zzey("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzxt zzxtVar) {
        com.google.android.gms.ads.internal.util.zzd.zzey("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final Bundle getAdMetadata() {
        com.google.android.gms.ads.internal.util.zzd.zzey("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzxq
    public final void zza(zzyx zzyxVar) {
        com.google.android.gms.ads.internal.util.zzd.zzey("setOnPaidEventListener is not supported in Publisher AdView returned by AdLoader.");
    }
}
