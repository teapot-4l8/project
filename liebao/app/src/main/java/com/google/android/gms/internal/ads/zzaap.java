package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaap extends zzavj {
    private zzavn zzcmb;

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void destroy() {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final String getMediationAdapterClassName() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final boolean isLoaded() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void pause() {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void resume() {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void setAppPackageName(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void setCustomData(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void show() {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zza(zzave zzaveVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zza(zzxt zzxtVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zzi(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zzj(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zzk(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final zzzc zzkm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zzl(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final boolean zzsc() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zza(zzavt zzavtVar) {
        zzbao.zzex("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzbae.zzaah.post(new zzaao(this));
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final void zza(zzavn zzavnVar) {
        this.zzcmb = zzavnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final Bundle getAdMetadata() {
        return new Bundle();
    }
}
