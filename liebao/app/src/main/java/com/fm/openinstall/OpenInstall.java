package com.fm.openinstall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import b.a.d;
import b.a.k.f;
import b.a.k.g;
import com.fm.openinstall.a.c;

/* loaded from: classes.dex */
public class OpenInstall {

    /* renamed from: a  reason: collision with root package name */
    private static d f5339a = null;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f5340b = false;

    /* renamed from: c  reason: collision with root package name */
    private static Context f5341c;

    /* renamed from: d  reason: collision with root package name */
    private static Runnable f5342d;

    /* renamed from: e  reason: collision with root package name */
    private static Configuration f5343e;
    private static Boolean f;

    private OpenInstall() {
    }

    private static void a(Context context, Configuration configuration, Runnable runnable) {
        init(context, configuration);
        if (runnable != null) {
            runnable.run();
            f5342d = null;
        }
    }

    private static void a(Runnable runnable) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        if (b.a.k.d.f3261a) {
            b.a.k.d.b("非UI线程调用初始化，可能影响数据获取", new Object[0]);
        }
        handler.post(runnable);
    }

    @Deprecated
    public static boolean checkYYB(Intent intent) {
        if (b.a.k.d.f3261a) {
            b.a.k.d.b("OpenInstall.checkYYB(Intent intent) 方法在后续版本中将被移除，请使用 OpenInstallHelper.checkYYB(intent)", new Object[0]);
        }
        return OpenInstallHelper.checkYYB(intent);
    }

    private static boolean d() {
        if (f5340b) {
            return true;
        }
        if (b.a.k.d.f3261a) {
            b.a.k.d.c("请先调用 init(Context) 初始化", new Object[0]);
        }
        return false;
    }

    public static void getInstall(com.fm.openinstall.a.b bVar) {
        getInstall(bVar, 0);
    }

    public static void getInstall(com.fm.openinstall.a.b bVar, int i) {
        if (d()) {
            f5339a.a(i, bVar);
        } else {
            bVar.a(null, null);
        }
    }

    @Deprecated
    public static void getUpdateApk(com.fm.openinstall.a.d dVar) {
        if (d()) {
            f5339a.a(dVar);
        } else {
            dVar.a(null);
        }
    }

    public static String getVersion() {
        return "2.5.2";
    }

    public static boolean getWakeUp(Intent intent, c cVar) {
        if (d() && OpenInstallHelper.isValidIntent(intent)) {
            f5339a.a(intent, cVar);
            return true;
        }
        return false;
    }

    public static boolean getWakeUpYYB(Intent intent, c cVar) {
        if (d() && OpenInstallHelper.checkYYB(intent)) {
            f5339a.a(cVar);
            return true;
        }
        return false;
    }

    public static void init(Context context) {
        init(context, Configuration.getDefault());
    }

    public static void init(Context context, Configuration configuration) {
        String a2 = f.a(context);
        if (TextUtils.isEmpty(a2)) {
            throw new IllegalArgumentException("请在AndroidManifest.xml中配置OpenInstall提供的AppKey");
        }
        init(context, a2, configuration);
    }

    public static void init(Context context, String str) {
        init(context, str, Configuration.getDefault());
    }

    public static void init(Context context, String str, Configuration configuration) {
        if (context == null) {
            throw new IllegalArgumentException("context不能为空");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("请前往OpenInstall控制台的 “Android集成” -> “Android应用配置” 中获取AppKey");
        }
        if (b.a.k.d.f3261a) {
            b.a.k.d.a("SDK Version : " + getVersion(), new Object[0]);
        }
        if (!OpenInstallHelper.isMainProcess(context)) {
            b.a.k.d.c("为了不影响数据的获取，请只在主进程中初始化 OpenInstall", new Object[0]);
        }
        if (f == null) {
            f = Boolean.valueOf(f.b(context));
        }
        if (configuration == null) {
            configuration = Configuration.getDefault();
        }
        a(new b(context, configuration, str));
    }

    public static void initWithPermission(Activity activity, Configuration configuration) {
        initWithPermission(activity, configuration, null);
    }

    public static void initWithPermission(Activity activity, Configuration configuration, Runnable runnable) {
        if (g.a(activity)) {
            a(activity.getApplicationContext(), configuration, runnable);
            return;
        }
        g.a(activity, new String[]{"android.permission.READ_PHONE_STATE"}, 999);
        f5341c = activity.getApplicationContext();
        f5342d = runnable;
        f5343e = configuration;
    }

    @Deprecated
    public static boolean isMainProcess(Context context) {
        if (b.a.k.d.f3261a) {
            b.a.k.d.b("OpenInstall.isMainProcess(Context context) 方法在后续版本中将被移除，请使用 OpenInstallHelper.isMainProcess(context)", new Object[0]);
        }
        return OpenInstallHelper.isMainProcess(context);
    }

    @Deprecated
    public static boolean isValidIntent(Intent intent) {
        if (b.a.k.d.f3261a) {
            b.a.k.d.b("OpenInstall.isValidIntent(Intent intent) 方法在后续版本中将被移除，请使用 OpenInstallHelper.isValidIntent(intent)", new Object[0]);
        }
        return OpenInstallHelper.isValidIntent(intent);
    }

    public static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Context context = f5341c;
        if (context == null || i != 999) {
            return;
        }
        a(context, f5343e, f5342d);
    }

    public static void reportEffectPoint(String str, long j) {
        if (d()) {
            f5339a.a(str, j);
        }
    }

    public static void reportRegister() {
        if (d()) {
            f5339a.a();
        }
    }

    public static void setDebug(boolean z) {
        b.a.k.d.f3261a = z;
    }

    public static void setEncrypt(boolean z) {
        f = Boolean.valueOf(z);
    }
}
