package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzapp extends zzaog {
    private final UnifiedNativeAdMapper zzdpy;

    public zzapp(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zzdpy = unifiedNativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final zzaek zztu() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final String getHeadline() {
        return this.zzdpy.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdpy.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image image : images) {
                arrayList.add(new zzaee(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final String getBody() {
        return this.zzdpy.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final zzaes zztt() {
        NativeAd.Image icon = this.zzdpy.getIcon();
        if (icon != null) {
            return new zzaee(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final String getCallToAction() {
        return this.zzdpy.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final String getAdvertiser() {
        return this.zzdpy.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final double getStarRating() {
        if (this.zzdpy.getStarRating() != null) {
            return this.zzdpy.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final String getStore() {
        return this.zzdpy.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final String getPrice() {
        return this.zzdpy.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final zzzd getVideoController() {
        if (this.zzdpy.getVideoController() != null) {
            return this.zzdpy.getVideoController().zzdz();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final IObjectWrapper zzvr() {
        View adChoicesContent = this.zzdpy.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final IObjectWrapper zzvs() {
        View zzafo = this.zzdpy.zzafo();
        if (zzafo == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzafo);
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final float getMediaContentAspectRatio() {
        return this.zzdpy.getMediaContentAspectRatio();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final float getVideoDuration() {
        return this.zzdpy.getDuration();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final float getVideoCurrentTime() {
        return this.zzdpy.getCurrentTime();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final IObjectWrapper zztv() {
        Object zzka = this.zzdpy.zzka();
        if (zzka == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzka);
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final Bundle getExtras() {
        return this.zzdpy.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final boolean getOverrideImpressionRecording() {
        return this.zzdpy.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final boolean getOverrideClickHandling() {
        return this.zzdpy.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final void recordImpression() {
        this.zzdpy.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdpy.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdpy.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzaoh
    public final void zzx(IObjectWrapper iObjectWrapper) {
        this.zzdpy.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
