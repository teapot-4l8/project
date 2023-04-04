package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaow extends zzaof {
    private final NativeContentAdMapper zzdpn;

    public zzaow(NativeContentAdMapper nativeContentAdMapper) {
        this.zzdpn = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final zzaek zztu() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final IObjectWrapper zztv() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final String getHeadline() {
        return this.zzdpn.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdpn.getImages();
        if (images != null) {
            ArrayList arrayList = new ArrayList();
            for (NativeAd.Image image : images) {
                arrayList.add(new zzaee(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final String getBody() {
        return this.zzdpn.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final zzaes zztw() {
        NativeAd.Image logo = this.zzdpn.getLogo();
        if (logo != null) {
            return new zzaee(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final String getCallToAction() {
        return this.zzdpn.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final String getAdvertiser() {
        return this.zzdpn.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final void recordImpression() {
        this.zzdpn.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdpn.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdpn.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdpn.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final void zzx(IObjectWrapper iObjectWrapper) {
        this.zzdpn.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final boolean getOverrideImpressionRecording() {
        return this.zzdpn.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final boolean getOverrideClickHandling() {
        return this.zzdpn.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final Bundle getExtras() {
        return this.zzdpn.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final IObjectWrapper zzvr() {
        View adChoicesContent = this.zzdpn.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final zzzd getVideoController() {
        if (this.zzdpn.getVideoController() != null) {
            return this.zzdpn.getVideoController().zzdz();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaoc
    public final IObjectWrapper zzvs() {
        View zzafo = this.zzdpn.zzafo();
        if (zzafo == null) {
            return null;
        }
        return ObjectWrapper.wrap(zzafo);
    }
}
