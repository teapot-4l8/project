package com.speed.speed_library.module.webview;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.e;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebCreator;
import com.just.agentweb.WebLifeCycle;
import com.speed.speed_library.R;
import com.speed.speed_library.b.f;
import com.speed.speed_library.event.BuyTypeEvent;
import com.speed.speed_library.model.UserModel;
import com.speed.speed_library.utils.h;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.d.b.g;
import kotlin.d.b.i;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.m;
import utils.AppLog;

/* compiled from: WebFragment.kt */
/* loaded from: classes.dex */
public final class b extends com.speed.speed_library.a.b {

    /* renamed from: b  reason: collision with root package name */
    public static final a f5819b = new a(null);
    private static final String h = "url";

    /* renamed from: c  reason: collision with root package name */
    private WebView f5820c;

    /* renamed from: d  reason: collision with root package name */
    private com.speed.speed_library.module.webview.a f5821d;

    /* renamed from: e  reason: collision with root package name */
    private String f5822e = "";
    private final C0153b f = new C0153b();
    private Map<String, String> g = new HashMap();
    private HashMap i;

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public View a(int i) {
        if (this.i == null) {
            this.i = new HashMap();
        }
        View view = (View) this.i.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            View findViewById = view2.findViewById(i);
            this.i.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d
    public void c() {
        HashMap hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* compiled from: WebFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a() {
            return b.h;
        }

        public final b a(String str) {
            i.b(str, "url");
            Bundle bundle = new Bundle();
            b bVar = new b();
            bundle.putString(a(), str);
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h hVar = h.f5876a;
        e activity = getActivity();
        if (activity == null) {
            i.a();
        }
        i.a((Object) activity, "this.activity!!");
        hVar.a(activity, getResources().getColor(R.color.colorWhite), true);
        c.a().a(this);
        Bundle arguments = getArguments();
        this.f5822e = (arguments == null || (r4 = arguments.getString(h)) == null) ? "" : "";
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        i.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_webview, viewGroup, false);
        i.a((Object) inflate, "inflater.inflate(R.layou…ebview, container, false)");
        a(inflate);
        g();
        return a();
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onPause() {
        AgentWeb a2;
        WebLifeCycle webLifeCycle;
        com.speed.speed_library.module.webview.a aVar = this.f5821d;
        if (aVar != null && (a2 = aVar.a()) != null && (webLifeCycle = a2.getWebLifeCycle()) != null) {
            webLifeCycle.onPause();
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.d
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        h hVar = h.f5876a;
        e activity = getActivity();
        if (activity == null) {
            i.a();
        }
        i.a((Object) activity, "this.activity!!");
        hVar.a(activity, getResources().getColor(R.color.colorWhite), true);
    }

    @Override // com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onResume() {
        AgentWeb a2;
        WebLifeCycle webLifeCycle;
        com.speed.speed_library.module.webview.a aVar = this.f5821d;
        if (aVar != null && (a2 = aVar.a()) != null && (webLifeCycle = a2.getWebLifeCycle()) != null) {
            webLifeCycle.onResume();
        }
        e();
        WebView webView = this.f5820c;
        if (webView != null) {
            webView.loadUrl(this.f5822e, this.g);
        }
        super.onResume();
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onDestroyView() {
        AppLog.INSTANCE.i("BaseFragment onDestroyView");
        super.onDestroyView();
        c();
    }

    @Override // com.speed.speed_library.a.b, com.speed.speed_library.a.d, androidx.fragment.app.d
    public void onDestroy() {
        AgentWeb a2;
        WebLifeCycle webLifeCycle;
        AppLog.INSTANCE.i("BaseFragment onDestroy");
        com.speed.speed_library.module.webview.a aVar = this.f5821d;
        if (aVar != null && (a2 = aVar.a()) != null && (webLifeCycle = a2.getWebLifeCycle()) != null) {
            webLifeCycle.onDestroy();
        }
        super.onDestroy();
    }

    private final void g() {
        AgentWeb a2;
        WebCreator webCreator;
        LinearLayout linearLayout = (LinearLayout) a().findViewById(R.id.ll_back);
        i.a((Object) linearLayout, "mRootView.ll_back");
        linearLayout.setVisibility(8);
        String externalCachePath = AgentWebConfig.getExternalCachePath(com.speed.speed_library.b.g.f5610b.a());
        String cachePath = AgentWebConfig.getCachePath(com.speed.speed_library.b.g.f5610b.a());
        if (!TextUtils.isEmpty(externalCachePath)) {
            new File(externalCachePath).delete();
        }
        if (!TextUtils.isEmpty(cachePath)) {
            new File(cachePath).delete();
        }
        e activity = getActivity();
        if (activity != null) {
            LinearLayout linearLayout2 = (LinearLayout) a().findViewById(R.id.container);
            i.a((Object) linearLayout2, "mRootView.container");
            com.speed.speed_library.module.webview.a aVar = new com.speed.speed_library.module.webview.a((com.speed.speed_library.a.a) activity, linearLayout2, this.f5822e, this.f);
            this.f5821d = aVar;
            this.f5820c = (aVar == null || (a2 = aVar.a()) == null || (webCreator = a2.getWebCreator()) == null) ? null : webCreator.getWebView();
            return;
        }
        throw new kotlin.i("null cannot be cast to non-null type com.speed.speed_library.base.BaseActivity");
    }

    /* compiled from: WebFragment.kt */
    /* renamed from: com.speed.speed_library.module.webview.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0153b extends WebChromeClient {
        C0153b() {
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            i.b(webView, "view");
            i.b(str, "title");
            super.onReceivedTitle(webView, str);
            String str2 = str;
            if (!TextUtils.isEmpty(str2) && !kotlin.h.g.b(str, "http", false, 2, (Object) null)) {
                TextView textView = (TextView) b.this.a(R.id.headerbar_title);
                i.a((Object) textView, "headerbar_title");
                textView.setText(str2);
            }
            if (TextUtils.isEmpty(webView.getUrl())) {
                return;
            }
            String url = webView.getUrl();
            i.a((Object) url, "view.url");
            if (kotlin.h.g.a((CharSequence) url, (CharSequence) "/recharge.html", false, 2, (Object) null)) {
                LinearLayout linearLayout = (LinearLayout) b.this.a(R.id.ll_right);
                i.a((Object) linearLayout, "ll_right");
                linearLayout.setVisibility(0);
                ImageView imageView = (ImageView) b.this.a(R.id.iv_right);
                i.a((Object) imageView, "iv_right");
                imageView.setVisibility(8);
                TextView textView2 = (TextView) b.this.a(R.id.tv_right_text);
                i.a((Object) textView2, "tv_right_text");
                textView2.setVisibility(0);
                TextView textView3 = (TextView) b.this.a(R.id.tv_right_text);
                i.a((Object) textView3, "tv_right_text");
                textView3.setText("我的订单");
                ((TextView) b.this.a(R.id.tv_right_text)).setOnClickListener(new a());
                return;
            }
            LinearLayout linearLayout2 = (LinearLayout) b.this.a(R.id.ll_right);
            i.a((Object) linearLayout2, "ll_right");
            linearLayout2.setVisibility(8);
        }

        /* compiled from: WebFragment.kt */
        /* renamed from: com.speed.speed_library.module.webview.b$b$a */
        /* loaded from: classes2.dex */
        static final class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (!com.speed.speed_library.business.e.f5632a.b()) {
                    f.a("登录异常，请稍后再试", 0, 2, null);
                    com.speed.speed_library.business.a.f5623a.f();
                    return;
                }
                com.speed.speed_library.b.c cVar = com.speed.speed_library.b.c.f5594a;
                e activity = b.this.getActivity();
                if (activity == null) {
                    i.a();
                }
                i.a((Object) activity, "this@WebFragment.activity!!");
                cVar.a(activity, com.speed.speed_library.b.b.f5592a.e(), "订单记录");
            }
        }
    }

