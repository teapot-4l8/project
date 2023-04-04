package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzchm extends zzafn {
    private final String zzcja;
    private final zzcdr zzgeo;
    private final zzcdf zzghx;

    public zzchm(String str, zzcdf zzcdfVar, zzcdr zzcdrVar) {
        this.zzcja = str;
        this.zzghx = zzcdfVar;
        this.zzgeo = zzcdrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final IObjectWrapper zzts() {
        return ObjectWrapper.wrap(this.zzghx);
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final String getHeadline() {
        return this.zzgeo.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final List<?> getImages() {
        return this.zzgeo.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final String getBody() {
        return this.zzgeo.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final zzaes zztw() {
        return this.zzgeo.zztw();
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final String getCallToAction() {
        return this.zzgeo.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final String getAdvertiser() {
        return this.zzgeo.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final Bundle getExtras() {
        return this.zzgeo.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final void destroy() {
        this.zzghx.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final zzzd getVideoController() {
        return this.zzgeo.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final void performClick(Bundle bundle) {
        this.zzghx.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final boolean recordImpression(Bundle bundle) {
        return this.zzghx.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final void reportTouchEvent(Bundle bundle) {
        this.zzghx.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final zzaek zztu() {
        return this.zzgeo.zztu();
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final IObjectWrapper zztv() {
        return this.zzgeo.zztv();
    }

    @Override // com.google.android.gms.internal.ads.zzafk
    public final String getMediationAdapterClassName() {
        return this.zzcja;
    }
}
