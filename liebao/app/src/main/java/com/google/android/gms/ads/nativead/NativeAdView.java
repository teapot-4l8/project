package com.google.android.gms.ads.nativead;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaab;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzaej;
import com.google.android.gms.internal.ads.zzaer;
import com.google.android.gms.internal.ads.zzaew;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class NativeAdView extends FrameLayout {
    private final FrameLayout zzboi;
    private final zzaew zzboj;

    public NativeAdView(Context context) {
        super(context);
        this.zzboi = zzd(context);
        this.zzboj = zzjy();
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzboi = zzd(context);
        this.zzboj = zzjy();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzboi = zzd(context);
        this.zzboj = zzjy();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzboi = zzd(context);
        this.zzboj = zzjy();
    }

    private final void zza(String str, View view) {
        try {
            this.zzboj.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e2) {
            zzbao.zzc("Unable to call setAssetView on delegate", e2);
        }
    }

    public final void setHeadlineView(View view) {
        zza("3001", view);
    }

    public final void setCallToActionView(View view) {
        zza("3002", view);
    }

    public final void setIconView(View view) {
        zza("3003", view);
    }

    public final void setBodyView(View view) {
        zza("3004", view);
    }

    public final void setAdvertiserView(View view) {
        zza("3005", view);
    }

    public final void setStoreView(View view) {
        zza("3006", view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzboj.zzf(ObjectWrapper.wrap(view));
        } catch (RemoteException e2) {
            zzbao.zzc("Unable to call setClickConfirmingView on delegate", e2);
        }
    }

    public final void setPriceView(View view) {
        zza("3007", view);
    }

    public final void setImageView(View view) {
        zza("3008", view);
    }

    public final void setStarRatingView(View view) {
        zza("3009", view);
    }

    public final void setMediaView(MediaView mediaView) {
        zza("3010", mediaView);
        if (mediaView != null) {
            mediaView.zza(new zzaeh(this) { // from class: com.google.android.gms.ads.nativead.zzb
                private final NativeAdView zzeyf;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeyf = this;
                }

                @Override // com.google.android.gms.internal.ads.zzaeh
                public final void setMediaContent(MediaContent mediaContent) {
                    this.zzeyf.zzb(mediaContent);
                }
            });
            mediaView.zza(new zzaej(this) { // from class: com.google.android.gms.ads.nativead.zzc
                private final NativeAdView zzeyf;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeyf = this;
                }

                @Override // com.google.android.gms.internal.ads.zzaej
                public final void setImageScaleType(ImageView.ScaleType scaleType) {
                    this.zzeyf.zzb(scaleType);
                }
            });
        }
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        zza("3011", adChoicesView);
    }

    public final void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzboj.zza((IObjectWrapper) nativeAd.zzjw());
        } catch (RemoteException e2) {
            zzbao.zzc("Unable to call setNativeAd on delegate", e2);
        }
    }

    private final View zzbj(String str) {
        try {
            IObjectWrapper zzco = this.zzboj.zzco(str);
            if (zzco != null) {
                return (View) ObjectWrapper.unwrap(zzco);
            }
            return null;
        } catch (RemoteException e2) {
            zzbao.zzc("Unable to call getAssetView on delegate", e2);
            return null;
        }
    }

    public final View getHeadlineView() {
        return zzbj("3001");
    }

    public final View getCallToActionView() {
        return zzbj("3002");
    }

    public final View getIconView() {
        return zzbj("3003");
    }

    public final View getBodyView() {
        return zzbj("3004");
    }

    public final View getStoreView() {
        return zzbj("3006");
    }

    public final View getPriceView() {
        return zzbj("3007");
    }

    public final View getAdvertiserView() {
        return zzbj("3005");
    }

    public final View getImageView() {
        return zzbj("3008");
    }

    public final View getStarRatingView() {
        return zzbj("3009");
    }

    public final MediaView getMediaView() {
        View zzbj = zzbj("3010");
        if (zzbj instanceof MediaView) {
            return (MediaView) zzbj;
        }
        if (zzbj != null) {
            zzbao.zzdz("View is not an instance of MediaView");
            return null;
        }
        return null;
    }

    public final AdChoicesView getAdChoicesView() {
        View zzbj = zzbj("3011");
        if (zzbj instanceof AdChoicesView) {
            return (AdChoicesView) zzbj;
        }
        return null;
    }

    public final void destroy() {
        try {
            this.zzboj.destroy();
        } catch (RemoteException e2) {
            zzbao.zzc("Unable to destroy native ad view", e2);
        }
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaew zzjy() {
        Preconditions.checkNotNull(this.zzboi, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzww.zzqx().zza(this.zzboi.getContext(), this, this.zzboi);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzboi);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.zzboi == view) {
            return;
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzboi);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzboi;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzaew zzaewVar = this.zzboj;
        if (zzaewVar != null) {
            try {
                zzaewVar.zzc(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call onVisibilityChanged on delegate", e2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzaew zzaewVar;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcth)).booleanValue() && (zzaewVar = this.zzboj) != null) {
            try {
                zzaewVar.zzg(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call handleTouchEvent on delegate", e2);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            try {
                this.zzboj.zzh(ObjectWrapper.wrap(scaleType));
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call setMediaViewImageScaleType on delegate", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(MediaContent mediaContent) {
        try {
            if (mediaContent instanceof zzaab) {
                this.zzboj.zza(((zzaab) mediaContent).zzrz());
            } else if (mediaContent == null) {
                this.zzboj.zza((zzaer) null);
            } else {
                zzbao.zzdz("Use MediaContent provided by NativeAd.getMediaContent");
            }
        } catch (RemoteException e2) {
            zzbao.zzc("Unable to call setMediaContent on delegate", e2);
        }
    }
}
