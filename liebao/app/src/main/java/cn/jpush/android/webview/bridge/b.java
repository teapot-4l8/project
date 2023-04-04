package cn.jpush.android.webview.bridge;

import android.os.Build;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import cn.jpush.android.helper.Logger;

/* loaded from: classes.dex */
public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    private final String f4522a = "InjectedChromeClient";

    /* renamed from: b  reason: collision with root package name */
    private c f4523b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4524c;

    public b(String str, Class cls) {
        this.f4523b = new c(str, cls);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        jsResult.confirm();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (Build.VERSION.SDK_INT < 17) {
            jsPromptResult.confirm(this.f4523b.a(webView, str2));
            return true;
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        webView.getSettings().setSavePassword(false);
        if (Build.VERSION.SDK_INT < 17) {
            if (i <= 25) {
                this.f4524c = false;
            } else if (!this.f4524c) {
                Logger.dd("InjectedChromeClient", "Android sdk version lesser than 17, Java—Js interact by injection!");
                webView.loadUrl(this.f4523b.a());
                this.f4524c = true;
                Logger.d("InjectedChromeClient", " inject js interface completely on progress " + i);
            }
        }
        super.onProgressChanged(webView, i);
    }
}
