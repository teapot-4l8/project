package cn.jpush.android.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import java.util.Locale;

/* loaded from: classes.dex */
public class a extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private final d f4500a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f4501b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4502c = false;

    public a(d dVar, Context context) {
        this.f4500a = dVar;
        this.f4501b = context;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.f4502c) {
            sslErrorHandler.proceed();
            return;
        }
        Context context = this.f4501b;
        if (context == null || context.getClass().isAssignableFrom(Activity.class)) {
            sslErrorHandler.cancel();
            return;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f4501b);
            builder.setTitle("提示");
            builder.setMessage("SSL 证书异常，是否继续加载？");
            builder.setNegativeButton("否", new DialogInterface.OnClickListener() { // from class: cn.jpush.android.ui.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    sslErrorHandler.cancel();
                }
            });
            builder.setPositiveButton("是", new DialogInterface.OnClickListener() { // from class: cn.jpush.android.ui.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    a.this.f4502c = true;
                    sslErrorHandler.proceed();
                }
            });
            builder.setCancelable(false);
            builder.create().show();
        } catch (Throwable th) {
            sslErrorHandler.cancel();
            Logger.w("JPushWebViewClient", "show dialog error:" + th);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        StringBuilder sb;
        Context context = webView.getContext();
        Logger.i("JPushWebViewClient", "Url vaule is :" + str);
        try {
            webView.getSettings().setSavePassword(false);
            cn.jpush.android.u.a.a(webView);
            String format = String.format(Locale.ENGLISH, "{\"url\":\"%s\"}", str);
            if (str.endsWith(".mp3")) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(str), "audio/*");
                webView.getContext().startActivity(intent);
                return true;
            }
            if (!str.endsWith(".mp4") && !str.endsWith(".3gp")) {
                if (str.endsWith(".apk")) {
                    webView.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                }
                if (str.startsWith("http")) {
                    cn.jpush.android.helper.c.a(this.f4500a.f4312c, 1016, format, JPushConstants.mApplicationContext);
                } else if (str.startsWith("mailto")) {
                    if (str.lastIndexOf("direct=") < 0 && !str.startsWith("mailto")) {
                        if (str.indexOf("?") > 0) {
                            sb = new StringBuilder();
                            sb.append(str);
                            sb.append("&direct=false");
                        } else {
                            sb = new StringBuilder();
                            sb.append(str);
                            sb.append("?direct=false");
                        }
                        str = sb.toString();
                        str.lastIndexOf("direct=");
                    }
                    int indexOf = str.indexOf("?");
                    String substring = str.substring(0, indexOf);
                    String substring2 = str.substring(indexOf);
                    Logger.v("JPushWebViewClient", "Uri: " + substring);
                    Logger.v("JPushWebViewClient", "QueryString: " + substring2);
                    Intent intent2 = null;
                    if (substring.startsWith("mailto")) {
                        String[] split = substring.split(":");
                        if (split.length == 2) {
                            int indexOf2 = substring2.indexOf("&content=");
                            String substring3 = substring2.substring(substring2.indexOf("title=") + 6, indexOf2);
                            String substring4 = substring2.substring(indexOf2 + 9);
                            String[] strArr = {split[1]};
                            Intent intent3 = new Intent("android.intent.action.SEND");
                            intent3.setType("plain/text");
                            intent3.putExtra("android.intent.extra.EMAIL", strArr);
                            intent3.putExtra("android.intent.extra.SUBJECT", substring3);
                            intent3.putExtra("android.intent.extra.TEXT", substring4);
                            intent2 = intent3;
                        }
                    }
                    if (intent2 != null) {
                        context.startActivity(intent2);
                    }
                    cn.jpush.android.helper.c.a(this.f4500a.f4312c, 1016, format, JPushConstants.mApplicationContext);
                    return true;
                }
                return false;
            }
            Intent intent4 = new Intent("android.intent.action.VIEW");
            intent4.setDataAndType(Uri.parse(str), "video/*");
            webView.getContext().startActivity(intent4);
            return true;
        } catch (Exception unused) {
            Logger.e("JPushWebViewClient", "Invalid url");
            return true;
        }
    }
}
