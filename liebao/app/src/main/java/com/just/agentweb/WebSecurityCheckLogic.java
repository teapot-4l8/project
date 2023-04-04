package com.just.agentweb;

import android.webkit.WebView;
import androidx.b.a;
import com.just.agentweb.AgentWeb;

/* loaded from: classes.dex */
public interface WebSecurityCheckLogic {
    void dealHoneyComb(WebView webView);

    void dealJsInterface(a<String, Object> aVar, AgentWeb.SecurityType securityType);
}