    @m(a = ThreadMode.MAIN)
    public final void buyTypeEventEvent(BuyTypeEvent buyTypeEvent) {
        i.b(buyTypeEvent, "event");
        if (buyTypeEvent.getType().equals("svip")) {
            this.f5822e = com.speed.speed_library.b.b.f5592a.a("svip");
        } else {
            this.f5822e = com.speed.speed_library.b.b.f5592a.a("vip");
        }
        e();
        WebView webView = this.f5820c;
        if (webView != null) {
            webView.loadUrl(this.f5822e, this.g);
        }
    }

    public final void e() {
        this.g.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
        this.g.put("bundleId", String.valueOf(com.speed.speed_library.b.g.f5610b.a().getPackageName()));
        this.g.put("Ua", String.valueOf(com.speed.speed_library.b.c.f5594a.a()));
        this.g.put("channel", String.valueOf(com.speed.speed_library.b.g.f5610b.b()));
        this.g.put("spreadNum", String.valueOf(com.speed.speed_library.b.g.f5610b.c()));
        this.g.put("push-id", String.valueOf(com.speed.speed_library.b.g.f5610b.G()));
        this.g.put("RouteType", String.valueOf(com.speed.speed_library.b.g.f5610b.H()));
        this.g.put("Platform", "Android");
        this.g.put("deviceId", String.valueOf(com.speed.speed_library.b.e.f5601a.a(com.speed.speed_library.b.g.f5610b.a()).a()));
        this.g.put("versionCode", String.valueOf(String.valueOf(com.speed.speed_library.utils.e.b(com.speed.speed_library.b.g.f5610b.a()))));
        this.g.put("appVersion", String.valueOf(com.speed.speed_library.utils.e.a(com.speed.speed_library.b.g.f5610b.a()).toString()));
        Map<String, String> map = this.g;
        UserModel j = com.speed.speed_library.b.g.f5610b.j();
        map.put("uid", String.valueOf(j != null ? Integer.valueOf(j.getUid()) : null));
        Map<String, String> map2 = this.g;
        UserModel j2 = com.speed.speed_library.b.g.f5610b.j();
        map2.put("Authorization", String.valueOf(j2 != null ? j2.getToken() : null));
    }
}
