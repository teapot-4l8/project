package cn.jiguang.am;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.service.JCommonService;
import java.util.List;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f3740a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static volatile c f3741b;

    /* renamed from: c  reason: collision with root package name */
    private static String f3742c;

    /* renamed from: d  reason: collision with root package name */
    private static String f3743d;

    public static c a() {
        if (f3741b == null) {
            synchronized (f3740a) {
                if (f3741b == null) {
                    f3741b = new c();
                }
            }
        }
        return f3741b;
    }

    public static String a(Context context) {
        String str = f3743d;
        if (str != null) {
            return str;
        }
        String b2 = b(context);
        if (TextUtils.isEmpty(b2)) {
            f3743d = "";
            return "";
        }
        f3743d = cn.jiguang.f.a.a(context, b2);
        cn.jiguang.an.d.b("JCommonServiceHelper", "user serviceProcess is:" + f3743d);
        return f3743d;
    }

    public static void a(Context context, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder("onAction action:");
            sb.append(str);
            sb.append(" bundle:");
            sb.append(bundle == null ? "null" : bundle.toString());
            cn.jiguang.an.d.b("JCommonServiceHelper", sb.toString());
            String b2 = b(context);
            if (TextUtils.isEmpty(b2)) {
                cn.jiguang.a.a.b(context, str, bundle);
            } else {
                e.a().a(context, b2, str, bundle);
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.d("JCommonServiceHelper", "onAction failed", th);
        }
    }

    public static String b(Context context) {
        ComponentInfo a2;
        try {
        } catch (Throwable th) {
            cn.jiguang.an.d.b("JCommonServiceHelper", "getUserServiceClass failed:" + th);
        }
        if (f3742c != null) {
            return f3742c;
        }
        Intent intent = new Intent();
        intent.setAction(JConstants.USER_SERVICE_ACTION);
        intent.setPackage(context.getPackageName());
        List<String> a3 = cn.jiguang.f.a.a(context, intent, "");
        if (a3.size() > 0 && JCommonService.class.isAssignableFrom(Class.forName(a3.get(0)))) {
            f3742c = a3.get(0);
            cn.jiguang.an.d.e("JCommonServiceHelper", "found userServiceClass :" + f3742c + " by getCommonServiceNames");
        }
        if (TextUtils.isEmpty(f3742c) && (a2 = cn.jiguang.f.a.a(context, context.getPackageName(), JCommonService.class)) != null) {
            f3742c = a2.name;
            cn.jiguang.an.d.e("JCommonServiceHelper", "found userServiceClass :" + f3742c + " by getComponentInfo");
        }
        if (TextUtils.isEmpty(f3742c)) {
            f3742c = "";
        }
        return f3742c;
    }

    public final void b(Context context, String str, Bundle bundle) {
        try {
            StringBuilder sb = new StringBuilder("callAction action:");
            sb.append(str);
            sb.append(" bundle:");
            sb.append(bundle == null ? "null" : bundle.toString());
            cn.jiguang.an.d.d("JCommonServiceHelper", sb.toString());
            cn.jiguang.ba.a.a("ACTION", new d(this, JConstants.getAppContext(context), str, bundle));
        } catch (Throwable th) {
            cn.jiguang.an.d.d("JCommonServiceHelper", "callAction failed", th);
        }
    }
}
