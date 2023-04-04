package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.h.w;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzub;
import com.just.agentweb.AgentWebPermissions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class zzbfh extends WebViewClient implements zzbgu {
    private final Object lock;
    private boolean zzbsa;
    private zzve zzchr;
    private zzahn zzdic;
    private zzahp zzdie;
    private com.google.android.gms.ads.internal.zza zzdjd;
    private zzaqz zzdjh;
    private com.google.android.gms.ads.internal.overlay.zzp zzduf;
    private com.google.android.gms.ads.internal.overlay.zzx zzduj;
    private boolean zzdyj;
    protected zzbfi zzesx;
    private final zztz zzesy;
    private final HashMap<String, List<zzaig<? super zzbfi>>> zzesz;
    private zzbgt zzeta;
    private zzbgw zzetb;
    private zzbgv zzetc;
    private boolean zzetd;
    private boolean zzete;
    private boolean zzetf;
    private boolean zzetg;
    private final zzarg zzeth;
    protected zzaxo zzeti;
    private boolean zzetj;
    private boolean zzetk;
    private int zzetl;
    private final HashSet<String> zzetm;
    private View.OnAttachStateChangeListener zzetn;

    public zzbfh(zzbfi zzbfiVar, zztz zztzVar, boolean z) {
        this(zzbfiVar, zztzVar, z, new zzarg(zzbfiVar, zzbfiVar.zzaea(), new zzabb(zzbfiVar.getContext())), null);
    }

    private zzbfh(zzbfi zzbfiVar, zztz zztzVar, boolean z, zzarg zzargVar, zzaqz zzaqzVar) {
        this.zzesz = new HashMap<>();
        this.lock = new Object();
        this.zzetd = false;
        this.zzesy = zztzVar;
        this.zzesx = zzbfiVar;
        this.zzbsa = z;
        this.zzeth = zzargVar;
        this.zzdjh = null;
        this.zzetm = new HashSet<>(Arrays.asList(((String) zzww.zzra().zzd(zzabq.zzcxn)).split(",")));
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zza(int i, int i2, boolean z) {
        this.zzeth.zzl(i, i2);
        zzaqz zzaqzVar = this.zzdjh;
        if (zzaqzVar != null) {
            zzaqzVar.zza(i, i2, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zza(zzve zzveVar, zzahn zzahnVar, com.google.android.gms.ads.internal.overlay.zzp zzpVar, zzahp zzahpVar, com.google.android.gms.ads.internal.overlay.zzx zzxVar, boolean z, zzaii zzaiiVar, com.google.android.gms.ads.internal.zza zzaVar, zzari zzariVar, zzaxo zzaxoVar, zzcsh zzcshVar, zzdup zzdupVar, zzcmb zzcmbVar, zzdtw zzdtwVar) {
        com.google.android.gms.ads.internal.zza zzaVar2 = zzaVar == null ? new com.google.android.gms.ads.internal.zza(this.zzesx.getContext(), zzaxoVar, null) : zzaVar;
        this.zzdjh = new zzaqz(this.zzesx, zzariVar);
        this.zzeti = zzaxoVar;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpy)).booleanValue()) {
            zza("/adMetadata", new zzahk(zzahnVar));
        }
        zza("/appEvent", new zzahm(zzahpVar));
        zza("/backButton", zzahr.zzdiq);
        zza("/refresh", zzahr.zzdir);
        zza("/canOpenApp", zzahr.zzdih);
        zza("/canOpenURLs", zzahr.zzdig);
        zza("/canOpenIntents", zzahr.zzdii);
        zza("/close", zzahr.zzdik);
        zza("/customClose", zzahr.zzdil);
        zza("/instrument", zzahr.zzdiu);
        zza("/delayPageLoaded", zzahr.zzdiw);
        zza("/delayPageClosed", zzahr.zzdix);
        zza("/getLocationInfo", zzahr.zzdiy);
        zza("/log", zzahr.zzdin);
        zza("/mraid", new zzaip(zzaVar2, this.zzdjh, zzariVar));
        zza("/mraidLoaded", this.zzeth);
        zza("/open", new zzaio(zzaVar2, this.zzdjh, zzcshVar, zzcmbVar, zzdtwVar));
        zza("/precache", new zzbep());
        zza("/touch", zzahr.zzdip);
        zza("/video", zzahr.zzdis);
        zza("/videoMeta", zzahr.zzdit);
        if (zzcshVar != null && zzdupVar != null) {
            zza("/click", zzdpt.zza(zzcshVar, zzdupVar));
            zza("/httpTrack", zzdpt.zzb(zzcshVar, zzdupVar));
        } else {
            zza("/click", zzahr.zzdij);
            zza("/httpTrack", zzahr.zzdim);
        }
        if (com.google.android.gms.ads.internal.zzr.zzlt().zzaa(this.zzesx.getContext())) {
            zza("/logScionEvent", new zzaim(this.zzesx.getContext()));
        }
        if (zzaiiVar != null) {
            zza("/setInterstitialProperties", new zzaij(zzaiiVar));
        }
        this.zzchr = zzveVar;
        this.zzduf = zzpVar;
        this.zzdic = zzahnVar;
        this.zzdie = zzahpVar;
        this.zzduj = zzxVar;
        this.zzdjd = zzaVar2;
        this.zzetd = z;
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public void onAdClicked() {
        zzve zzveVar = this.zzchr;
        if (zzveVar != null) {
            zzveVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final com.google.android.gms.ads.internal.zza zzadl() {
        return this.zzdjd;
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final boolean zzadm() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbsa;
        }
        return z;
    }

    public final boolean zzadn() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzete;
        }
        return z;
    }

    public final boolean zzado() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzetf;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzadp() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzadq() {
        synchronized (this.lock) {
        }
        return null;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.lock) {
            if (this.zzesx.isDestroyed()) {
                com.google.android.gms.ads.internal.util.zzd.zzed("Blank page loaded, 1...");
                this.zzesx.zzael();
                return;
            }
            this.zzetj = true;
            zzbgw zzbgwVar = this.zzetb;
            if (zzbgwVar != null) {
                zzbgwVar.zzuv();
                this.zzetb = null;
            }
            zzadw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view, zzaxo zzaxoVar, int i) {
        if (!zzaxoVar.zzxh() || i <= 0) {
            return;
        }
        zzaxoVar.zzl(view);
        if (zzaxoVar.zzxh()) {
            com.google.android.gms.ads.internal.util.zzj.zzegq.postDelayed(new zzbfm(this, view, zzaxoVar, i), 100L);
        }
    }

    private final void zzadr() {
        if (this.zzetn == null) {
            return;
        }
        this.zzesx.getView().removeOnAttachStateChangeListener(this.zzetn);
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zzads() {
        zzaxo zzaxoVar = this.zzeti;
        if (zzaxoVar != null) {
            WebView webView = this.zzesx.getWebView();
            if (w.D(webView)) {
                zza(webView, zzaxoVar, 10);
                return;
            }
            zzadr();
            this.zzetn = new zzbfl(this, zzaxoVar);
            this.zzesx.getView().addOnAttachStateChangeListener(this.zzetn);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zzadt() {
        synchronized (this.lock) {
            this.zzetg = true;
        }
        this.zzetl++;
        zzadw();
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zzadu() {
        this.zzetl--;
        zzadw();
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zzadv() {
        zztz zztzVar = this.zzesy;
        if (zztzVar != null) {
            zztzVar.zza(zzub.zza.zzb.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzetk = true;
        zzadw();
        this.zzesx.destroy();
    }

    private final void zzadw() {
        if (this.zzeta != null && ((this.zzetj && this.zzetl <= 0) || this.zzetk)) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue() && this.zzesx.zzacb() != null) {
                zzaby.zza(this.zzesx.zzacb().zzsr(), this.zzesx.zzabw(), "awfllc");
            }
            this.zzeta.zzam(true ^ this.zzetk);
            this.zzeta = null;
        }
        this.zzesx.zzaep();
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzbVar) {
        boolean zzaek = this.zzesx.zzaek();
        zza(new AdOverlayInfoParcel(zzbVar, (!zzaek || this.zzesx.zzaed().zzafj()) ? this.zzchr : null, zzaek ? null : this.zzduf, this.zzduj, this.zzesx.zzacc(), this.zzesx));
    }

    public final void zza(com.google.android.gms.ads.internal.util.zzbg zzbgVar, zzcsh zzcshVar, zzcmb zzcmbVar, zzdtw zzdtwVar, String str, String str2, int i) {
        zzbfi zzbfiVar = this.zzesx;
        zza(new AdOverlayInfoParcel(zzbfiVar, zzbfiVar.zzacc(), zzbgVar, zzcshVar, zzcmbVar, zzdtwVar, str, str2, i));
    }

    public final void zzb(boolean z, int i) {
        zzve zzveVar = (!this.zzesx.zzaek() || this.zzesx.zzaed().zzafj()) ? this.zzchr : null;
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzduf;
        com.google.android.gms.ads.internal.overlay.zzx zzxVar = this.zzduj;
        zzbfi zzbfiVar = this.zzesx;
        zza(new AdOverlayInfoParcel(zzveVar, zzpVar, zzxVar, zzbfiVar, z, i, zzbfiVar.zzacc()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzaek = this.zzesx.zzaek();
        zzve zzveVar = (!zzaek || this.zzesx.zzaed().zzafj()) ? this.zzchr : null;
        zzbfn zzbfnVar = zzaek ? null : new zzbfn(this.zzesx, this.zzduf);
        zzahn zzahnVar = this.zzdic;
        zzahp zzahpVar = this.zzdie;
        com.google.android.gms.ads.internal.overlay.zzx zzxVar = this.zzduj;
        zzbfi zzbfiVar = this.zzesx;
        zza(new AdOverlayInfoParcel(zzveVar, zzbfnVar, zzahnVar, zzahpVar, zzxVar, zzbfiVar, z, i, str, zzbfiVar.zzacc()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzaek = this.zzesx.zzaek();
        zzve zzveVar = (!zzaek || this.zzesx.zzaed().zzafj()) ? this.zzchr : null;
        zzbfn zzbfnVar = zzaek ? null : new zzbfn(this.zzesx, this.zzduf);
        zzahn zzahnVar = this.zzdic;
        zzahp zzahpVar = this.zzdie;
        com.google.android.gms.ads.internal.overlay.zzx zzxVar = this.zzduj;
        zzbfi zzbfiVar = this.zzesx;
        zza(new AdOverlayInfoParcel(zzveVar, zzbfnVar, zzahnVar, zzahpVar, zzxVar, zzbfiVar, z, i, str, str2, zzbfiVar.zzacc()));
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzaqz zzaqzVar = this.zzdjh;
        boolean zzwa = zzaqzVar != null ? zzaqzVar.zzwa() : false;
        com.google.android.gms.ads.internal.zzr.zzku();
        com.google.android.gms.ads.internal.overlay.zzo.zza(this.zzesx.getContext(), adOverlayInfoParcel, !zzwa);
        if (this.zzeti != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzdue != null) {
                str = adOverlayInfoParcel.zzdue.url;
            }
            this.zzeti.zzdw(str);
        }
    }

    public final void zza(String str, zzaig<? super zzbfi> zzaigVar) {
        synchronized (this.lock) {
            List<zzaig<? super zzbfi>> list = this.zzesz.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList<>();
                this.zzesz.put(str, list);
            }
            list.add(zzaigVar);
        }
    }

    public final void zzb(String str, zzaig<? super zzbfi> zzaigVar) {
        synchronized (this.lock) {
            List<zzaig<? super zzbfi>> list = this.zzesz.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzaigVar);
        }
    }

    public final void zza(String str, Predicate<zzaig<? super zzbfi>> predicate) {
        synchronized (this.lock) {
            List<zzaig<? super zzbfi>> list = this.zzesz.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzaig<? super zzbfi> zzaigVar : list) {
                if (predicate.apply(zzaigVar)) {
                    arrayList.add(zzaigVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void reset() {
        zzaxo zzaxoVar = this.zzeti;
        if (zzaxoVar != null) {
            zzaxoVar.zzxj();
            this.zzeti = null;
        }
        zzadr();
        synchronized (this.lock) {
            this.zzesz.clear();
            this.zzchr = null;
            this.zzduf = null;
            this.zzeta = null;
            this.zzetb = null;
            this.zzdic = null;
            this.zzdie = null;
            this.zzetd = false;
            this.zzbsa = false;
            this.zzete = false;
            this.zzetg = false;
            this.zzduj = null;
            this.zzetc = null;
            if (this.zzdjh != null) {
                this.zzdjh.zzag(true);
                this.zzdjh = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zza(zzbgt zzbgtVar) {
        this.zzeta = zzbgtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zza(zzbgw zzbgwVar) {
        this.zzetb = zzbgwVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        com.google.android.gms.ads.internal.util.zzd.zzed(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        com.google.android.gms.ads.internal.util.zzd.zzed(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        } else {
            if (this.zzetd && webView == this.zzesx.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzve zzveVar = this.zzchr;
                    if (zzveVar != null) {
                        zzveVar.onAdClicked();
                        zzaxo zzaxoVar = this.zzeti;
                        if (zzaxoVar != null) {
                            zzaxoVar.zzdw(str);
                        }
                        this.zzchr = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzesx.getWebView().willNotDraw()) {
                try {
                    zzei zzaei = this.zzesx.zzaei();
                    if (zzaei != null && zzaei.zzb(parse)) {
                        parse = zzaei.zza(parse, this.zzesx.getContext(), this.zzesx.getView(), this.zzesx.zzabx());
                    }
                } catch (zzeh unused) {
                    String valueOf2 = String.valueOf(str);
                    com.google.android.gms.ads.internal.util.zzd.zzez(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                com.google.android.gms.ads.internal.zza zzaVar = this.zzdjd;
                if (zzaVar == null || zzaVar.zzkc()) {
                    zza(new com.google.android.gms.ads.internal.overlay.zzb("android.intent.action.VIEW", parse.toString(), null, null, null, null, null, null));
                } else {
                    this.zzdjd.zzbk(str);
                }
            } else {
                String valueOf3 = String.valueOf(str);
                com.google.android.gms.ads.internal.util.zzd.zzez(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        }
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final WebResourceResponse zzc(String str, Map<String, String> map) {
        zzth zza;
        try {
            String zzc = zzayv.zzc(str, this.zzesx.getContext(), this.zzdyj);
            if (!zzc.equals(str)) {
                return zzd(zzc, map);
            }
            zzti zzbs = zzti.zzbs(str);
            if (zzbs != null && (zza = com.google.android.gms.ads.internal.zzr.zzlb().zza(zzbs)) != null && zza.zznc()) {
                return new WebResourceResponse("", "", zza.zznd());
            }
            if (zzbai.isEnabled() && zzadi.zzdel.get().booleanValue()) {
                return zzd(str, map);
            }
            return null;
        } catch (Exception | NoClassDefFoundError e2) {
            com.google.android.gms.ads.internal.zzr.zzkz().zza(e2, "AdWebViewClient.interceptRequest");
            return zzadx();
        }
    }

    private static WebResourceResponse zzadx() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpn)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzd(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i <= 20) {
                    URLConnection openConnection = url.openConnection();
                    openConnection.setConnectTimeout(10000);
                    openConnection.setReadTimeout(10000);
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        openConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                    if (!(openConnection instanceof HttpURLConnection)) {
                        throw new IOException("Invalid protocol.");
                    }
                    httpURLConnection = (HttpURLConnection) openConnection;
                    com.google.android.gms.ads.internal.zzr.zzkv().zza(this.zzesx.getContext(), this.zzesx.zzacc().zzbrz, false, httpURLConnection, false, 60000);
                    zzbai zzbaiVar = new zzbai();
                    zzbaiVar.zza(httpURLConnection, (byte[]) null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzbaiVar.zza(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        break;
                    }
                    String headerField = httpURLConnection.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
                    if (headerField == null) {
                        throw new IOException("Missing Location header in redirect");
                    }
                    if (headerField.startsWith("tel:")) {
                        return null;
                    }
                    URL url2 = new URL(url, headerField);
                    String protocol = url2.getProtocol();
                    if (protocol == null) {
                        com.google.android.gms.ads.internal.util.zzd.zzez("Protocol is null");
                        return zzadx();
                    } else if (!protocol.equals("http") && !protocol.equals("https")) {
                        String valueOf = String.valueOf(protocol);
                        com.google.android.gms.ads.internal.util.zzd.zzez(valueOf.length() != 0 ? "Unsupported scheme: ".concat(valueOf) : new String("Unsupported scheme: "));
                        return zzadx();
                    } else {
                        String valueOf2 = String.valueOf(headerField);
                        com.google.android.gms.ads.internal.util.zzd.zzdz(valueOf2.length() != 0 ? "Redirecting to ".concat(valueOf2) : new String("Redirecting to "));
                        httpURLConnection.disconnect();
                        url = url2;
                    }
                } else {
                    TrafficStats.clearThreadStatsTag();
                    StringBuilder sb = new StringBuilder(32);
                    sb.append("Too many redirects (20)");
                    throw new IOException(sb.toString());
                }
            }
            com.google.android.gms.ads.internal.zzr.zzkv();
            return com.google.android.gms.ads.internal.util.zzj.zzd(httpURLConnection);
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    public final void zzaz(boolean z) {
        this.zzetd = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zzwi() {
        synchronized (this.lock) {
            this.zzetd = false;
            this.zzbsa = true;
            zzbat.zzeki.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbfk
                private final zzbfh zzeto;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeto = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbfh zzbfhVar = this.zzeto;
                    zzbfhVar.zzesx.zzaeo();
                    com.google.android.gms.ads.internal.overlay.zze zzaeb = zzbfhVar.zzesx.zzaeb();
                    if (zzaeb != null) {
                        zzaeb.zzwi();
                    }
                }
            });
        }
    }

    public final void zzbb(boolean z) {
        this.zzdyj = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zzk(int i, int i2) {
        zzaqz zzaqzVar = this.zzdjh;
        if (zzaqzVar != null) {
            zzaqzVar.zzk(i, i2);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zzj(Uri uri) {
        final String path = uri.getPath();
        List<zzaig<? super zzbfi>> list = this.zzesz.get(path);
        if (path != null && list != null) {
            String encodedQuery = uri.getEncodedQuery();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcxm)).booleanValue() && this.zzetm.contains(path) && encodedQuery != null) {
                if (encodedQuery.length() >= ((Integer) zzww.zzra().zzd(zzabq.zzcxo)).intValue()) {
                    String valueOf = String.valueOf(path);
                    com.google.android.gms.ads.internal.util.zzd.zzed(valueOf.length() != 0 ? "Parsing gmsg query params on BG thread: ".concat(valueOf) : new String("Parsing gmsg query params on BG thread: "));
                    zzebh.zza(com.google.android.gms.ads.internal.zzr.zzkv().zzh(uri), new zzbfo(this, list, path, uri), zzbat.zzeki);
                    return;
                }
            }
            com.google.android.gms.ads.internal.zzr.zzkv();
            zza(com.google.android.gms.ads.internal.util.zzj.zzg(uri), list, path);
            return;
        }
        String valueOf2 = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 32);
        sb.append("No GMSG handler found for GMSG: ");
        sb.append(valueOf2);
        com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzczs)).booleanValue() || com.google.android.gms.ads.internal.zzr.zzkz().zzyf() == null) {
            return;
        }
        zzbat.zzeke.execute(new Runnable(path) { // from class: com.google.android.gms.internal.ads.zzbfj
            private final String zzdmo;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdmo = path;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.ads.internal.zzr.zzkz().zzyf().zzcr(this.zzdmo.substring(1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Map<String, String> map, List<zzaig<? super zzbfi>> list, String str) {
        if (com.google.android.gms.ads.internal.util.zzd.zzyz()) {
            String valueOf = String.valueOf(str);
            com.google.android.gms.ads.internal.util.zzd.zzed(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
            }
        }
        for (zzaig<? super zzbfi> zzaigVar : list) {
            zzaigVar.zza(this.zzesx, map);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zzbc(boolean z) {
        synchronized (this.lock) {
            this.zzete = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgu
    public final void zzbd(boolean z) {
        synchronized (this.lock) {
            this.zzetf = z;
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzesx.zzc(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
