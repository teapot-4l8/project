package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.u.f;
import cn.jpush.android.webview.bridge.HostJsScope;
import cn.jpush.android.webview.bridge.d;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;

/* loaded from: classes.dex */
public class b extends ProxyActivityAction {

    /* renamed from: a  reason: collision with root package name */
    public static d f4507a;

    /* renamed from: b  reason: collision with root package name */
    private String f4508b;

    /* renamed from: c  reason: collision with root package name */
    private WebView f4509c;

    /* renamed from: d  reason: collision with root package name */
    private cn.jpush.android.d.d f4510d = null;

    private cn.jpush.android.d.d a(Activity activity, Intent intent) {
        cn.jpush.android.d.d a2 = cn.jpush.android.p.b.a(activity.getApplicationContext(), activity.getIntent());
        if (a2 != null) {
            return a2;
        }
        Logger.dd("PopWinActivityImpl", "parse entity form plugin plateform");
        String uri = intent.getData() != null ? intent.getData().toString() : null;
        if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
            uri = intent.getExtras().getString("JMessageExtra");
        }
        return cn.jpush.android.t.b.a(activity, uri, "");
    }

    private void a() {
        try {
            f.a(this.f4509c, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{f4507a, "JPushWeb"});
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger.e("PopWinActivityImpl", "addJavascriptInterface failed:" + e2.toString());
        }
    }

    private void a(Activity activity) {
        if (activity.getIntent() != null) {
            try {
                cn.jpush.android.d.d a2 = a(activity, activity.getIntent());
                this.f4510d = a2;
                if (a2 != null) {
                    this.f4508b = a2.f4312c;
                    b(activity);
                    c(activity);
                } else {
                    Logger.ww("PopWinActivityImpl", "Warning，null message entity! Close PopWinActivity!");
                    activity.finish();
                }
                return;
            } catch (Exception e2) {
                Logger.ee("PopWinActivityImpl", "Extra data is not serializable!");
                e2.printStackTrace();
            }
        } else {
            Logger.ww("PopWinActivityImpl", "PopWinActivity get NULL intent!");
        }
        activity.finish();
    }

    private void b(Activity activity) {
        int identifier = activity.getResources().getIdentifier("jpush_popwin_layout", "layout", activity.getPackageName());
        if (identifier == 0) {
            Logger.ee("PopWinActivityImpl", "Please add layout resource jpush_popwin_layout.xml to res/layout !");
            activity.finish();
            return;
        }
        activity.setContentView(identifier);
        int identifier2 = activity.getResources().getIdentifier("wvPopwin", "id", activity.getPackageName());
        if (identifier2 == 0) {
            Logger.ee("PopWinActivityImpl", "Please use default code in jpush_popwin_layout.xml!");
            activity.finish();
            return;
        }
        WebView webView = (WebView) activity.findViewById(identifier2);
        this.f4509c = webView;
        if (webView == null) {
            Logger.ee("PopWinActivityImpl", "Can not get webView in layout file!");
            activity.finish();
            return;
        }
        webView.setScrollbarFadingEnabled(true);
        this.f4509c.setScrollBarStyle(33554432);
        WebSettings settings = this.f4509c.getSettings();
        settings.setDomStorageEnabled(true);
        cn.jpush.android.u.a.a(settings);
        cn.jpush.android.u.a.a(this.f4509c);
        settings.setSavePassword(false);
        this.f4509c.setBackgroundColor(0);
        f4507a = new d(activity, this.f4510d);
        if (Build.VERSION.SDK_INT >= 17) {
            Logger.dd("PopWinActivityImpl", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
            a();
        }
        this.f4509c.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
        this.f4509c.setWebViewClient(new a(this.f4510d, activity));
        HostJsScope.setWebViewHelper(f4507a);
    }

    private void c(Activity activity) {
        String str = this.f4510d.P;
        String str2 = this.f4510d.N;
        Logger.d("PopWinActivityImpl", "showUrl = " + str2);
        if (TextUtils.isEmpty(str) || !new File(str.replace("file://", "")).exists()) {
            this.f4509c.loadUrl(str2);
        } else {
            this.f4509c.loadUrl(str);
        }
        cn.jpush.android.helper.c.a(this.f4508b, 1000, activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onBackPressed(Activity activity) {
        cn.jpush.android.helper.c.a(this.f4508b, 1006, activity.getApplicationContext());
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onConfigurationChanged(Activity activity, Configuration configuration) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onCreate(Activity activity, Bundle bundle) {
        cn.jpush.android.u.a.d(activity);
        a(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onDestroy(Activity activity) {
        WebView webView = this.f4509c;
        if (webView != null) {
            webView.removeAllViews();
            this.f4509c.destroy();
            this.f4509c = null;
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onEvent(Activity activity, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || !str.equals("start_push_activity") || this.f4510d == null || this.f4509c == null) {
            return;
        }
        String string = bundle.getString(ImagesContract.URL);
        if (!TextUtils.isEmpty(string)) {
            this.f4510d.N = string;
            Intent intent = new Intent(activity, PushActivity.class);
            intent.putExtra("msg_data", this.f4510d.c());
            intent.putExtra(PushActivity.FROM_OTHER_WAY, true);
            intent.setFlags(335544320);
            activity.startActivity(intent);
        }
        activity.finish();
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onNewIntent(Activity activity, Intent intent) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onPause(Activity activity) {
        if (this.f4509c == null || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.f4509c.onPause();
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onRestart(Activity activity) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onResume(Activity activity) {
        if (this.f4509c != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.f4509c.onResume();
            }
            HostJsScope.setWebViewHelper(f4507a);
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStart(Activity activity, Intent intent) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStop(Activity activity) {
    }
}
