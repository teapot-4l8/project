package com.google.android.gms.ads.appopen;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzsk;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzxq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public final class AppOpenAdView extends ViewGroup {
    private AppOpenAd zzaei;
    private AppOpenAdPresentationCallback zzaej;

    public AppOpenAdView(Context context) {
        super(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public AppOpenAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppOpenAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setAppOpenAd(AppOpenAd appOpenAd) {
        IObjectWrapper zzki;
        try {
            zzxq zzea = appOpenAd.zzea();
            if (zzea == null || (zzki = zzea.zzki()) == null) {
                return;
            }
            View view = (View) ObjectWrapper.unwrap(zzki);
            if (view.getParent() == null) {
                removeAllViews();
                addView(view);
                this.zzaei = appOpenAd;
                zzeb();
                return;
            }
            zzbao.zzex("Trying to set AppOpenAd which is already in use.");
        } catch (RemoteException e2) {
            zzbao.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setAppOpenAdPresentationCallback(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzaej = appOpenAdPresentationCallback;
        zzeb();
    }

    private final void zzeb() {
        AppOpenAd appOpenAd = this.zzaei;
        if (appOpenAd == null || this.zzaej == null) {
            return;
        }
        appOpenAd.zza(new zzsk(this.zzaej));
    }

    private final AdSize getAdSize() {
        zzxq zzea = this.zzaei.zzea();
        if (zzea != null) {
            try {
                zzvt zzkk = zzea.zzkk();
                if (zzkk != null) {
                    return zzkk.zzqo();
                }
                return null;
            } catch (RemoteException e2) {
                zzbao.zze("#007 Could not call remote method.", e2);
                return null;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        } else {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e2) {
                zzbao.zzc("Unable to retrieve ad size.", e2);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }
}
