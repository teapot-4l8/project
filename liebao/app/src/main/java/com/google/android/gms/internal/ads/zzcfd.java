package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import cn.jpush.android.service.WakedResultReceiver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcfd {
    private final zzchu zzgio;
    private final zzcja zzgix;
    private ViewTreeObserver.OnScrollChangedListener zzgjc = null;

    public zzcfd(zzcja zzcjaVar, zzchu zzchuVar) {
        this.zzgix = zzcjaVar;
        this.zzgio = zzchuVar;
    }

    public final View zza(View view, WindowManager windowManager) {
        zzbfi zza = this.zzgix.zza(zzvt.zzqk(), null, null);
        zza.getView().setVisibility(4);
        zza.getView().setContentDescription("policy_validator");
        zza.zza("/sendMessageToSdk", new zzaig(this) { // from class: com.google.android.gms.internal.ads.zzcfc
            private final zzcfd zzgjb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgjb = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                this.zzgjb.zze((zzbfi) obj, map);
            }
        });
        zza.zza("/hideValidatorOverlay", new zzaig(this, windowManager, view) { // from class: com.google.android.gms.internal.ads.zzcff
            private final zzcfd zzgjb;
            private final WindowManager zzgjf;
            private final View zzgjg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgjb = this;
                this.zzgjf = windowManager;
                this.zzgjg = view;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                this.zzgjb.zza(this.zzgjf, this.zzgjg, (zzbfi) obj, map);
            }
        });
        zza.zza("/open", new zzaio(null, null, null, null, null));
        this.zzgio.zza(new WeakReference(zza), "/loadNativeAdPolicyViolations", new zzaig(this, view, windowManager) { // from class: com.google.android.gms.internal.ads.zzcfe
            private final zzcfd zzgjb;
            private final View zzgjd;
            private final WindowManager zzgje;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgjb = this;
                this.zzgjd = view;
                this.zzgje = windowManager;
            }

            @Override // com.google.android.gms.internal.ads.zzaig
            public final void zza(Object obj, Map map) {
                this.zzgjb.zza(this.zzgjd, this.zzgje, (zzbfi) obj, map);
            }
        });
        this.zzgio.zza(new WeakReference(zza), "/showValidatorOverlay", zzcfh.zzdif);
        return zza.getView();
    }

    private static int zza(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzww.zzqw();
        return zzbae.zze(context, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(View view, WindowManager windowManager, zzbfi zzbfiVar, Map map) {
        int i;
        zzbfiVar.zzaef().zza(new zzbgt(this, map) { // from class: com.google.android.gms.internal.ads.zzcfj
            private final Map zzeds;
            private final zzcfd zzgjb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgjb = this;
                this.zzeds = map;
            }

            @Override // com.google.android.gms.internal.ads.zzbgt
            public final void zzam(boolean z) {
                this.zzgjb.zzb(this.zzeds, z);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        int zza = zza(context, (String) map.get("validator_width"), ((Integer) zzww.zzra().zzd(zzabq.zzdao)).intValue());
        int zza2 = zza(context, (String) map.get("validator_height"), ((Integer) zzww.zzra().zzd(zzabq.zzdap)).intValue());
        int zza3 = zza(context, (String) map.get("validator_x"), 0);
        int zza4 = zza(context, (String) map.get("validator_y"), 0);
        zzbfiVar.zza(zzbgx.zzs(zza, zza2));
        try {
            zzbfiVar.getWebView().getSettings().setUseWideViewPort(((Boolean) zzww.zzra().zzd(zzabq.zzdaq)).booleanValue());
            zzbfiVar.getWebView().getSettings().setLoadWithOverviewMode(((Boolean) zzww.zzra().zzd(zzabq.zzdar)).booleanValue());
        } catch (NullPointerException unused) {
        }
        WindowManager.LayoutParams zzaaj = com.google.android.gms.ads.internal.util.zzbn.zzaaj();
        zzaaj.x = zza3;
        zzaaj.y = zza4;
        windowManager.updateViewLayout(zzbfiVar.getView(), zzaaj);
        String str = (String) map.get("orientation");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            if ("1".equals(str) || WakedResultReceiver.WAKE_TYPE_KEY.equals(str)) {
                i = rect.bottom;
            } else {
                i = rect.top;
            }
            this.zzgjc = new ViewTreeObserver.OnScrollChangedListener(view, zzbfiVar, str, zzaaj, i - zza4, windowManager) { // from class: com.google.android.gms.internal.ads.zzcfg
                private final String zzdmx;
                private final View zzgjh;
                private final zzbfi zzgji;
                private final WindowManager.LayoutParams zzgjj;
                private final int zzgjk;
                private final WindowManager zzgjl;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgjh = view;
                    this.zzgji = zzbfiVar;
                    this.zzdmx = str;
                    this.zzgjj = zzaaj;
                    this.zzgjk = r5;
                    this.zzgjl = windowManager;
                }

                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    View view2 = this.zzgjh;
                    zzbfi zzbfiVar2 = this.zzgji;
                    String str2 = this.zzdmx;
                    WindowManager.LayoutParams layoutParams = this.zzgjj;
                    int i2 = this.zzgjk;
                    WindowManager windowManager2 = this.zzgjl;
                    Rect rect2 = new Rect();
                    if (!view2.getGlobalVisibleRect(rect2) || zzbfiVar2.getView().getWindowToken() == null) {
                        return;
                    }
                    if ("1".equals(str2) || WakedResultReceiver.WAKE_TYPE_KEY.equals(str2)) {
                        layoutParams.y = rect2.bottom - i2;
                    } else {
                        layoutParams.y = rect2.top - i2;
                    }
                    windowManager2.updateViewLayout(zzbfiVar2.getView(), layoutParams);
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(this.zzgjc);
            }
        }
        String str2 = (String) map.get("overlay_url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzbfiVar.loadUrl(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzgio.zza("sendMessageToNativeJs", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(WindowManager windowManager, View view, zzbfi zzbfiVar, Map map) {
        com.google.android.gms.ads.internal.util.zzd.zzdz("Hide native ad policy validator overlay.");
        zzbfiVar.getView().setVisibility(8);
        if (zzbfiVar.getView().getWindowToken() != null) {
            windowManager.removeView(zzbfiVar.getView());
        }
        zzbfiVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzgjc == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this.zzgjc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbfi zzbfiVar, Map map) {
        this.zzgio.zza("sendMessageToNativeJs", map);
    }
}
