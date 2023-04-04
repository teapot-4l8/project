package com.speed.speed_library.module.a;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebCreator;
import com.lxj.xpopup.b.d;
import com.speed.speed_library.R;
import com.speed.speed_library.b.b;
import com.speed.speed_library.module.main.MainActivity;
import java.util.HashMap;
import kotlin.d.b.i;

/* compiled from: CouponDialog.kt */
/* loaded from: classes2.dex */
public final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private com.speed.speed_library.module.webview.a f5699b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f5700c;

    /* renamed from: d  reason: collision with root package name */
    private String f5701d;

    /* renamed from: e  reason: collision with root package name */
    private String f5702e;
    private final C0145a f;
    private HashMap g;

    public View a(int i) {
        if (this.g == null) {
            this.g = new HashMap();
        }
        View view = (View) this.g.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.g.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        i.b(context, com.umeng.analytics.pro.d.R);
        this.f5701d = b.f5592a.a("vip");
        this.f5702e = "购买";
        this.f = new C0145a();
    }

    public final WebView getMWebView() {
        return this.f5700c;
    }

    public final void setMWebView(WebView webView) {
        this.f5700c = webView;
    }

    public final String getMUrl() {
        return this.f5701d;
    }

    public final void setMUrl(String str) {
        i.b(str, "<set-?>");
        this.f5701d = str;
    }

    public final String getMTitle() {
        return this.f5702e;
    }

    public final void setMTitle(String str) {
        i.b(str, "<set-?>");
        this.f5702e = str;
    }

    @Override // com.lxj.xpopup.b.d, com.lxj.xpopup.b.b
    protected int getImplLayoutId() {
        return R.layout.dialog_coupon;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public void k() {
        AgentWeb a2;
        WebCreator webCreator;
        super.k();
        Context context = getContext();
        if (context == null) {
            throw new kotlin.i("null cannot be cast to non-null type com.speed.speed_library.module.main.MainActivity");
        }
        LinearLayout linearLayout = (LinearLayout) a(R.id.ll_webview_container);
        i.a((Object) linearLayout, "ll_webview_container");
        com.speed.speed_library.module.webview.a aVar = new com.speed.speed_library.module.webview.a((MainActivity) context, linearLayout, b.f5592a.d(), this.f);
        this.f5699b = aVar;
        this.f5700c = (aVar == null || (a2 = aVar.a()) == null || (webCreator = a2.getWebCreator()) == null) ? null : webCreator.getWebView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lxj.xpopup.b.b
    public void p() {
        super.p();
        com.speed.speed_library.business.a.f5623a.g();
    }

    /* compiled from: CouponDialog.kt */
    /* renamed from: com.speed.speed_library.module.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0145a extends WebChromeClient {
        C0145a() {
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            i.b(webView, "view");
            i.b(str, "title");
            super.onReceivedTitle(webView, str);
        }
    }
}
