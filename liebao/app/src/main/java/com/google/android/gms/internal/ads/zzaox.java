package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaox extends zzaoa {
    private final NativeAppInstallAdMapper zzdpo;

    public zzaox(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzdpo = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final zzaek zztu() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final IObjectWrapper zztv() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String getHeadline() {
        return this.zzdpo.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdpo.getImages();
        if (images != null) {
            ArrayList arrayList = new ArrayList();
            for (NativeAd.Image image : images) {
                arrayList.add(new zzaee(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String getBody() {
        return this.zzdpo.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final zzaes zztt() {
        NativeAd.Image icon = this.zzdpo.getIcon();
        if (icon != null) {
            return new zzaee(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String getCallToAction() {
        return this.zzdpo.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final double getStarRating() {
        return this.zzdpo.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String getStore() {
        return this.zzdpo.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final String getPrice() {
        return this.zzdpo.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void recordImpression() {
        this.zzdpo.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdpo.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdpo.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdpo.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final void zzx(IObjectWrapper iObjectWrapper) {
        this.zzdpo.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final boolean getOverrideImpressionRecording() {
        return this.zzdpo.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final boolean getOverrideClickHandling() {
        return this.zzdpo.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final Bundle getExtras() {
        return this.zzdpo.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final zzzd getVideoController() {
        if (this.zzdpo.getVideoController() != null) {
            return this.zzdpo.getVideoController().zzdz();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final IObjectWrapper zzvr() {
        View adChoicesContent = this.zzdpo.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzaob
    public final IObjectWrapper zzvs() {
        View zzafo = this.zzdpo.zzafo();
        if (zzafo == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzafo);
    }
}
