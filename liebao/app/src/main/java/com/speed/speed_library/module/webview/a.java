package com.speed.speed_library.module.webview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.google.android.gms.common.internal.ImagesContract;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.AgentWebSettingsImpl;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.JsInterfaceHolder;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebCreator;
import com.just.agentweb.WebViewClient;
import com.speed.speed_library.R;
import com.speed.speed_library.b.e;
import com.speed.speed_library.business.c;
import com.speed.speed_library.model.UserModel;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.framework.UMFrUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.d.b.i;
import kotlin.h.g;

/* compiled from: MyAgentWeb.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private AgentWeb f5813a;

    /* renamed from: b  reason: collision with root package name */
    private Context f5814b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f5815c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f5816d;

    /* renamed from: e  reason: collision with root package name */
    private long f5817e;
    private WebViewClient f;

    public final AgentWeb a() {
        return this.f5813a;
    }

    public final Context b() {
        return this.f5814b;
    }

    public final WebView c() {
        return this.f5815c;
    }

    public final Map<String, String> d() {
        return this.f5816d;
    }

    /* compiled from: MyAgentWeb.kt */
    /* renamed from: com.speed.speed_library.module.webview.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0152a extends WebViewClient {
        C0152a() {
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            i.b(webView, "view");
            i.b(webResourceRequest, "request");
            Log.d("shouldOverrideUrl = ", webResourceRequest.getUrl().toString());
            String uri = webResourceRequest.getUrl().toString();
            i.a((Object) uri, "request.url.toString()");
            if (g.b(uri, "url://", false, 2, (Object) null)) {
                String uri2 = webResourceRequest.getUrl().toString();
                i.a((Object) uri2, "request.url.toString()");
                if (g.b(uri2, "url://buyb", false, 2, (Object) null)) {
                    WebView c2 = a.this.c();
                    if (c2 == null) {
                        i.a();
                    }
                    c2.loadUrl(com.speed.speed_library.b.b.f5592a.a("vip"), a.this.d());
                    return true;
                }
                c cVar = c.f5627a;
                Context b2 = a.this.b();
                if (b2 == null) {
                    i.a();
                }
                String uri3 = webResourceRequest.getUrl().toString();
                i.a((Object) uri3, "request.url.toString()");
                cVar.l(b2, uri3);
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Log.d("shouldOverrideUrl = ", str);
            if (g.b(String.valueOf(str), "url://", false, 2, (Object) null)) {
                if (g.b(String.valueOf(str), "url://buyb", false, 2, (Object) null)) {
                    WebView c2 = a.this.c();
                    if (c2 == null) {
                        i.a();
                    }
                    c2.loadUrl(com.speed.speed_library.b.b.f5592a.a("vip"), a.this.d());
                    return true;
                }
                c cVar = c.f5627a;
                Context b2 = a.this.b();
                if (b2 == null) {
                    i.a();
                }
                cVar.l(b2, String.valueOf(str));
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }
    }

    public final void e() {
        this.f5816d.put("ts", String.valueOf(this.f5817e));
        this.f5816d.put("bundleId", String.valueOf(com.speed.speed_library.b.g.f5610b.a().getPackageName()));
        this.f5816d.put("Ua", String.valueOf(com.speed.speed_library.b.c.f5594a.a()));
        this.f5816d.put("channel", String.valueOf(com.speed.speed_library.b.g.f5610b.b()));
        this.f5816d.put("spreadNum", String.valueOf(com.speed.speed_library.b.g.f5610b.c()));
        this.f5816d.put("push-id", String.valueOf(com.speed.speed_library.b.g.f5610b.G()));
        this.f5816d.put("RouteType", String.valueOf(com.speed.speed_library.b.g.f5610b.H()));
        this.f5816d.put("Platform", "Android");
        this.f5816d.put("deviceId", String.valueOf(e.f5601a.a(com.speed.speed_library.b.g.f5610b.a()).a()));
        this.f5816d.put("versionCode", String.valueOf(String.valueOf(com.speed.speed_library.utils.e.b(com.speed.speed_library.b.g.f5610b.a()))));
        this.f5816d.put("appVersion", String.valueOf(com.speed.speed_library.utils.e.a(com.speed.speed_library.b.g.f5610b.a()).toString()));
        Map<String, String> map = this.f5816d;
        UserModel j = com.speed.speed_library.b.g.f5610b.j();
        map.put("uid", String.valueOf(j != null ? Integer.valueOf(j.getUid()) : null));
        Map<String, String> map2 = this.f5816d;
        UserModel j2 = com.speed.speed_library.b.g.f5610b.j();
        map2.put("Authorization", String.valueOf(j2 != null ? j2.getToken() : null));
    }

    public a(Activity activity, ViewGroup viewGroup, String str, WebChromeClient webChromeClient) {
        WebCreator webCreator;
        i.b(activity, d.R);
        i.b(viewGroup, "viewGroup");
        i.b(str, ImagesContract.URL);
        i.b(webChromeClient, "webChromeClient");
        this.f5816d = new HashMap();
        this.f = new C0152a();
        AgentWebConfig.debug();
        Activity activity2 = activity;
        this.f5814b = activity2;
        this.f5817e = System.currentTimeMillis() / 1000;
        e();
        AgentWeb.CommonBuilder additionalHttpHeader = AgentWeb.with(activity).setAgentWebParent(viewGroup, new LinearLayout.LayoutParams(-1, -1)).useDefaultIndicator(activity.getResources().getColor(R.color.colorPrimary), 1).setAgentWebWebSettings(AgentWebSettingsImpl.getInstance()).setWebChromeClient(webChromeClient).setWebViewClient(this.f).setMainFrameErrorView(R.layout.widget_agentweb_error_page, R.id.btn_retry).setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK).additionalHttpHeader(str, "ts", String.valueOf(String.valueOf(this.f5817e))).additionalHttpHeader(str, "bundleId", String.valueOf(com.speed.speed_library.b.g.f5610b.a().getPackageName())).additionalHttpHeader(str, "Ua", String.valueOf(com.speed.speed_library.b.c.f5594a.a())).additionalHttpHeader(str, "channel", String.valueOf(com.speed.speed_library.b.g.f5610b.b())).additionalHttpHeader(str, "spreadNum", String.valueOf(com.speed.speed_library.b.g.f5610b.c())).additionalHttpHeader(str, "Platform", "Android").additionalHttpHeader(str, "RouteType", String.valueOf(com.speed.speed_library.b.g.f5610b.H())).additionalHttpHeader(str, "push-id", com.speed.speed_library.b.g.f5610b.G()).additionalHttpHeader(str, "deviceId", String.valueOf(e.f5601a.a(com.speed.speed_library.b.g.f5610b.a()).a())).additionalHttpHeader(str, "appVersion", String.valueOf(com.speed.speed_library.utils.e.a(com.speed.speed_library.b.g.f5610b.a()).toString())).additionalHttpHeader(str, "versionCode", String.valueOf(String.valueOf(com.speed.speed_library.utils.e.b(com.speed.speed_library.b.g.f5610b.a()))));
        UserModel j = com.speed.speed_library.b.g.f5610b.j();
        AgentWeb.CommonBuilder additionalHttpHeader2 = additionalHttpHeader.additionalHttpHeader(str, "uid", String.valueOf((j == null || (r9 = String.valueOf(j.getUid())) == null) ? "0" : "0"));
        UserModel j2 = com.speed.speed_library.b.g.f5610b.j();
        AgentWeb go2 = additionalHttpHeader2.additionalHttpHeader(str, "Authorization", String.valueOf(j2 != null ? j2.getToken() : null)).createAgentWeb().ready().go(str);
        this.f5813a = go2;
        WebView webView = (go2 == null || (webCreator = go2.getWebCreator()) == null) ? null : webCreator.getWebView();
        this.f5815c = webView;
        WebSettings settings = webView != null ? webView.getSettings() : null;
        if (settings == null) {
            i.a();
        }
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(2);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDatabaseEnabled(true);
        settings.setBlockNetworkImage(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(false);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            WebView.enableSlowWholeDocumentDraw();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WebView webView2 = this.f5815c;
            if (webView2 == null) {
                i.a();
            }
            Context context = webView2.getContext();
            i.a((Object) context, "mWebView!!.getContext()");
            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
            Context applicationContext = context.getApplicationContext();
            i.a((Object) applicationContext, "context.applicationContext");
            if (!i.a((Object) applicationContext.getPackageName(), (Object) currentProcessName)) {
                WebView.setDataDirectorySuffix(currentProcessName);
            }
        }
        AgentWeb agentWeb = this.f5813a;
        if (agentWeb == null) {
            i.a();
        }
        JsInterfaceHolder jsInterfaceHolder = agentWeb.getJsInterfaceHolder();
        AgentWeb agentWeb2 = this.f5813a;
        if (agentWeb2 == null) {
            i.a();
        }
        jsInterfaceHolder.addJavaObject("Android", new com.speed.speed_library.b.a(agentWeb2, activity2));
    }
}
