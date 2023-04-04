package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcel extends zzaez implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcfl {
    public static final String[] zzgib = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, "3010"};
    private FrameLayout zzboi;
    private zzaer zzclt;
    private zzcdf zzghx;
    private zzqs zzghy;
    private final String zzgia;
    private FrameLayout zzgic;
    private zzebs zzgid;
    private View zzgie;
    private boolean zzgig;
    private Map<String, WeakReference<View>> zzdva = new HashMap();
    private IObjectWrapper zzgif = null;
    private boolean zzevf = false;
    private final int zzekb = 204890000;

    public zzcel(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.zzgic = frameLayout;
        this.zzboi = frameLayout2;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzgia = str;
        com.google.android.gms.ads.internal.zzr.zzls();
        zzbbm.zza((View) frameLayout, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzr.zzls();
        zzbbm.zza((View) frameLayout, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzgid = zzbat.zzeki;
        this.zzghy = new zzqs(this.zzgic.getContext(), this.zzgic);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final synchronized void zzb(String str, IObjectWrapper iObjectWrapper) {
        zza(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized void zza(String str, View view, boolean z) {
        if (this.zzevf) {
            return;
        }
        if (view == null) {
            this.zzdva.remove(str);
            return;
        }
        this.zzdva.put(str, new WeakReference<>(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !"3011".equals(str)) {
            if (com.google.android.gms.ads.internal.util.zzbn.zzdn(this.zzekb)) {
                view.setOnTouchListener(this);
            }
            view.setClickable(true);
            view.setOnClickListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final synchronized IObjectWrapper zzco(String str) {
        return ObjectWrapper.wrap(zzgd(str));
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized View zzgd(String str) {
        if (this.zzevf) {
            return null;
        }
        WeakReference<View> weakReference = this.zzdva.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final synchronized void zza(IObjectWrapper iObjectWrapper) {
        if (this.zzevf) {
            return;
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzcdf)) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Not an instance of native engine. This is most likely a transient error");
            return;
        }
        if (this.zzghx != null) {
            this.zzghx.zzc(this);
        }
        zzapv();
        zzcdf zzcdfVar = (zzcdf) unwrap;
        this.zzghx = zzcdfVar;
        zzcdfVar.zza(this);
        this.zzghx.zzaa(this.zzgic);
        this.zzghx.zzab(this.zzboi);
        if (this.zzgig) {
            this.zzghx.zzaol().zza(this.zzclt);
        }
    }

    private final synchronized void zzapv() {
        this.zzgid.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcek
            private final zzcel zzghz;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzghz = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzghz.zzapw();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final synchronized void destroy() {
        if (this.zzevf) {
            return;
        }
        if (this.zzghx != null) {
            this.zzghx.zzc(this);
            this.zzghx = null;
        }
        this.zzdva.clear();
        this.zzgic.removeAllViews();
        this.zzboi.removeAllViews();
        this.zzdva = null;
        this.zzgic = null;
        this.zzboi = null;
        this.zzgie = null;
        this.zzghy = null;
        this.zzevf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final synchronized void zzc(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        if (this.zzghx != null) {
            this.zzghx.cancelUnconfirmedClick();
            this.zzghx.zza(view, this.zzgic, zzapq(), zzapr(), false);
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzghx != null) {
            this.zzghx.zza(view, motionEvent, this.zzgic);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized JSONObject zztq() {
        if (this.zzghx != null) {
            return this.zzghx.zza(this.zzgic, zzapq(), zzapr());
        }
        return null;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        if (this.zzghx != null) {
            this.zzghx.zzb(this.zzgic, zzapq(), zzapr(), zzcdf.zzz(this.zzgic));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        if (this.zzghx != null) {
            this.zzghx.zzb(this.zzgic, zzapq(), zzapr(), zzcdf.zzz(this.zzgic));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized Map<String, WeakReference<View>> zzapq() {
        return this.zzdva;
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized Map<String, WeakReference<View>> zzapr() {
        return this.zzdva;
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized Map<String, WeakReference<View>> zzaps() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final synchronized String zzapt() {
        return this.zzgia;
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final FrameLayout zzapo() {
        return this.zzboi;
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final zzqs zzapp() {
        return this.zzghy;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final synchronized void zzf(IObjectWrapper iObjectWrapper) {
        this.zzghx.setClickConfirmingView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final synchronized void zzh(IObjectWrapper iObjectWrapper) {
        if (this.zzevf) {
            return;
        }
        this.zzgif = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final IObjectWrapper zzapu() {
        return this.zzgif;
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final void zzg(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzgic, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaew
    public final synchronized void zza(zzaer zzaerVar) {
        if (this.zzevf) {
            return;
        }
        this.zzgig = true;
        this.zzclt = zzaerVar;
        if (this.zzghx != null) {
            this.zzghx.zzaol().zza(zzaerVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfl
    public final /* synthetic */ View zzakl() {
        return this.zzgic;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzapw() {
        if (this.zzgie == null) {
            View view = new View(this.zzgic.getContext());
            this.zzgie = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzgic != this.zzgie.getParent()) {
            this.zzgic.addView(this.zzgie);
        }
    }
}
