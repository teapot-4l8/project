package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzcei extends zzafc implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcfl {
    private final WeakReference<View> zzght;
    private final Map<String, WeakReference<View>> zzghu = new HashMap();
    private final Map<String, WeakReference<View>> zzghv = new HashMap();
    private final Map<String, WeakReference<View>> zzghw = new HashMap();
    private zzcdf zzghx;
    private zzqs zzghy;

    public zzcei(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        com.google.android.gms.ads.internal.zzr.zzls();
        zzbbm.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzr.zzls();
        zzbbm.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzght = new WeakReference<>(view);
        for (Map.Entry<String, View> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.zzghu.put(key, new WeakReference<>(value));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key) && !"3011".equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
        this.zzghw.putAll(this.zzghu);
        for (Map.Entry<String, View> entry2 : hashMap2.entrySet()) {
            View value2 = entry2.getValue();
            if (value2 != null) {
                this.zzghv.put(entry2.getKey(), new WeakReference<>(value2));
                value2.setOnTouchListener(this);
                value2.setClickable(false);
            }
        }
        this.zzghw.putAll(this.zzghv);
        this.zzghy = new zzqs(view.getContext(), view);
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final FrameLayout zzapo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzafd
    public final synchronized void unregisterNativeAd() {
        if (this.zzghx != null) {
            this.zzghx.zzc(this);
            this.zzghx = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafd
    public final synchronized void zza(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzcdf)) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        if (this.zzghx != null) {
            this.zzghx.zzc(this);
        }
        if (((zzcdf) unwrap).zzaoj()) {
            zzcdf zzcdfVar = (zzcdf) unwrap;
            this.zzghx = zzcdfVar;
            zzcdfVar.zza(this);
            this.zzghx.zzaa(zzakl());
            return;
        }
        com.google.android.gms.ads.internal.util.zzd.zzex("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final View zzakl() {
        return this.zzght.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final zzqs zzapp() {
        return this.zzghy;
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized void zza(String str, View view, boolean z) {
        if (view == null) {
            this.zzghw.remove(str);
            this.zzghu.remove(str);
            this.zzghv.remove(str);
            return;
        }
        this.zzghw.put(str, new WeakReference<>(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !"3011".equals(str)) {
            this.zzghu.put(str, new WeakReference<>(view));
            view.setClickable(true);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized Map<String, WeakReference<View>> zzapq() {
        return this.zzghw;
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized Map<String, WeakReference<View>> zzapr() {
        return this.zzghu;
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized Map<String, WeakReference<View>> zzaps() {
        return this.zzghv;
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized View zzgd(String str) {
        WeakReference<View> weakReference = this.zzghw.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized String zzapt() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized IObjectWrapper zzapu() {
        return null;
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzghx != null) {
            this.zzghx.zza(view, motionEvent, zzakl());
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        if (this.zzghx != null) {
            this.zzghx.zza(view, zzakl(), zzapq(), zzapr(), true);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        if (this.zzghx != null) {
            this.zzghx.zzb(zzakl(), zzapq(), zzapr(), zzcdf.zzz(zzakl()));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        if (this.zzghx != null) {
            this.zzghx.zzb(zzakl(), zzapq(), zzapr(), zzcdf.zzz(zzakl()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafd
    public final synchronized void zzf(IObjectWrapper iObjectWrapper) {
        if (this.zzghx != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                com.google.android.gms.ads.internal.util.zzd.zzez("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zzghx.setClickConfirmingView((View) unwrap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized JSONObject zztq() {
        return null;
    }
}
