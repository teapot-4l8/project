package com.google.android.gms.ads.nativead;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzafd;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzww;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class NativeAdViewHolder {
    private static WeakHashMap<View, NativeAdViewHolder> zzbol = new WeakHashMap<>();
    private zzafd zzbok;
    private WeakReference<View> zzbom;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if (view instanceof NativeAdView) {
            zzbao.zzex("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zzbol.get(view) != null) {
            zzbao.zzex("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zzbol.put(view, this);
            this.zzbom = new WeakReference<>(view);
            this.zzbok = zzww.zzqx().zza(view, zzb(map), zzb(map2));
        }
    }

    private static HashMap<String, View> zzb(Map<String, View> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public final void setNativeAd(NativeAd nativeAd) {
        IObjectWrapper iObjectWrapper = (IObjectWrapper) nativeAd.zzjw();
        WeakReference<View> weakReference = this.zzbom;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            zzbao.zzez("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzbol.containsKey(view)) {
            zzbol.put(view, this);
        }
        zzafd zzafdVar = this.zzbok;
        if (zzafdVar != null) {
            try {
                zzafdVar.zza(iObjectWrapper);
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call setNativeAd on delegate", e2);
            }
        }
    }

    public final void unregisterNativeAd() {
        zzafd zzafdVar = this.zzbok;
        if (zzafdVar != null) {
            try {
                zzafdVar.unregisterNativeAd();
            } catch (RemoteException e2) {
                zzbao.zzc("Unable to call unregisterNativeAd on delegate", e2);
            }
        }
        WeakReference<View> weakReference = this.zzbom;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            zzbol.remove(view);
        }
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbok.zzf(ObjectWrapper.wrap(view));
        } catch (RemoteException e2) {
            zzbao.zzc("Unable to call setClickConfirmingView on delegate", e2);
        }
    }
}
