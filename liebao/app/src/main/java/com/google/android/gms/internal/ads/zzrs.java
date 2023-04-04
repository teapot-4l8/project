package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzrs implements Runnable {
    private ValueCallback<String> zzbud = new zzrv(this);
    final /* synthetic */ zzrk zzbue;
    final /* synthetic */ WebView zzbuf;
    final /* synthetic */ boolean zzbug;
    final /* synthetic */ zzrq zzbuh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzrs(zzrq zzrqVar, zzrk zzrkVar, WebView webView, boolean z) {
        this.zzbuh = zzrqVar;
        this.zzbue = zzrkVar;
        this.zzbuf = webView;
        this.zzbug = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzbuf.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzbuf.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzbud);
            } catch (Throwable unused) {
                this.zzbud.onReceiveValue("");
            }
        }
    }
}
