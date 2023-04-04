package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcht extends zzagv {
    private final String zzcja;
    private final zzcdr zzgeo;
    private final zzcdf zzghx;

    public zzcht(String str, zzcdf zzcdfVar, zzcdr zzcdrVar) {
        this.zzcja = str;
        this.zzghx = zzcdfVar;
        this.zzgeo = zzcdrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final IObjectWrapper zzts() {
        return ObjectWrapper.wrap(this.zzghx);
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getHeadline() {
        return this.zzgeo.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final List<?> getImages() {
        return this.zzgeo.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final List<?> getMuteThisAdReasons() {
        if (isCustomMuteThisAdEnabled()) {
            return this.zzgeo.getMuteThisAdReasons();
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final boolean isCustomMuteThisAdEnabled() {
        return (this.zzgeo.getMuteThisAdReasons().isEmpty() || this.zzgeo.zzaor() == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getBody() {
        return this.zzgeo.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final zzaes zztt() {
        return this.zzgeo.zztt();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getCallToAction() {
        return this.zzgeo.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getAdvertiser() {
        return this.zzgeo.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final double getStarRating() {
        return this.zzgeo.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getStore() {
        return this.zzgeo.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getPrice() {
        return this.zzgeo.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void destroy() {
        this.zzghx.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final zzzd getVideoController() {
        return this.zzgeo.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void performClick(Bundle bundle) {
        this.zzghx.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final boolean recordImpression(Bundle bundle) {
        return this.zzghx.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void reportTouchEvent(Bundle bundle) {
        this.zzghx.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final zzaek zztu() {
        return this.zzgeo.zztu();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final IObjectWrapper zztv() {
        return this.zzgeo.zztv();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final String getMediationAdapterClassName() {
        return this.zzcja;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final Bundle getExtras() {
        return this.zzgeo.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void zza(zzagr zzagrVar) {
        this.zzghx.zza(zzagrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void zza(zzys zzysVar) {
        this.zzghx.zza(zzysVar);
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void zza(zzyo zzyoVar) {
        this.zzghx.zza(zzyoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void zzud() {
        this.zzghx.zzud();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void recordCustomClickGesture() {
        this.zzghx.recordCustomClickGesture();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final boolean isCustomClickGestureEnabled() {
        return this.zzghx.isCustomClickGestureEnabled();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void cancelUnconfirmedClick() {
        this.zzghx.cancelUnconfirmedClick();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final zzaer zzue() {
        return this.zzghx.zzaol().zzue();
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final zzzc zzkm() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzczt)).booleanValue()) {
            return this.zzghx.zzall();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzags
    public final void zza(zzyx zzyxVar) {
        this.zzghx.zza(zzyxVar);
    }
}
