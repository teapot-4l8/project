package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzuh;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbfy extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzbfi {
    private int maxHeight;
    private int maxWidth;
    private String zzadd;
    private final zzbar zzbpx;
    private final WindowManager zzbro;
    private int zzbwf;
    private int zzdrr;
    private int zzdrs;
    private boolean zzduh;
    private String zzdvx;
    private Boolean zzeej;
    private zzacf zzeos;
    private final zztz zzesy;
    private final zzbgy zzeur;
    private final zzei zzeus;
    private final zzacv zzeut;
    private final com.google.android.gms.ads.internal.zzm zzeuu;
    private final com.google.android.gms.ads.internal.zzb zzeuv;
    private final float zzeuw;
    private zzdot zzeux;
    private zzdoy zzeuy;
    private boolean zzeuz;
    private boolean zzeva;
    private zzbfh zzevb;
    private com.google.android.gms.ads.internal.overlay.zze zzevc;
    private IObjectWrapper zzevd;
    private zzbgx zzeve;
    private boolean zzevf;
    private boolean zzevg;
    private boolean zzevh;
    private int zzevi;
    private boolean zzevj;
    private boolean zzevk;
    private zzbgc zzevl;
    private boolean zzevm;
    private boolean zzevn;
    private zzaeg zzevo;
    private zzaef zzevp;
    private zzsi zzevq;
    private int zzevr;
    private int zzevs;
    private zzacf zzevt;
    private zzacf zzevu;
    private zzace zzevv;
    private WeakReference<View.OnClickListener> zzevw;
    private int zzevx;
    private int zzevy;
    private com.google.android.gms.ads.internal.overlay.zze zzevz;
    private boolean zzewa;
    private com.google.android.gms.ads.internal.util.zzbz zzewb;
    private Map<String, zzbek> zzewc;
    private final DisplayMetrics zzxe;

    public static zzbfy zzc(Context context, zzbgx zzbgxVar, String str, boolean z, boolean z2, zzei zzeiVar, zzacv zzacvVar, zzbar zzbarVar, zzach zzachVar, com.google.android.gms.ads.internal.zzm zzmVar, com.google.android.gms.ads.internal.zzb zzbVar, zztz zztzVar, zzdot zzdotVar, zzdoy zzdoyVar) {
        return new zzbfy(new zzbgy(context), zzbgxVar, str, z, z2, zzeiVar, zzacvVar, zzbarVar, zzachVar, zzmVar, zzbVar, zztzVar, zzdotVar, zzdoyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbgr
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final zzbch zzabu() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final boolean zzaeu() {
        return false;
    }

    private zzbfy(zzbgy zzbgyVar, zzbgx zzbgxVar, String str, boolean z, boolean z2, zzei zzeiVar, zzacv zzacvVar, zzbar zzbarVar, zzach zzachVar, com.google.android.gms.ads.internal.zzm zzmVar, com.google.android.gms.ads.internal.zzb zzbVar, zztz zztzVar, zzdot zzdotVar, zzdoy zzdoyVar) {
        super(zzbgyVar);
        zzdoy zzdoyVar2;
        this.zzeuz = false;
        this.zzeva = false;
        this.zzevj = true;
        this.zzevk = false;
        this.zzdvx = "";
        this.zzdrs = -1;
        this.zzdrr = -1;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.zzeur = zzbgyVar;
        this.zzeve = zzbgxVar;
        this.zzadd = str;
        this.zzevg = z;
        this.zzevi = -1;
        this.zzeus = zzeiVar;
        this.zzeut = zzacvVar;
        this.zzbpx = zzbarVar;
        this.zzeuu = zzmVar;
        this.zzeuv = zzbVar;
        this.zzbro = (WindowManager) getContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzr.zzkv();
        DisplayMetrics zza = com.google.android.gms.ads.internal.util.zzj.zza(this.zzbro);
        this.zzxe = zza;
        this.zzeuw = zza.density;
        this.zzesy = zztzVar;
        this.zzeux = zzdotVar;
        this.zzeuy = zzdoyVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Unable to enable Javascript.", e2);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(com.google.android.gms.ads.internal.zzr.zzkv().zzq(zzbgyVar, zzbarVar.zzbrz));
        com.google.android.gms.ads.internal.zzr.zzkx().zza(getContext(), settings);
        setDownloadListener(this);
        zzaez();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(new zzbgg(this, new zzbgh(this) { // from class: com.google.android.gms.internal.ads.zzbgf
                private final zzbfi zzewn;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzewn = this;
                }

                @Override // com.google.android.gms.internal.ads.zzbgh
                public final void zzj(Uri uri) {
                    zzbgu zzaef = this.zzewn.zzaef();
                    if (zzaef == null) {
                        com.google.android.gms.ads.internal.util.zzd.zzex("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
                    } else {
                        zzaef.zzj(uri);
                    }
                }
            }), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzewb = new com.google.android.gms.ads.internal.util.zzbz(this.zzeur.zzabx(), this, this, null);
        zzafd();
        zzace zzaceVar = new zzace(new zzach(true, "make_wv", this.zzadd));
        this.zzevv = zzaceVar;
        zzaceVar.zzsr().zzc(zzachVar);
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue() && (zzdoyVar2 = this.zzeuy) != null && zzdoyVar2.zzbwe != null) {
            this.zzevv.zzsr().zzg("gqi", this.zzeuy.zzbwe);
        }
        zzacf zzb = zzaby.zzb(this.zzevv.zzsr());
        this.zzeos = zzb;
        this.zzevv.zza("native:view_create", zzb);
        this.zzevu = null;
        this.zzevt = null;
        com.google.android.gms.ads.internal.zzr.zzkx().zzbh(zzbgyVar);
        com.google.android.gms.ads.internal.zzr.zzkz().zzyi();
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfi
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbfh) {
            this.zzevb = (zzbfh) webViewClient;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs
    public final com.google.android.gms.ads.internal.zzb zzaby() {
        return this.zzeuv;
    }

    private final boolean zzaew() {
        int i;
        int i2;
        boolean z = false;
        if (this.zzevb.zzadm() || this.zzevb.zzadn()) {
            zzww.zzqw();
            DisplayMetrics displayMetrics = this.zzxe;
            int zzb = zzbae.zzb(displayMetrics, displayMetrics.widthPixels);
            zzww.zzqw();
            DisplayMetrics displayMetrics2 = this.zzxe;
            int zzb2 = zzbae.zzb(displayMetrics2, displayMetrics2.heightPixels);
            Activity zzabx = this.zzeur.zzabx();
            if (zzabx == null || zzabx.getWindow() == null) {
                i = zzb;
                i2 = zzb2;
            } else {
                com.google.android.gms.ads.internal.zzr.zzkv();
                int[] zzf = com.google.android.gms.ads.internal.util.zzj.zzf(zzabx);
                zzww.zzqw();
                int zzb3 = zzbae.zzb(this.zzxe, zzf[0]);
                zzww.zzqw();
                i2 = zzbae.zzb(this.zzxe, zzf[1]);
                i = zzb3;
            }
            if (this.zzdrr == zzb && this.zzdrs == zzb2 && this.maxWidth == i && this.maxHeight == i2) {
                return false;
            }
            z = (this.zzdrr == zzb && this.zzdrs == zzb2) ? true : true;
            this.zzdrr = zzb;
            this.zzdrs = zzb2;
            this.maxWidth = i;
            this.maxHeight = i2;
            new zzarj(this).zza(zzb, zzb2, i, i2, this.zzxe.density, this.zzbro.getDefaultDisplay().getRotation());
            return z;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(String str, Map<String, ?> map) {
        try {
            zza(str, com.google.android.gms.ads.internal.zzr.zzkv().zzj(map));
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Could not convert parameters to JSON.");
        }
    }

    @Override // android.webkit.WebView
    public final synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (isDestroyed()) {
            com.google.android.gms.ads.internal.util.zzd.zzfb("#004 The webview is destroyed. Ignoring action.");
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    private final synchronized void zzfl(String str) {
        if (!isDestroyed()) {
            loadUrl(str);
        } else {
            com.google.android.gms.ads.internal.util.zzd.zzez("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfi
    public final synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            try {
                super.loadUrl(str);
                return;
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e2) {
                com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "AdWebViewImpl.loadUrl");
                com.google.android.gms.ads.internal.util.zzd.zzd("Could not call loadUrl. ", e2);
                return;
            }
        }
        com.google.android.gms.ads.internal.util.zzd.zzez("#004 The webview is destroyed. Ignoring action.");
    }

    private final synchronized void zzfm(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e2) {
            com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "AdWebViewImpl.loadUrlUnsafe");
            com.google.android.gms.ads.internal.util.zzd.zzd("Could not call loadUrl. ", e2);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfi
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            com.google.android.gms.ads.internal.util.zzd.zzez("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfi
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            com.google.android.gms.ads.internal.util.zzd.zzez("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zzb(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, zzbgn.zzf(str2, zzbgn.zzaff()), "text/html", "UTF-8", str3);
        } else {
            com.google.android.gms.ads.internal.util.zzd.zzez("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final synchronized void zza(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, null);
        } else {
            com.google.android.gms.ads.internal.util.zzd.zzez("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final void zzfn(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzyg() == null) {
                zzaex();
            }
            if (zzyg().booleanValue()) {
                zza(str, (ValueCallback<String>) null);
                return;
            }
            String valueOf = String.valueOf(str);
            zzfl(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        String valueOf2 = String.valueOf(str);
        zzfl(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zzcv(String str) {
        zzfn(str);
    }

    private final synchronized void zzaex() {
        Boolean zzyg = com.google.android.gms.ads.internal.zzr.zzkz().zzyg();
        this.zzeej = zzyg;
        if (zzyg == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zza((Boolean) true);
            } catch (IllegalStateException unused) {
                zza((Boolean) false);
            }
        }
    }

    private final void zza(Boolean bool) {
        synchronized (this) {
            this.zzeej = bool;
        }
        com.google.android.gms.ads.internal.zzr.zzkz().zza(bool);
    }

    private final synchronized Boolean zzyg() {
        return this.zzeej;
    }

    @Override // com.google.android.gms.internal.ads.zzalf
    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        zzfn(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        com.google.android.gms.ads.internal.util.zzd.zzdz(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzfn(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzady() {
        zzaey();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbpx.zzbrz);
        zza("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzec(int i) {
        if (i == 0) {
            zzaby.zza(this.zzevv.zzsr(), this.zzeos, "aebb2");
        }
        zzaey();
        if (this.zzevv.zzsr() != null) {
            this.zzevv.zzsr().zzg("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzbpx.zzbrz);
        zza("onhide", hashMap);
    }

    private final void zzaey() {
        zzaby.zza(this.zzevv.zzsr(), this.zzeos, "aeh2");
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzwm() {
        if (this.zzevt == null) {
            zzaby.zza(this.zzevv.zzsr(), this.zzeos, "aes2");
            zzacf zzb = zzaby.zzb(this.zzevv.zzsr());
            this.zzevt = zzb;
            this.zzevv.zza("native:view_show", zzb);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbpx.zzbrz);
        zza("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzadz() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzr.zzla().zzrh()));
        hashMap.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzr.zzla().zzrg()));
        hashMap.put("device_volume", String.valueOf(com.google.android.gms.ads.internal.util.zzae.zzbj(getContext())));
        zza("volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zza("onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized com.google.android.gms.ads.internal.overlay.zze zzaeb() {
        return this.zzevc;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized IObjectWrapper zzaej() {
        return this.zzevd;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized com.google.android.gms.ads.internal.overlay.zze zzaec() {
        return this.zzevz;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbgq
    public final synchronized zzbgx zzaed() {
        return this.zzeve;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized String zzaee() {
        return this.zzadd;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final WebViewClient zzaeg() {
        return this.zzevb;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized boolean zzaeh() {
        return this.zzduh;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbgp
    public final zzei zzaei() {
        return this.zzeus;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs, com.google.android.gms.internal.ads.zzbgs
    public final zzbar zzacc() {
        return this.zzbpx;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized boolean zzaek() {
        return this.zzevg;
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            com.google.android.gms.ads.internal.zzr.zzkv();
            com.google.android.gms.ads.internal.util.zzj.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            com.google.android.gms.ads.internal.util.zzd.zzdz(sb.toString());
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzevb.zzadn() && !this.zzevb.zzado()) {
            synchronized (this) {
                if (this.zzevo != null) {
                    this.zzevo.zzc(motionEvent);
                }
            }
        } else {
            zzei zzeiVar = this.zzeus;
            if (zzeiVar != null) {
                zzeiVar.zza(motionEvent);
            }
            zzacv zzacvVar = this.zzeut;
            if (zzacvVar != null) {
                zzacvVar.zza(motionEvent);
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:206:0x0141 A[Catch: all -> 0x01fe, TryCatch #0 {, blocks: (B:123:0x0001, B:125:0x0008, B:128:0x000d, B:130:0x0013, B:132:0x0017, B:135:0x0021, B:137:0x0029, B:140:0x002e, B:142:0x0036, B:144:0x0048, B:147:0x004d, B:149:0x0054, B:153:0x005e, B:156:0x0063, B:159:0x0076, B:163:0x0084, B:162:0x0080, B:166:0x0091, B:168:0x0099, B:170:0x00ab, B:173:0x00b2, B:175:0x00ce, B:177:0x00d9, B:176:0x00d5, B:180:0x00de, B:183:0x00e3, B:185:0x00eb, B:188:0x00f8, B:197:0x011e, B:199:0x0125, B:204:0x012f, B:206:0x0141, B:208:0x0151, B:216:0x016b, B:218:0x01c0, B:219:0x01c4, B:221:0x01cb, B:224:0x01d6, B:226:0x01dc, B:227:0x01df, B:229:0x01e3, B:230:0x01ec, B:233:0x01f9), top: B:239:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x016b A[Catch: all -> 0x01fe, TryCatch #0 {, blocks: (B:123:0x0001, B:125:0x0008, B:128:0x000d, B:130:0x0013, B:132:0x0017, B:135:0x0021, B:137:0x0029, B:140:0x002e, B:142:0x0036, B:144:0x0048, B:147:0x004d, B:149:0x0054, B:153:0x005e, B:156:0x0063, B:159:0x0076, B:163:0x0084, B:162:0x0080, B:166:0x0091, B:168:0x0099, B:170:0x00ab, B:173:0x00b2, B:175:0x00ce, B:177:0x00d9, B:176:0x00d5, B:180:0x00de, B:183:0x00e3, B:185:0x00eb, B:188:0x00f8, B:197:0x011e, B:199:0x0125, B:204:0x012f, B:206:0x0141, B:208:0x0151, B:216:0x016b, B:218:0x01c0, B:219:0x01c4, B:221:0x01cb, B:224:0x01d6, B:226:0x01dc, B:227:0x01df, B:229:0x01e3, B:230:0x01ec, B:233:0x01f9), top: B:239:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x01d6 A[Catch: all -> 0x01fe, TRY_ENTER, TryCatch #0 {, blocks: (B:123:0x0001, B:125:0x0008, B:128:0x000d, B:130:0x0013, B:132:0x0017, B:135:0x0021, B:137:0x0029, B:140:0x002e, B:142:0x0036, B:144:0x0048, B:147:0x004d, B:149:0x0054, B:153:0x005e, B:156:0x0063, B:159:0x0076, B:163:0x0084, B:162:0x0080, B:166:0x0091, B:168:0x0099, B:170:0x00ab, B:173:0x00b2, B:175:0x00ce, B:177:0x00d9, B:176:0x00d5, B:180:0x00de, B:183:0x00e3, B:185:0x00eb, B:188:0x00f8, B:197:0x011e, B:199:0x0125, B:204:0x012f, B:206:0x0141, B:208:0x0151, B:216:0x016b, B:218:0x01c0, B:219:0x01c4, B:221:0x01cb, B:224:0x01d6, B:226:0x01dc, B:227:0x01df, B:229:0x01e3, B:230:0x01ec, B:233:0x01f9), top: B:239:0x0001 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final synchronized void onMeasure(int i, int i2) {
        int i3;
        boolean z;
        int size;
        if (isDestroyed()) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (!isInEditMode() && !this.zzevg && !this.zzeve.zzafk()) {
            if (this.zzeve.zzafm()) {
                super.onMeasure(i, i2);
                return;
            } else if (this.zzeve.zzafl()) {
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcub)).booleanValue()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zzbgc zzabv = zzabv();
                float aspectRatio = zzabv != null ? zzabv.getAspectRatio() : 0.0f;
                if (aspectRatio == 0.0f) {
                    super.onMeasure(i, i2);
                    return;
                }
                int size2 = View.MeasureSpec.getSize(i);
                int size3 = View.MeasureSpec.getSize(i2);
                int i4 = (int) (size3 * aspectRatio);
                int i5 = (int) (size2 / aspectRatio);
                if (size3 == 0 && i5 != 0) {
                    i4 = (int) (i5 * aspectRatio);
                    size3 = i5;
                } else if (size2 == 0 && i4 != 0) {
                    i5 = (int) (i4 / aspectRatio);
                    size2 = i4;
                }
                setMeasuredDimension(Math.min(i4, size2), Math.min(i5, size3));
                return;
            } else if (this.zzeve.isFluid()) {
                if (!((Boolean) zzww.zzra().zzd(zzabq.zzcue)).booleanValue() && PlatformVersion.isAtLeastJellyBeanMR1()) {
                    zza("/contentHeight", new zzbga(this));
                    zzfn("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                    float f = this.zzxe.density;
                    int size4 = View.MeasureSpec.getSize(i);
                    if (this.zzevs == -1) {
                        size = View.MeasureSpec.getSize(i2);
                    } else {
                        size = (int) (this.zzevs * f);
                    }
                    setMeasuredDimension(size4, size);
                    return;
                }
                super.onMeasure(i, i2);
                return;
            } else if (this.zzeve.zzafj()) {
                setMeasuredDimension(this.zzxe.widthPixels, this.zzxe.heightPixels);
                return;
            } else {
                int mode = View.MeasureSpec.getMode(i);
                int size5 = View.MeasureSpec.getSize(i);
                int mode2 = View.MeasureSpec.getMode(i2);
                int size6 = View.MeasureSpec.getSize(i2);
                int i6 = Integer.MAX_VALUE;
                if (mode != Integer.MIN_VALUE && mode != 1073741824) {
                    i3 = Integer.MAX_VALUE;
                    if (mode2 != Integer.MIN_VALUE || mode2 == 1073741824) {
                        i6 = size6;
                    }
                    if (this.zzeve.widthPixels <= i3 && this.zzeve.heightPixels <= i6) {
                        z = false;
                        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxb)).booleanValue()) {
                            boolean z2 = ((float) this.zzeve.widthPixels) / this.zzeuw <= ((float) i3) / this.zzeuw && ((float) this.zzeve.heightPixels) / this.zzeuw <= ((float) i6) / this.zzeuw;
                            if (z) {
                                z = z2;
                            }
                        }
                        if (!z) {
                            StringBuilder sb = new StringBuilder(103);
                            sb.append("Not enough space to show ad. Needs ");
                            sb.append((int) (this.zzeve.widthPixels / this.zzeuw));
                            sb.append("x");
                            sb.append((int) (this.zzeve.heightPixels / this.zzeuw));
                            sb.append(" dp, but only has ");
                            sb.append((int) (size5 / this.zzeuw));
                            sb.append("x");
                            sb.append((int) (size6 / this.zzeuw));
                            sb.append(" dp.");
                            com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
                            if (getVisibility() != 8) {
                                setVisibility(4);
                            }
                            setMeasuredDimension(0, 0);
                            if (!this.zzeuz) {
                                this.zzesy.zza(zzub.zza.zzb.BANNER_SIZE_INVALID);
                                this.zzeuz = true;
                                return;
                            }
                        } else {
                            if (getVisibility() != 8) {
                                setVisibility(0);
                            }
                            if (!this.zzeva) {
                                this.zzesy.zza(zzub.zza.zzb.BANNER_SIZE_VALID);
                                this.zzeva = true;
                            }
                            setMeasuredDimension(this.zzeve.widthPixels, this.zzeve.heightPixels);
                        }
                        return;
                    }
                    z = true;
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcxb)).booleanValue()) {
                    }
                    if (!z) {
                    }
                    return;
                }
                i3 = size5;
                if (mode2 != Integer.MIN_VALUE) {
                }
                i6 = size6;
                if (this.zzeve.widthPixels <= i3) {
                    z = false;
                    if (((Boolean) zzww.zzra().zzd(zzabq.zzcxb)).booleanValue()) {
                    }
                    if (!z) {
                    }
                    return;
                }
                z = true;
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcxb)).booleanValue()) {
                }
                if (!z) {
                }
                return;
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zzaew = zzaew();
        com.google.android.gms.ads.internal.overlay.zze zzaeb = zzaeb();
        if (zzaeb == null || !zzaew) {
            return;
        }
        zzaeb.zzwl();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zza(com.google.android.gms.ads.internal.overlay.zze zzeVar) {
        this.zzevc = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zzar(IObjectWrapper iObjectWrapper) {
        this.zzevd = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zzb(com.google.android.gms.ads.internal.overlay.zze zzeVar) {
        this.zzevz = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zza(zzbgx zzbgxVar) {
        this.zzeve = zzbgxVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zzbe(boolean z) {
        boolean z2 = z != this.zzevg;
        this.zzevg = z;
        zzaez();
        if (z2) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcoe)).booleanValue() || !this.zzeve.zzafj()) {
                new zzarj(this).zzdv(z ? "expanded" : "default");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzaeo() {
        this.zzewb.zzaal();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzewb.onAttachedToWindow();
        }
        boolean z = this.zzevm;
        if (this.zzevb != null && this.zzevb.zzadn()) {
            if (!this.zzevn) {
                this.zzevb.zzadp();
                this.zzevb.zzadq();
                this.zzevn = true;
            }
            zzaew();
            z = true;
        }
        zzbh(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.zzewb.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzevn && this.zzevb != null && this.zzevb.zzadn() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzevb.zzadp();
                this.zzevb.zzadq();
                this.zzevn = false;
            }
        }
        zzbh(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzby(Context context) {
        this.zzeur.setBaseContext(context);
        this.zzewb.zzj(this.zzeur.zzabx());
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zzap(boolean z) {
        if (this.zzevc != null) {
            this.zzevc.zza(this.zzevb.zzadm(), z);
        } else {
            this.zzduh = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void setRequestedOrientation(int i) {
        this.zzevi = i;
        if (this.zzevc != null) {
            this.zzevc.setRequestedOrientation(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs, com.google.android.gms.internal.ads.zzbgk
    public final Activity zzabx() {
        return this.zzeur.zzabx();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final Context zzaea() {
        return this.zzeur.zzaea();
    }

    private final synchronized void zzaez() {
        if (!this.zzevg && !this.zzeve.zzafj()) {
            if (Build.VERSION.SDK_INT < 18) {
                com.google.android.gms.ads.internal.util.zzd.zzdz("Disabling hardware acceleration on an AdView.");
                zzafa();
                return;
            }
            com.google.android.gms.ads.internal.util.zzd.zzdz("Enabling hardware acceleration on an AdView.");
            zzafb();
            return;
        }
        com.google.android.gms.ads.internal.util.zzd.zzdz("Enabling hardware acceleration on an overlay.");
        zzafb();
    }

    private final synchronized void zzafa() {
        if (!this.zzevh) {
            setLayerType(1, null);
        }
        this.zzevh = true;
    }

    private final synchronized void zzafb() {
        if (this.zzevh) {
            setLayerType(0, null);
        }
        this.zzevh = false;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfi
    public final synchronized void destroy() {
        zzafd();
        this.zzewb.zzaam();
        if (this.zzevc != null) {
            this.zzevc.close();
            this.zzevc.onDestroy();
            this.zzevc = null;
        }
        this.zzevd = null;
        this.zzevb.reset();
        if (this.zzevf) {
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzlr();
        zzbeh.zzc(this);
        zzafc();
        this.zzevf = true;
        com.google.android.gms.ads.internal.util.zzd.zzed("Initiating WebView self destruct sequence in 3...");
        com.google.android.gms.ads.internal.util.zzd.zzed("Loading blank page in WebView, 2...");
        zzfm("about:blank");
    }

    protected final void finalize() {
        try {
            synchronized (this) {
                if (!this.zzevf) {
                    this.zzevb.reset();
                    com.google.android.gms.ads.internal.zzr.zzlr();
                    zzbeh.zzc(this);
                    zzafc();
                    zzyj();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zzael() {
        com.google.android.gms.ads.internal.util.zzd.zzed("Destroying WebView!");
        zzyj();
        com.google.android.gms.ads.internal.util.zzj.zzegq.post(new zzbfz(this));
    }

    private final synchronized void zzyj() {
        if (!this.zzewa) {
            this.zzewa = true;
            com.google.android.gms.ads.internal.zzr.zzkz().zzyj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized boolean isDestroyed() {
        return this.zzevf;
    }

    @Override // android.webkit.WebView, android.view.View
    protected final void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzaep() {
        if (this.zzevu == null) {
            zzacf zzb = zzaby.zzb(this.zzevv.zzsr());
            this.zzevu = zzb;
            this.zzevv.zza("native:view_load", zzb);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfi
    public final void onPause() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Could not pause webview.", e2);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbfi
    public final void onResume() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Could not resume webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzaes() {
        com.google.android.gms.ads.internal.util.zzd.zzed("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzbb(boolean z) {
        this.zzevb.zzbb(z);
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Could not stop loading webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zzbf(boolean z) {
        this.zzevj = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized boolean zzaem() {
        return this.zzevj;
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final synchronized void zzkr() {
        this.zzevk = true;
        if (this.zzeuu != null) {
            this.zzeuu.zzkr();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzm
    public final synchronized void zzks() {
        this.zzevk = false;
        if (this.zzeuu != null) {
            this.zzeuu.zzks();
        }
    }

    private final synchronized void zzafc() {
        if (this.zzewc != null) {
            for (zzbek zzbekVar : this.zzewc.values()) {
                zzbekVar.release();
            }
        }
        this.zzewc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs
    public final synchronized void zza(String str, zzbek zzbekVar) {
        if (this.zzewc == null) {
            this.zzewc = new HashMap();
        }
        this.zzewc.put(str, zzbekVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final synchronized zzbek zzfe(String str) {
        if (this.zzewc == null) {
            return null;
        }
        return this.zzewc.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final synchronized String getRequestId() {
        return this.zzdvx;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final synchronized String zzabz() {
        if (this.zzeuy != null) {
            return this.zzeuy.zzbwe;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final synchronized void zzdv(int i) {
        this.zzbwf = i;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final synchronized int zzaca() {
        return this.zzbwf;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final synchronized void zzacf() {
        if (this.zzevp != null) {
            this.zzevp.zzto();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zza(zzaef zzaefVar) {
        this.zzevp = zzaefVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zza(zzsi zzsiVar) {
        this.zzevq = zzsiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized zzsi zzaet() {
        return this.zzevq;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final zzacf zzabw() {
        return this.zzeos;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs
    public final zzace zzacb() {
        return this.zzevv;
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbfi
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzevw = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zza(zzaeg zzaegVar) {
        this.zzevo = zzaegVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized zzaeg zzaeq() {
        return this.zzevo;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs
    public final synchronized zzbgc zzabv() {
        return this.zzevl;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbcs
    public final synchronized void zza(zzbgc zzbgcVar) {
        if (this.zzevl != null) {
            com.google.android.gms.ads.internal.util.zzd.zzex("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzevl = zzbgcVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized boolean zzaen() {
        return this.zzevr > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zzbg(boolean z) {
        int i = this.zzevr + (z ? 1 : -1);
        this.zzevr = i;
        if (i <= 0 && this.zzevc != null) {
            this.zzevc.zzwo();
        }
    }

    private final void zzafd() {
        zzach zzsr;
        zzace zzaceVar = this.zzevv;
        if (zzaceVar == null || (zzsr = zzaceVar.zzsr()) == null || com.google.android.gms.ads.internal.zzr.zzkz().zzyf() == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzkz().zzyf().zza(zzsr);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzaer() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zzaz(boolean z) {
        this.zzevb.zzaz(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zzwn() {
        com.google.android.gms.ads.internal.overlay.zze zzaeb = zzaeb();
        if (zzaeb != null) {
            zzaeb.zzwn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final int zzacd() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final int zzace() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zzdw(int i) {
        this.zzevx = i;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final void zzdx(int i) {
        this.zzevy = i;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final int zzacg() {
        return this.zzevx;
    }

    @Override // com.google.android.gms.internal.ads.zzbcs
    public final int zzach() {
        return this.zzevy;
    }

    @Override // com.google.android.gms.internal.ads.zzbgo
    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzbVar) {
        this.zzevb.zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgo
    public final void zzb(boolean z, int i) {
        this.zzevb.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgo
    public final void zza(boolean z, int i, String str) {
        this.zzevb.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgo
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzevb.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbgo
    public final void zza(com.google.android.gms.ads.internal.util.zzbg zzbgVar, zzcsh zzcshVar, zzcmb zzcmbVar, zzdtw zzdtwVar, String str, String str2, int i) {
        this.zzevb.zza(zzbgVar, zzcshVar, zzcmbVar, zzdtwVar, str, str2, i);
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zza(zzqx zzqxVar) {
        synchronized (this) {
            this.zzevm = zzqxVar.zzbrt;
        }
        zzbh(zzqxVar.zzbrt);
    }

    private final void zzbh(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(String str, zzaig<? super zzbfi> zzaigVar) {
        zzbfh zzbfhVar = this.zzevb;
        if (zzbfhVar != null) {
            zzbfhVar.zza(str, zzaigVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zzb(String str, zzaig<? super zzbfi> zzaigVar) {
        zzbfh zzbfhVar = this.zzevb;
        if (zzbfhVar != null) {
            zzbfhVar.zzb(str, zzaigVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(String str, Predicate<zzaig<? super zzbfi>> predicate) {
        zzbfh zzbfhVar = this.zzevb;
        if (zzbfhVar != null) {
            zzbfhVar.zza(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final boolean zzc(boolean z, int i) {
        destroy();
        this.zzesy.zza(new zzty(z, i) { // from class: com.google.android.gms.internal.ads.zzbfx
            private final int zzehh;
            private final boolean zzeuq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzeuq = z;
                this.zzehh = i;
            }

            @Override // com.google.android.gms.internal.ads.zzty
            public final void zza(zzuh.zzi.zza zzaVar) {
                zzbfy.zza(this.zzeuq, this.zzehh, zzaVar);
            }
        });
        this.zzesy.zza(zzub.zza.zzb.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbex
    public final zzdot zzadk() {
        return this.zzeux;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi, com.google.android.gms.internal.ads.zzbgd
    public final zzdoy zzaev() {
        return this.zzeuy;
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void onAdClicked() {
        zzbfh zzbfhVar = this.zzevb;
        if (zzbfhVar != null) {
            zzbfhVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void zza(zzdot zzdotVar, zzdoy zzdoyVar) {
        this.zzeux = zzdotVar;
        this.zzeuy = zzdoyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final synchronized void zzac(boolean z) {
        if (z) {
            setBackgroundColor(0);
        }
        if (this.zzevc != null) {
            this.zzevc.zzac(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final /* synthetic */ zzbgu zzaef() {
        return this.zzevb;
    }

    public static final /* synthetic */ void zza(boolean z, int i, zzuh.zzi.zza zzaVar) {
        zzuh.zzae.zza zzqf = zzuh.zzae.zzqf();
        if (zzqf.zzqe() != z) {
            zzqf.zzy(z);
        }
        zzaVar.zza((zzuh.zzae) ((zzena) zzqf.zzcy(i).zzbjv()));
    }
}
