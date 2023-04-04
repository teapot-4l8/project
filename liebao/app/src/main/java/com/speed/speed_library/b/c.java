package com.speed.speed_library.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import cn.jpush.android.api.JPushInterface;
import com.google.android.gms.common.internal.ImagesContract;
import com.snail.antifake.jni.EmulatorDetectUtil;
import com.speed.speed_library.R;
import com.speed.speed_library.model.WhiteListInfo;
import com.speed.speed_library.module.webview.WebViewActivity;
import com.umeng.analytics.pro.ak;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONObject;

/* compiled from: AppUtil.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f5594a = new c();

    private c() {
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("DeviceManufacturer", Build.MANUFACTURER);
        jSONObject.put("SystemDevice", Build.DEVICE);
        jSONObject.put("SystemVersion", Build.VERSION.RELEASE);
        jSONObject.put("channel", g.f5610b.b());
        jSONObject.put("spreadNum", g.f5610b.c());
        jSONObject.put("APILevel", Build.VERSION.SDK_INT);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(kotlin.f.d.a(new kotlin.f.c(0, 9), kotlin.e.c.f7166b)));
        String registrationID = JPushInterface.getRegistrationID(g.f5610b.a());
        if (registrationID == null) {
            registrationID = "";
        }
        if (registrationID == null) {
            throw new kotlin.i("null cannot be cast to non-null type kotlin.CharSequence");
        }
        sb.append(kotlin.h.g.c(registrationID).toString());
        sb.append(String.valueOf(kotlin.f.d.a(new kotlin.f.c(0, 9), kotlin.e.c.f7166b)));
        jSONObject.put("processId", sb.toString());
        jSONObject.put("versionCode", String.valueOf(com.speed.speed_library.utils.e.b(g.f5610b.a())));
        jSONObject.put("versionName", com.speed.speed_library.utils.e.a(g.f5610b.a()).toString());
        jSONObject.put("isEmulator", EmulatorDetectUtil.a(g.f5610b.a()));
        String jSONObject2 = jSONObject.toString();
        kotlin.d.b.i.a((Object) jSONObject2, "uaJson.toString()");
        return new kotlin.h.f("\\s*").a(jSONObject2, "");
    }

    public final void a(Context context, String str, String str2) {
        kotlin.d.b.i.b(context, "activity");
        kotlin.d.b.i.b(str, ImagesContract.URL);
        kotlin.d.b.i.b(str2, "title");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(d.f5595a.Q(), str);
        intent.putExtra(d.f5595a.R(), str2);
        intent.setClass(context, WebViewActivity.class);
        context.startActivity(intent);
    }

    public final String b() {
        String packageName = g.f5610b.a().getPackageName();
        kotlin.d.b.i.a((Object) packageName, "Global.context.packageName");
        return packageName;
    }

    public final String c() {
        String string = g.f5610b.a().getResources().getString(g.f5610b.a().getApplicationInfo().labelRes);
        kotlin.d.b.i.a((Object) string, "Global.context.resources…applicationInfo.labelRes)");
        return string;
    }

    public final boolean a(String str) {
        kotlin.d.b.i.b(str, "phone");
        return Patterns.PHONE.matcher(str).matches();
    }

    public final boolean b(String str) {
        kotlin.d.b.i.b(str, "password");
        return str.length() > 5 && str.length() < 19;
    }

    public final boolean d() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public final int a(Context context, int i) {
        kotlin.d.b.i.b(context, "conetxt");
        return androidx.core.content.b.c(context, i);
    }

    public final int b(Context context, int i) {
        kotlin.d.b.i.b(context, com.umeng.analytics.pro.d.R);
        Resources resources = context.getResources();
        kotlin.d.b.i.a((Object) resources, "context.resources");
        return (int) ((i * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final <T extends View> T a(View view, int i) {
        kotlin.d.b.i.b(view, ak.aE);
        T t = (T) view.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new kotlin.i("null cannot be cast to non-null type T");
    }

    public final String a(long j) {
        return a(j, "yyyy-MM-dd HH:mm");
    }

    public final String a(long j, String str) {
        kotlin.d.b.i.b(str, "format");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        String format = simpleDateFormat.format(new Date(j * 1000));
        kotlin.d.b.i.a((Object) format, "sdf.format(dt)");
        return format;
    }

    public final Intent a(WhiteListInfo.IntentItem intentItem) {
        kotlin.d.b.i.b(intentItem, "intent");
        Intent intent = new Intent();
        intent.addFlags(268435456);
        if (intentItem.getAction().length() > 0) {
            intent.setAction(intentItem.getAction());
        }
        if (intentItem.getComponent() != null) {
            WhiteListInfo.Component component = intentItem.getComponent();
            if (component == null) {
                kotlin.d.b.i.a();
            }
            String pkg = component.getPkg();
            WhiteListInfo.Component component2 = intentItem.getComponent();
            if (component2 == null) {
                kotlin.d.b.i.a();
            }
            intent.setComponent(new ComponentName(pkg, component2.getCls()));
        }
        if (intentItem.getExtras() != null) {
            List<WhiteListInfo.Extra> extras = intentItem.getExtras();
            if (extras == null) {
                kotlin.d.b.i.a();
            }
            for (WhiteListInfo.Extra extra : extras) {
                intent.putExtra(extra.getKey(), extra.getValue());
            }
        }
        return intent;
    }

    public final boolean a(Context context, Intent intent) {
        kotlin.d.b.i.b(context, com.umeng.analytics.pro.d.R);
        kotlin.d.b.i.b(intent, "intent");
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public final boolean e() {
        if (g.f5610b.a() != null && !TextUtils.isEmpty(g.f5610b.a().getString(R.string.app_package_name))) {
            String string = g.f5610b.a().getString(R.string.app_package_name);
            kotlin.d.b.i.a((Object) string, "Global.context.getString….string.app_package_name)");
            if (kotlin.h.g.c(string, "haiou", false, 2, null)) {
                return false;
            }
        }
        return true;
    }

    public final List<PackageInfo> a(Context context) {
        kotlin.d.b.i.b(context, com.umeng.analytics.pro.d.R);
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(1);
            kotlin.d.b.i.a((Object) installedPackages, "packgeInfos");
            return installedPackages;
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ArrayList();
        }
    }
}
