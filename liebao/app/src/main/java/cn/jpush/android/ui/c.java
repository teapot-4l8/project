package cn.jpush.android.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ProxyActivityAction;
import cn.jpush.android.u.f;
import cn.jpush.android.webview.bridge.HostJsScope;
import cn.jpush.android.webview.bridge.d;
import com.google.android.gms.ads.AdRequest;
import java.io.File;

/* loaded from: classes.dex */
public class c extends ProxyActivityAction {

    /* renamed from: a  reason: collision with root package name */
    public static d f4511a;

    /* renamed from: d  reason: collision with root package name */
    private String f4514d;

    /* renamed from: e  reason: collision with root package name */
    private WebView f4515e;
    private RelativeLayout f;
    private TextView g;
    private ImageButton h;
    private ProgressBar i;

    /* renamed from: b  reason: collision with root package name */
    private int f4512b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4513c = false;
    private View.OnClickListener j = new View.OnClickListener() { // from class: cn.jpush.android.ui.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                try {
                    if (view.getContext() == null || !(view.getContext() instanceof Activity)) {
                        return;
                    }
                    ((Activity) view.getContext()).onBackPressed();
                } catch (Throwable unused) {
                }
            }
        }
    };

    private cn.jpush.android.d.d a(Activity activity, Intent intent) {
        cn.jpush.android.d.d a2 = cn.jpush.android.p.b.a(activity, activity.getIntent());
        if (a2 != null) {
            return a2;
        }
        Logger.dd("PushActivityImpl", "parse entity form plugin plateform");
        String uri = intent.getData() != null ? intent.getData().toString() : null;
        if (TextUtils.isEmpty(uri) && intent.getExtras() != null) {
            uri = intent.getExtras().getString("JMessageExtra");
        }
        Logger.d("PushActivityImpl", "content:" + uri);
        return cn.jpush.android.t.b.a(activity, uri, "");
    }

    private void a(Activity activity, cn.jpush.android.d.d dVar) {
        if (dVar == null) {
            Logger.ww("PushActivityImpl", "Null message entity! Close PushActivity!");
        } else if (dVar.p == 0) {
            activity.setRequestedOrientation(1);
            b(activity, dVar);
            return;
        } else {
            Logger.w("PushActivityImpl", "Invalid msg type to show - " + dVar.p);
            cn.jpush.android.p.b.b(activity, dVar);
        }
        activity.finish();
    }

    private void b() {
        try {
            f.a(this.f4515e, "addJavascriptInterface", new Class[]{Object.class, String.class}, new Object[]{f4511a, "JPushWeb"});
        } catch (Exception e2) {
            e2.printStackTrace();
            Logger.e("PushActivityImpl", "addJavascriptInterface failed:" + e2.toString());
        }
    }

    private void b(Activity activity) {
        if (activity.getIntent() != null) {
            try {
                this.f4513c = activity.getIntent().getBooleanExtra(PushActivity.FROM_OTHER_WAY, false);
                cn.jpush.android.d.d a2 = a(activity, activity.getIntent());
                if (a2 != null) {
                    this.f4514d = a2.f4312c;
                    a(activity, a2);
                } else {
                    Logger.ww("PushActivityImpl", "Warning，null message entity! Close PushActivity!");
                    activity.finish();
                }
                return;
            } catch (Exception e2) {
                Logger.ee("PushActivityImpl", "Extra data is not serializable!");
                e2.printStackTrace();
            }
        } else {
            Logger.ww("PushActivityImpl", "PushActivity get NULL intent!");
        }
        activity.finish();
    }

    private void b(Activity activity, cn.jpush.android.d.d dVar) {
        String str;
        Logger.i("PushActivityImpl", "Action: processShow");
        if (dVar != null) {
            if (dVar.S == 0) {
                this.f4512b = dVar.Q;
                int identifier = activity.getResources().getIdentifier("jpush_webview_layout", "layout", activity.getPackageName());
                if (identifier == 0) {
                    str = "Please add layout resource jpush_webview_layout.xml to res/layout !";
                } else {
                    activity.setContentView(identifier);
                    String str2 = dVar.N;
                    if (cn.jpush.android.u.a.a(str2)) {
                        String str3 = dVar.P;
                        if (dVar.f4315q) {
                            int identifier2 = activity.getResources().getIdentifier("actionbarLayoutId", "id", activity.getPackageName());
                            if (identifier2 == 0) {
                                str = "Please use default code in jpush_webview_layout.xml!";
                            } else {
                                a(activity, activity.findViewById(identifier2), dVar);
                                if (TextUtils.isEmpty(str3) || !new File(str3.replace("file://", "")).exists() || this.f4513c) {
                                    this.f4515e.loadUrl(str2);
                                } else {
                                    this.f4515e.loadUrl(str3);
                                }
                            }
                        }
                        if (!this.f4513c) {
                            cn.jpush.android.helper.c.a(this.f4514d, 1000, activity.getApplicationContext());
                        }
                    } else {
                        cn.jpush.android.p.b.b(activity, dVar);
                    }
                }
                Logger.ee("PushActivityImpl", str);
            }
            int i = dVar.R;
            return;
        }
        Logger.ww("PushActivityImpl", "Null message entity! Close PushActivity!");
        activity.finish();
    }

    private void c(Activity activity) {
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags &= -1025;
            activity.getWindow().setAttributes(attributes);
            activity.getWindow().clearFlags(AdRequest.MAX_CONTENT_URL_LENGTH);
        } catch (Throwable unused) {
            Logger.w("PushActivityImpl", "quitFullScreen errno");
        }
    }

    public void a() {
        try {
            if (this.f == null || this.f.getVisibility() != 8) {
                return;
            }
            this.f.setVisibility(0);
            c((Activity) this.f.getContext());
            this.h.setOnClickListener(this.j);
            if (this.f4515e != null) {
                this.f4515e.postDelayed(new Runnable() { // from class: cn.jpush.android.ui.c.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (c.this.f4515e != null) {
                                c.this.f4515e.clearHistory();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }, 1000L);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Activity activity) {
        activity.finish();
        if (1 == this.f4512b) {
            try {
                ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
                ComponentName componentName = activityManager.getRunningTasks(1).get(0).baseActivity;
                ComponentName componentName2 = activityManager.getRunningTasks(1).get(0).topActivity;
                Logger.d("PushActivityImpl", "baseActivity  = " + componentName.toString());
                Logger.d("PushActivityImpl", "topActivity  = " + componentName2.toString());
                if (componentName == null || componentName2 == null || !componentName2.toString().equals(componentName.toString())) {
                    return;
                }
                cn.jpush.android.u.a.e(activity);
            } catch (Exception unused) {
                Logger.ww("PushActivityImpl", "Get running tasks failed.");
                cn.jpush.android.u.a.e(activity);
            }
        }
    }

    public void a(Activity activity, View view, cn.jpush.android.d.d dVar) {
        String str = dVar.O;
        view.setFocusable(true);
        this.f4515e = (WebView) activity.findViewById(activity.getResources().getIdentifier("fullWebView", "id", activity.getPackageName()));
        this.f = (RelativeLayout) activity.findViewById(activity.getResources().getIdentifier("rlRichpushTitleBar", "id", activity.getPackageName()));
        this.g = (TextView) activity.findViewById(activity.getResources().getIdentifier("tvRichpushTitle", "id", activity.getPackageName()));
        this.h = (ImageButton) activity.findViewById(activity.getResources().getIdentifier("imgRichpushBtnBack", "id", activity.getPackageName()));
        this.i = (ProgressBar) activity.findViewById(activity.getResources().getIdentifier("pushPrograssBar", "id", activity.getPackageName()));
        if (this.f4515e == null || this.f == null || this.g == null || this.h == null) {
            Logger.ee("PushActivityImpl", "Please use default code in jpush_webview_layout.xml!");
            activity.finish();
        }
        if (1 == dVar.R) {
            this.f.setVisibility(8);
            activity.getWindow().setFlags(1024, 1024);
        } else {
            this.g.setText(str);
            this.h.setOnClickListener(this.j);
        }
        this.f4515e.setScrollbarFadingEnabled(true);
        this.f4515e.setScrollBarStyle(33554432);
        WebSettings settings = this.f4515e.getSettings();
        cn.jpush.android.u.a.a(settings);
        cn.jpush.android.u.a.a(this.f4515e);
        settings.setSavePassword(false);
        f4511a = new d(activity, dVar);
        if (Build.VERSION.SDK_INT >= 17) {
            Logger.dd("PushActivityImpl", "Android sdk version greater than or equal to 17, Java—Js interact by annotation!");
            b();
        }
        this.f4515e.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, this.i, this.g));
        this.f4515e.setWebViewClient(new a(dVar, activity));
        HostJsScope.setWebViewHelper(f4511a);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onBackPressed(Activity activity) {
        WebView webView = this.f4515e;
        if (webView != null && webView.canGoBack()) {
            this.f4515e.goBack();
            return;
        }
        cn.jpush.android.helper.c.a(this.f4514d, 1006, activity);
        a(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onConfigurationChanged(Activity activity, Configuration configuration) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onCreate(Activity activity, Bundle bundle) {
        cn.jpush.android.u.a.d(activity);
        b(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onDestroy(Activity activity) {
        WebView webView = this.f4515e;
        if (webView != null) {
            webView.removeAllViews();
            this.f4515e.clearSslPreferences();
            this.f4515e.destroy();
            this.f4515e = null;
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onEvent(Activity activity, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str) || !str.equals("push_show_titlebar")) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: cn.jpush.android.ui.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.a();
            }
        });
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public boolean onKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onNewIntent(Activity activity, Intent intent) {
        activity.setIntent(intent);
        b(activity);
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onPause(Activity activity) {
        if (this.f4515e == null || Build.VERSION.SDK_INT < 11) {
            return;
        }
        this.f4515e.onPause();
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onRestart(Activity activity) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onResume(Activity activity) {
        if (this.f4515e != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                this.f4515e.onResume();
            }
            HostJsScope.setWebViewHelper(f4511a);
        }
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStart(Activity activity, Intent intent) {
    }

    @Override // cn.jpush.android.local.ProxyActivityAction
    public void onStop(Activity activity) {
    }
}
