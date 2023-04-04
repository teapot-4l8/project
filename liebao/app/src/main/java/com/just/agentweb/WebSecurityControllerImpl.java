package com.just.agentweb;

import android.os.Build;
import android.webkit.WebView;
import androidx.b.a;
import com.just.agentweb.AgentWeb;

/* loaded from: classes.dex */
public class WebSecurityControllerImpl implements WebSecurityController<WebSecurityCheckLogic> {
    private a<String, Object> mMap;
    private AgentWeb.SecurityType mSecurityType;
    private WebView mWebView;

    public WebSecurityControllerImpl(WebView webView, a<String, Object> aVar, AgentWeb.SecurityType securityType) {
        this.mWebView = webView;
        this.mMap = aVar;
        this.mSecurityType = securityType;
    }

    @Override // com.just.agentweb.WebSecurityController
    public void check(WebSecurityCheckLogic webSecurityCheckLogic) {
        if (Build.VERSION.SDK_INT > 11) {
            webSecurityCheckLogic.dealHoneyComb(this.mWebView);
        }
        if (this.mMap == null || this.mSecurityType != AgentWeb.SecurityType.STRICT_CHECK || this.mMap.isEmpty()) {
            return;
        }
        webSecurityCheckLogic.dealJsInterface(this.mMap, this.mSecurityType);
    }
}
