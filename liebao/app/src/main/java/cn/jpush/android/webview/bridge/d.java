package cn.jpush.android.webview.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Activity> f4528a;

    /* renamed from: b  reason: collision with root package name */
    private final cn.jpush.android.d.d f4529b;

    public d(Context context, cn.jpush.android.d.d dVar) {
        this.f4528a = new WeakReference<>((Activity) context);
        this.f4529b = dVar;
    }

    @JavascriptInterface
    private void userClick(String str) {
        int i;
        try {
            i = Integer.parseInt(str);
        } catch (Exception unused) {
            Logger.e("WebViewHelper", "Invalid actionId from Web - " + str);
            i = 1100;
        }
        cn.jpush.android.helper.c.a(this.f4529b.f4312c, i, this.f4528a.get());
    }

    @JavascriptInterface
    public void click(String str, String str2, String str3) {
        boolean z;
        if (this.f4528a.get() != null) {
            Logger.d("WebViewHelper", "Web callback:click - actionId:" + str + ", shouldClose:" + str2 + ", shouldCancelNotification:" + str3);
            userClick(str);
            boolean z2 = false;
            try {
                z = Boolean.parseBoolean(str2);
                try {
                    z2 = Boolean.parseBoolean(str3);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                z = false;
            }
            if (z2) {
                cn.jpush.android.p.b.b(this.f4528a.get(), this.f4529b);
            }
            if (z) {
                this.f4528a.get().finish();
            }
        }
    }

    @JavascriptInterface
    public void close() {
        if (this.f4528a.get() != null) {
            Logger.d("WebViewHelper", "Web callback:close");
            this.f4528a.get().finish();
        }
    }

    @JavascriptInterface
    public void createShortcut(String str, String str2, String str3) {
    }

    @JavascriptInterface
    public void download(String str) {
        if (this.f4528a.get() == null) {
            return;
        }
        Logger.d("WebViewHelper", "Web callback:download - " + str);
    }

    @JavascriptInterface
    public void download(String str, String str2) {
        if (this.f4528a.get() == null) {
            return;
        }
        userClick(str);
        download(str2);
        cn.jpush.android.p.b.b(this.f4528a.get(), this.f4529b);
        this.f4528a.get().finish();
    }

    @JavascriptInterface
    public void download(String str, String str2, String str3) {
        Logger.v("WebViewHelper", "msgType from web: " + str3);
        download(str, str2);
    }

    @JavascriptInterface
    public void executeMsgMessage(String str) {
    }

    @JavascriptInterface
    public void showTitleBar() {
        try {
            if (this.f4528a.get() == null || !(this.f4528a.get() instanceof PushActivity)) {
                return;
            }
            ((PushActivity) this.f4528a.get()).showTitleBar();
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void showToast(String str) {
        if (this.f4528a.get() != null) {
            Logger.d("WebViewHelper", "Web callback:showToast - " + str);
            Toast.makeText(this.f4528a.get(), str, 0).show();
        }
    }

    @JavascriptInterface
    public void startActivityByIntent(String str, String str2) {
        Activity activity = this.f4528a.get();
        if (activity == null) {
            return;
        }
        try {
            Intent intent = new Intent(str);
            intent.addCategory(activity.getPackageName());
            intent.putExtra(JPushInterface.EXTRA_EXTRA, str2);
            intent.setFlags(268435456);
            activity.startActivity(intent);
        } catch (Exception unused) {
            Logger.ee("WebViewHelper", "Unhandle intent : " + str);
        }
    }

    @JavascriptInterface
    public void startActivityByName(String str, String str2) {
        Logger.d("WebViewHelper", "activityName = " + str);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("WebViewHelper", "The activity name is null or empty, Give up..");
        }
        Activity activity = this.f4528a.get();
        if (activity == null) {
            return;
        }
        try {
            Intent intent = new Intent(activity, Class.forName(str));
            intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
            intent.setFlags(268435456);
            activity.startActivity(intent);
        } catch (Exception unused) {
            Logger.ee("WebViewHelper", "The activity name is invalid, Give up..");
        }
    }

    @JavascriptInterface
    public void startMainActivity(String str) {
        Activity activity = this.f4528a.get();
        if (activity == null) {
            return;
        }
        try {
            activity.finish();
            cn.jpush.android.u.a.b(activity, str);
        } catch (Exception unused) {
            Logger.ee("WebViewHelper", "startMainActivity failed");
        }
    }

    @JavascriptInterface
    public void startPushActivity(String str) {
        try {
            Logger.d("WebViewHelper", "[startPushActivity]:" + str + ",activity:" + this.f4528a.get());
            if (this.f4528a.get() == null || !(this.f4528a.get() instanceof PopWinActivity)) {
                return;
            }
            ((PopWinActivity) this.f4528a.get()).startPushActivity(str);
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public void triggerNativeAction(String str) {
        this.f4528a.get();
    }
}
