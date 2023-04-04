package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzaew;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public class NativeAdView extends FrameLayout {
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

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public AdChoicesView getAdChoicesView() {
        View zzbj = zzbj(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzbj instanceof AdChoicesView) {
            return (AdChoicesView) zzbj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(String str, View view) {
        try {
            this.zzboj.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e2) {
            zzbao.zzc("Unable to call setAssetView on delegate", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View zzbj(String str) {
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

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzboj.zza((IObjectWrapper) nativeAd.zzjw());
        } catch (RemoteException e2) {
            zzbao.zzc("Unable to call setNativeAd on delegate", e2);
        }
    }

    public void destroy() {
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
        Preconditions.checkNotNull(this.zzboi, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzww.zzqx().zza(this.zzboi.getContext(), this, this.zzboi);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzboi);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.zzboi == view) {
            return;
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzboi);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzboi;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
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
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
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
}
