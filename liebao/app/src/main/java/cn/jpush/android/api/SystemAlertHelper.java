package cn.jpush.android.api;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import androidx.recyclerview.widget.l;
import cn.jpush.android.d.d;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.u.a;
import cn.jpush.android.webview.bridge.HostJsScope;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class SystemAlertHelper {

    /* renamed from: a  reason: collision with root package name */
    private static int f4266a = 400;

    /* renamed from: b  reason: collision with root package name */
    private static int f4267b = 600;

    /* renamed from: c  reason: collision with root package name */
    private static ImageButton f4268c;

    /* renamed from: d  reason: collision with root package name */
    private static WindowManager f4269d;

    /* renamed from: e  reason: collision with root package name */
    private static WebView f4270e;

    private static DisplayMetrics a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            Logger.d("SystemAlertHelper", "width : " + displayMetrics.widthPixels);
            Logger.d("SystemAlertHelper", "height : " + displayMetrics.heightPixels);
            Logger.d("SystemAlertHelper", "density : " + displayMetrics.density);
            Logger.d("SystemAlertHelper", "densityDpi : " + displayMetrics.densityDpi);
            Logger.d("SystemAlertHelper", "xdpi : " + displayMetrics.xdpi);
            Logger.d("SystemAlertHelper", "ydpi : " + displayMetrics.ydpi);
            return displayMetrics;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, WindowManager windowManager, WebView webView, ImageButton imageButton) {
        int i;
        int i2;
        DisplayMetrics a2 = a(context);
        if (a2 != null) {
            f4266a = (a2.widthPixels * 3) / 4;
            int i3 = a2.heightPixels / 2;
            f4267b = i3;
            i = f4266a / 2;
            i2 = -(i3 / 2);
        } else {
            i = l.a.DEFAULT_DRAG_ANIMATION_DURATION;
            i2 = -300;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = 1;
        layoutParams.gravity = 17;
        layoutParams.type = 2003;
        layoutParams.flags |= 552;
        layoutParams.width = f4266a;
        layoutParams.height = f4267b;
        layoutParams.x = -1;
        layoutParams.y = -1;
        windowManager.addView(webView, layoutParams);
        imageButton.setBackgroundColor(context.getResources().getColor(17170445));
        imageButton.setImageBitmap(getImageFromAssetsFile(context, "jpush_close.png"));
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.y = i2;
        layoutParams.x = i;
        windowManager.addView(imageButton, layoutParams);
    }

    public static void close() {
        WindowManager windowManager = f4269d;
        if (windowManager == null) {
            return;
        }
        try {
            if (f4270e != null) {
                windowManager.removeView(f4270e);
            }
            if (f4268c != null) {
                f4269d.removeView(f4268c);
            }
        } catch (Throwable unused) {
        }
        f4269d = null;
        f4270e = null;
        f4268c = null;
    }

    public static Bitmap getImageFromAssetsFile(Context context, String str) {
        Bitmap bitmap = null;
        try {
            InputStream open = context.getResources().getAssets().open(str);
            bitmap = BitmapFactory.decodeStream(open);
            open.close();
            return bitmap;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bitmap;
        }
    }

    public static int getWindowHeight() {
        return f4267b;
    }

    public static int getWindowWidth() {
        return f4266a;
    }

    public static void startActivityByName(WebView webView, String str, String str2) {
        Context appContext;
        Logger.d("SystemAlertHelper", "action --- startActivityByName--------activityName : " + str + "----- params : " + str2);
        if (TextUtils.isEmpty(str)) {
            Logger.ee("SystemAlertHelper", "The activity name is null or empty, Give up..");
        }
        if (webView == null || (appContext = JPushConstants.getAppContext(webView.getContext())) == null) {
            return;
        }
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                Intent intent = new Intent(webView.getContext(), cls);
                intent.putExtra(JPushInterface.EXTRA_ACTIVITY_PARAM, str2);
                intent.setFlags(268435456);
                appContext.startActivity(intent);
                close();
            }
        } catch (Exception unused) {
            Logger.ee("SystemAlertHelper", "The activity name is invalid, Give up..");
        }
    }

    public static void systemAlert() {
    }

    public static void systemAlert(final Context context, final d dVar) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: cn.jpush.android.api.SystemAlertHelper.1
            @Override // java.lang.Runnable
            public void run() {
                String str = d.this.N;
                if (TextUtils.isEmpty(str)) {
                    Logger.e("SystemAlertHelper", " not Rich Notification");
                    return;
                }
                WindowManager unused = SystemAlertHelper.f4269d = (WindowManager) context.getSystemService("window");
                WebView unused2 = SystemAlertHelper.f4270e = new WebView(context);
                ImageButton unused3 = SystemAlertHelper.f4268c = new ImageButton(context);
                SystemAlertHelper.b(context, SystemAlertHelper.f4269d, SystemAlertHelper.f4270e, SystemAlertHelper.f4268c);
                SystemAlertHelper.f4270e.setHorizontalScrollBarEnabled(false);
                SystemAlertHelper.f4270e.setVerticalScrollBarEnabled(false);
                SystemAlertHelper.f4270e.setScrollbarFadingEnabled(true);
                SystemAlertHelper.f4270e.setScrollBarStyle(33554432);
                a.a(SystemAlertHelper.f4270e.getSettings());
                a.a(SystemAlertHelper.f4270e);
                SystemAlertHelper.f4270e.setWebChromeClient(new cn.jpush.android.webview.bridge.a("JPushWeb", HostJsScope.class, null, null));
                SystemAlertHelper.f4270e.setWebViewClient(new cn.jpush.android.ui.a(d.this, context));
                if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
                    SystemAlertHelper.f4270e.loadUrl(str);
                }
                SystemAlertHelper.f4268c.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.api.SystemAlertHelper.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SystemAlertHelper.close();
                    }
                });
            }
        });
    }
}
