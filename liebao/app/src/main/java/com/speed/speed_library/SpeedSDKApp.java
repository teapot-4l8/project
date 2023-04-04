package com.speed.speed_library;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.jpush.android.api.JPushInterface;
import com.fm.openinstall.OpenInstall;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.lxj.xpopup.a;
import com.orhanobut.hawk.Hawk;
import com.speed.speed_library.b.g;
import com.speed.speed_library.b.i;
import com.umeng.commonsdk.framework.UMFrUtils;
import utils.AppLog;

/* compiled from: SpeedSDKApp.kt */
/* loaded from: classes.dex */
public class SpeedSDKApp extends Application {

    /* compiled from: SpeedSDKApp.kt */
    /* loaded from: classes.dex */
    static final class a implements OnInitializationCompleteListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f5541a = new a();

        a() {
        }

        @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
        public final void onInitializationComplete(InitializationStatus initializationStatus) {
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        SpeedSDKApp speedSDKApp = this;
        g.f5610b.a(speedSDKApp);
        g gVar = g.f5610b;
        String a2 = com.c.a.a.g.a(g.f5610b.a());
        if (a2 == null) {
            a2 = "";
        }
        gVar.a(a2);
        if (a()) {
            OpenInstall.init(speedSDKApp);
            com.speed.speed_library.business.a.f5623a.i();
        }
        JPushInterface.init(speedSDKApp);
        AppLog.INSTANCE.initLog();
        Hawk.init(speedSDKApp).build();
        new a.C0125a(speedSDKApp).a((Boolean) false);
        if (!TextUtils.isEmpty(getResources().getString(R.string.umeng_key))) {
            i iVar = i.f5619a;
            String string = getResources().getString(R.string.umeng_key);
            kotlin.d.b.i.a((Object) string, "resources.getString(R.string.umeng_key)");
            iVar.a(string);
        }
        if (!TextUtils.isEmpty(getResources().getString(R.string.bugly_id))) {
            i iVar2 = i.f5619a;
            String string2 = getResources().getString(R.string.bugly_id);
            kotlin.d.b.i.a((Object) string2, "resources.getString(R.string.bugly_id)");
            iVar2.b(string2);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            String currentProcessName = UMFrUtils.getCurrentProcessName(speedSDKApp);
            Context applicationContext = getApplicationContext();
            kotlin.d.b.i.a((Object) applicationContext, "this.applicationContext");
            if (!kotlin.d.b.i.a((Object) applicationContext.getPackageName(), (Object) currentProcessName)) {
                WebView.setDataDirectorySuffix(currentProcessName);
            }
        }
        MobileAds.initialize(speedSDKApp, a.f5541a);
    }

    public final boolean a() {
        int myPid = Process.myPid();
        Object systemService = getSystemService("activity");
        if (systemService == null) {
            throw new kotlin.i("null cannot be cast to non-null type android.app.ActivityManager");
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return kotlin.d.b.i.a((Object) getApplicationInfo().packageName, (Object) runningAppProcessInfo.processName);
            }
        }
        return false;
    }
}
