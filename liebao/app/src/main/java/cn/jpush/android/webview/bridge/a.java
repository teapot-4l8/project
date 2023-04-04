package cn.jpush.android.webview.bridge;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f4520a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f4521b;

    public a(String str, Class cls, ProgressBar progressBar, TextView textView) {
        super(str, cls);
        this.f4520a = progressBar;
        this.f4521b = textView;
        if (progressBar != null) {
            progressBar.setMax(100);
        }
        TextView textView2 = this.f4521b;
        if (textView2 != null) {
            textView2.setSingleLine(true);
            this.f4521b.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
    }

    @Override // cn.jpush.android.webview.bridge.b, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        ProgressBar progressBar = this.f4520a;
        if (progressBar != null) {
            if (100 == i) {
                progressBar.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
                this.f4520a.setProgress(i);
            }
        }
        if (this.f4521b == null || webView.getTitle() == null || webView.getTitle().equals(this.f4521b.getText())) {
            return;
        }
        this.f4521b.setText(webView.getTitle());
    }
}
