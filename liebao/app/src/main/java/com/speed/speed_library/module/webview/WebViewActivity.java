package com.speed.speed_library.module.webview;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebCreator;
import com.just.agentweb.WebLifeCycle;
import com.speed.speed_library.R;
import com.speed.speed_library.b.d;
import com.speed.speed_library.b.g;
import java.io.File;
import java.util.HashMap;
import kotlin.d.b.i;

/* compiled from: WebViewActivity.kt */
/* loaded from: classes2.dex */
public final class WebViewActivity extends com.speed.speed_library.a.a implements View.OnClickListener {
    private com.speed.speed_library.module.webview.a k;
    private WebView l;
    private String m = "";
    private String n = "";
    private final a o = new a();
    private HashMap p;

    @Override // com.speed.speed_library.a.a
    public View d(int i) {
        if (this.p == null) {
            this.p = new HashMap();
        }
        View view = (View) this.p.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.p.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_webview);
        l();
        n();
        m();
    }

    public final void l() {
        if (getIntent() != null) {
            if (getIntent().getStringExtra(d.f5595a.Q()) != null) {
                String stringExtra = getIntent().getStringExtra(d.f5595a.Q());
                i.a((Object) stringExtra, "intent.getStringExtra(WEBVIEW_EXTRA_URL)");
                this.m = stringExtra;
            }
            if (getIntent().getStringExtra(d.f5595a.R()) != null) {
                String stringExtra2 = getIntent().getStringExtra(d.f5595a.R());
                i.a((Object) stringExtra2, "intent.getStringExtra(WEBVIEW_EXTRA_TITLE)");
                this.n = stringExtra2;
            }
        }
        TextView textView = (TextView) d(R.id.headerbar_title);
        i.a((Object) textView, "headerbar_title");
        textView.setText(this.n);
    }

    private final void n() {
        AgentWeb a2;
        WebCreator webCreator;
        String externalCachePath = AgentWebConfig.getExternalCachePath(g.f5610b.a());
        String cachePath = AgentWebConfig.getCachePath(g.f5610b.a());
        if (!TextUtils.isEmpty(externalCachePath)) {
            new File(externalCachePath).delete();
        }
        if (!TextUtils.isEmpty(cachePath)) {
            new File(cachePath).delete();
        }
        LinearLayout linearLayout = (LinearLayout) d(R.id.container);
        i.a((Object) linearLayout, "container");
        com.speed.speed_library.module.webview.a aVar = new com.speed.speed_library.module.webview.a(this, linearLayout, this.m, this.o);
        this.k = aVar;
        this.l = (aVar == null || (a2 = aVar.a()) == null || (webCreator = a2.getWebCreator()) == null) ? null : webCreator.getWebView();
    }

    public final void m() {
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i.a(view, (LinearLayout) d(R.id.ll_back))) {
            onBackPressed();
        }
    }

    /* compiled from: WebViewActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends WebChromeClient {
        a() {
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            i.b(webView, "view");
            i.b(str, "title");
            super.onReceivedTitle(webView, str);
            String str2 = str;
            if (TextUtils.isEmpty(str2) || kotlin.h.g.b(str, "http", false, 2, (Object) null)) {
                return;
            }
            TextView textView = (TextView) WebViewActivity.this.d(R.id.headerbar_title);
            i.a((Object) textView, "headerbar_title");
            textView.setText(str2);
        }
    }

    @Override // androidx.activity.b, android.app.Activity
    public void onBackPressed() {
        AgentWeb a2;
        com.speed.speed_library.module.webview.a aVar = this.k;
        if (aVar == null || (a2 = aVar.a()) == null || a2.back()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AgentWeb a2;
        i.b(keyEvent, "event");
        com.speed.speed_library.module.webview.a aVar = this.k;
        Boolean valueOf = (aVar == null || (a2 = aVar.a()) == null) ? null : Boolean.valueOf(a2.handleKeyEvent(i, keyEvent));
        if (valueOf == null) {
            i.a();
        }
        if (valueOf.booleanValue()) {
            return true;
        }
        finish();
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        AgentWeb a2;
        WebLifeCycle webLifeCycle;
        com.speed.speed_library.module.webview.a aVar = this.k;
        if (aVar != null && (a2 = aVar.a()) != null && (webLifeCycle = a2.getWebLifeCycle()) != null) {
            webLifeCycle.onResume();
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        AgentWeb a2;
        WebLifeCycle webLifeCycle;
        com.speed.speed_library.module.webview.a aVar = this.k;
        if (aVar != null && (a2 = aVar.a()) != null && (webLifeCycle = a2.getWebLifeCycle()) != null) {
            webLifeCycle.onPause();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        AgentWeb a2;
        WebLifeCycle webLifeCycle;
        com.speed.speed_library.module.webview.a aVar = this.k;
        if (aVar != null && (a2 = aVar.a()) != null && (webLifeCycle = a2.getWebLifeCycle()) != null) {
            webLifeCycle.onDestroy();
        }
        super.onDestroy();
    }
}
